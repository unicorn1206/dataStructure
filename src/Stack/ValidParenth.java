package Stack;

public class ValidParenth {
    public boolean isValid(String s){
        boolean result = false;
        ArrayStack<Character> charArrayStack = new ArrayStack<Character>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            //如果是({[，放入栈中
            if('(' == charArray[i] || '{' == charArray[i] || '[' == charArray[i]){
                charArrayStack.push(charArray[i]);
            }else{//如果是]})，从栈顶取出元素，查看是否匹配
                if (charArrayStack.isEmpty()){
                    return false;
                }
                char topChar = charArrayStack.pop();
                if(topChar == '(' && charArray[i] == ')' ||
                        topChar == '{' && charArray[i] == '}' ||
                        topChar == '[' && charArray[i] == ']'){
                    continue;
                }else{
                    return result;
                }
            }
        }
        return charArrayStack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenth validParenth = new ValidParenth();
        System.out.println(validParenth.isValid("{({[]]})}"));
    }
}

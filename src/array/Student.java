package array;

/**
 * 用于测试Array类
 */
public class Student {
    public String name;
    public int age;

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<Student>();
        Student alice = new Student("alice", 25);
        Student mike = new Student("mike", 35);
        arr.addLast(alice);
        arr.addLast(mike);
        System.out.println(arr.toString());
    }
}

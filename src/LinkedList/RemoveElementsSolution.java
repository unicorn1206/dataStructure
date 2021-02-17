package LinkedList;

public class RemoveElementsSolution {

    /**
     * 移除链表中值为val的元素
     * @param head 链表
     * @param val 目标值
     * @param depth 递归深度
     * @return
     */
    public ListNode removeElements(ListNode head, int val,int depth){
        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove" + val + " in: " + head);
        if(head == null){
            System.out.print(depthString);
            System.out.println("Return:" +  head);
            return null;
        }
        ListNode res = removeElements(head.next,val,depth + 1);
        System.out.print(depthString);
        System.out.println("After Remove" +  val + ":" + res);

        ListNode ret;
        if(head.val == val){
            ret = res;
//           return res;
        }else{
            head.next = res;
            ret = head;
//            return head;
        }
        System.out.print(depthString);
        System.out.println("Return:" +  ret);
        return ret;

    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0;i < depth;i++){
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
//        System.out.println(head.toString());
        RemoveElementsSolution re = new RemoveElementsSolution();
        ListNode res = re.removeElements(head,6,0);
        System.out.println(res.toString());
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

        public ListNode(int[] arr){
            if(arr == null || arr.length == 0){
                throw new IllegalArgumentException("arr can not be empty");
            }
            this.val = arr[0];
            ListNode cur = this;
//            ListNode cur = new ListNode(arr[0]);
            for(int i = 1;i< arr.length;i++){
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
//            System.out.println(cur.toString());
        }

        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            ListNode cur= this;
            for (; cur != null; cur = cur.next){
                res.append(cur.val + "->");
            }
            res.append("NULL");
            return res.toString();
        }
    }
}

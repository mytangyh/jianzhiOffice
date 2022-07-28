public class reverselist {
    public ListNode head;
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }else{
            ListNode temp = this.head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    public void show(){
        ListNode temp = this.head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
    //从指定位置开始打印
    public void show2(ListNode newhead){
        ListNode cur = newhead;
        while(cur != null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
//迭代
    public ListNode ReverseList(ListNode head) {
        
        //pre 指针 用来指向反转后的节点
        ListNode pre = null;
        // cur 指针 当前节点
        ListNode cur = head;
        while(cur != null){
            // 指向当前的下一个节点
            ListNode curNext = cur.next;
            // 反转 当前节点的指针指向前一个节点
            cur.next = pre;
            // pre 指针向后移动
            pre = cur;
            // cur 指针向后移动
            cur = curNext;
        }
        return pre;
    }
    //递归
    public ListNode printListFromTailToHead(ListNode head) {
        if(head == null||head.next == null){
            return head;
        }
        ListNode newhead = printListFromTailToHead(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
    public static void main(String[] args) {

        System.out.println("Hello World!");
        reverselist list = new reverselist();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.show();
        ListNode node1 = list.ReverseList(list.head);
        System.out.println(" --");
        list.show2(node1);
        // System.out.println(" --");
        // ListNode node = list.printListFromTailToHead(list.head);
        // // System.out.println(node);
        // list.show2(node);
    }
}
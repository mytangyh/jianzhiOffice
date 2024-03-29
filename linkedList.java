
public class linkedList {
    public Node head;

    public void addFirst(int data) {// 头插法
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {// 尾插法
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void createListLow() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        this.head = node1;

    }

    public void show() {// 遍历链表
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    /**
     * @return
     */
    public int size() {
        int count = 0;
        Node temp = this.head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;

    }

    public boolean isContains(int key) {
        Node temp = this.head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;

    }

    public Node searchPre(int index) {
        Node temp = head;
        int count = 0;
        while (count != index - 1) {
            temp = temp.next;
            count++;
        }
        return temp;

    }

    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            System.out.println("不合法");
            return;
        }
        if (index == 0) {
            addFirst(data);
        }
        if (index == size()) {
            addLast(data);
        }
        Node temp = searchPre(index);
        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;

    }

    private void delete(int index) {
        if (index < 0 || index > size()) {
            System.out.println("不合法");
            return;
        }
        if (index == 0) {
            head = head.next;
        }
        Node temp = searchPre(index);
        temp.next = temp.next.next;
    }

    public void clear() {
        head = null;
    }

    public static void main(String[] args) {
        linkedList list = new linkedList();

        // list.show();
        // System.out.println("\n" + list.size());
        list.createListLow();
        list.show();
        System.out.println("\n" + list.size());
        System.out.println(list.isContains(3));
        list.addIndex(2, 5);
        list.show();
        System.out.println("\n" + list.size());
        list.delete(2);
        list.show();
        System.out.println("\n" + list.size());
        list.clear();
        list.show();
        System.out.println("\n" + list.size());

    }

}

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
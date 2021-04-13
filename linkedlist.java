package datastructure;

public class linkedlist {
    static Node head;

    public class Node {
        int data;
        Node next;
    }

    public void insert(int data) {                   // insert element in linked list at end
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }

    }

    public void addstart(int data) {                    // add element in start
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    public void inserAt(int index, int data) {           // insert element between in linked list
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (index == 0) {
            addstart(data);
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void show(Node head) {                 // print data of linked list
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public int numberofNode() {               // count number of node in linked list
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count = count + 1;
            temp = temp.next;
        }
        return count;

    }

    public void delete2(int index) {                   // delete not by index value
        Node N = head;
        if (index <= numberofNode() - 1 && N != null) {
            if (index == 0) {
                head = head.next;
            } else {
                Node n = head;
                Node n1 = null;
                for (int i = 0; i < index - 1; i++) {
                    n = n.next;
                }
                n1 = n.next;
                n.next = n1.next;
            }

        } else if (N == null && index > numberofNode() - 1) {
            return;
        }
    }

    public static Node reverse(Node head) {        // reverse linked list (itretive)
        if (head == null) {
            return head;
        }
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public void sort(){
        Node current=head;
        Node index=null;
        int temp;
        if(head==null){
            return;
        }else{
        while(current!=null){
         index=current.next;
         while(index!=null){
             if(current.data>index.data){
                 temp=current.data;
                 current.data=index.data;
                 index.data=temp;
             }
             index=index.next;
         }
         current=current.next;
        }
    }   

    }
    

    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        list.insert(10);
        list.insert(11);
        list.insert(100);
        list.insert(14);
        list.insert(150);
        list.addstart(33);
        list.inserAt(2, 12);
        list.numberofNode();
        list.delete2(5);
        list.show(head);
        System.out.println("reverse linkedlist");
        Node reverselinklist = reverse(head);
        list.show(reverselinklist);
        System.out.println("sort linkedlist");
        list.sort();
        list.show(head);

    }
}

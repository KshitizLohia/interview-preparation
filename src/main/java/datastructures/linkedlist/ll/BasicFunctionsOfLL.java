package datastructures.linkedlist.ll;

public class BasicFunctionsOfLL {
    public static void main(String[] args) {
        ListNode a = new ListNode();
        a.setData(1);
        ListNode b = new ListNode();
        b.setData(2);
        ListNode c = new ListNode();
        c.setData(3);
        ListNode d = new ListNode();
        d.setData(4);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(null);

//        System.out.println(length(a));
//        printList(insertBeginning(a, -1));
//        printList(insertEnd(a, -1));
//        printList(insertMiddle(a, -1, 2));
//        printList(deleteStart(a));
        printList(deleteEnd(a));
    }

    // length of linked list
    public static int length(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.getNext();
        }
        return l;
    }

    // length of linked list
    public static void printList(ListNode head) {
        System.out.println("===========");
        while (head != null) {
            System.out.println(head.getData());
            head = head.getNext();
        }
        System.out.println("===========");
    }

    // a -> b -> c
    // insert node at the beginning
    public static ListNode insertBeginning(ListNode head, int data) {
        ListNode a = new ListNode();
        a.setData(data);
        a.setNext(head);
        return a;
    }

    // insert node at the end
    public static ListNode insertEnd(ListNode head, int data) {
        ListNode start = head;
        while (true) {
            head = head.getNext();
            if (head.getNext() == null) {
                break;
            }
        }
        ListNode a = new ListNode();
        a.setData(data);
        a.setNext(null);
        head.setNext(a);
        return start;
    }

    // insert node at the middle
    public static ListNode insertMiddle(ListNode head, int data, int k) {
        // if k is less than 0
        if (k<0) {
            k =0;
        }
        // if head is set to null
        if (head == null) {
            ListNode a = new ListNode();
            a.setData(data);
            a.setNext(null);
            return a;
        }

        //
        int index = 1;
        ListNode prevNode = head;
        while (prevNode.getNext() != null && index < k) {
            prevNode = prevNode.getNext();
            index++;
        }

        ListNode a = new ListNode();
        a.setData(data);
        a.setNext(prevNode.getNext());
        prevNode.setNext(a);

        return head;
    }

    // delete node at the start
    public static ListNode deleteStart(ListNode head) {
        // handle base case
        if (head == null) return null;
        // other scenarios
        ListNode nextNode = head.getNext();
        head.setNext(null);
        return nextNode;
    }

    // delete node at the end
    public static ListNode deleteEnd(ListNode head) {

        if (head == null) return null;
        if (head.getNext() == null) {
            head.setNext(null);
            return head;
        }
        ListNode nextNode = head.getNext();
        ListNode prevNode = head;
        while (nextNode.getNext() != null) {
            prevNode = nextNode;
            nextNode = nextNode.getNext();
        }
        prevNode.setNext(null);
        return head;
    }

    // delete node at the middle


}


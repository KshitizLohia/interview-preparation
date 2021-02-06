package datastructures.linkedlist.ll;

public class QuestionsOfLL {
    public static void main(String[] args) {
        ListNode a = new ListNode();
        a.setData(1);
        ListNode b = new ListNode();
        b.setData(5);
        ListNode c = new ListNode();
        c.setData(7);
        ListNode d = new ListNode();
        d.setData(9);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(null);

//        System.out.println(length(a));
//        printList(insertBeginning(a, -1));
//        printList(insertEnd(a, -1));
//        printList(insertMiddle(a, -1, 2));
//        printList(b);
        printList(insertInSortedList(6, a));
    }

    public static void printList(ListNode head) {
        System.out.println("===========");
        while (head != null) {
            System.out.println(head.getData());
            head = head.getNext();
        }
        System.out.println("===========");
    }

    public static ListNode reverseLL(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return head;
    }

    public static ListNode insertInSortedList(int n, ListNode head) {
        ListNode current = head;
        ListNode temp = null;
        while (current != null && current.getData() < n) {
            temp = current;
            current = current.getNext();
        }
        ListNode a = new ListNode();
        a.setData(n);
        if (temp ==  null) {
            return null;
        }
        else {
            temp.setNext(a);
            a.setNext(current);
            return head;
        }
    }
}


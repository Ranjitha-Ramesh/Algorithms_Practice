package leetcode.lists;

//Given a linked list, rotate the list to the right by k places,
// where k is non-negative.
public class rotateList {

    public static void main(String[] args) {
//        Input: 1->2->3->4->5->NULL, k = 2
//        Output: 4->5->1->2->3->NULL
        ListNode root = new ListNode(1);
        ListNode cur = root;
        int len = 4, i = 2;
        while (len-- != 0) {
            cur.next = new ListNode(i++);
            cur = cur.next;
        }
        ListNode res = rotateRight(root, 2);
        while (res != null) {
            System.out.println(res.val + " ");
            res = res.next;
        }
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode thePoint = head;
        ListNode cur = head;
        int size = 0;
//move i to the kth position if k is greater than the list length , save the size
        for (int i = 0; i < k; i++) {
            if (cur.next == null) {
                size = i + 1;
                break;
            } else cur = cur.next;
        }
//do mod of size if k>size
        if (size != 0) {
            k = k % size;
            if (k == 0) return head;
            cur = head;
            for (int i = 0; i < k; i++) {
                cur = cur.next;
            }
        }
//thePoint will be k terms before the cur, when cur reaches end,
// thePoint will be our required start
        while (cur.next != null) {
            cur = cur.next;
            thePoint = thePoint.next;
        }
        ListNode tmp = thePoint.next;
        thePoint.next = null;
        cur.next = head;
        head = tmp;
        return head;
    }
}

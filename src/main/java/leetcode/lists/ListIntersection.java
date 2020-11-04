package leetcode.lists;

import java.util.HashSet;
import java.util.Set;
//Given two linked lists, the task is to complete the function findIntersection(), that returns the intersection of two linked lists.
// Each of the two linked list contains distinct node values. The order of nodes in this list should be same as the order in which those particular nodes appear in input list 1

public class ListIntersection {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode obj1 = head1;
        ListNode head2 = new ListNode(0);
        ListNode obj2 = head2;
        int[] o1 = {9, 6, 4, 2, 3, 8};
        int[] o2 = {1, 2, 8, 6};
        for (int i : o1) {
            obj1.next = new ListNode(i);
            obj1 = obj1.next;
        }
        for (int i : o2) {
            obj2.next = new ListNode(i);
            obj2 = obj2.next;
        }
        head1 = head1.next;
        head2 = head2.next;

        ListNode n = findIntersection(head1, head2);

        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public static ListNode findIntersection(ListNode head1, ListNode head2) {
        Set<Integer> set = new HashSet<Integer>();
        while (head2 != null) {
            set.add(head2.val);
            head2 = head2.next;

        }
        ListNode front = null;
        ListNode res = null;
        while (head1 != null) {
            if (set.contains(head1.val)) {
                ListNode tmp = res;
                ListNode nn = new ListNode(head1.val);

                if (tmp == null) {
                    front = nn;
                    res = nn;
                } else {
                    res.next = nn;
                    res = res.next;
                }
            }
            head1 = head1.next;
        }
        return front;
    }
}

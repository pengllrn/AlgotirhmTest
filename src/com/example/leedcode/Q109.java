package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/19 13:03</pre>
 */
public class Q109 {
}

class Solution109{
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        ListNode preSlow = head;
        ListNode slow = head.next;
        ListNode fast = head.next;
        boolean flag = false;
        while (fast.next != null){
            if(flag) {
                preSlow = slow;
                slow = slow.next;
            }
            fast = fast.next;
            flag = !flag;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        preSlow.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}

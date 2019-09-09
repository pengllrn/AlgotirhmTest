package com.example.leedcode;

/**
 * @author Pengllrn
 * @since <pre>2019/6/11 10:00</pre>
 */
public class Q725 {
}

/**
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 */
class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k < 1 && root == null)
            return null;
        ListNode[] ans = new ListNode[k];
        int cnt = 0;
        ListNode cur = root;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        int avg = cnt / k;
        int rest = cnt - avg * k;
        cur = root;
        for (int i = 0; cur != null && i < k; i++) {
            ans[i] = cur;
            int n = avg + ((rest-- > 0) ? 1 : 0);
            for (int j = 0; j < n - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ans;
    }
}

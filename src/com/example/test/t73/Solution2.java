package com.example.test.t73;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pengllrn
 * @since <pre>2019/7/3 14:26</pre>
 */
public class Solution2 {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null)
            return null;
        RandomListNode cur = pHead;
        while (cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = pHead;
        while (cur != null){
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        RandomListNode ret = pHead.next;
        pHead.next = null;
        cur = ret.next;
        RandomListNode ans = ret;
        while (cur != null){
            ret.next = cur.next;
            cur.next = null;
            ret = ret.next;
            cur = ret.next;
        }

        return ans;
    }

    class RandomListNode{
        int label;
        RandomListNode next;
        RandomListNode random;

        public RandomListNode(int label){
            this.label = label;
        }
    }

}

class Solution11 {//Method 1
    public RandomListNode Clone(RandomListNode pHead){
        RandomListNode cur = pHead;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        while(cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            map.put(cur, node);
            cur = cur.next;
        }
        RandomListNode copy = map.get(pHead);
        RandomListNode ret = copy;
        while(pHead != null && pHead.next != null){
            copy.next = map.get(pHead.next);
            copy.random = map.get(pHead.random);
            pHead = pHead.next;
            copy = copy.next;
        }
        StringBuilder sb = new StringBuilder();
        return ret;
    }
}

class RandomListNode{
    int label;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode(int label){
        this.label = label;
    }
}


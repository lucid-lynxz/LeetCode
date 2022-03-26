package util;

import bean.ListNode;

/**
 * 链表工具类
 */
public class LinkUtil {
    /**
     * 将整数数组转为单链表
     */
    public static ListNode makeListNode(int... arr) {
        int len = arr.length;
        if (len == 0) {
            return null;
        }

        ListNode current = new ListNode();
        ListNode head = current;
        for (int i = 0; i < len; i++) {
            current.val = arr[i];
            if (i != len - 1) {
                current.next = new ListNode();
                current = current.next;
            }
        }
        return head;
    }
//
//    /**
//     * 将数组转为二叉树, 如: 1,null,2,3 表示root.val=1, root.left=nul, root.right.val=2
//     */
//    public static TreeNode makeTreeNode(Integer... arr) {
//        TreeNode root = new TreeNode();
//        TreeNode cur = root;
//        int len = arr.length;
//        int ptr = 0;
//        while (ptr < len) {
//            cur.val = arr[ptr];
//            Integer leftVal = arr[ptr + 1];
//            Integer rightVal = arr[ptr + 2];
//            ptr++;
//        }
//        for (int i = 0; i < arr.length - 2; i++) {
//            cur.val = arr[i];
//
//
//        }
//    }
}

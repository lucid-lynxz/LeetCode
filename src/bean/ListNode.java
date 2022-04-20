package bean;

/**
 * 单链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val);
            cur = cur.next;
            if (cur != null) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
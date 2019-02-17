package leetcode.problem83;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode preNode = head;
        ListNode curNode = head.next;
        while(preNode!=null){
            if(curNode!=null){
                //进行比较
                if(preNode.val == curNode.val){
                    preNode.next = curNode.next;
                    curNode.next = null;
                    curNode = preNode.next;
                }else{
                    preNode = preNode.next;
                    curNode = curNode.next;
                }
            }else{
                //从preNode节点算起只有一个节点 没必要进行操作 直接返回head
                return head;
            }
        }
        return head;
    }
}
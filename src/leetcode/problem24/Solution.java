package leetcode.problem24;


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return head;
        ListNode preNode = head;
        ListNode curNode = head.next;
        ListNode tempNode = null;
        int flag = 0;
        while(preNode!=null&&curNode!=null){

            preNode.next = curNode.next;
            curNode.next = preNode;
            if(flag==1)
            {
                tempNode.next = curNode;
                tempNode = preNode;
            }
            if(flag==0){
                head = curNode;
                tempNode = preNode;
                flag = 1;
            }

            preNode = preNode.next;
            if(preNode!=null)
                curNode = preNode.next;


        }
        return head;
    }
}

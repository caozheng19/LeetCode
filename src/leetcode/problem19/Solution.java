package leetcode.problem19;



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ln = head;
        int len = 0;
        while(ln!=null){
            len++;
            ln = ln.next;

        }

        int count = 1;
        ListNode originHead = head;
        ListNode preListNode = head;
        ListNode currentListNode = head.next;
        while(preListNode!=null&&currentListNode!=null){

            if(count==len-n) {
                System.out.println(preListNode.val);
                System.out.println(currentListNode.val);
                preListNode.next = currentListNode.next;
                return originHead;
            }
            preListNode = currentListNode;
            currentListNode = currentListNode.next;
            count++;
        }
        /*
           当输入为[1]
                   1
           时会用到这里
         */
        return originHead.next;
    }
}

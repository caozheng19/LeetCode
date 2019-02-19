package leetcode.problem203;



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

//利用哑巴节点
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        if(head.next==null&&head.val==val) return null;
        ListNode preNode = new ListNode(-1);
        ListNode dummyNode  = preNode;
        preNode.next = head;
        ListNode curNode = head;
        while(curNode!=null){
            if(curNode.val==val){
                System.out.println("11111");
                preNode.next = curNode.next;
                curNode = curNode.next;
            }else{
                preNode = preNode.next;
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }
}
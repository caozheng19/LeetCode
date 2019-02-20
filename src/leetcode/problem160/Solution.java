package leetcode.problem160;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
//一个链表长x,另外一个链表长y,(x>=y),第一个链表先走x-y步 然后一起走
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode tempHeadA = headA;
        ListNode tempHeadB = headB;
        while(tempHeadA!=null){
            lenA++;
            tempHeadA = tempHeadA.next;
        }
        while(tempHeadB!=null){
            lenB++;
            tempHeadB = tempHeadB.next;
        }
        int dis = Math.abs(lenA-lenB);
        if(lenB>lenA){
            while(dis>0){
                headB = headB.next;
                dis--;
            }
        }else{
            while(dis>0){
                headA = headA.next;
                dis--;
            }
        }
        while(headA!=null){
            if(headA==headB){
                return headA;
            }
            else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
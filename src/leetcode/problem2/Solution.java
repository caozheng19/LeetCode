package leetcode.problem2;



class ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int carry = 0;
        int sum = 0;
        while(l1!=null||l2!=null){
            int x = (l1!=null) ? l1.val : 1;
            int y = (l2!=null) ? l2.val : 1;
            sum = x+y+carry;
            if(sum>=10){
                carry = 1;
                result.val = sum % 10;
            }else if(sum<10){
                carry = 0;
                result.val = sum;
            }
            result.next = new ListNode(0);
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;

        }
        return result;

    }
}
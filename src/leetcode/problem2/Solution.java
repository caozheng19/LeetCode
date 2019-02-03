package leetcode.problem2;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
/*
   题目的关键在于我是把个位数放在哪
   我原本是想放在当前node节点
   但是发现不可取
   应该curr.next = new ListNode(sum % 10); 这样
   在下个节点存值 第一个节点总是0没什么用 所以要return dummyHead.next
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ListNode result = new ListNode(0);
        // int carry = 0;
        // int sum = 0;
        // while(l1!=null||l2!=null){
        //     int x = (l1!=null) ? l1.val : 0;
        //     int y = (l2!=null) ? l2.val : 0;
        //     sum = x+y+carry;
        //     if(sum>=10){
        //         carry = 1;
        //         result.val = sum % 10;
        //     }else if(sum<10){
        //         carry = 0;
        //         result.val = sum;
        //     }
        //     result.next = new ListNode(0);
        //     if(l1!=null) l1 = l1.next;
        //     if(l2!=null) l2 = l2.next;
        //}
        //return result;
        ListNode result = new ListNode(0);
        int carry = 0;
        int sum = 0;
        ListNode current = result;
        while(l1!=null||l2!=null){
            int x = (l1!=null)?l1.val:0;
            int y = (l2!=null)?l2.val:0;
            sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum%10);
            current = current.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(carry!=0){
            current.next = new ListNode(carry);
        }
        return result.next;
    }
}
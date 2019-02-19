package leetcode.problem234;


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

//快慢指针法
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        int len = 0;
        while(fast!=null&&fast.next!=null){
            len++;
            slow = slow.next;
            fast = fast.next.next;
            if(fast==null){
                len = len * 2;
            }else if(fast.next==null){
                len = len * 2 +1;
            }
        }
        ListNode newHead = reverse(slow,len);
        while(head!=slow){
            System.out.println(head.val+"   "+newHead.val);
            if(head.val!=newHead.val){
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
    public ListNode reverse(ListNode slow,int len){
        ListNode pre = null;
        ListNode cen = null;
        ListNode behind = null;
        ListNode newHead = null;
        if(len%2==0){
            System.out.println(slow.val);
            pre = slow;
            if(pre!=null)
                cen = slow.next;
            if(cen!=null)
                behind = cen.next;
            if(cen==null) return slow;
            while(cen!=null){
                cen.next = pre;
                pre = cen;
                newHead =cen;
                cen = behind;
                if(behind!=null) behind = behind.next;
            }
        }else{
            pre = slow.next;
            if(pre!=null)
                cen = slow.next;
            if(cen!=null)
                behind = cen.next;
            if(cen==null) return slow;
            while(cen!=null){
                cen.next = pre;
                pre = cen;
                newHead =cen;
                cen = behind;
                if(behind!=null) behind = behind.next;
            }
        }
        return newHead;
    }
}
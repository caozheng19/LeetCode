package leetcode.problem328;



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode oddEvenList(ListNode head) {
        //无节点
        if(head==null) return null;
        //一个节点
        if(head.next==null) return head;
        //两个节点
        if(head.next.next==null) return head;
        ListNode odd = head;//奇数
        ListNode originOdd = head;//奇数链表的开头
        ListNode even = head.next;
        ListNode originEven = head.next;
        //当链表节点个数为奇数时：even指向null
        //当链表节点个数为偶数时: even指向最后一个节点,even.next==null
        while(even!=null&&even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = originEven;
        return originOdd;

    }
}
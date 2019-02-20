package leetcode.problem142;


import java.util.HashMap;
import java.util.Map;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return null;
        int count = 0;
        Map<ListNode,Integer> map = new HashMap<>();
        while(head!=null){
            if(!map.containsKey(head)){
                map.put(head,count++);
            }else{
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
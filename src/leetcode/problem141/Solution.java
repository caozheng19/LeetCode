package leetcode.problem141;


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
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        if(head.next == null) return false;
        Map<ListNode,Integer> map = new HashMap<>();
        while(head!=null){
            if(!map.containsKey(head)){
                map.put(head,1);
            }else{
                System.out.println(head.val);
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
package leetcode.problem61;



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

//关键是移动k个位置就相当于把最后k个放到最前面
//而不是移动k个位置就相当于把前面k个放到最后面
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null||k==0) return head;
        ListNode tempNode =  head;
        int listLong = 0 ;
        ListNode preTempNode = null;
        while(tempNode!=null){
            listLong++;
            preTempNode = tempNode;
            tempNode = tempNode.next;
        }
        preTempNode.next = head;
        int removeDis = k % listLong ;
        //假设下标从0开始
        int index = listLong - removeDis;
        //找到下标为index的节点
        int i = 0;
        ListNode curNode = head;
        ListNode preCurNode = null;
        while(i<index){
            preCurNode = curNode;
            curNode = curNode.next;
            i++;
        }
        head = curNode;
        preCurNode.next = null;
        //找到尾节点
        // ListNode lastNode = curNode;
        // ListNode markLastNode = curNode;
        // while(lastNode!=null){
        //     markLastNode = lastNode;
        //     lastNode = lastNode.next;
        // }
        // System.out.println("3333");
        // markLastNode.next = head;
        // System.out.println(markLastNode.val);
        // System.out.println(curNode.val);
        // head = curNode;
        return head;



//         if(head==null||k==0) return head;
//         ListNode tempNode =  head;
//         int listLong = 0 ;
//         while(tempNode!=null){
//               listLong++;
//               tempNode = tempNode.next;
//         }
//         //原链表的前v个元素按当前顺序移到最后一个节点后面
//         int v = (k % listLong)+1;
//         int i = 1;
//         ListNode curNode = head;
//         //找到要移动的第v个元素
//         while(i<v){
//             i++;
//             curNode = curNode.next;
//         }
//         ListNode lastNode = head;
//         ListNode markLastNode = null;
//         //找到尾元素
//         while(lastNode!=null){
//             markLastNode = lastNode;
//             lastNode = lastNode.next;
//         }
//         System.out.println(markLastNode.val);
//         markLastNode.next = head;
//         ListNode newHeadNode = curNode.next;
//         curNode.next = null;
//         return newHeadNode;
    }
}
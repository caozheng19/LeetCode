package leetcode.problem82;



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        int headFlag = 1; //当headFlag的值为1时 说明head的值没有发生变化(head仍然是原始链表的head) 当且仅当headFlag为1且head所指向节点的值有重复项时 更换head的指向并且将headFlag置为0
        ListNode frontfrontNode = null;
        ListNode markNode = head;
        ListNode frontNode = head;
        ListNode behindNode = head.next;
        while(frontNode!=null){
            //如果behindNode!=null说明有至少两个节点 所以需要比较
            if(behindNode!=null){
                if(frontNode.val == behindNode.val){
                    //找到最后一个重复的节点
                    while(behindNode.next!=null&&frontNode.val==behindNode.next.val){
                        behindNode = behindNode.next;
                    }
                   /*如果不加frontNode==head
                   1,2,3,3,4,4,5]
                   输出
                   [4,5]
                   预期结果
                   [1,2,5]
                   */
                    if(headFlag==1&&frontNode==head){
                        head=behindNode.next;
                        if(behindNode!=null)
                            frontNode = behindNode.next;
                        if(frontNode!=null)
                            behindNode = frontNode.next;
                        frontfrontNode = head;
                        //一开始写的是headFlag=0 但是不适用于[1,1,2,2]
                        headFlag=1;
                    }else{
                        if(behindNode!=null)
                            frontfrontNode.next = behindNode.next;
                        if(behindNode!=null)
                            frontNode = behindNode.next;
                        if(frontNode!=null)
                            behindNode = frontNode.next;
                    }
                }else{
                    frontfrontNode = frontNode;
                    frontNode = behindNode;
                    if(behindNode!=null)
                        behindNode = behindNode.next;

                }
            }else{
                return head;
            }
        }
        return head;
    }
}
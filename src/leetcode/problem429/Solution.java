package leetcode.problem429;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> outerList = new ArrayList<>();
        if(root==null) return new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> innerList = new ArrayList<>();
            while(queueSize>0){
                Node node = queue.poll();

                for(Node v : node.children){
                    queue.add(v);
                }

                innerList.add(node.val);
                queueSize--;
            }
            outerList.add(innerList);
        }
        return outerList;
    }
}

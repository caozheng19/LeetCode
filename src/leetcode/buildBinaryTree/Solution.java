package leetcode.buildBinaryTree;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int index = 1;
    static class Node{
        String data;
        Node left;
        Node right;
        Node(String data){
            this.data = data;
        }
    }
    public static void main(String[] args){
        String inputStr = "ABC##DE#G##F###";
        String[] inputArr = inputStr.split("");
        Node root = createTree(inputArr);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
    }
    public static Node createTree(String[] inputArr){
        if(inputArr.length==0||index>inputArr.length-1) return null;
        if(inputArr[index].equals("#")){
            return null;
        }
        Node node = new Node(inputArr[index]);
        index++;
        node.left = createTree(inputArr);
        index++;
        node.right = createTree(inputArr);
        return node;
    }
    public static void preOrder(Node node){
        if(node==null) return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(Node node){
        if(node==null) return;
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }
    public static void postOrder(Node node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
    public static void levelOrder(Node node){
        if(node==null) return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            while(queueSize-->0){
                Node n = queue.poll();
                System.out.print(n.data);
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
            }
        }
    }
}
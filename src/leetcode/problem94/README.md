迭代算法
```$xslt
class Solution {
    public List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) { 
       Stack<TreeNode> stack = new Stack<TreeNode>();
       while(root!=null||!stack.isEmpty()){
           while(root!=null){
               stack.add(root);
               root = root.left;
           }
           if(!stack.isEmpty()){
               root = stack.pop();
               list.add(root.val);
               root = root.right;   
           }
       }
       return list;
    }
}
```
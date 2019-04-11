迭代算法
```$xslt
class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
       Stack<TreeNode> stack = new Stack<TreeNode>();
       while(root!=null||!stack.isEmpty()){
           while(root!=null){
               list.add(root.val);
               stack.push(root);
               root=root.left;
           }
           if(!stack.isEmpty()){
               root = stack.pop();
               root = root.right;
           }
       }
       return list;
    }
}
```
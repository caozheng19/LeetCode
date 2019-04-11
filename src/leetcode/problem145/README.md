迭代算法
```
class Solution {
    public List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while(root!=null||!stack1.isEmpty()){
            while(root!=null){
                stack1.push(root);
                stack2.push(0);
                root  = root.left;
            }
            while(!stack1.isEmpty()&&stack2.peek()==1){
                TreeNode n = stack1.pop();
                list.add(n.val);
                stack2.pop();
            }
            if(!stack1.isEmpty()){
                stack2.pop();
                stack2.push(1);
                root = stack1.peek();
                root = root.right;
            }
        }
        return list;
    }
   
}
```

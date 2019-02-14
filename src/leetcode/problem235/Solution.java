package leetcode.problem235;



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    private TreeNode ancestor = new TreeNode(0);
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLowestCommonAncestor(root,p,q);
        return ancestor;
    }
    public void findLowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if((root.val - p.val) * (root.val-q.val) <= 0){
            ancestor = root;

            return;
        }else if(root.val>p.val){
            findLowestCommonAncestor(root.left,p,q);
        }else{
            findLowestCommonAncestor(root.right,p,q);
        }
    }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         TreeNode ancestor = new TreeNode(0);
//         System.out.println("11111111111");
//         System.out.println(ancestor);
//         findLowestCommonAncestor(ancestor,root,p,q);
//         System.out.println("22222222222");
//         System.out.println(ancestor);

//         return ancestor;
//     }
//     public void findLowestCommonAncestor(TreeNode ancestor,TreeNode root,TreeNode p,TreeNode q){
//         if((root.val - p.val) * (root.val-q.val) <= 0){
//             ancestor = root;
//             System.out.println(ancestor);
//             return;
//         }else if(root.val>p.val){
//             findLowestCommonAncestor(ancestor,root.left,p,q);
//         }else{
//             findLowestCommonAncestor(ancestor,root.right,p,q);
//         }
//     }
}
* 递归算法
```$xslt
class Solution {
    List<Integer> innerList = new ArrayList<Integer>();
    List<List<Integer>> outerList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return outerList;
        int depth = countDepth(root);
        for(int i =1;i<=depth;i++){
            innerList.clear();
            levelbianli(root,i);
            outerList.add(new ArrayList<>(innerList));
        }
        return outerList;
        
    }
    
    public void levelbianli(TreeNode node,int i){
        if(node==null) return;
        if(i<1) return;
        if(i==1){
           innerList.add(node.val);
        }
        levelbianli(node.left,i-1); //注意这里
        levelbianli(node.right,i-1);
    }
    
    public int countDepth(TreeNode node){
        if(node==null) return 0;
        int left = countDepth(node.left)+1;
        int right = countDepth(node.right)+1;
        return Math.max(left,right);
    }
}
```
* 创建二叉树的代码
```$xslt
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
```
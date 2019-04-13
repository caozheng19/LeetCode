package leetcode.problem867;

class Solution {
    public int[][] res;
    public int[][] transpose(int[][] A) {
        res = new int[A[0].length][A.length];
        for(int i = 0;i<A.length;i++){
            for(int j = 0;j<A[i].length;j++){
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}

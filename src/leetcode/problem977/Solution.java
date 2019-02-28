package leetcode.problem977;

class Solution {
    public int[] sortedSquares(int[] A) {
        if(A.length==1) return new int[]{Math.abs(A[0])*Math.abs(A[0])};
        int[] B = new int[A.length];
        for(int i = 0;i<A.length-1;i++){
            for(int j = 0;j<A.length-i-1;j++){
                if(Math.abs(A[j])*Math.abs(A[j])>Math.abs(A[j+1])*Math.abs(A[j+1])){
                    B[j] = Math.abs(A[j+1])*Math.abs(A[j+1]);
                    B[j+1] = Math.abs(A[j])*Math.abs(A[j]);
                    int temp = A[j];
                    A[j] =A[j+1];
                    A[j+1] = temp;
                }else{
                    B[j] = Math.abs(A[j])*Math.abs(A[j]);
                    B[j+1] = Math.abs(A[j+1])*Math.abs(A[j+1]);
                }
            }
        }
        return B;
    }
}
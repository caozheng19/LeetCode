package leetcode.problem54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> list = new ArrayList<Integer>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0) return list;
        int top = 0;
        int left = 0;
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;
        while(top<=bottom&&left<=right){
            for(int i=top,j=left;j<=right&&top<=bottom&&left<=right;j++){

                list.add(matrix[i][j]);
            }
            top++;
            for(int i = right,j=top;j<=bottom&&top<=bottom&&left<=right;j++){

                list.add(matrix[j][i]);
            }
            right--;
            for(int i = bottom,j=right;j>=left&&top<=bottom&&left<=right;j--){
                System.out.println(matrix[i][j]);
                list.add(matrix[i][j]);
            }
            bottom--;
            for(int i = left,j=bottom;j>=top&&top<=bottom&&left<=right;j--){
                list.add(matrix[j][i]);
            }
            left++;

        }
        return list;
    }
}
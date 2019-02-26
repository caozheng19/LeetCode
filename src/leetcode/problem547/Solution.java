package leetcode.problem547;

class Solution {
    public int findCircleNum(int[][] M) {
        int [] father= new int[M.length];
        for(int i = 0;i<father.length;i++){
            father[i] = i;
        }
        for(int i = 0;i<M.length;i++){
            for(int j = i+1;j<M[i].length;j++){
                if(M[i][j]==1){
                    merge(father,i,j);
                }
            }
        }
        int count = 0;
        for(int i = 0;i<father.length;i++){
            if(father[i]==i){
                count++;
            }
        }
        return count;
    }
    public void merge(int[] father,int i,int j){
        int fatherI = find(father,i);
        int fatherJ = find(father,j);
        if(fatherI!=fatherJ){
            father[fatherI] = fatherJ;//一开始写成father[i]=j; father[i]=fatherJ都不对
        }
    }
    public int find(int[] father,int x){
        while(father[x]!=x){
            x = father[x];
        }
        return x;
    }
}

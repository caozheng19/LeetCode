package leetcode.problem684;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] father = new int[edges.length];
        int[] result = new int[2];
        for(int i = 0;i<edges.length;i++){
            father[i]=i;
        }
        for(int i = 0;i<edges.length;i++){
            result = merge(father,edges[i][0]-1,edges[i][1]-1,result);


        }
        return result;
    }
    public int[] merge(int[] father,int i,int j,int[] result){
        int fatherI = find(father,i);
        int fatherJ = find(father,j);
        if(fatherI!=fatherJ){
            father[fatherI] = fatherJ;
            return result;
        }else{
            result[0]=i+1;
            result[1]=j+1;
            return new int[]{i+1,j+1};

        }
    }
    public int find(int[] father,int x){
        while(father[x]!=x){
            x = father[x];
        }
        return x;
    }
}
package leetcode.problem69;

class Solution {
    public int mySqrt(int x) {
        long result = erfensearch(x,1,x);
        return (int)result;
    }
    public long erfensearch(int target,long left,long right){
        if(left<=right){
            long mid = (left+right)/2;
            if(mid*mid==target){
                return mid;
            }else if(mid*mid>target){
                return erfensearch(target,left,mid-1);
            }else{
                return erfensearch(target,mid+1,right);
            }
        }else{
            return right;
        }

    }
}

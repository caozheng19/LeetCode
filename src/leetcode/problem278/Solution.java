package leetcode.problem278;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

//public class Solution extends VersionControl {
//    public int firstBadVersion(int n) {
//        int index = erfenSearch(n,1,n);
//        return index;
//    }
//    public int erfenSearch(int n,int left,int right){
//        if(left<=right){
//            int mid = left+(right-left)/2;
//            if(isBadVersion(mid)){
//                return erfenSearch(n,left,mid-1);
//            }else if(!isBadVersion(mid)){
//                return erfenSearch(n,mid+1,right);
//            }
//        }
//        if(left>right){
//            return left;
//        }
//        return -1;
//    }

//}
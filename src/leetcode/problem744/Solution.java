package leetcode.problem744;
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        return erfenSearch(letters,0,letters.length-1,target);
    }
    public char erfenSearch(char[] letters,int left,int right,char target){
        if(left<=right){
            int mid = (left+right)/2;
            if(letters[mid]>target){
                return erfenSearch(letters,left,mid-1,target);
            }else{
                return erfenSearch(letters,mid+1,right,target);
            }
        }
        else{
            int index = left%letters.length;
            return letters[index];
        }
    }
}

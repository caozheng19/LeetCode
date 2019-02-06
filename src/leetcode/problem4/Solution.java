package leetcode.problem4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int []temp = new int[nums1.length+nums2.length];
        int t = 0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<=nums2[j]){
                temp[t++] = nums1[i++];
            }else{
                temp[t++] = nums2[j++];
            }
        }
        while(i<nums1.length){
            temp[t++] = nums1[i++];
        }
        while(j<nums2.length){
            temp[t++] = nums2[j++];
        }
        if((nums1.length+nums2.length)%2==0){

//             System.out.println((int)Math.ceil((nums1.length+nums2.length)/2.0));

//             System.out.println((int)Math.floor((nums1.length+nums2.length)/2.0));
            return (temp[(int)Math.ceil((nums1.length+nums2.length-1)/2.0)]+temp[(int)Math.floor((nums1.length+nums2.length-1)/2.0)])*1.0/2.0;

        }else{
            return temp[(nums1.length+nums2.length-1)/2];
        }

    }
}

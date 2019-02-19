package leetcode.problem922;

//思路就是用两个“指针”分别指向指向奇数下标和偶数下标 当当前下标和下标所对应的值不全是奇数或偶数时 就交换这两个指针的值
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;//偶数
        int odd = 1;//奇数
        while(even<=A.length-2){
            System.out.println(even);
            if(A[even]%2!=0){
                while(odd<=A.length-1){
                    if(A[odd]%2==0){
                        int t = A[even];
                        A[even] = A[odd];
                        A[odd] = t;
                        even+=2;
                        odd+=2;
                        break;
                    }else{
                        odd+=2;
                    }
                }

            }else{
                even+=2;
            }
        }
        return A;
    }
}

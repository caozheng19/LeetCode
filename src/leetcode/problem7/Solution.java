package leetcode.problem7;

class Solution {
    public int reverse(int x) {
        try {
            String str = String.valueOf(x);
            StringBuilder strBuilder = new StringBuilder(str);
            //  StringBuilder strBuilderReverse = strBuilder.reverse();
            int len = strBuilder.length();
            if (str.charAt(0) == '-') {
                return Integer.valueOf(strBuilder.delete(0, 1).reverse().insert(0, '-').toString());
            }
            return Integer.valueOf(strBuilder.reverse().toString());
        } catch (Exception e) {
            return 0;
        }

    }
}

package leetcode.InputAndOutput;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.IllegalStateException;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrInput = br.readLine().trim().split(" ");
        int n = Integer.parseInt(arrInput[0]);
        int m = Integer.parseInt(arrInput[1]);
        for (int i = 1; i <= n; i++) {//输入数据，sum是左上角（0，0）到右下角（i，j）表示的矩阵的所有元素之和。这也是动态规划的关键，如果不这样存数据，那么求每个矩阵的值就要遍历，耗费很多时间
            char[] arrChar = br.readLine().trim().toCharArray();
            System.out.println(arrChar);
        }
    }
}

什么是全排列？就是从n个数字中选择n个数字按照一定的顺序排列起来。
本文要讨论的算法要完成的任务是：给定一个数组，输出其所有的全排列结果。要求可以概括为两点：
输出该数组所有的全排列结果
任意两个全排列是不同的，即任意两个全排列中n个数字排列的顺序不能相同
 

其实核心思想就是枚举数组中每个位置的数字，而难点就是如何有序地枚举数组每个位置的数字而做到既全面又不重复。
首先我们以这个数组为a={1,2,3}为例，要找到它所有的全排列，这里我们用a[0],a[1],a[2]来表示这个数组中的第一、第二、第三个位置的数值，当前的数组各个位置的值为a[0]=1,a[1]=2,a[2]=3。于是算法可以分为以下几步来完成：
对a[0]的位置用1,2,3分别来替换，得到3个子序列
由于a[0]位置能取的所有的值的情况已经枚举完毕了，所以我们再对这3个子序列中a[1]位置所有能取的值再进行枚举。
到这里时，所有的子序列a[0]和a[1]都已经确定了，所以a[2]就自然已经确定了，只需要输出即可。图示如下：


其中，用红色的框标识出来的便是子序列，这里采用的是递归的方法，所以每一层实际上代表着递归的深度。
```
package nextPer;
 
import java.util.Arrays;
 
public class NextPer {
	public static void main(String[] args) {
		int[] arr={1,2,3};
		nextPer(arr,0);
	}
	private static void nextPer(int[] arr,int start){
                    //当start==arr.length-1时，说明子序列的长度为1，就不用再往下分子序列了
		if(start==arr.length-1){
			System.out.println(Arrays.toString(arr));
		}
		for(int i=start;i<arr.length;i++){
                        //start代表的是每一个子序列的第一个位置，我们每一层递归的任务都只有一个：
                        //枚举该层子序列第一个位置可以取的值
			int temp=arr[start];
			arr[start]=arr[i];
			arr[i]=temp;
			
                        //该层递归的子序列第一个位置已经确定了，所以又可以往下再分
			nextPer(arr,start+1);
 
                        //把第该层子序列第一个位置的值换成另外一个值，所以要交换回来
			temp=arr[start];
			arr[start]=arr[i];
			arr[i]=temp;
		}
	}
}
```
要明白这个算法的思想，只需要明白每一层递归在做的事：就是在不断地划分子序列，直到不能再划分为止，就可以输出该数组的值----即当子序列长度为1时，该子序列就不能再往下划分了。
在这里要注意几点：
由于递归的特性，是层层往下走，只有走到某个分支的末尾（我们叫做递归的出口）时才停止，然后再回溯（就是回到上一层），并把上一层的各个分支走完，再逐步往回走，所以结合输出结果和图示我们就可以知道，程序实际上在按从左到右一个分支一个分支地来走的。
这里的例子目的只是为了说明其算法思想，所以比较简单，但是我们的目的是可以对任意长度的数组进行全排列，只要明白这个算法的思路，就可以实现。我们暂时不考虑数组里面元素重复的情况，这其实可以先去重再用这个方法来实现。
这个例子可以帮我们理解递归的思想，但是递归的空间开销较大，所以使用递归的时候要注意有出口而且深度不要太深。

[原文链接](https://blog.csdn.net/GetterAndSetter/article/details/81516259)

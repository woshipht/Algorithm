package 排序算法;

import java.util.Arrays;

public class 基数排序 {
    public static void main(String[] args){
        int[] test = {421,240,115,532,305,430,124};
        print(doAlgorithm(test));
    }

    //本质上是 “多关键字排序” 与 “非比较排序” ，整体思路与计数排序类似，特别思想是：每个循环都是一次计数排序，循环结束后是基数排序
    static int[] doAlgorithm(int[] a){
        int[] count = new int[10];          //计数数组，用于装0~9，一共10个数，因为每次都只关注一位数字
        int[] result = new int[a.length];
        int findMax = -1;                   //用于计算数组中最高的位数

        for(int i=0; i<a.length; i++) {     //计算数组中最高的位数findMax+1
            int CountNum = 0;

            for(int j=a[i]; j>0; j/=10){
                CountNum++;
            }
            if(CountNum > findMax){ findMax = CountNum;}
        }

        for(int i=0; i<findMax+1; i++){     //findMax+1是数组中最大的位数，i=2代表此时比较百位数，即10^2=100，以此类推
            int division = (int) Math.pow(10,i);

            for(int j=0; j<a.length; j++){
                int num = a[j] / division % 10;     //计算出当前 位数 的数值
                count[num]++;                       //在对应计数数组上添加
            }

            for(int j=1; j<count.length; j++) {
                count[j] = count[j] + count[j-1];   //将计数数组改成累加数组
            }

            for(int j=a.length-1; j>=0; j--){
                int num = a[j] / division % 10;
                result[--count[num]] = a[j];        //从后往前遍历数组，思路同计数排序
            }

            System.arraycopy(result,0,a,0,a.length);    //将a数组的值全部替换为result数组，这样就可以避免多次生成新数组，重复利用a与result
            Arrays.fill(count,0);       //将整个count以0填充，以便再次使用
        }
        return result;
    }

    static void print(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
    }
}

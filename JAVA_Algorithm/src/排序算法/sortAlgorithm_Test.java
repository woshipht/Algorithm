package 排序算法;

import java.util.Arrays;
import java.util.Random;

public class sortAlgorithm_Test {
    public static void main(String[] args){
        check();
    }

    static int[] generateRandomNum(){
        Random r = new Random();
        int[] a = new int[10000];
        for(int i=0; i<a.length; i++){
            a[i] = r.nextInt(10000);
        }
        return a;
    }

    static void check(){
        int[] arr = generateRandomNum();
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr,0,arr2,0,arr.length);
        boolean ifSame = true;

        for(int j=0;j<100;j++){
            Arrays.sort(arr);
//            选择排序.doAlgorithm(arr2);
//            冒泡排序.doAlgorithm(arr2);
//            插入排序.doAlgorithm(arr2);
//            希尔排序.doAlgorithm1(arr2);
//            希尔排序.doAlgorithm2(arr2);
//            归并排序_complete.doMerge(arr2,0,arr2.length-1);
//            单轴快速排序.recursion(arr2,0,arr2.length-1);
//            int[] arr3 = 计数排序.doAlgorithm2(arr2);                 //计数排序会返回一个全新数组，对比此全新数组！
//            int[] arr3 = 基数排序.doAlgorithm(arr2);
//            int[] arr3 = 桶排序.doAlgorithm(arr2);

            for(int i=0;i<arr.length;i++){
                if(arr[i]!=arr2[i]){
                    ifSame=false;
                }
            }
        }

        if(ifSame==true){System.out.println("You win!");}
        else{System.out.println("You lose!");}
    }
}

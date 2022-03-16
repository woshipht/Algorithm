package 排序算法;

import java.util.ArrayList;
import java.util.Arrays;

public class 桶排序 {
    public static void main(String[] args){
        int[] test = {0,12,18,93,45,76,89,3,55,98,67,100};
        print(doAlgorithm(test));
    }


    static int[] doAlgorithm(int[] a){
        ArrayList<Integer> bucket1 = new ArrayList<>();      //默认分4个桶
        ArrayList<Integer> bucket2 = new ArrayList<>();
        ArrayList<Integer> bucket3 = new ArrayList<>();
        ArrayList<Integer> bucket4 = new ArrayList<>();

        int max = a[0],min = a[0];
        int[] result = new int[a.length];

        for(int i=1; i<a.length; i++){
            if(max < a[i]){ max = a[i];}    //找到数组中的最小值和最大值
            if(min > a[i]){ min = a[i];}
        }

        float range = (max-min)/4;

        for (int j : a) {                   //装桶
            if (min <= j && j <= min + range) {
                bucket1.add(j);
            }
            if (min + range < j && j <= min + range * 2) {
                bucket2.add(j);
            }
            if (min + range * 2 < j && j <= min + range * 3) {
                bucket3.add(j);
            }
            if (min + range * 3 < j && j <= max) {
                bucket4.add(j);
            }
        }

        int[] bucket1OfArray = new int[bucket1.size()];         //将arraylist转化为int[]并在桶内进行快排
        for(int i=0; i<bucket1.size(); i++){
            bucket1OfArray[i] = bucket1.get(i);
        }
        单轴快速排序.recursion(bucket1OfArray,0,bucket1OfArray.length-1);

        int[] bucket2OfArray = new int[bucket2.size()];
        for(int i=0; i<bucket2.size(); i++){
            bucket2OfArray[i] = bucket2.get(i);
        }
        单轴快速排序.recursion(bucket2OfArray,0,bucket2OfArray.length-1);

        int[] bucket3OfArray = new int[bucket3.size()];
        for(int i=0; i<bucket3.size(); i++){
            bucket3OfArray[i] = bucket3.get(i);
        }
        单轴快速排序.recursion(bucket3OfArray,0,bucket3OfArray.length-1);

        int[] bucket4OfArray = new int[bucket4.size()];
        for(int i=0; i<bucket4.size(); i++){
            bucket4OfArray[i] = bucket4.get(i);
        }
        单轴快速排序.recursion(bucket4OfArray,0,bucket4OfArray.length-1);

        System.arraycopy(bucket1OfArray,0,result,0,bucket1OfArray.length);      //将快排后结果放入result
        System.arraycopy(bucket2OfArray,0,result,bucket1OfArray.length,bucket2OfArray.length);
        System.arraycopy(bucket3OfArray,0,result,bucket1OfArray.length+bucket2OfArray.length,bucket3OfArray.length);
        System.arraycopy(bucket4OfArray,0,result,bucket1OfArray.length+bucket2OfArray.length+bucket3OfArray.length,bucket4OfArray.length);

        return result;
    }

    static void print(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
    }
}

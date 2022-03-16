package 排序算法;

public class 单轴快速排序 {
    public static void main(String[] args){
        int[] test = {1,7,2,5,3,9,8,4,6,10};
        print(test);
        recursion(test,0,test.length-1);
        print(test);
    }

    public static void recursion(int[] a, int left, int right) {
        if(left>right) return;
        int mid = Algorithm(a,left,right);
        recursion(a,left,mid-1);
        recursion(a,mid+1,right);
    }

    public static int Algorithm(int[] a, int left, int right){
        int axis = a[right];           //轴
        int axisPosition = right;

        while (left<right){
            while (a[left] < axis && left <= right){ left++; }       //找到左往右第一个大于7
            while (a[right] >= axis && left < right){ right--; }        //找到右往左第一个小于7
            if(left<right){
                changePosition(a,left,right);       //直接交换找到的两个位置
            }
        }
        changePosition(a,left,axisPosition);        //最后交换轴与第一个最大数的位置
        return left;
    }

    public static void changePosition(int[] a, int firstBigger, int firstSmaller){
        int temp = a[firstBigger];
        a[firstBigger] = a[firstSmaller];
        a[firstSmaller] = temp;
    }

    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}

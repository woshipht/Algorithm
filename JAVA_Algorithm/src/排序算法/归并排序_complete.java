package 排序算法;

public class 归并排序_complete {
    public static void main(String[] args){
        int[] test1 = {2,6,4,10,8,5,1,11,9,3,7};
        doMerge(test1,0,test1.length-1);
        print(test1);
    }

    static void doMerge(int[] a,int left, int right){
        if(left == right) return;
        //均分两个子数组
        int mid = (left + right)/2;
        //左边递归
        doMerge(a,left,mid);
        //右边递归
        doMerge(a,mid+1,right);
        //实际判断函数
        doAlgorithm(a,left,mid+1,right);
    }

    static void doAlgorithm(int[] a, int left, int right, int end){
        int mid = right-1;    //两个数组的分界值
        int[] temp = new int[end-left+1];      //此时的temp数组长度 与 此时递归过程中a数组的实际参与长度(end-left+1)有关

        int i = left; int j = right; int k = 0;

        while(i <= mid && j <= end){ temp[k++] = a[i] > a[j] ? a[j++] : a[i++]; }

        while(i <= mid){ temp[k++] = a[i++]; }

        while(j <= end){ temp[k++] = a[j++]; }

        //从a数组左指针位置，开始复制temp数组中的值到a数组
        for(int l=0; l<temp.length; l++){
            a[left+l] = temp[l];
        }
    }

    static void changePosition(int[] a, int origin, int min){
        int temp = a[origin];
        a[origin] = a[min];
        a[min] = temp;
    }

    static void print(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
    }
}

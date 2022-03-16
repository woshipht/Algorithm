package 排序算法;

public class 归并排序_basic {
    public static void main(String[] args){
        int[] test1 = {1,4,7,8,10,12,3,6,9};
        print(doAlgorithm(test1));
    }

    static int[] doAlgorithm(int[] a){
        int mid = 5;
        int[] temp = new int[a.length];

        int i = 0;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=a.length){
            if(a[i]>a[j]){
                temp[k++] = a[j++];
                //等价于 temp[k] = a[j]; j++; k++;
            }else {
                temp[k++] = a[i++];
                //等价于 temp[k] = a[i]; i++; k++;
            }
            //整个while中可以再简化成 temp[k++] = a[i] > a[j] ? a[j++] : a[i++];
        }

        while(i<=mid){
            temp[k++] = a[i++];
        }

        while(j<=a.length){
            temp[k++] = a[j++];
        }

        return temp;
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

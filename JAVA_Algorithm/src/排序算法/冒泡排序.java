package 排序算法;

public class 冒泡排序 {
    public static void main(String[] args){
        int[] test = {5,6,1,7,4,3,8,2,9};

        print(doAlgorithm(test));
    }

    static int[] doAlgorithm(int[] a){
        for(int i=a.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(a[j]>a[j+1]){
                    changePosition(a,j,j+1);
                }
            }
        }
        return a;
    }

    static void changePosition(int[] a, int origin, int min){
        int temp = a[origin];
        a[origin] = a[min];
        a[min] = temp;
    }

    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}

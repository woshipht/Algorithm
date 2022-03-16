package 排序算法;

public class 插入排序 {
    public static void main(String[] args){
        int[] test = {2,6,4,8,5,1,9,3,7};
        print(doAlgorithm(test));
    }

    static int[] doAlgorithm(int[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i;j>0;j--){
                if(a[j]<a[j-1]){
                    changePosition(a,j,j-1);
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
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]);
        }
    }
}

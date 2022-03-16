package 排序算法;

public class 希尔排序 {
    public static void main(String[] args){
        int[] test1 = {65,6,11,2,5,3,9,78,13,24,17,8};
        print(doAlgorithm1(test1));
        System.out.println();
        int[] test2 = {65,6,11,2,5,3,9,78,13,24,17,8};
        print(doAlgorithm2(test2));
    }

    static int[] doAlgorithm1(int[] a){
        //二分序列计算, gap = length/2
        for(int gap=a.length/2;gap>0;gap/=2){
            for (int i = gap; i < a.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (a[j] < a[j - gap]) {
                        changePosition(a, j, j - gap);
                    }
                }
            }
        }
        return a;
    }

    static int[] doAlgorithm2(int[] a){
        //knuth序列计算, gap = 3*gap + 1
        int h=1;

        while (h <= a.length/3){
            h=3*h+1;
        }

        for(int gap=h;gap>0;gap=(gap-1)/3){
            for (int i = gap; i < a.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (a[j] < a[j - gap]) {
                        changePosition(a, j, j - gap);
                    }
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
            System.out.print(a[i]+" ");
        }
    }
}

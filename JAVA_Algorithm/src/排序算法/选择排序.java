package 排序算法;

public class 选择排序 {
    public static void main(String[] args){
        int[] test = {5,7,9,4,6,3,8,1,2};
        选择排序 example = new 选择排序();
        int[] result = example.doAlgorithm(test);
        example.print(result);
    }

    public static int[] doAlgorithm(int[] a){
        for(int i=0;i<a.length-1;i++){
            int num = i;
            for(int j=i+1;j<a.length;j++){
                if(a[num] > a[j]){
                    num = j;
                }
            }
            changePosition(a,i,num);
        }
        return a;
    }

    public static void changePosition(int[] a, int origin, int min){
        int temp = a[origin];
        a[origin] = a[min];
        a[min] = temp;
    }

    public void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}

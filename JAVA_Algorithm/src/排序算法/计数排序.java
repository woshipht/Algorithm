package 排序算法;

public class 计数排序 {
    public static void main(String[] args){
        int[] test = {1,0,0,2,1,2,1,0,2,0,1,0,0,2,0};
        int[] test1 = {11,10,13,12,11,12,11,13,12,10,11,10,15,12,10};
        print(doAlgorithm2(test1));
//        print(doAlgorithm3(test));
    }

    //写的这个算法是不稳定的，且只能从0开始
    static int[] doAlgorithm1(int[] a){
        int[] num = new int[3];
        int[] array = new int[a.length];

        for(int i=0; i<a.length; i++){
            num[a[i]]++;                    //生成计数数组
        }

        for(int i=0, k=0; i<num.length; i++){
            while (num[i]-- != 0){          //在num[i]后面加--可以省略下一行
//                num[i]--;
                array[k++] = i;             //在array[]加++可以省略下一行
//                k++;
            }
        }

        return array;
    }

    //写的这个算法是不稳定的，且可以不从0开始
    static int[] doAlgorithm2(int[] a){
        int max = a[0],min = a[0];

        for(int i=1; i<a.length; i++){
            if(max < a[i]){ max = a[i];}    //找到数组中的最小值和最大值
            if(min > a[i]){ min = a[i];}
        }

        int[] num = new int[max - min + 1];     //确定计数数组长度
        int[] array = new int[a.length];

        for(int i=0; i<a.length; i++){
            num[a[i] - min]++;                    //生成计数数组
        }

        for(int i=0, k=0; i<num.length; i++){
            while (num[i]-- != 0){          //在num[i]后面加--可以省略下一行
//                num[i]--;
                array[k++] = i+min;             //在array[]加++可以省略下一行
//                k++;
            }
        }

        return array;
    }

    //写的这个算法是稳定的，采用了累加数组的概念！
    static int[] doAlgorithm3(int[] a){
        int[] num = new int[3];
        int[] array = new int[a.length];

        for(int i=0; i<a.length; i++){
            num[a[i]]++;                    // 生成计数数组
        }

        for(int i=1; i<num.length; i++){
            num[i] = num[i] + num[i-1];     // 将上面的计数数组变为累加数组
        }

        for(int i=a.length-1; i>=0; i--){
            array[num[a[i]]-1] = a[i];      //从后往前遍历数组，每次发现一个数a[i]后，找到a[i]对应累加数组值，将a[i]放在新数组的累加数组值-1位置，然后将累加数组值--
            num[a[i]]--;

//            array[--num[a[i]]] = a[i];    //和上面一样，但是更简洁
        }

        return array;
    }

    static void print(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
    }
}

package 漫画算法.数组结构;

import java.util.Arrays;

public class 数组及其操作_数组实现 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,0,0};
        System.out.println("初始数组：                  array = "+Arrays.toString(array));

        //1.读取元素，直接读
        System.out.println("1.读取单个元素：             array[2] = "+array[2]);

        //2.更新元素，直接改
        array[4] = 555;
        System.out.println("2.更新第五个元素后：          array = "+Arrays.toString(array));

        //3.插入元素
        //①尾部插入，直接插
        int num1 = 999;
        数组及其操作_数组实现.尾部插入操作(array,num1);

        //②中间插入，涉及数组元素后移
        int num2 = 1818;
        System.out.print("3.②中间");
        数组及其操作_数组实现.中间插入操作(array,3,num2);

        //③超范围插入,涉及数组扩容
        int num3 = 813;
        System.out.print("3.③超范围");
        array = 数组及其操作_数组实现.超范围插入操作(array,4,num3);

        //4.删除元素,涉及数组元素前移
        数组及其操作_数组实现.删除操作(array,4);
    }

    public static void 尾部插入操作(int[] array, int num){
        int size=0;
        for(int i=0; i<array.length; i++){
            if(array[i] !=0) size++;
        }

        if(size == array.length) System.out.println("数组满了，不能插入");

        if(size < array.length) array[size] = num ;
        System.out.println("3.①尾部插入元素999后：       array = "+Arrays.toString(array));
    }

    public static void 中间插入操作(int[] array, int position, int num){
        int size=0;
        for(int i=0; i<array.length; i++){
            if(array[i] !=0) size++;
        }

        if(size == array.length) System.out.println("数组满了，不能插入");

        if(position<0 || position>size){
            System.out.println("插入数组位置错误，不能插入");
            return;
        }

        for (int i = size; i>=position; i--){
            array[i] = array[i-1];
        }

        array[position-1] = num;
        System.out.println("插入元素"+num+"在"+position+"位置后：    array = " +Arrays.toString(array));
    }

    public static int[] 超范围插入操作(int[] array, int position, int num){
        int size=0;
        for(int i=0; i<array.length; i++){
            if(array[i] !=0) size++;
        }

        if(size == array.length){
            int[] arr = new int[array.length * 2];
            System.arraycopy(array,0,arr,0,array.length);
            array = arr;
        }

        if(position<0 || position>size){
            System.out.println("数组位置错误，不能插入");
            return new int[8];
        }

        数组及其操作_数组实现.中间插入操作(array,position,num);

        return array;
    }

    public static void 删除操作(int[] array, int position){
        int size=0;
        for(int i=0; i<array.length; i++){
            if(array[i] !=0) size++;
        }

        if(position<0 || position>size){
            System.out.println("数组位置错误，不能插入");
            return;
        }

        for(int i=position-1; i<size-1; i++){
            array[i] = array[i+1];
        }

        array[size-1] = 0;
        System.out.println("4.删除元素在"+position+"位置后：              array = " +Arrays.toString(array));
    }
}

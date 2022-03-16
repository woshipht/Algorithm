package 漫画算法.栈结构;

import java.util.Arrays;

public class 栈及其操作_数组实现 {

    public static void main(String[] args) {
        int[] stack = new int[5];

        //1.入栈
        栈及其操作_数组实现.入栈(stack,8);
        栈及其操作_数组实现.入栈(stack,5);
        栈及其操作_数组实现.入栈(stack,3);
        System.out.println("栈内信息为：          stack = "+ Arrays.toString(stack));

        //2.出栈
        栈及其操作_数组实现.出栈(stack);
        System.out.println("出栈一个元素后：       stack = "+ Arrays.toString(stack));
        栈及其操作_数组实现.出栈(stack);
        System.out.println("出栈一个元素后：       stack = "+ Arrays.toString(stack));
        栈及其操作_数组实现.出栈(stack);
        System.out.println("出栈一个元素后：       stack = "+ Arrays.toString(stack));
    }

    public static void 入栈(int[] array, int num){
        int size = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] !=0) size++;
        }

        if(size == array.length) System.out.println("栈满了，不能插入");

        if(size < array.length) array[size] = num ;
    }

    public static void 出栈(int[] array){
        int size = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] !=0) size++;
        }

        array[size-1] = 0;
    }
}

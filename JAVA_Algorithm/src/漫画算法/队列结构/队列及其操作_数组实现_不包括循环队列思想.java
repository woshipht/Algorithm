package 漫画算法.队列结构;

import java.util.Arrays;

public class 队列及其操作_数组实现_不包括循环队列思想 {
    private static int size = 0;

    public static void main(String[] args) {
        int[] stack = new int[5];

        //1.入栈
        队列及其操作_数组实现_不包括循环队列思想.入队(stack,8);
        队列及其操作_数组实现_不包括循环队列思想.入队(stack,5);
        队列及其操作_数组实现_不包括循环队列思想.入队(stack,3);
        System.out.println("队列内信息为：          stack = "+ Arrays.toString(stack));

        //2.出栈
        队列及其操作_数组实现_不包括循环队列思想.出队(stack);
        System.out.println("出队一个元素后：       stack = "+ Arrays.toString(stack));
        队列及其操作_数组实现_不包括循环队列思想.出队(stack);
        System.out.println("出队一个元素后：       stack = "+ Arrays.toString(stack));

        //3.继续入栈，发现前面部分会浪费掉
        队列及其操作_数组实现_不包括循环队列思想.入队(stack,8);
        队列及其操作_数组实现_不包括循环队列思想.入队(stack,5);
        System.out.println("队列内信息为：          stack = "+ Arrays.toString(stack));
        队列及其操作_数组实现_不包括循环队列思想.入队(stack,5);
    }

    public static void 入队(int[] array, int num){
        if(size == array.length) System.out.println("队列满了，不能入队");

        if(size < array.length) array[size] = num ;

        size++;
    }

    public static void 出队(int[] array){
        int length = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] !=0) length++;
        }

        if(length == 0) System.out.println("队列空了，不能出队");
        for(int i=0; i<array.length; i++){
            if(array[i] !=0) {
                array[i]=0;
                return;
            }
        }
    }
}

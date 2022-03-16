package 漫画算法.队列结构;

import java.util.Arrays;

public class 队列及其操作_数组实现_循环队列思想 {
    private static int front = 0;
    private static int last = 0;

    public static void main(String[] args) {
        int[] stack = new int[5];

        //1.入栈
        队列及其操作_数组实现_循环队列思想.入队(stack,1);
        队列及其操作_数组实现_循环队列思想.入队(stack,2);
        队列及其操作_数组实现_循环队列思想.入队(stack,3);
        System.out.println("队列内信息为：          stack = "+ Arrays.toString(stack));

        //2.出栈
        队列及其操作_数组实现_循环队列思想.出队(stack);
        System.out.println("出队一个元素后：       stack = "+ Arrays.toString(stack));
        队列及其操作_数组实现_循环队列思想.出队(stack);
        System.out.println("出队一个元素后：       stack = "+ Arrays.toString(stack));

        //3.继续入栈，发现整个队列循环起来
        队列及其操作_数组实现_循环队列思想.入队(stack,4);
        队列及其操作_数组实现_循环队列思想.入队(stack,5);
        System.out.println("队列内信息为：          stack = "+ Arrays.toString(stack));
        队列及其操作_数组实现_循环队列思想.入队(stack,6);
        队列及其操作_数组实现_循环队列思想.入队(stack,7);
        System.out.println("队列内信息为：          stack = "+ Arrays.toString(stack));
        队列及其操作_数组实现_循环队列思想.出队(stack);
        队列及其操作_数组实现_循环队列思想.出队(stack);
        队列及其操作_数组实现_循环队列思想.出队(stack);
        队列及其操作_数组实现_循环队列思想.出队(stack);
        队列及其操作_数组实现_循环队列思想.出队(stack);
        队列及其操作_数组实现_循环队列思想.入队(stack,8);
        队列及其操作_数组实现_循环队列思想.入队(stack,9);
        队列及其操作_数组实现_循环队列思想.入队(stack,10);
        队列及其操作_数组实现_循环队列思想.入队(stack,11);
        System.out.println("队列内信息为：          stack = "+ Arrays.toString(stack));
    }

    public static void 入队(int[] array, int num){
        int size=0;
        for(int i=0; i<array.length; i++){
            if(array[i] !=0) size++;
        }

        if(size == array.length) {
            System.out.println("队列满了，不能入队");
            return;
        }

        array[last] = num;
        last = (last+1)%array.length;
    }

    public static void 出队(int[] array){
        int length = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] !=0) length++;
        }

        if(length == 0) {
            System.out.println("队列空了，不能出队");
            return;
        }

        array[front]=0;
        front = (front+1)%array.length;
    }
}

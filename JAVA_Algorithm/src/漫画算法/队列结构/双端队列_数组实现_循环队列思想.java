package 漫画算法.队列结构;

import java.util.Arrays;

public class 双端队列_数组实现_循环队列思想 {
    private static int front = 0;
    private static int last = 0;

    public static void main(String[] args) {
        int[] stack = new int[5];

        //1.入栈
        双端队列_数组实现_循环队列思想.入队(stack,1,false);
        双端队列_数组实现_循环队列思想.入队(stack,2,false);
        双端队列_数组实现_循环队列思想.入队(stack,3,false);
        System.out.println("队列内信息为：          stack = "+ Arrays.toString(stack));

        //2.出栈
        双端队列_数组实现_循环队列思想.出队(stack,true);
        System.out.println("出队一个元素后：       stack = "+ Arrays.toString(stack));
        双端队列_数组实现_循环队列思想.出队(stack,false);
        System.out.println("出队一个元素后：       stack = "+ Arrays.toString(stack));

        //3.继续入栈，发现整个队列循环起来

    }

    public static void 入队(int[] array, int num, boolean ifLast){
        int size=0;
        if(ifLast){
            for(int i=0; i<array.length; i++){
                if(array[i] !=0) size++;
            }

            if(size == array.length) {
                System.out.println("队列满了，不能入队");
                return;
            }

            array[last] = num;
            last = (last+1)%array.length;
        }else {
            for(int i=0; i<array.length; i++){
                if(array[i] !=0) size++;
            }

            if(size == array.length) {
                System.out.println("队列满了，不能入队");
                return;
            }

            if(front==0){
                front = front+array.length;
            }
            front--;
            array[front] = num;
        }

    }

    public static void 出队(int[] array,boolean ifFront){
        if(ifFront){
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
        }else {
            int length = 0;
            for(int i=0; i<array.length; i++){
                if(array[i] !=0) length++;
            }

            if(length == 0) {
                System.out.println("队列空了，不能出队");
                return;
            }


            if(last==0){
                last = last+array.length;
            }
            last--;
            array[last] = 0;

        }

    }
}

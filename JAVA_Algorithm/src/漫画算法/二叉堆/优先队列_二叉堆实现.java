package 漫画算法.二叉堆;

import java.util.Arrays;

public class 优先队列_二叉堆实现 {
    private int[] array;
    private int size;

    public static void main(String[] args){
        优先队列_二叉堆实现 priorityQueue = new 优先队列_二叉堆实现();

        //入队过程
        priorityQueue.入队(7);
        priorityQueue.入队(1);
        priorityQueue.入队(3);
        priorityQueue.入队(10);
        priorityQueue.入队(5);
        priorityQueue.入队(2);
        priorityQueue.入队(8);
        二叉堆_数组实现.打印二叉堆(priorityQueue.array);

        //出队过程
        System.out.println("出队元素为：" + priorityQueue.出队());;
        二叉堆_数组实现.打印二叉堆(priorityQueue.array);
        System.out.println("出队元素为：" + priorityQueue.出队());;
        二叉堆_数组实现.打印二叉堆(priorityQueue.array);
        System.out.println("出队元素为：" + priorityQueue.出队());;
        二叉堆_数组实现.打印二叉堆(priorityQueue.array);
        System.out.println("出队元素为：" + priorityQueue.出队());;
        二叉堆_数组实现.打印二叉堆(priorityQueue.array);
    }

    public 优先队列_二叉堆实现(){
        array = new int[8];
        size = 0;
    }

    //本质上就是使用二叉堆的插入
    public void 入队(int num){
        //如果优先队列满了，就扩容
        if(size >= array.length){
            int newSize = size*2;
            array = Arrays.copyOf(array,newSize);
        }
        //入队到队尾
        array[size++] = num;
        //对刚入队的元素进行二叉堆上浮操作
        二叉堆_数组实现.上浮操作(array,size-1);
    }

    //本质上就是使用二叉堆的删除
    public int 出队(){
        //如果优先队列空，就提示
        if(size <= 0){
            System.out.println("优先队列已空");
            return -1;
        }
        //出队，让第一个元素出队
        int head = array[0];
        array[0] = array[--size];
        array[size] = 0;
        //对第一个元素进行二叉堆下沉操作
        二叉堆_数组实现.下沉操作(array,0,size);

        return head;
    }
}

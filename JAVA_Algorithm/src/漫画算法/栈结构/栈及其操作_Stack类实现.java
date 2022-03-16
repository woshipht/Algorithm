package 漫画算法.栈结构;

import java.util.Arrays;
import java.util.Stack;

public class 栈及其操作_Stack类实现 {
    public static void main(String[] args) {
        Stack stack = new Stack();

        //1.入栈
        stack.push(5);
        stack.push(4);
        stack.push(3);
        System.out.println("栈内信息为：          stack = "+ stack);

        //2.出栈
        stack.pop();
        System.out.println("出栈一个元素后：       stack = "+ stack);

        stack.pop();
        System.out.println("出栈一个元素后：       stack = "+ stack);
    }
}

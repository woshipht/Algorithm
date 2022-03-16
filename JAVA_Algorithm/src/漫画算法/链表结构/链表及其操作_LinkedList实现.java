package 漫画算法.链表结构;

import java.util.LinkedList;

public class 链表及其操作_LinkedList实现 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        //初始化链表
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println("初始链表为：" + linkedList);

        //头部插入
        linkedList.add(0,666);
        System.out.println("在头部插入链表节点666后，" + linkedList);
        //尾部插入
        linkedList.add(linkedList.size(), 888);
        System.out.println("在尾部插入链表节点888后，" + linkedList);
        //中间插入
        linkedList.add(2, 1818);
        System.out.println("在3位置中间插入链表节点1818后，" + linkedList);

        //通过position查找并更新节点
        System.out.println("查找到第5个节点的data为：" + linkedList.get(4));
        linkedList.set(4,518518);
        System.out.println("更改第5个节点的data为518518：" + linkedList);

        //通过data查找并更新节点
        linkedList.set(linkedList.indexOf(1818),1314520);
        System.out.println("更改data为1818的节点的data为1314520：" + linkedList);

        //通过position进行删除操作
        //头部删除
        linkedList.remove(0);
        System.out.println("删除链表头部节点后，" + linkedList);
        //尾部删除
        linkedList.remove(linkedList.size()-1);
        System.out.println("删除链表尾部节点后，" + linkedList);
        //中间删除
        linkedList.remove(2);
        System.out.println("中间删除链表3位置节点后，" + linkedList);

        //通过data进行删除操作
        linkedList.remove(linkedList.indexOf(1314520));
        System.out.println("删除data为1314520的节点后，" + linkedList);
    }
}

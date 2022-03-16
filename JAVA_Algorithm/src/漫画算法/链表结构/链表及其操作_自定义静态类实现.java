package 漫画算法.链表结构;

public class 链表及其操作_自定义静态类实现 {
    private static Node head_node;
    private static Node last_node;
    private static int size=0;

    public static void main(String[] args) {
        //初始化链表
        链表及其操作_自定义静态类实现.插入操作(1,0);
        链表及其操作_自定义静态类实现.插入操作(2,1);
        链表及其操作_自定义静态类实现.插入操作(3,2);
        链表及其操作_自定义静态类实现.插入操作(4,3);
        System.out.print("初始");
        链表及其操作_自定义静态类实现.打印链表();
        System.out.println();

        //头部插入
        链表及其操作_自定义静态类实现.插入操作(666,0);
        System.out.print("在头部插入链表节点666后，");
        链表及其操作_自定义静态类实现.打印链表();
        System.out.println();

        //尾部插入
        链表及其操作_自定义静态类实现.插入操作(888,size);
        System.out.print("在尾部插入链表节点888后，");
        链表及其操作_自定义静态类实现.打印链表();
        System.out.println();

        //中间插入
        链表及其操作_自定义静态类实现.插入操作(1818,2);
        System.out.print("在3位置中间插入链表节点1818后，");
        链表及其操作_自定义静态类实现.打印链表();
        System.out.println();

        //通过position查找并更新节点
        Node node1 = 链表及其操作_自定义静态类实现.通过position进行查找操作(4);
        System.out.println("查找到第5个节点的data为：" + node1.data);
        node1.data = 518518;
        System.out.println("更改第5个节点的data为：" + node1.data);
        链表及其操作_自定义静态类实现.打印链表();
        System.out.println();

        //通过data查找并更新节点
        Node node2 = 链表及其操作_自定义静态类实现.通过data进行查找操作(1818);
        node2.data = 1314520;
        System.out.println("更改data为1818的节点的data为1314520：" + node2.data);
        链表及其操作_自定义静态类实现.打印链表();
        System.out.println();

        //通过position进行删除操作
        //头部删除
        链表及其操作_自定义静态类实现.通过position进行删除操作(0);
        System.out.print("删除链表头部节点后，");
        链表及其操作_自定义静态类实现.打印链表();
        //尾部删除
        链表及其操作_自定义静态类实现.通过position进行删除操作(size-1);
        System.out.print("删除链表尾部节点后，");
        链表及其操作_自定义静态类实现.打印链表();
        //中间删除
        链表及其操作_自定义静态类实现.通过position进行删除操作(2);
        System.out.print("中间删除链表3位置节点后，");
        链表及其操作_自定义静态类实现.打印链表();
        System.out.println();

        //通过data进行删除操作
        链表及其操作_自定义静态类实现.通过position进行删除操作(链表及其操作_自定义静态类实现.通过Node查找position(链表及其操作_自定义静态类实现.通过data进行查找操作(1314520)));
        System.out.print("删除data为1314520的节点后，");
        链表及其操作_自定义静态类实现.打印链表();
    }

    private static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void 插入操作(int data, int position){
        if(position<0 || position>size){
            System.out.println("插入链表位置错误，不能插入");
            return;
        }

        Node newNode = new Node(data);

        if(size == 0){              //此时链表为空链表
            head_node = newNode;
            last_node = newNode;
        }else if(position == 0){    //此时插入链表头部，将新节点的next指向原头部节点，新节点变成头部节点
            newNode.next = head_node;
            head_node = newNode;
        }else if(position == size){ //此时插入链表尾部，将原尾部节点的next指向新节点，新节点变成尾部节点
            last_node.next = newNode;
            last_node = newNode;
        }else {                     //此时中间插入链表，通过确认链表位置进行类似上面的插入方式
            Node positionNode = 通过position进行查找操作(position-1);
            newNode.next = positionNode.next;
            positionNode.next = newNode;
        }
        size++;
    }

    public static Node 通过position进行查找操作(int position){
        if(position<0 || position>=size){
            System.out.println("超出链表范围，无法搜索！");
            return new Node(-1);
        }

        Node temp = head_node;
        for(int i=0; i<position; i++){
            temp = temp.next;
        }

        return temp;
    }

    public static Node 通过data进行查找操作(int data){
        Node temp = head_node;

        for(int i=0; i<size; i++){
            if(temp.data == data){
                System.out.println("查找到data为：" + data+"的节点，它的位置是"+(i+1));
                return temp;
            }
            temp = temp.next;
        }

        System.out.println("未找到想要的节点！");
        return new Node(-1);
    }

    public static int 通过Node查找position(Node node){
        Node temp = head_node;

        for(int i=0; i<size; i++){
            if(temp.data == node.data){
                return i;
            }
            temp = temp.next;
        }

        System.out.println("未找到想要的节点！");
        return -1;
    }

    public static void 打印链表(){
        Node temp = head_node;
        System.out.print("链表为：");

        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void 通过position进行删除操作(int position){
        if(position<0 || position>=size){
            System.out.println("超出链表范围，无法删除！");
            return;
        }

        if(position == 0){        //此时删除链表头部，将原头部节点的next变为头部节点
            head_node = head_node.next;
        }else if(position == size-1){   //此时删除链表尾部，将原尾部节点的前一个节点变为尾部节点
            //要删除的节点的前一个节点
            Node previousNode = 链表及其操作_自定义静态类实现.通过position进行查找操作(position-1);
            previousNode.next = null;
            last_node = previousNode;
        }else {                         //此时中间删除链表节点，通过确认链表位置进行类似上面的插入方式
            //要删除的节点的前一个节点
            Node previousNode = 链表及其操作_自定义静态类实现.通过position进行查找操作(position-1);
            previousNode.next = previousNode.next.next;
        }
        size--;
    }
}

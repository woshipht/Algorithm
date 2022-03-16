package 漫画算法.树结构;

import java.util.*;

public class 二叉树的广度优先遍历_Queue类实现 {
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList(Arrays.asList(new Integer[]{1,2,4,null,null,5,null,null,3,null,6}));
        TreeNode treeNode = createTree(linkedList);

        //层序遍历，输出顺序为：根节点 -> 左子树 -> 右子树
        System.out.println("层序遍历： ");
        层序遍历(treeNode);
    }

    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data){
            this.data = data;
        }
    }

    public static TreeNode createTree(LinkedList<Integer> inputList){
        TreeNode treeNode = null;

        //判断是否该LinkedList对象初始为null，若为null，则直接返回一个空数组
        //判断是否该LinkedList对象初始是否内部没有任何节点，若没有任何节点，则直接返回一个空数组
        if(inputList==null || inputList.isEmpty()){
            return null;
        }

        //将 LinkedList 中的第一个节点移除并放入Integer包装器对象 data 中
        Integer data = inputList.removeFirst();

        //检测是否此时 data 对象为null，如果为null，则不会进行下述的递归过程！
        if(data != null){
            //LinkedList转化为树的转化标准为，非null前，全是左子树，出现null后，代表左子树空，开始判断右子树，然后进行和左子树数量匹配的右子树判断，然后开始判断根节点的右子树,类似前序遍历
            //将当前节点的数据设置为data
            treeNode = new TreeNode(data);
            //先递归左子树，再递归右子树
            treeNode.leftChild = createTree(inputList);
            treeNode.rightChild = createTree(inputList);
        }
        return treeNode;
    }

    public static void 层序遍历(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode treeNode = node;

        //先将根节点放入队列中
        queue.offer(treeNode);

        //一直循环到队列空为止，代表数已经全部遍历
        while(!queue.isEmpty()){
            //推出队列中的一个元素，并直接打印
            treeNode = queue.poll();
            System.out.print(" -> " + treeNode.data);

            //若有左节点，直接将左节点放入队列中
            if(treeNode.leftChild != null){
                queue.offer(treeNode.leftChild);
            }

            //若有右节点，直接将右节点放入队列中
            if(treeNode.rightChild != null){
                queue.offer(treeNode.rightChild);
            }
        }
    }
}

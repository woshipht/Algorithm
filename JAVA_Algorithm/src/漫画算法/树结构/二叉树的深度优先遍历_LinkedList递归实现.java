package 漫画算法.树结构;

import java.util.Arrays;
import java.util.LinkedList;

public class 二叉树的深度优先遍历_LinkedList递归实现 {
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TreeNode treeNode = createTree(linkedList);

        //前序遍历，输出顺序为：根节点 -> 左子树 -> 右子树
        System.out.println("前序遍历： ");
        前序遍历(treeNode);

        //中序遍历，输出顺序为：左子树 -> 根节点 -> 右子树
        System.out.println("中序遍历： ");
        中序遍历(treeNode);

        //后序遍历，输出顺序为：左子树 -> 右子树 -> 根节点
        System.out.println("后序遍历： ");
        后序遍历(treeNode);
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

    public static void 前序遍历(TreeNode node){
        if(node == null){
            return;
        }

        //前序遍历，输出顺序为：根节点 -> 左子树 -> 右子树
        System.out.println(node.data);
        前序遍历(node.leftChild);
        前序遍历(node.rightChild);
    }

    public static void 中序遍历(TreeNode node){
        if(node == null){
            return;
        }

        //中序遍历，输出顺序为：左子树 -> 根节点 -> 右子树
        中序遍历(node.leftChild);
        System.out.println(node.data);
        中序遍历(node.rightChild);
    }

    public static void 后序遍历(TreeNode node){
        if(node == null){
            return;
        }

        //后序遍历，输出顺序为：左子树 -> 右子树 -> 根节点
        后序遍历(node.leftChild);
        后序遍历(node.rightChild);
        System.out.println(node.data);
    }


}

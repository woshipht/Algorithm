package 漫画算法.树结构;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class 二叉树的深度优先遍历_Stack类实现 {
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TreeNode treeNode = createTree(linkedList);

        //前序遍历，输出顺序为：根节点 -> 左子树 -> 右子树
        System.out.print("前序遍历： ");
        前序遍历(treeNode);

        //中序遍历，输出顺序为：左子树 -> 根节点 -> 右子树
        System.out.print("\n中序遍历： ");
        中序遍历(treeNode);

        //后序遍历，输出顺序为：左子树 -> 右子树 -> 根节点
        System.out.print("\n后序遍历1： ");
        后序遍历1(treeNode);
        System.out.print("\n后序遍历2： ");
        后序遍历2(treeNode);
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
            //LinkedList转化为树的转化标准为，非null前，全是左子树，出现null后，代表左子树空，开始判断右子树，然后进行和左子树数量匹配的
            //  右子树判断，然后开始判断根节点的右子树,类似前序遍历
            //将当前节点的数据设置为data
            treeNode = new TreeNode(data);
            //先递归左子树，再递归右子树
            treeNode.leftChild = createTree(inputList);
            treeNode.rightChild = createTree(inputList);
        }
        return treeNode;
    }

    public static void 前序遍历(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = node;

        //初状态时，stack为空，treeNode!=null，之后直到全部遍历后，stack才会再次为空
        while (treeNode!=null || !stack.isEmpty()){
            //若该节点不为空，一直重复找左节点，直到找到null，即没有左节点为止
            while (treeNode!=null){
                //从根节点开始，将找到的节点全部放入stack，并打印，然后指向此时根节点的左节点，重复这个过程直到找不到左节点为止
                System.out.print(" -> " + treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //只要找不到左节点，此时treeNode应该是null,若此时若stack不为空，证明stack内的节点还没有判断过是否存在右子树
            if(!stack.isEmpty()){
                //将treeNode变为stack内pop的第一个节点，开始判断该节点是否有右子树！
                //如果有右子树，回到上一个while循环时，因为treeNode!=null，所以会对这个右子树再次进行找左节点过程
                //然后如果这个右子树没有左节点，也没有右节点，下次再次pop时，就会pop这个右子树的上一个节点，然后依次在进行判断
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void 中序遍历(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = node;

        //过程同上，前序遍历是在push进stack时打印，中序遍历是在pop出stack时打印
        while (treeNode!=null || !stack.isEmpty()){
            while (treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                System.out.print(" -> " + treeNode.data);
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void 后序遍历1(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = node;

        //第一种思路： 每次push左节点进stack时，要push2次，当pop时，如果此时stack顶部元素和pop出来的元素相等同时stack不空，则直接去找该节点的右节点，同时不打印
        //这样的好处是，stack内还会保存一个根节点在栈内，下次从右节点回到根节点时，由于此时最后一个根节点也被pop出来，所以stack顶部元素和pop出来的元素不相等
        //于是不会找右节点，也就证明这个节点已经找过了右节点，不用再找了，于是可以打印！
        while(treeNode!=null || !stack.isEmpty()){
            while (treeNode!=null){
                stack.push(treeNode);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                if(!stack.isEmpty() && treeNode == stack.peek()){
                    treeNode = treeNode.rightChild;
                }else {
                    System.out.print(" -> " + treeNode.data);
                    treeNode =null;
                }
            }
        }
    }

    public static void 后序遍历2(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = node;
        //核心思路：上一个访问的节点的值
        TreeNode prevNode = node;

        //第二种思路： 正常push左节点进stack，每次先peek一下栈内的元素
        //如果这个栈内元素没有右节点，那就执行pop，并打印，同时将上一个访问过的节点指向pop出来的节点，最后将节点设为null
        //如果有右节点 同时 上一个访问过的节点不等于它的右节点，那就直接去右节点（这证明它有右节点，同时我们没有访问过）
        //如果有右节点 但是 上一个访问过的节点等于它的右节点，证明它有右节点，但是我们访问过，于是也会进行pop操作，打印，将上一个访问过的节点指向pop出来的节点，最后将节点设为null
        //这样我们就做到了，如果一个根节点有左节点也有右节点，我们首先会看它的左节点，然后判断右节点没有去过，去它的右节点，最后才会回到根节点，发现右节点已经去过了，然后打印自己
        while(treeNode!=null || !stack.isEmpty()){
            while (treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                treeNode = stack.peek();
                if(treeNode.rightChild == null || treeNode.rightChild == prevNode){
                    treeNode = stack.pop();
                    prevNode = treeNode;
                    System.out.print(" -> " + treeNode.data);
                    treeNode =null;
                }else {
                    treeNode = treeNode.rightChild;
                }
            }
        }
    }
}

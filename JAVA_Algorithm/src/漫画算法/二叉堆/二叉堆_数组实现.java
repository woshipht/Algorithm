package 漫画算法.二叉堆;

public class 二叉堆_数组实现 {
    public static void main(String[] args){
        //初始有序二叉堆
        int[] array1 = new int[]{1,3,2,6,5,7,8,9,10};
        System.out.println("初始有序二叉堆:");
        二叉堆_数组实现.打印二叉堆(array1);

        //插入节点
        System.out.println("插入节点1后:");
        二叉堆_数组实现.打印二叉堆(二叉堆_数组实现.插入节点(array1,1));

        //初始无序完全二叉树
        int[] array2 = new int[]{7,1,3,10,5,2,8,9,6};
        System.out.println("初始无序完全二叉树:");
        二叉堆_数组实现.打印二叉堆(array2);

        //将无序二叉树变为有序二叉堆
        二叉堆_数组实现.构建二叉堆(array2);
        System.out.println("将无序二叉树变为有序二叉堆后:");
        二叉堆_数组实现.打印二叉堆(array2);

        //删除节点(顶部节点)
        System.out.println("删除节点(顶部节点)后:");
        二叉堆_数组实现.打印二叉堆(二叉堆_数组实现.删除节点(array2));
    }

    public static void 打印二叉堆(int[] array){
        int time = 2;
        for(int i=0; i<array.length; i++){
            if(i+1 == time){
                System.out.println();
                time *= 2;
            }
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println();
    }

    //给定一个完全二叉树数组，以及要进行下沉操作的节点的位置，这个节点会一直下沉直到无法下沉为止！
    public static void 下沉操作(int[] array, int parentIndex, int length){
        //要进行下沉操作的节点的值
        int temp = array[parentIndex];
        //要进行下沉操作的节点的左子节点
        int childIndex = parentIndex * 2 + 1;

        //直到左子节点位置超界(即已经到底)，或者父节点的值小于等于子节点位置的值(证明这个父节点不必下沉)，一直重复下沉操作
        while (childIndex<length && temp > array[childIndex]){

            //判断是否还有右子节点，如果有右子节点，将需要交换的子节点位置变为左右子节点中较小的那个的位置！
            if(childIndex+1<length && array[childIndex]>array[childIndex+1]){
                childIndex++;
            }

            //将子节点位置的值替换到父节点
            array[parentIndex] = array[childIndex];
            //将父节点变为之前的子节点，子节点变成之前的子节点的左子节点，然后再进行while循环
            parentIndex = childIndex;
            childIndex = childIndex*2+1;
        }
        //最后把最开始的进行下沉操作的节点的值放到最终位置
        array[parentIndex] = temp;
    }

    //给定一个完全二叉树数组，以及要进行上浮操作的节点的位置，这个节点会一直上浮直到无法上浮为止！
    public static void 上浮操作(int[] array, int childIndex){
        //要进行上浮操作的子节点的值
        int temp = array[childIndex];
        //要进行上浮操作的子节点的父节点
        int parentIndex = (childIndex-1)/2;

        //直到子节点已经到顶，或者父节点的值小于等于子节点位置的值(证明这个节点不必上浮)，一直重复上浮操作
        while (childIndex > 0 && array[parentIndex] > temp){

            //将父节点位置的值替换到子节点
            array[childIndex] = array[parentIndex];
            //将子节点变为之前的父节点，父节点变成之前的父节点的父节点，然后再进行while循环
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
        //最后把最开始的进行上浮操作的节点的值放到最终位置
        array[childIndex] = temp;
    }

    //默认插入节点会插入到数组的最后一个位置！
    public static int[] 插入节点(int[] array, int num){
        //新建一个数组，在尾部加上插入节点，数组长度加1，其余部分和之前相同
        int[] newArray = new int[array.length+1];
        newArray[array.length] = num;
        System.arraycopy(array,0,newArray,0,array.length);

        //对新数组的最后一个位置进行上浮操作
        二叉堆_数组实现.上浮操作(newArray,newArray.length-1);

        return newArray;
    }

    //默认删除节点会删除数组的第一个位置，同时将数组的最后一个位置替换到第一个位置！
    public static int[] 删除节点(int[] array){
        //新建一个数组，将数组的最后一个位置替换到第一个位置，数组长度减1，其余部分和之前相同
        int[] newArray = new int[array.length-1];
        newArray[0] = array[array.length-1];
        System.arraycopy(array,1,newArray,1,array.length-2);

        //对新数组的第一个位置进行下沉操作
        二叉堆_数组实现.下沉操作(newArray,0,newArray.length);

        return newArray;
    }

    //将一个完全二叉树变成二叉堆，对所有非叶子节点进行下沉操作
    public static void 构建二叉堆(int[] array){
        //找到完全二叉树数组的第一个 非叶子节点(即存在子节点) 位置，在这个位置之前的所有位置一定都是 非叶子节点 ，对所有非叶子节点进行下沉操作！
        for(int i = (array.length-2)/2; i>=0; i--){
            二叉堆_数组实现.下沉操作(array,i,array.length);
        }
    }
}
package ares.cjc.algorithm;

import java.util.Arrays;

public class BubbleSort {
    /**
     *  原始冒泡排序，两层循环。
     *  时间复杂度O（n^2）
     *  空间复杂度O（1）
     *  稳定排序
     */
    public static void sort1(int arr[]){
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 冒泡版本2：
     * 如果在上一轮中，没有元素进行交换，则说明元素已经全部有序，不需要再循环了
     */
    public static void sort2(int arr[]){
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i++){

            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                    //有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    /**
     * 冒泡版本3：
     * 记录最后一次交换的位置，后续循环到此位置就行，不需要再做后续无谓的比较
     * 解决 5 3 2 1 6 7 8 9 的问题
     */
    public static void sort3(int arr[]){
        int temp = 0;
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;

        //无序数列的边界，每次比较只需要比较到这里为止
        int sortBorder = arr.length - 1;

        for(int i = 0; i < arr.length - 1; i++){

            //有序标记，每一轮的初始是true
            boolean isSorted = true;

            for(int j = 0; j < sortBorder; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                    //有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if(isSorted){
                break;
            }
        }
    }


    /**
     * 冒泡版本4：
     * 鸡尾酒排序
     * 解决问题：2 3 4 5 6 7 8 1
     * 每一遍大循环里都有两个小循环，从左到右再从右到左
     */
    public static void sort4(int[] arr){
        int temp = 0;

        //记录右侧最后一次交换的位置
        int lastRightExchangeIndex = 0;

        //记录左侧最后一次交换的位置
        int lastLeftExchangeIndex = 0;

        //无序数列的右边界，每次比较只需要比到这里为止
        int rightSortBorder = arr.length - 1;

        //无序数列的左边界，每次比较只需要比到这里为止
        int leftSortBorder = 0;

        for(int i = 0; i < arr.length/2 - 1; i++){

            //有序标记，每一轮的初始是true
            boolean isSorted = true;

            //奇数轮，从左向右比较和交换
            for(int j = leftSortBorder; j < rightSortBorder; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                    //有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastRightExchangeIndex = j;
                }
            }
            rightSortBorder = lastRightExchangeIndex;
            if(isSorted){
                break;
            }

            //奇数轮之前，重新标记为true
            isSorted = true;
            //偶数轮，从右向左比较和交换
            for(int j = rightSortBorder; j > leftSortBorder; j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;

                    //有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastLeftExchangeIndex = j;
                }
            }
            leftSortBorder = lastLeftExchangeIndex;
            if(isSorted){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
//        sort1(array);
//        sort2(array);
//        sort3(array);
        sort4(array);
        System.out.println(Arrays.toString(array));
    }
}

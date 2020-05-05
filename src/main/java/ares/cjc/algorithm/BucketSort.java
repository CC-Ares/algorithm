package ares.cjc.algorithm;

import java.util.*;

/**
 * 桶排序
 *
 * 时间复杂度：O(n+m+n(logn-logm)）
 * 空间复杂度：O（m+n）
 */
public class BucketSort {

    public static double[] sort(double[] arr) {
        //1. 找到数组最大值和最小值
        double min = 0;
        double max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        //2. 找到最大值与最小值的差
        double d = max - min;

        //2. 初始化桶
        int bucketNum = arr.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        //3. 遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < arr.length; i++) {
            int num = (int)((arr[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(arr[i]);
        }

        //4. 对每个桶内进行排序
        for(int i = 0; i < bucketList.size(); i++){
            Collections.sort(bucketList.get(i));
        }

        //5. 输出全部元素
        double[] sortedArray = new double[arr.length];
        int index = 0;
        for(LinkedList<Double> list : bucketList){
            for(double element : list){
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = new double[]{4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        double[] sortedArray = sort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}

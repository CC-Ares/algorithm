package ares.cjc.algorithm.group;

import ares.cjc.algorithm.Sort;

/**
 * 希尔排序
 * 为了解决插入排序遇到最小值再最后面只能一个一个插入到最前面的问题
 * 把数组分割为任意个间隔为h的数组，分别对他们进行排序，慢慢缩小h，直到h为1，完成排序
 */
public class Shell extends Sort{

    public static void sort(int[] arr){
        if(!isArray(arr)) return;

        int N = arr.length;
        int h = 1;
        while (h<N/3){
            h=3*h + 1;      //1,4,13,40,121,364,1093...
        }
        while (h>=1){
            //将数组变为h有序
            for(int i=h;i<N;i++){
                //将arr[i]插入到arr[i-h],arr[i-2*h],a[i-3*h]...之中
                for(int j=i;j>=h&&arr[j]<arr[j-h];j-=h){
                    exchange(arr,j,j-h);
                }
            }
            h=h/3;

            //i:13,h:13,j:13
            //i:4,h:4;j:4
        }
    }
}

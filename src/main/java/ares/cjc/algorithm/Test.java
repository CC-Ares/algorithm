package ares.cjc.algorithm;

import ares.cjc.algorithm.group.Insert;
import ares.cjc.algorithm.group.Merge;
import ares.cjc.algorithm.group.Selection;
import ares.cjc.algorithm.group.Shell;

public class Test {
    public static void main(String[] args) {
        int[] array = {1,8,9,3,5,4,7,2,6};
//        Selection.sort(array);
//        Insert.sort(array);
//        Shell.sort(array);
        Merge.sort(array);
        System.out.println(Selection.isSort(array));
    }
}

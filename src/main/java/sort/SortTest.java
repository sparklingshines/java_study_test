package sort;

import java.util.Arrays;

/**
 * 排序算法大体可分为两种：
 * 一种是比较排序，时间复杂度O(nlogn) ~ O(n^2)，主要有：冒泡排序，选择排序，插入排序，归并排序，堆排序，快速排序等。
 * 另一种是非比较排序，时间复杂度可以达到O(n)，主要有：计数排序，基数排序，桶排序等。
 */
public class SortTest {

    /**
     * 交换元素的位置
     *
     * @param source
     * @param i
     * @param j
     */
    public static void swap(int[] source, int i, int j) {
        int temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }

    /**
     * 冒泡排序
     *
     * @param source
     * @param n
     */
    public static void bubbleSort(int[] source, int n) {
        for (int j = 0; j < n - 1; j++) {
            // 每次最大元素就像气泡一样"浮"到数组的最后
            for (int i = 0; i < n - 1 - j; i++) {
                // 依次比较相邻的两个元素,使较大的那个向后移
                if (source[i] > source[i + 1]) {
                    // 如果条件改成A[i] >= A[i + 1],则变为不稳定的排序算法
                    swap(source, i, i + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序-鸡尾酒排序
     *
     * @param source
     * @param n
     */
    public static void cocktailSort(int[] source, int n) {
        // 初始化边界
        int left = 0;
        int right = n - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                // 前半轮,将最大元素放到后面
                if (source[i] > source[i + 1]) {
                    swap(source, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                // 后半轮,将最小元素放到前面
                if (source[i - 1] > source[i]) {
                    swap(source, i - 1, i);
                }
            }
            left++;
        }
    }

    /**
     * 选择排序
     * 选择排序也是一种简单直观的排序算法。它的工作原理很容易理解：初始时在序列中找到最小（大）元素，放到序列的起始位置作为已排序序列；
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * 注意选择排序与冒泡排序的区别：冒泡排序通过依次交换相邻两个顺序不合法的元素位置，从而将当前最小（大）元素放到合适的位置；而选择排序每遍历一次都记住了当前最小（大）元素的位置，
     * 最后仅需一次交换操作即可将其放到合适的位置。
     *
     * @param source
     * @param n
     */
    public static void selectionSort(int[] source, int n) {
        for (int i = 0; i < n - 1; i++) {
            // i为已排序序列的末尾
            int min = i;
            for (int j = i + 1; j < n; j++) {
                // 未排序序列
                if (source[j] < source[min]) {
                    // 找出未排序序列中的最小值
                    min = j;
                }
            }
            if (min != i) {
                swap(source, min, i);    // 放到已排序序列的末尾，该操作很有可能把稳定性打乱，所以选择排序是不稳定的排序算法
            }
        }
    }

    /**
     * 直接插入排序
     * 1.从第一个元素开始，该元素可以认为已经被排序
     * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5.将新元素插入到该位置后
     * 6.重复步骤2~5
     * <p>
     * 插入排序不适合对于数据量比较大的排序应用。但是，如果需要排序的数据量很小，比如量级小于千，那么插入排序还是一个不错的选择。
     * 插入排序在工业级库中也有着广泛的应用，在STL的sort算法和stdlib的qsort算法中，都将插入排序作为快速排序的补充，用于少量元素的排序（通常为8个或以下）。
     *
     * @param source
     * @param n
     */
    public static void insertionSort(int[] source, int n) {
        for (int i = 1; i < n; i++) {
            // 右手抓到一张扑克牌
            int get = source[i];
            int j = i - 1;
            // 拿在左手上的牌总是排序好的
            while (j >= 0 && source[j] > get) {
                // 将抓到的牌与手牌从右向左进行比较
                source[j + 1] = source[j];
                // 如果该手牌比抓到的牌大，就将其右移
                j--;
            }
            // 直到该手牌比抓到的牌小(或二者相等)，将抓到的牌插入到该手牌右边(相等元素的相对次序未变，所以插入排序是稳定的)
            source[j + 1] = get;
        }
    }

    /**
     * 插入排序的改进：二分插入排序
     * 对于插入排序，如果比较操作的代价比交换操作大的话，可以采用二分查找法来减少比较操作的次数
     *
     * @param source
     * @param n
     */
    public static void dichotomyInsertionSort(int[] source, int n) {
        for (int i = 1; i < n; i++) {
            // 右手抓到一张扑克牌
            int get = source[i];
            int left = 0;                    // 拿在左手上的牌总是排序好的，所以可以用二分法
            int right = i - 1;                // 手牌左右边界进行初始化
            while (left <= right)            // 采用二分法定位新牌的位置
            {
                int mid = (left + right) / 2;
                if (source[mid] > get)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            for (int j = i - 1; j >= left; j--) {
                // 将欲插入新牌位置右边的牌整体向右移动一个单位
                source[j + 1] = source[j];
            }
            // 将抓到的牌插入手牌
            source[left] = get;
        }
    }

    /**
     * 插入排序的更高效改进：希尔排序(Shell Sort)
     * <p>
     * 希尔排序，也叫递减增量排序，是插入排序的一种更高效的改进版本。希尔排序是不稳定的排序算法。
     * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
     * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
     * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位
     * 希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。这样可以让一个元素可以一次性地朝最终位置前进一大步。
     * 然后算法再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，但是到了这步，需排序的数据几乎是已排好的了（此时插入排序较快）。
     * 假设有一个很小的数据在一个已按升序排好序的数组的末端。如果用复杂度为O(n^2)的排序（冒泡排序或直接插入排序），可能会进行n次的比较和交换才能将该数据移至正确位置。
     * 而希尔排序会用较大的步长移动数据，所以小数据只需进行少数比较和交换即可到正确位置。
     *
     * @param source
     * @param n
     */
    public static void shellSort(int[] source, int n) {
        int h = 0;
        // 生成初始增量
        while (h <= n) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int j = i - h;
                int get = source[i];
                while (j >= 0 && source[j] > get) {
                    source[j + h] = source[j];
                    j = j - h;
                }
                source[j + h] = get;
            }
            // 递减增量
            h = (h - 1) / 3;
        }
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }

    /**
     * 归并排序
     * 归并排序是创建在归并操作上的一种有效的排序算法，效率为O(nlogn)，1945年由冯·诺伊曼首次提出。
     * 归并排序的实现分为递归实现与非递归(迭代)实现。递归实现的归并排序是算法设计中分治策略的典型应用，我们将一个大问题分割成小问题分别解决，然后用所有小问题的答案来解决整个大问题。
     * 非递归(迭代)实现的归并排序首先进行是两两归并，然后四四归并，然后是八八归并，一直下去直到归并了整个数组。
     * 归并排序算法主要依赖归并(Merge)操作。归并操作指的是将两个已经排序的序列合并成一个序列的操作，归并操作步骤如下：
     * 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     * 设定两个指针，最初位置分别为两个已经排序序列的起始位置
     * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     * 重复步骤3直到某一指针到达序列尾
     * 将另一序列剩下的所有元素直接复制到合并序列尾
     *
     * @param source
     * @param low
     * @param high
     */
    public static void mergeSort(int[] source, int low,int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(source, low, mid);
            mergeSort(source, mid + 1, high);
            //左右归并
            merge(source, low, mid, high);
        }
    }

    public static void main(String[] args) {

        int[] array = {114, 45, 1, 2, 4, 6, 68, 46, 98, 35, 2, 65};
        SortTest.bubbleSort(array, array.length);
        System.out.println(Arrays.toString(array));
        System.out.println("--------------------");
        int[] array1 = {114, 45, 1, 2, 4, 6, 68, 46, 98, 35, 2, 65};
        SortTest.cocktailSort(array1, array1.length);
        System.out.println(Arrays.toString(array1));
        System.out.println("--------------------");
        int[] array2 = {114, 45, 1, 2, 4, 6, 68, 46, 98, 35, 2, 65};
        SortTest.selectionSort(array2, array2.length);
        System.out.println(Arrays.toString(array2));
        System.out.println("--------------------");
        int[] array3 = {114, 45, 1, 2, 4, 6, 68, 46, 98, 35, 2, 65};
        SortTest.insertionSort(array3, array3.length);
        System.out.println(Arrays.toString(array3));
        System.out.println("--------------------");
        int[] array4 = {114, 45, 1, 2, 4, 6, 68, 46, 98, 35, 2, 65};
        SortTest.dichotomyInsertionSort(array4, array4.length);
        System.out.println(Arrays.toString(array4));
        System.out.println("--------------------");
        int[] array5 = {114, 45, 1, 2, 4, 6, 68, 46, 98, 35, 2, 65};
        SortTest.dichotomyInsertionSort(array5, array5.length);
        System.out.println(Arrays.toString(array5));
        System.out.println("--------------------");
    }
}

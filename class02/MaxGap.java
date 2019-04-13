package NowCoder.class02;


import java.util.Arrays;

/**
 *
 * Q:给定一个数组，求如果排序之后，相邻两数的最大差值，要求O（N）时间复杂度
 *
 * 桶排序的应用，N个数，需要N+1个桶(鸽巢原理)，进行N+1等分，每个桶记录该桶区间内的min，max以及是否为空的flag
 *
 * 空桶的是为了证明最大差值一定不是来自于一个桶的内部，而是2个相邻桶之间
 *  19    空    30    49     对于这种情况，最大差值并不一定是来自于空桶的两侧
 * 10~19 20~29 30~39 40~49
 * 找到每个桶的前一个桶的最大值和自身的最小值的差值，通过全局变量记录求出这些差值中的最大值，即是结果
 *
 */
public class MaxGap {
    public static int maxGap(int[] nums) {
        int n = nums.length;
        if (nums == null || n < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        int[] mins = new int[n + 1];
        int[] maxs = new int[n + 1];
        boolean[] flags = new boolean[n + 1];
        int bid = 0;
        // 把nums数组中的数放到桶里面， 至少有一个桶是空的
        for (int i = 0; i < n; i++) {
            bid = bucket(nums[i], n, min, max);
            mins[bid] = flags[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = flags[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            flags[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        // 遍历每个桶，计算前一个桶的最大值和当前桶的最小值之间的差值，求最大的差值即是返回值
        for (int i = 1; i <= n; i++) {
            if (flags[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    // 获得当前的数所处的桶的位置
    public static int bucket(int num, int n, int min, int max) {
        return ((num - min) * n / (max - min));
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}

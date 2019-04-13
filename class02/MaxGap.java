package NowCoder.class02;


import java.util.Arrays;

/**
 *
 * Q:����һ�����飬���������֮����������������ֵ��Ҫ��O��N��ʱ�临�Ӷ�
 *
 * Ͱ�����Ӧ�ã�N��������ҪN+1��Ͱ(�볲ԭ��)������N+1�ȷ֣�ÿ��Ͱ��¼��Ͱ�����ڵ�min��max�Լ��Ƿ�Ϊ�յ�flag
 *
 * ��Ͱ����Ϊ��֤������ֵһ������������һ��Ͱ���ڲ�������2������Ͱ֮��
 *  19    ��    30    49     �����������������ֵ����һ���������ڿ�Ͱ������
 * 10~19 20~29 30~39 40~49
 * �ҵ�ÿ��Ͱ��ǰһ��Ͱ�����ֵ���������Сֵ�Ĳ�ֵ��ͨ��ȫ�ֱ�����¼�����Щ��ֵ�е����ֵ�����ǽ��
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
        // ��nums�����е����ŵ�Ͱ���棬 ������һ��Ͱ�ǿյ�
        for (int i = 0; i < n; i++) {
            bid = bucket(nums[i], n, min, max);
            mins[bid] = flags[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = flags[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            flags[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        // ����ÿ��Ͱ������ǰһ��Ͱ�����ֵ�͵�ǰͰ����Сֵ֮��Ĳ�ֵ�������Ĳ�ֵ���Ƿ���ֵ
        for (int i = 1; i <= n; i++) {
            if (flags[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    // ��õ�ǰ����������Ͱ��λ��
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

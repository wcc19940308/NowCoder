package NowCoder.swordToOffer;
import java.util.LinkedList;
import java.util.List;

public class LastRemaining_Solution {
    public static int LastRemaining_Solution(int n, int m) {
        if (n < 0 || m < 0) {
            return 0;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int res = LastRemaining_Solution(5, 2);
        System.out.println(res);
    }
}

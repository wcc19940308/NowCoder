package NowCoder.swordToOffer;

public class RectCover {
    public int RectCover(int target) {
        if ( target == 0 || target == 1 || target == 2) {
            return target;
        }
        int prepre = 1;
        int pre = 2;
        for (int i = 3; i <= target; i++) {
            int tmp = pre;
            pre = pre + prepre;
            prepre = tmp;
        }
        return pre;
    }
}

package NowCoder.class04;

/**
 *
 * 折纸游戏:一张纸从下往上叠，叠1下，1个向下的折痕，叠2下，2个向下的折痕，1个向上的折痕，问叠n下，从上到下折痕的情况
 * 这是一道二叉树的应用题，叠1下，向下，可以把这个向下的节点视作根节点，叠2下，下下上，每叠1下，除了根节点，都会在原先的基础上翻倍，即折痕数 = 2n-1
 * 而且每次都会产生1上1下的折痕，并且下折痕在上，上折痕在下，因此可以把下折痕视作左子树，上折痕视作右子树
 *
 */
public class PaperFolding {
    public static void printAllFolds(int N) {
        printProcess(N, 1, true);
    }

    public static void printProcess(int N, int cur, boolean flag) {
        if (cur > N) {
            return;
        }
        printProcess(N, cur + 1, true);
        System.out.println(flag ? "down " : "up ");
        printProcess(N, cur + 1, false);
    }

    public static void main(String[] args) {
        printAllFolds(2);
    }
}

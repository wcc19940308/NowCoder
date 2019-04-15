package NowCoder.class03;

/**
 *
 * 之字形打印打印矩阵
 * 不要局限于局部，从 宏观 上把握整体的打印顺序
 * 1  2   3  4
 * 5  6   7  8
 * 9  10  11 12
 * 可以看到每次都是输出对角线上的值，因此选择2个点A，B位于(0, 0)，A每次往右走，一旦碰到最右边，那么往下走；B每次往下走，一旦碰到最下边，那么往右走
 * A走到最后一行或者B走到最后一列作为终止条件
 * 所以我们现在的目标就是如何根据2个点的坐标，来打印这2个点对应的对角线上的值。然后再根据一个给定的bool来判断打印的方向
 *
 */
public class ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix) {
        // 每次循环中的2个点的坐标位置
        int startRow = 0;
        int startCol = 0;
        int endRow = 0;
        int endCol = 0;

        // 最右下角的那个点的坐标
        int finalRow = matrix.length - 1;
        int finalCol = matrix[0].length - 1;
        boolean flag = true;
        // 当A点还没有走到最后一行的时候
        while (startRow != finalRow + 1) {
            printLevel(matrix, startRow, startCol, endRow, endCol, flag);
            // 注意这里更新行，列的顺序会影响结果
            startRow = startCol == finalCol ? startRow + 1 : startRow;
            startCol = startCol == finalCol ? startCol : startCol + 1;
            endCol = endRow == finalRow ? endCol + 1 : endCol;
            endRow = endRow == finalRow ? endRow : endRow + 1;
            flag = !flag;
        }
        System.out.println();
    }

    public static void printLevel(int[][] matrix, int startRow, int startCol, int endRow, int endCol, boolean flag) {
        // 如果flag为真，那么从左下打印到右上; 否则，从右上打印到左下
        if (flag) {
            while (endRow != startRow - 1) {
                System.out.print(matrix[endRow--][endCol++] + " ");
            }
        } else {
            while (startRow != endRow + 1) {
                System.out.print(matrix[startRow++][startCol--] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }
}

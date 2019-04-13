package NowCoder.class03;


/**
 *
 * 此类问题通过设计宏观的方法论，脱离局部，把握整体
 *
 * 顺时针打印矩形
 *
 * 对于一个矩形：
 * 1   2   3    4
 * 12  13  14   5
 * 11  16  15   6
 * 10   9   8   7
 *
 * 可以只考虑先打印最外圈的数据，即从(0, 0)到(3, 3)的数据，然后将左上角坐标都+1，右下角坐标都-1，再次打印，
 * 直到左上角的横坐标和纵坐标都大于右下角的横坐标和纵坐标，注意这里可能会有1行和1列的情况
 *
 */
public class PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            printEdge(matrix, startRow++, startCol++, endRow--, endCol--);
        }
    }

    public static void printEdge(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        if (startRow == endRow) {
            for (int i = startCol; i <= endCol; i++) {
                System.out.println(matrix[startRow][i] +" ");
            }
        } else if (startCol == endCol) {
            for (int i = startRow; i <= endRow; i++) {
                System.out.println(matrix[i][startCol] + " ");
            }
        } else {
            int curRow = startRow;
            int curCol = startCol;
            // 这里不会重复打印，因为当curCol == endCol的时候就跳出循环了，到下一个循环才会打印左上角的那个数字
            while (curCol != endCol) {
                System.out.println(matrix[curRow][curCol] + " ");
                curCol++;
            }
            while (curRow != endRow) {
                System.out.println(matrix[curRow][curCol] + " ");
                curRow++;
            }
            while (curCol != startCol) {
                System.out.println(matrix[curRow][curCol] + " ");
                curCol--;
            }
            while (curRow != startRow) {
                System.out.println(matrix[curRow][curCol] + " ");
                curRow--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }

}

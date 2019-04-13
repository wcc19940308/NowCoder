package NowCoder.class03;


/**
 *
 * ��������ͨ����ƺ�۵ķ����ۣ�����ֲ�����������
 *
 * ˳ʱ���ӡ����
 *
 * ����һ�����Σ�
 * 1   2   3    4
 * 12  13  14   5
 * 11  16  15   6
 * 10   9   8   7
 *
 * ����ֻ�����ȴ�ӡ����Ȧ�����ݣ�����(0, 0)��(3, 3)�����ݣ�Ȼ�����Ͻ����궼+1�����½����궼-1���ٴδ�ӡ��
 * ֱ�����Ͻǵĺ�����������궼�������½ǵĺ�����������꣬ע��������ܻ���1�к�1�е����
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
            // ���ﲻ���ظ���ӡ����Ϊ��curCol == endCol��ʱ�������ѭ���ˣ�����һ��ѭ���Ż��ӡ���Ͻǵ��Ǹ�����
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

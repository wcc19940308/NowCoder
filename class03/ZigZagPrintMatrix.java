package NowCoder.class03;

/**
 *
 * ֮���δ�ӡ��ӡ����
 * ��Ҫ�����ھֲ����� ��� �ϰ�������Ĵ�ӡ˳��
 * 1  2   3  4
 * 5  6   7  8
 * 9  10  11 12
 * ���Կ���ÿ�ζ�������Խ����ϵ�ֵ�����ѡ��2����A��Bλ��(0, 0)��Aÿ�������ߣ�һ���������ұߣ���ô�����ߣ�Bÿ�������ߣ�һ���������±ߣ���ô������
 * A�ߵ����һ�л���B�ߵ����һ����Ϊ��ֹ����
 * �����������ڵ�Ŀ�������θ���2��������꣬����ӡ��2�����Ӧ�ĶԽ����ϵ�ֵ��Ȼ���ٸ���һ��������bool���жϴ�ӡ�ķ���
 *
 */
public class ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix) {
        // ÿ��ѭ���е�2���������λ��
        int startRow = 0;
        int startCol = 0;
        int endRow = 0;
        int endCol = 0;

        // �����½ǵ��Ǹ��������
        int finalRow = matrix.length - 1;
        int finalCol = matrix[0].length - 1;
        boolean flag = true;
        // ��A�㻹û���ߵ����һ�е�ʱ��
        while (startRow != finalRow + 1) {
            printLevel(matrix, startRow, startCol, endRow, endCol, flag);
            // ע����������У��е�˳���Ӱ����
            startRow = startCol == finalCol ? startRow + 1 : startRow;
            startCol = startCol == finalCol ? startCol : startCol + 1;
            endCol = endRow == finalRow ? endCol + 1 : endCol;
            endRow = endRow == finalRow ? endRow : endRow + 1;
            flag = !flag;
        }
        System.out.println();
    }

    public static void printLevel(int[][] matrix, int startRow, int startCol, int endRow, int endCol, boolean flag) {
        // ���flagΪ�棬��ô�����´�ӡ������; ���򣬴����ϴ�ӡ������
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

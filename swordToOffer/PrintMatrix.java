package NowCoder.swordToOffer;

import java.util.ArrayList;

/**
 * ˳ʱ���ӡ����
 * ��Ŀ����:
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || m == 0) return list;
        int startX = 0, startY = 0;
        int endX = matrix.length - 1, endY = matrix[0].length - 1;
        while (startX <= endX && startY <= endY) {
            smallProcess(matrix, startX, startY, endX, endY, list);
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return list;
    }

    // (startX, startY)��(endX, endY)��Ϊ��������ϽǺ����½�˳ʱ���ӡÿһ������
    public void smallProcess(int[][] matrix, int startX, int startY, int endX, int endY, ArrayList<Integer> list) {
        if (startX == endX) {
            for (int i = startY; i <= endY; i++) {
                list.add(matrix[startX][i]);
            }
        } else if (startY == endY) {
            for (int i = startX; i <= endX; i++) {
                list.add(matrix[i][startY]);
            }
        } else {
            for (int i = startY; i < endY; i++) {
                list.add(matrix[startX][i]);
            }
            for (int i = startX; i < endX; i++) {
                list.add(matrix[i][endY]);
            }
            for (int i = endY; i > startY; i--) {
                list.add(matrix[endX][i]);
            }
            for (int i = endX; i > startX; i--) {
                list.add(matrix[i][startY]);
            }
        }
    }
}

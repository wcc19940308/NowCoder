package NowCoder.swordToOffer;

import java.util.ArrayList;

/**
 * �������к�Ϊĳһֵ��·��
 * ��Ŀ����
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * (ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 *
 * ע�������·������ָ���ǴӸ��ڵ�Ϊ��㵽Ҷ�ڵ�Ϊ�յ��·��
 */
public class FindPath {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        recursive(root, target, list, new ArrayList<>());
        return list;
    }

    public  void recursive(TreeNode root, int target, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> tmpList) {
        if (root == null) return;
        tmpList.add(root.val);
        target -= root.val;
        if (0 == target && root.left == null && root.right == null) {
            list.add(new ArrayList<>(tmpList));
        }
        recursive(root.left, target, list, tmpList);
        recursive(root.right, target, list, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = root.left = new TreeNode(5);
        TreeNode right = root.right = new TreeNode(12);
        TreeNode lleft = left.left = new TreeNode(4);
        TreeNode lright = left.right = new TreeNode(7);
    }
}

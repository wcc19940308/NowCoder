package NowCoder.advanced_class03;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 构造数组的MaxTree（单调栈的应用,也可以使用建堆来实现）
 * 对于数组中的每个数，找到左边第一个比他大的x1，右边第一个比他大的x2
 * 如果x1 == null & x2 == null ，那么x为父节点
 * 如果x1 != null && x2 != null ，那么x选择x1,x2中小的作为父
 * 如果x1和x2有一个为null，那么选择不为null的作为父节点
 * 这样构造出来的二叉树就是MaxTree
 */
public class GetMaxTree {
    static class Node {
        int val;
        Node left;
        Node rigit;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node getMaxTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Map<Node, Node> leftBigMap = new HashMap<>();
        Map<Node, Node> rightBigMap = new HashMap<>();
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(arr[i]);
        }
        for (int i = 0; i < nodes.length; i++) {
            Node curNode = nodes[i];
            while (!stack.isEmpty() && stack.peek().val < curNode.val) {
                popNode(stack,leftBigMap);
            }
            stack.push(curNode);
        }
        // 将栈中剩下的元素处理完，下同
        while (!stack.isEmpty()) {
            popNode(stack,leftBigMap);
        }

        for (int i = nodes.length - 1; i >= 0; i--) {
            Node curNode = nodes[i];
            while (!stack.isEmpty() && stack.peek().val < curNode.val) {
                popNode(stack,rightBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popNode(stack, rightBigMap);
        }

        Node head = null;
        for (int i = 0; i < nodes.length; i++) {
            Node left = leftBigMap.get(nodes[i]);
            Node right = rightBigMap.get(nodes[i]);
            if (left == null && right == null) {
                head = nodes[i];
            } else if (left == null) {
                if (right.left == null) {
                    right.left = nodes[i];
                } else {
                    right.rigit = nodes[i];
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = nodes[i];
                } else {
                    left.rigit = nodes[i];
                }
            } else {
                Node parent = left.val < right.val ? left : right;
                if (parent.left == null) {
                    parent.left = nodes[i];
                } else {
                    parent.rigit = nodes[i];
                }
            }
        }
        return head;
    }

    public static void popNode(Stack<Node> stack, Map<Node, Node> map) {
        Node pop = stack.pop();
        if (!stack.isEmpty()) {
            map.put(pop, stack.peek());
        } else {
            map.put(pop, null);
        }
    }
}

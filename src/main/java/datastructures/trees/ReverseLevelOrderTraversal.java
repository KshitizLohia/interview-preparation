package datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.setLeft(new TreeNode(7));
        root.setRight(new TreeNode(1));
        root.getLeft().setRight(new TreeNode(5));
        root.getLeft().setLeft(new TreeNode(10));
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> a = new ArrayList<>();
        Queue<TreeNode> b = new LinkedList<>();
        b.offer(root);
        while (!b.isEmpty()) {
            int level = b.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i=0;i<level;i++) {
                TreeNode currentNode = b.poll();
                currentLevel.add(currentNode.getValue());
                if (currentNode.getLeft() != null) {
                    b.offer(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    b.offer(currentNode.getRight());
                }
            }
            a.add(0, currentLevel);
        }
        return a;
    }
}

package datastructures.trees;

public class DepthFirstTraversal {
    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null) return false;
        if (sum == root.getValue() && root.getRight()==null && root.getLeft()==null) return true;
        return hasPath(root.getLeft(), sum- root.getValue()) || hasPath(root.getRight(), sum-root.getValue());
    }
}

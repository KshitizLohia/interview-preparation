package datastructures.trees;

import lombok.Data;

@Data
public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}

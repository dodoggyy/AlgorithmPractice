package practice;

import javax.swing.tree.TreeNode;

/**
 * Implement 617. Merge Two Binary Trees
 * 
 * @author Chris.Lin
 * @version 1.0
 */
public class MergeTwoBinaryTrees {
    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }
            TreeNode mMergeTree = new TreeNode(-1);
            if (t1 == null) {
                mMergeTree.val = t2.val;
                mMergeTree.left = mergeTrees(null, t2.left);
                mMergeTree.right = mergeTrees(null, t2.right);
            } else if (t2 == null) {
                mMergeTree.val = t1.val;
                mMergeTree.left = mergeTrees(t1.left, null);
                mMergeTree.right = mergeTrees(t1.right, null);
            } else {
                mMergeTree.val = t1.val + t2.val;
                mMergeTree.left = mergeTrees(t1.left, t2.left);
                mMergeTree.right = mergeTrees(t1.right, t2.right);
            }
            return mMergeTree;
        }

        public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null)
                return null;
            if (t1 == null)
                return t2;
            if (t2 == null)
                return t1;
            
        }
    }
}

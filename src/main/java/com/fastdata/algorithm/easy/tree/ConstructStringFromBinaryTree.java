package com.fastdata.algorithm.easy.tree;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/construct-string-from-binary-tree/
 * @Date: create in 1/14/21 - 11:37 AM
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        // corner case
        if (t == null) return "";
        // 若无左右子树，直接返回当前值
        if (t.left == null && t.right == null) {
            // 此写法属于string concat，比较耗时，可以使用stringbuilder
            return t.val + "";
        }
        // 若其中一颗子树为null，另一颗子树不为null，说明有一颗子树，递归找存在的子树值
        // 由于左子树不能省略括号
        if (t.left == null) {
            return t.val + "()" + "(" + tree2str(t.right) + ")";
        }
        // 右子树可以省略括号
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        // 以上情况都不满足，说明返回t的serialization string
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
}

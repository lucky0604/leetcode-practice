package com.fastdata.algorithm.medium.tree;

import com.fastdata.algorithm.easy.tree.TreeNode;

public class FindBottomLeftTreeValue {

    int maxHeight=0;
    int res=0;
    boolean isFound=false;

    public int findBottomLeftValue(TreeNode root) {
        maxHeight = findHeight(root);
        findNode(root,1);

        return res;
    }

    private void findNode(TreeNode root,int level){

        if(root == null){
            return;
        }

        findNode(root.left,level+1);
        findNode(root.right,level+1);

        if(!isFound&&level==maxHeight){
            res=root.val;
            isFound=true;
        }
    }

    private int findHeight(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.max(left,right)+1;

    }
}

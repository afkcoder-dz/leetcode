package com.java.leetcode.binarytree;

//Constraints:

import com.java.leetcode.objects.TreeNode;

//The number of nodes in both trees is in the range [0, 100].
//        -104 <= Node.val <= 104
public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p ==  null && q == null) return true;
        if((p == null && q != null) || (p != null && q == null)) return false;
        if(p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        TreeNode q1 = new TreeNode(1);
        q1.right = new TreeNode(2);

        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);
        p2.right = new TreeNode(1);
        TreeNode q2 = new TreeNode(1);
        q2.left = new TreeNode(1);
        q2.right = new TreeNode(2);

        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2);
        p3.right = new TreeNode(3);
        TreeNode q3 = new TreeNode(1);
        q3.left = new TreeNode(2);
        q3.right = new TreeNode(3);


        System.out.println(isSameTree(p1,q1));

        System.out.println(isSameTree(p2,q2));
        System.out.println(isSameTree(p3,q3));


    }
}

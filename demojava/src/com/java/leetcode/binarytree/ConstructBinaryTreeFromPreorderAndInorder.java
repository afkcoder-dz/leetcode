package com.java.leetcode.binarytree;

import com.java.leetcode.objects.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder {

    public TreeNode buildTree0(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1) return root;

        int rootIndexInorder = inorderIndexMap.get(root.val);

        int[] leftSubtreeInorder = Arrays.copyOfRange(inorder, 0, rootIndexInorder);
        int[] rightSubtreeInorder = Arrays.copyOfRange(inorder, rootIndexInorder + 1, inorder.length);

        int[] leftSubtreePreorder;
        int[] rightSubtreePreorder;

        if(rootIndexInorder == 0) {
            leftSubtreePreorder = new int[]{};
            rightSubtreePreorder = Arrays.copyOfRange(preorder,1, preorder.length + 1);
        } else{
            leftSubtreePreorder = Arrays.copyOfRange(preorder, 1, rootIndexInorder + 1);
            rightSubtreePreorder = Arrays.copyOfRange(preorder, rootIndexInorder + 1, preorder.length+1);
        }

        root.left = buildTree0(leftSubtreePreorder,leftSubtreeInorder);
        root.right = buildTree0(rightSubtreePreorder, rightSubtreeInorder);
        return root;
    }



    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, inorderIndexMap);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd,
                                     Map<Integer, Integer> inorderIndexMap) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        int rootIndexInInorder = inorderIndexMap.get(rootValue);


        int leftSubtreeSize = rootIndexInInorder - inStart;

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize,
                inorder, inStart, rootIndexInInorder - 1, inorderIndexMap);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd,
                inorder, rootIndexInInorder + 1, inEnd, inorderIndexMap);

        return root;
    }


    public int getIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index when the target is found
            }
        }
        return -1; // Return -1 if the target is not found
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorder constructBinaryTreeFromPreorderAndInorder = new ConstructBinaryTreeFromPreorderAndInorder();
        constructBinaryTreeFromPreorderAndInorder.buildTree(new int[]{1,2,3}, new int[]{3,2,1});
    }



}

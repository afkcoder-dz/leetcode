package com.java.leetcode.binarytree;

import com.java.leetcode.objects.TreeNode;

import java.util.*;

import static com.java.leetcode.objects.TreeNode.insertLevelOrder;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root == null){
             return null;  //return null if no one matches.
         }
         if(root == p || root == q) {
             return root; // Return one match node
         }
         TreeNode left = lowestCommonAncestor(root.left, p, q);
         TreeNode right = lowestCommonAncestor(root.right, p, q);

         if (left != null && right != null) {
             return root;  // Both left and right are non-null, it means one of p and q is on the left subtree, the other is on the right subtree, so the root is the LCA.
         }

         return left != null ? left : right; // Only one is non-null, it means both p and q is on the left subtree or the right subtree. so the first match node is the LCA.
    }




    // iterative method
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        parentMap.put(root, null); // Root has no parent


        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left != null) {
                queue.offer(current.left);
                parentMap.put(current.left, current);
            }
            if(current.right != null) {
                queue.offer(current.right);
                parentMap.put(current.right, current);
            }
        }

        // Get ancestors of node p
        Set<TreeNode> ancestorsOfP = new HashSet<>();
        while(p != null){
            ancestorsOfP.add(p);
            p = parentMap.get(p);
        }

        // Find the first common ancestor of q
        while(!ancestorsOfP.contains(q)){
            q = parentMap.get(q);
        }
        return q;
    }


    public static void main(String[] args) {
        // Example binary tree represented as an array
        int[] nodes = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4}; // -1 represents null
        TreeNode root = insertLevelOrder(nodes, 0);

        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();
        TreeNode p = root.left; // Node 5
        TreeNode q = root.left.right.right; // Node 4

       // TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);
        //System.out.println("Lowest Common Ancestor: " + (lca != null ? lca.val : "null"));

        TreeNode lca2 = lcaFinder.lowestCommonAncestor2(root, p, root);
        System.out.println("Lowest Common Ancestor: " + (lca2 != null ? lca2.val : "null"));
    }
}

/**

 ### **Time Complexity**

 1. **Building the Parent Map**:
 - During the level-order traversal of the tree, each node is visited once, and its parent is recorded.
 - Time complexity: \( O(N) \), where \( N \) is the number of nodes in the tree.

 2. **Tracing Ancestors for \( p \)**:
 - Starting from \( p \), we trace its path to the root by following parent pointers.
 - The height of the tree determines the number of steps.
 - Time complexity: \( O(H) \), where \( H \) is the height of the tree.

 3. **Tracing \( q \) to Find LCA**:
 - Starting from \( q \), we trace its path to the root until we find a common ancestor in the ancestor set of \( p \).
 - Again, this takes at most \( O(H) \) steps.

 **Total Time Complexity**:
 \[
 O(N) + O(H) + O(H) = O(N)
 \]
 \( H \) is at most \( N \) in a skewed tree, but \( H \) is much smaller in balanced trees. Still, \( O(N) \) dominates.

 ---

 ### **Space Complexity**

 1. **Parent Map**:
 - The parent map stores a pointer for each node in the tree, which requires \( O(N) \) space.

 2. **Ancestor Set for \( p \)**:
 - The ancestor set stores at most \( O(H) \) nodes (the path from \( p \) to the root).

 3. **Queue for BFS**:
 - The queue for level-order traversal holds at most \( O(W) \) nodes at any time, where \( W \) is the maximum width of the tree. In the worst case, \( W \) can be \( N/2 \) for a full binary tree, which simplifies to \( O(N) \).

 **Total Space Complexity**:
 \[
 O(N) + O(H) + O(W) = O(N)
 \]

 ### **Summary**
 - **Time Complexity**: \( O(N) \)
 - **Space Complexity**: \( O(N) \)



### **Time Complexity** for the Recursive Method

In the recursive method, each node is visited once to check if \( p \) or \( q \) is found in its left or right subtree.

        1. **Single Recursive Call**:
        - For each node, the function makes at most two recursive calls (one for the left child and one for the right child).
        - Each recursive call performs a constant amount of work (checking the base case and combining the results).

        2. **Traversal of the Tree**:
        - The recursion traverses the entire tree, visiting each node exactly once.
        - Time complexity: \( O(N) \), where \( N \) is the number of nodes in the tree.

        ---

        ### **Space Complexity** for the Recursive Method

Space complexity in recursion is determined by the **call stack**, which depends on the height of the binary tree:

        1. **Call Stack Usage**:
        - At any point, the recursive function maintains a call stack that corresponds to the depth of the recursion.
   - The depth of recursion is equal to the height of the tree (\( H \)).

        2. **Worst Case**:
        - For a **skewed tree** (all nodes in a single line), the height is \( N \), so the space complexity is \( O(N) \).

        3. **Best Case**:
        - For a **balanced tree**, the height is \( O(\log N) \), so the space complexity is \( O(\log N) \).

        ---

        ### **Summary**

        #### Recursive Method Complexity:
        - **Time Complexity**: \( O(N) \)
        - Every node is visited once.
- **Space Complexity**:
        - \( O(H) \), where \( H \) is the height of the tree.
        - Worst case: \( O(N) \) (skewed tree).
        - Best case: \( O(\log N) \) (balanced tree).

*/


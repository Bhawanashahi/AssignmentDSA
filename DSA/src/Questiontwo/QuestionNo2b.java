package Questiontwo;

import java.util.LinkedList;
import java.util.Queue;

/* 2.b) You are given an array of binary trees that represent different cities where a certain corporation
has its branch office and the organization wishes to provide service by constructing a service center.
Building service centers at any node, i.e., a city can give service to its directly connected cities where
it can provide service to its parents, itself, and its immediate children. Returns the smallest number of
service centers required by the corporation to provide service to all connected cities. Note that: the root
node represents the head office and other connected nodes represent the branch office connected to the head
office maintaining some kind of hierarchy.

Input: tree= {0,0, null, 0, null, 0, null, null, 0}
Output: 2
Explanation: construction of two service centers denoted by black markk will be enough to provide service
to all cities.
*/
class TreeNode{
    TreeNode left;
    TreeNode right;
        int data;

    // Constructor that takes a data value and initializes the left and right nodes to null
    TreeNode(int data){
        this.data=data;
        this.left=this.right=null;
    }

    // Default constructor
    TreeNode(){
    }

    // Method to add nodes to the binary tree given an array input
    public TreeNode addToTree(Object[] input) {
        // If input is empty or null, return null
        if (input == null || input.length == 0) {
            return null;
        }

        // Create a new TreeNode with the first element in the input array and add it to a queue
        TreeNode root = new TreeNode((int) input[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Iterate through the rest of the input array, adding nodes to the binary tree
        for (int i = 1; i < input.length; i += 2) {
            TreeNode curr = queue.poll();
            // If the current element is not null, add it as the left child of the current node
            if (input[i] != null) {
                curr.left = new TreeNode((int) input[i]);
                queue.offer(curr.left);
            }
            // If the next element is not null and there are more elements in the input array, add it as the right child of the current node
            if (i+1 < input.length && input[i+1] != null) {
                curr.right = new TreeNode((int) input[i+1]);
                queue.offer(curr.right);
            }
        }

        return root; // Return the root node of the binary tree
    }


}






class ConstructionServiceCenter{
    int res = 0;

    // Function to calculate the minimum number of service centers required using depth first search (DFS)
    public int minCameraCover(TreeNode root) {
        // Call the DFS function and return the result
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    // Helper function to perform DFS and calculate the minimum number of service centers required
    public int dfs(TreeNode root) {
        // Check if the current node is null
        if (root == null) return 2;
        // Recursively call DFS on the left and right children of the current node
        int left = dfs(root.left), right = dfs(root.right);
        // Check if the left or right child is uncovered
        if (left == 0 || right == 0) {
            // Increment the number of service centers required
            res++;
            // Return 1 to indicate that the current node is covered
            return 1;
        }
        // Check if the left or right child is covering the current node
        return left == 1 || right == 1 ? 2 : 0;
    }



    public static void main(String[] args) {
        Object[] tree= {0,0, null, 0, null, 0, null, null, 0 , 0 ,null,0};
        TreeNode root = new TreeNode().addToTree(tree);
        int ans = new ConstructionServiceCenter().minCameraCover(root);
        System.out.println(ans);


    }

}


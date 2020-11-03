package leetcode.trees;

import java.util.*;
import java.lang.*;
import java.io.*;

public class ArrayToBBST {
//    Input:
//            1
//            7
//            1 2 3 4 5 6 7
//
//    Output:
//            4 2 1 3 6 5 7
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String arr = sc.nextLine();
            int[] nums = Arrays.stream(arr.split(" ")).mapToInt(Integer::parseInt).toArray();

            TreeNode node = createTree(nums, 0, n - 1);
            printTree(node);
            testcases--;
        }
    }

    private static TreeNode createTree(int[] arr, int l, int r) {
        if (l > r) return null;
        int rt = (r - l + 1) / 2;
        TreeNode root;
        if (l == r) {
            root = new TreeNode((arr[l]));
            return root;
        } else {
            root = new TreeNode(arr[rt + l]);
            root.left = createTree(arr, l, rt + l - 1);
            root.right = createTree(arr, rt + l + 1, r);

        }
        return root;
    }

    private static void printTree(TreeNode node) {
        if (node == null) return;

        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);

    }

}

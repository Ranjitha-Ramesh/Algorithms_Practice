package leetcode.Arrays;

//Given an array Arr[] of N positive integers. The task is to find the
// maximum of j - i subjected to the constraint of Arr[i] <= Arr[j].
public class MaxIndex {
    public static void main(String[] args) {
        int N = 9;
        int[] Arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxIndexDiff(Arr, N));
        //Output: 6
    }

    private static int maxIndexDiff(int arr[], int n) {

        if (n < 2) return 0;

        int[] Lmin = new int[n];
        int[] Rmax = new int[n];
        int maxdiff = -1;

        Lmin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            Lmin[i] = Integer.min(Lmin[i - 1], arr[i]);
        }

        Rmax[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            Rmax[j] = Integer.max(Rmax[j + 1], arr[j]);
        }

        int i = 0, j = 0;

        while (i < n && j < n) {
            if (Lmin[i] <= Rmax[j]) {
                maxdiff = Integer.max(maxdiff, (j - i));
                j++;
            } else
                i++;
        }

        return maxdiff;
    }
}

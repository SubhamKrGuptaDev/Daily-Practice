package codeforce;

import java.util.Scanner;

public class GCD_on_a_grid {

    // Main Method for Input Testcase
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int k=0; k<testCase; k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int maxGCD = findMaxGCD(arr, n, m);
            System.out.println(maxGCD);
        }

    }

    // Find Max GCD in a grid
    private static int findMaxGCD(int[][] arr, int n, int m) {
        int maxElement = -1;
        for(int i = 0; i < n; i++) {
            int ele = arr[i][0];
            for(int j = 1; j < m; j++) {
                ele = gcdEle(ele, arr[i][j]);
                maxElement = Math.max(ele, maxElement);
            }
        }

        return maxElement;
    }

    // GCD finder
    private static int gcdEle(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

}

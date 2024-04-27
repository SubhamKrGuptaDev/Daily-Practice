/**
 *
 * 3001. Minimum Moves to Capture The Queen
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * There is a 1-indexed 8 x 8 chessboard containing 3 pieces.
 *
 * You are given 6 integers a, b, c, d, e, and f where:
 *
 * (a, b) denotes the position of the white rook.
 * (c, d) denotes the position of the white bishop.
 * (e, f) denotes the position of the black queen.
 * Given that you can only move the white pieces, return the minimum number of moves required to capture the black queen.
 *
 * Note that:
 *
 * Rooks can move any number of squares either vertically or horizontally, but cannot jump over other pieces.
 * Bishops can move any number of squares diagonally, but cannot jump over other pieces.
 * A rook or a bishop can capture the queen if it is located in a square that they can move to.
 * The queen does not move.
 *
 *
 * Example 1:
 *
 *
 * Input: a = 1, b = 1, c = 8, d = 8, e = 2, f = 3
 * Output: 2
 * Explanation: We can capture the black queen in two moves by moving the white rook to (1, 3) then to (2, 3).
 * It is impossible to capture the black queen in less than two moves since it is not being attacked by any of the pieces at the beginning.
 * Example 2:
 *
 *
 * Input: a = 5, b = 3, c = 3, d = 4, e = 5, f = 2
 * Output: 1
 * Explanation: We can capture the black queen in a single move by doing one of the following:
 * - Move the white rook to (5, 2).
 * - Move the white bishop to (5, 2).
 *
 *
 * Constraints:
 *
 * 1 <= a, b, c, d, e, f <= 8
 * No two pieces are on the same square.
 *
 *
 *
 */



package Leetcode;

public class Minimum_Moves_to_Capture_The_Queen {

    public int minMovesToCaptureTheQueen(int r1, int r2, int b1, int b2, int q1, int q2) {
        // bishop cases
        if(isBishopCanFoundQueen(r1, r2, b1, b2, q1, q2)) {
            return 1;
        }

        if(isRookCanFoundQueen(r1, r2, b1, b2, q1, q2)) {
            return 1;
        }

        return 2;
    }

    private boolean isRookCanFoundQueen(int r1, int r2, int b1, int b2, int q1, int q2) {

        int i1 = r1 - 1;
        int i2 = r1 + 1;
        int j1 = r2;

        // top to bottom
        while(i1 > 0 || i2 <= 8) {

            if(i1 == b1 && j1 == b2) {
                i1 = 0;
            }

            if(i2 == b1 && j1 == b2) {
                i2 = 9;
            }

            if((i1 == q1 && j1 == q2) || (i2 == q1 && j1 == q2)) {
                return true;
            }

            i1--;
            i2++;
        }

        // left to right
        i1 = r1;
        j1 = r2 - 1;
        int j2 = r2 + 1;

        while(j1 > 0 || j2 <= 8) {
            if((i1 == q1 && j1 == q2) || (i1 == q1 && j2 == q2)) {
                return true;
            }

            if(j1 == b2 && i1 == b1) {
                j1 = 0;
            }

            if(j2 == b2 && i1 == b1) {
                j2 = 9;
            }

            j1--;
            j2++;
        }

        return false;
    }

    private boolean isBishopCanFoundQueen(int r1, int r2, int b1, int b2, int q1, int q2) {

        int i1 = b1-1;
        int j1 = b2-1;

        int i2 = b1 + 1;
        int j2 = b2 + 1;

        while(i1 > 0 || j2 <= 8) {
            if((i1 == r1 && j1 == r2)) {
                i1 = 0;
                j1 = 0;
            }

            if((i2 == r1 && j2 == r2)) {
                i2 = 9;
                j2 = 9;
            }

            if((i1 == q1 && j1 == q2) || (i2 == q1 && j2 == q2)) {
                return true;
            }

            i1--;
            j1--;
            i2++;
            j2++;
        }


        i1 = b1 - 1;
        j1 = b2 + 1;
        i2 = b1 + 1;
        j2 = b2 - 1;

        while((i1 > 0 && j1 <= 8) || (i2 <= 8 && j2 > 0)) {

            if((i1 == r1 && j1 == r2)) {
                i1 = 0;
                j1 = 9;
            }

            if((i2 == r1 && j2 == r2)) {
                i2 = 9;
                j2 = 0;
            }

            if((i1 == q1 && j1 == q2) || (i2 == q1 && j2 == q2))
                return true;

            i1--;
            j1++;
            i2++;
            j2--;
        }

        return false;
    }

    public int minMovesToCaptureTheQueenOptimized(int a, int b, int c, int d, int e, int f) {
        if(a==e || b==f){
            //check if bishop is in the path of rook or not..
            if(a==c){
                if((d>b && d<f) || (d>f && d<b))return 2;
            }if(b==d){
                if((c>a && c<e) || (c>e && c<a))return 2;
            }
            return 1;
        }
        else if(Math.abs(c-e)==Math.abs(d-f)){
            // check if rook is in the path of bishop or not..
            if(Math.abs(a-c)==Math.abs(b-d) && Math.abs(e-a)==Math.abs(f-b)){
                if((a>e && a<c) || (a>c && a<e)){
                    return 2;
                }
            }
            return 1;
        }
        return 2;
    }

    public int minMovesToCaptureTheQueenBruteForce(int r1, int r2, int b1, int b2, int q1, int q2) {
        // bishop cases
        if(isBishopCanFoundQueenBruteForce(r1, r2, b1, b2, q1, q2)) {
            return 1;
        }

        if(isRookCanFoundQueenBruteForce(r1, r2, b1, b2, q1, q2)) {
            return 1;
        }

        return 2;
    }

    private boolean isRookCanFoundQueenBruteForce(int r1, int r2, int b1, int b2, int q1, int q2) {

        int i1 = r1 - 1;
        int i2 = r1 + 1;
        int j1 = r2;

        // top to bottom
        while(i1 > 0 || i2 <= 8) {

            if(i1 == b1 && j1 == b2) {
                i1 = 0;
            }

            if(i2 == b1 && j1 == b2) {
                i2 = 9;
            }

            if((i1 == q1 && j1 == q2) || (i2 == q1 && j1 == q2)) {
                return true;
            }

            i1--;
            i2++;
        }

        // left to right
        i1 = r1;
        j1 = r2 - 1;
        int j2 = r2 + 1;

        while(j1 > 0 || j2 <= 8) {
            if((i1 == q1 && j1 == q2) || (i1 == q1 && j2 == q2)) {
                return true;
            }

            if(j1 == b2 && i1 == b1) {
                j1 = 0;
            }

            if(j2 == b2 && i1 == b1) {
                j2 = 9;
            }

            j1--;
            j2++;
        }

        return false;
    }

    private boolean isBishopCanFoundQueenBruteForce(int r1, int r2, int b1, int b2, int q1, int q2) {

        int i1 = b1-1;
        int j1 = b2-1;

        int i2 = b1 + 1;
        int j2 = b2 + 1;

        while(i1 > 0 || j2 <= 8) {
            if((i1 == r1 && j1 == r2)) {
                i1 = 0;
                j1 = 0;
            }

            if((i2 == r1 && j2 == r2)) {
                i2 = 9;
                j2 = 9;
            }

            if((i1 == q1 && j1 == q2) || (i2 == q1 && j2 == q2)) {
                return true;
            }

            i1--;
            j1--;
            i2++;
            j2++;
        }


        i1 = b1 - 1;
        j1 = b2 + 1;
        i2 = b1 + 1;
        j2 = b2 - 1;

        while((i1 > 0 && j1 <= 8) || (i2 <= 8 && j2 > 0)) {

            if((i1 == r1 && j1 == r2)) {
                i1 = 0;
                j1 = 9;
            }

            if((i2 == r1 && j2 == r2)) {
                i2 = 9;
                j2 = 0;
            }

            if((i1 == q1 && j1 == q2) || (i2 == q1 && j2 == q2))
                return true;

            i1--;
            j1++;
            i2++;
            j2--;
        }

        return false;
    }

}

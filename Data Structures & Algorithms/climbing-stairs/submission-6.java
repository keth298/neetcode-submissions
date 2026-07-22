class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[][] M = {{1, 1}, {1, 0}};
        return matrixPow(M, n)[0][0];
    }

    public int[][] matrixMult(int[][] A, int[][] B){
        return new int[][] {
            {A[0][0] * B[0][0] + A[0][1] * B[1][0],
             A[0][0] * B[0][1] + A[0][1] * B[1][1]},
            {A[1][0] * B[0][0] + A[1][1] * B[1][0],
             A[1][0] * B[0][1] + A[1][1] * B[1][1]}
        };
    }

    public int[][] matrixPow(int[][]M, int n){
        int[][] res = {{1, 0}, {0, 1}};
        int[][] base = M;

        while(n > 0){
            if(n % 2 == 1){
                res = matrixMult(res, base);
            } 
            base = matrixMult(base, base);
            n /= 2;
        }

        return res;
    }
}

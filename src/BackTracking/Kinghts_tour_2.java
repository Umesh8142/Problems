package BackTracking;

import java.io.*;
        import java.util.*;

public class Kinghts_tour_2 {
    public static void main(String[] args) throws Exception     {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
    int[][] chess = new int[n][n];

        printKnightsTour(chess,n, r, c, 1);
    }

    public static void printKnightsTour(int[][] chess,int n, int r, int c, int move)
    {
        // Write your code here

        if(r<0 || c<0 || r>=n || c>=n || chess[r][c]!=0) return;
        if(move==(n*n)){
            chess[r][c]=25;
            displayBoard(chess);
            chess[r][c]=0;
            return;
        }
        chess[r][c]=move;
        printKnightsTour(chess,n,r-2,c+1,move+1);
        printKnightsTour(chess,n,r-1,c+2,move+1);
        printKnightsTour(chess,n,r+1,c+2,move+1);
        printKnightsTour(chess,n,r+2,c+1,move+1);
        printKnightsTour(chess,n,r+2,c-1,move+1);
        printKnightsTour(chess,n,r+1,c-2,move+1);
        printKnightsTour(chess,n,r-1,c-2,move+1);
        printKnightsTour(chess,n,r-2,c-1,move+1);
        chess[r][c]=0;

        return;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

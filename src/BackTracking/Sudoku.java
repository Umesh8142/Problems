package BackTracking;
import java.util.*;
public class Sudoku {




        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            char[][] board = new char[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = sc.next().charAt(0);
                }
            }
            sc.close();
            if (isValidSudoku(board)) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }

        public static boolean isValidSudoku(char[][] board) {
            // your code here
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(board[i][j]=='.') continue;
                    else{
                        if(isPossible(i,j,board[i][j],board)==false){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        static private boolean isPossible(int r,int c,char num,char[][]board){
            // check row
            for(int i=r, j=0 ; j<9 ;j++ ){
                if(j==c) continue;
                if(board[i][j]==num) return false;
            }
            // check col
            for(int i=0, j=c ; i<9 ;i++ ){
                if(i==r) continue;
                if(board[i][j]==num) return false;
            }
            // check 3*3 matrix of row ,col from staring of r,c
            return true;
        }
    }


package BackTracking;

import java.util.*;
public class Floodfill {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] image = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                image[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int newColor = sc.nextInt();
        int[][] ans = Solution.floodFill(image, x, y, newColor);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(j == m-1) {
                    System.out.print(ans[i][j] + "\n");
                }
                else {
                    System.out.print(ans[i][j] + " ");
                }
            }
        }
    }
}
class Solution
{

    static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {   int n=image.length;
        int m=image[0].length;
        boolean [][] vis =new boolean[n][m];
       dfs(x,y,image[x][y],newColor,image,vis);
       return image;
    }
    static void dfs(int i,int j,int col,int new_col,int [][]im,boolean [][]vis){

        if(i<0 || j<0 || i>=im.length || j>=im[0].length || vis[i][j]==true || im[i][j]!=col ){
            return;
        }

        if(im[i][j]==col){
            im[i][j]=new_col;
        }
        vis[i][j]=true;
        dfs(i-1,j, col,new_col,im,vis);
        dfs(i,j+1, col,new_col,im,vis);
        dfs(i+1,j, col,new_col,im,vis);
        dfs(i,j-1, col,new_col,im,vis);

        vis[i][j]=false;
        return;
    }

}

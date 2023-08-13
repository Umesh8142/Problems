import java.util.Scanner;

public class MaxSum {
    static int count =0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();

        int [][] a = new int [n][n];
        for(int i=0;i<n;i++ ){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int [][] dp = new int [n][n];
        System.out.println(sum(0,0,a,n));
        System.out.println(count);

    }
    static private int sum(int i,int j,int [][] a,int n,int dp[][]){
        count++;
        if(i<0 || j<0 || i>=n || j>=n) return 0;
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        if(i==n-1 && j==n-1){
            return a[i][j];
        }

        int r=sum(i,j+1,a,n,dp);
        int d= sum(i+1,j,a,n,dp);

        return dp[i][j]=a[i][j]+Math.max(r,d);
    }
    static private int sum(int i,int j,int [][] a,int n){
        count++;
        if(i<0 || j<0 || i>=n || j>=n) return 0;
        if(i==n-1 && j==n-1){
            return a[i][j];
        }

        int r=sum(i,j+1,a,n);
        int d= sum(i+1,j,a,n);

        return a[i][j]+Math.max(r,d);
    }
}

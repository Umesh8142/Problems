import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[][] costs = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                costs[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(minCost(costs));
    }

    static int ans=Integer.MAX_VALUE;
    static public int minCost(int[][] costs) {
        int n = costs.length;
        int m=costs[0].length;
        int dp [][]=new int[n][m];
        return backTrack(n,costs,dp);

    }

//https://www.interviewbit.com/problems/paint-house/
    static int  backTrack(int n,int m,int[][] costs,int [][]dp){
       for(int i=0;i<n;i++){
           for(int j=0;j<3;j++){
               if(i==0){
                   dp[i][j]=costs[i][j];
                   continue;
               }
               if(j==0){
                   dp[i][0]=costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
               }
               else if(j==1){
                   dp[i][j]=costs[i][j]+Math.min(dp[i-1][0],dp[i-1][2]);
               }
               else if(j==2){
                   dp[i][j]=costs[i][j]+Math.min(dp[i-1][0],dp[i-1][1]);
               }
           }
       }
       int sum =Integer.MAX_VALUE;
       for(int i=0;i<3;i++ ){
           if(sum>dp[n-1][i]){
               sum=dp[n-1][i];
           }
       }
       return sum;
    }
    static int  backTrack(int n,int[][] costs,int [][]dp){
        for(int i=0;i<n;i++){
            if(i==0){
                dp[i][0]=costs[i][0];
                dp[i][1]=costs[i][1];
                dp[i][2]=costs[i][2];
            }
            else{
                dp[i][0]=costs[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
                dp[i][1]=costs[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
                dp[i][2]=costs[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
            }
        }
        int sum =Integer.MAX_VALUE;
        for(int i=0;i<3;i++ ){
            if(sum>dp[n-1][i]){
                sum=dp[n-1][i];
            }
        }
        return sum;
    }
}
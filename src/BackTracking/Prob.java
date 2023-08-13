package BackTracking;

public class Prob{
    public static void main(String[] args) {
        int KnightPos[]={4,5};
        int TargetPos[]={1,1};
        int N=6;
        solution3 a = new solution3();
        int ans=a.minStepToReachTarget(KnightPos,TargetPos,N);
        System.out.println(ans);
    }
}
class solution3
{   int ans=0;
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        steps(KnightPos[0],KnightPos[1],TargetPos[0],TargetPos[1],new boolean[N][N],N,0);
        return ans;
    }
    void steps(int i,int j,int ti,int tj,boolean vis[][],int N,int step){
        if(i<0 || j<0 || i>=N || j>=N || vis[i][j]==true) return;

        if(i==ti && j==tj){
            ans=Math.min(ans,step);
            return;
        }
        vis[i][j]=true;
        steps(i-2,j+1,ti,tj,vis,N,step+1);
        steps(i-1,j+2,ti,tj,vis,N,step+1);
        steps(i+1,j+2,ti,tj,vis,N,step+1);
        steps(i+2,j+1,ti,tj,vis,N,step+1);
        steps(i+2,j-1,ti,tj,vis,N,step+1);
        steps(i+1,j-2,ti,tj,vis,N,step+1);
        steps(i-1,j-2,ti,tj,vis,N,step+1);
        steps(i-2,j-1,ti,tj,vis,N,step+1);
        vis[i][j]=false;
        return;

    }
}

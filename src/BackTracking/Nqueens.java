package BackTracking;


import java.util.*;

public class Nqueens{
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        List<List<String>> ans=s.solveNQueens(3);
        for(List<String> i:ans){
            System.out.println(i);
        }
    }

}
class Solution1 {
    List<List<String>> ans= new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> list =new ArrayList<String>();
        boolean [] rcheck = new boolean[n];
        boolean [] ccheck = new boolean[n];
        boolean [] dig =new boolean[2*n-1];
        boolean [] adig =new boolean[2*n-1];
        Nqueens(0,n,rcheck,ccheck,dig,adig,list);
        return ans;

    }
    void Nqueens(int row,int n,boolean[] rcheck,boolean [] chceck, boolean[] dig,boolean [] adig, ArrayList<String> list){
        if(row==n){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int col=0;col<n;col++){
            if(isQueen(row,col,rcheck,chceck,dig,adig,n)==true){
                String s="";
                for(int i=0;i<n;i++){
                    if(i==col){
                        s=s+"Q";
                    }
                    else
                        s=s+".";
                }
                list.add(s);
                rcheck [row]=true;
                chceck[col]=true;
                dig[(n-1)-row+col]=true;
                adig[col+row]=true;
                Nqueens(row+1,n,rcheck,chceck,dig,adig,list);
                rcheck[row]=false;
                chceck[col]=false;
                dig[(n-1)-row+col]=false;
                adig[col+row]=false;
                list.remove(list.size()-1);
            }
        }
    }
    boolean isQueen(int row,int col,boolean[] rcheck,boolean [] chceck, boolean[] dig,boolean [] adig,int n){
        if(rcheck[row]==true && chceck[col]==true && dig[(n-1)-row+col]==true && adig[row+col]==true)
            return false;
        return true;
    }
}
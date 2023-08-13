package BackTracking;


import java.util.*;

class Solution2 {
    List<List<Integer>> ans =new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        // Write your code here
        ArrayList<Integer>list =new ArrayList<Integer>();
        backtrack(2,n/2,n,1, list);
        return ans;
    }
    void backtrack(int st,int end,int tar,int currP,ArrayList<Integer> list){
        if(currP>tar){
            return;
        }
        if(currP==tar){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=st;i<=end;i++){
            list.add(i);
            backtrack(i,end,tar,currP*i,list);
            list.remove(list.size()-1);
        }
        return;
    }
}

public class Factor{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Solution2 Obj = new Solution2();
        List<List<Integer>> result = Obj.getFactors(n);
        Collections.sort(result, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++)
                System.out.print(result.get(i).get(j) + " ");
            System.out.println();
        }

        sc.close();
    }
}

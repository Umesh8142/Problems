package BackTracking;


import java.util.*;
class SubsetsOfArray {
    static Set<ArrayList<Integer>> ans = new HashSet<>();
    public static ArrayList<ArrayList<Integer>> subsets(int[] arr, int n) {

        //Write your code here
        Set<Integer>list=new HashSet<>();
        backtrack(arr,0,n,list);
        ArrayList<ArrayList<Integer>> ans1 = new ArrayList<>(ans);
        return ans1;
    }
    static void backtrack(int [] arr,int indx,int n,Set<Integer>list){
        if(indx==n){
            return;
        }

        for(int i=indx;i<n;i++){
            list.add(arr[i]);
            ans.add(new ArrayList<>(list));
            backtrack(arr,indx+1,n,list);
            list.clear();
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            ArrayList<ArrayList<Integer>> res = subsets(A, n);
            Collections.sort(res, (o1, o2) -> {
                if(o1.size()==o2.size()){
                    return o1.get(0)- o2.get(0);
                }
                return o1.size()-o2.size();
            });
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();

            }
        }
    }
}

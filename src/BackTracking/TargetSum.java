package BackTracking;
import java.util.*;
public class TargetSum {



        static Set<ArrayList<Integer>> ans =new HashSet<>();
        public static ArrayList<ArrayList<Integer>> findSubsets(int[] arr, int tar) {

            ArrayList<Integer> list= new ArrayList<Integer>();
            backtrack(arr,0,tar,list);
            ArrayList<ArrayList<Integer>> ans1=new ArrayList<>(ans);
            return ans1;
        }
        public static void backtrack(int [] arr,int curr,int tar,ArrayList<Integer>list){
            if(tar==0){

                ans.add(new ArrayList<>(list));
                return;
            }
            if(tar<0){
                return;
            }
            for(int i=curr;i<arr.length;i++){
                list.add(arr[i]);
                backtrack(arr,i+1,tar-arr[i],list);
                list.remove(list.size()-1);
                backtrack(arr,i+1,tar,list);
               return ;
            }
            return;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n, tar;
            n = sc.nextInt();
            tar = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            ArrayList<ArrayList<Integer>> subsets = findSubsets(arr, tar);
            Collections.sort(subsets, new Comparator<ArrayList<Integer>>() {
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return o2.get(0).compareTo(o1.get(0));
                }
            });
            if (subsets.isEmpty()) {
                System.out.println(-1);
            } else {
                for (int i = 0; i < subsets.size(); i++) {
                    for (int j = 0; j < subsets.get(i).size(); j++)
                        System.out.print(subsets.get(i).get(j) + " ");
                    System.out.println();
                }
            }
            sc.close();
        }
    }


package BackTracking;
import java.io.*;
import java.util.*;
public class PlaceTheitemsInBoxes {

    static char[] c;

    public static void combinations(int N, int R) {
        // write your code here
        c = new char[N];
        Arrays.fill(c, '-');
        backtrack(c, 0, R, 0);
    }

    static void backtrack(char[] a, int indx, int R, int count) {
        if (count == R) {
            String str = "";
            System.out.println(str.valueOf(a));
            return;
        }
        for (int i = indx; i < a.length; i++) {
            a[i] = 'i';
            backtrack(a, i + 1, R, count + 1);
            a[i] = '-';
        }

    }
}
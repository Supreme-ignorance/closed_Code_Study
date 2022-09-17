package SWEA_1979_WordPuzzle;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] col = new int[N];
            int ans = 0;
            for (int i = 0; i < N; i++) {
                int row = 0;
                for (int j = 0; j < N; j++) {
                    int blank = sc.nextInt();
                    if (blank == 0) {
                        if (row == K)
                            ++ans;
                        if (col[j] == K)
                            ++ans;
                        row = 0;
                        col[j] = 0;
                    }
                    else {
                        ++row;
                        ++col[j];
                    }
                }
                if (row == K)
                    ++ans;
            }
            for (int j = 0; j < N; j++) {
                if (col[j] == K)
                    ++ans;              
            }
            System.out.println("#" + t + " " +ans);
        }
    }
}
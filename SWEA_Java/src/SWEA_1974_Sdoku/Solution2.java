package SWEA_1974_Sdoku;

import java.util.*;
 
public class Solution2 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int[][] sdoku = new int[9][9];
            int answer = 1;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sdoku[i][j] = sc.nextInt();
                }
            }
 
            for (int i = 0; i < 9; i++) {
                int[] col = new int[9];
                int[] square = new int[9];
                for (int j = 0; j < 9; j++) {
                    col[j] = sdoku[j][i];
                    square[j] = sdoku[3*(i/3)+j/3][3*(i%3)+j%3];
                }
                if (!(is_sdoku(sdoku[i]) && is_sdoku(col) && is_sdoku(square))) {
                    answer = 0;
                    break;
                }
            }
 
            System.out.println("#" + t + " " + answer);
 
        }
    }
 
    public static boolean is_sdoku(int[] Line) {
        List<Integer> line = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            line.add(Line[i]);
        }
        line.sort(null);
        for (int i = 0; i < 9; i++) {
            if (line.get(i) != i+1)
                return false;
        }
        return true;
    }
 
}
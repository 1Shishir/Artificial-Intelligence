
import java.util.Scanner;

public class Clustering {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static void main(String[] args) {
        Scanner keyBoard = new Scanner(System.in);
        System.out.print("n = ");
        int n = keyBoard.nextInt();
        int[][] arr = new int[n][2];
        System.out.print("Eps = ");
        int eps = keyBoard.nextInt();
        System.out.print("Minpts = ");
        int minPts = keyBoard.nextInt();
        int i = 0;
        while(i < n) {
            arr[i][0] = keyBoard.nextInt();
            arr[i][1] = keyBoard.nextInt();
            i++;
        }

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < n; j++) {
                if (getDistance(arr[0][k], arr[0][j], arr[k][0], arr[0][j]) < minPts) {
                    System.out.println(arr[k][j]);
                }
            }
        }



        for (int k = 0; k < arr.length; k++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[k][j] + " ");
            }
            System.out.println();
        }
    }
}
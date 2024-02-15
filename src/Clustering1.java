import java.util.Scanner;

import static java.lang.Math.sqrt;
public class Clustering1 {

        public static void main(String[] args) {
            int counter=0, counter1=0,counter2=0,counter3=0,counter4=0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter value of n : ");
            int n = sc.nextInt();
            System.out.println("Enter the points :");

            int[][] globeArr = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    globeArr[i][j] = sc.nextInt();
                }
            }
            System.out.println("Enter the value of epsilon:");
            int ep = sc.nextInt();
            System.out.println("Enter the value of MinPts:");
            int minpts = sc.nextInt();
//Points 1,2
            for (int i = 0; i < n; i++) {
                double val = sqrt((globeArr[0][0] - globeArr[i][0]) * (globeArr[0][0] - globeArr[i][0]) + (globeArr[0][1] - globeArr[i][1]) * (globeArr[0][1] - globeArr[i][1]));
                if(val==ep){
                    counter++;
                }
            }

            if(counter>=2){
                System.out.println("Its a Core Point : "+globeArr[0][0]+" , "+globeArr[0][1]);
            }
//Points 2,3
            for (int i = 0; i < n; i++) {
                double val = sqrt((globeArr[1][0] - globeArr[i][0]) * (globeArr[1][0] - globeArr[i][0]) + (globeArr[1][1] - globeArr[i][1]) * (globeArr[1][1] - globeArr[i][1]));
                if(val==ep){
                    counter1++;
                }
            }

            if(counter1>=2){
                System.out.println("Its a Core Point : "+globeArr[1][0]+" , "+globeArr[1][1]);
            }
//Points 2,2
            for (int i = 0; i < n; i++) {
                double val = sqrt((globeArr[2][0] - globeArr[i][0]) * (globeArr[2][0] - globeArr[i][0]) + (globeArr[2][1] - globeArr[i][1]) * (globeArr[2][1] - globeArr[i][1]));
                if(val==ep){
                    counter2++;
                }
            }
            if(counter2>=2){
                System.out.println("Its a Core Point : "+globeArr[2][0]+" , "+globeArr[2][1]);
            }
//Points 3,3
            for (int i = 0; i < n; i++) {
                double val = sqrt((globeArr[3][0] - globeArr[i][0]) * (globeArr[3][0] - globeArr[i][0]) + (globeArr[3][1] - globeArr[i][1]) * (globeArr[3][1] - globeArr[i][1]));
                if(val==ep){
                    counter3++;
                }
            }
            if(counter1>=3){
                System.out.println("Its a Core Point : "+globeArr[3][0]+" , "+globeArr[3][1]);
            }
//Points 0,1
            for (int i = 0; i < n; i++) {
                double val = sqrt((globeArr[4][0] - globeArr[i][0]) * (globeArr[4][0] - globeArr[i][0]) + (globeArr[4][1] - globeArr[i][1]) * (globeArr[4][1] - globeArr[i][1]));
                if(val==ep){
                    counter4++;
                }
            }
            if(counter1>=4){
                System.out.println("Its a Core Point : "+globeArr[4][0]+" , "+globeArr[4][1]);
            }
        }
    }

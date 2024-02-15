import java.util.Scanner;

public class DecisionTree {
    static int totalYes = 0 ;
    static int totalNo = 0 ;
    public static double info(int yes, int no){
        float yesNo = yes + no ;
        double val = - ((yes/yesNo) * (Math.log(yes/yesNo)) / Math.log(2)) - ((no/yesNo) * (Math.log(no/yesNo)) / Math.log(2));
        if ( Double.isNaN(val) ){
            return  0;
        }
        return  val;
    }
    public static double[] calculateEntrophy(int[] y1, int[] n1){
        double[] arr1 = new double[y1.length];
        for(int i=0;i< y1.length;i++){
            arr1[i]=info(y1[i],n1[i]);
        }
        return arr1;
    }

    public static double Entrophy(int[] y1, int[] n1, double[] info){

        int total = 0;
        double entro = 0;

        for(int i=0;i<y1.length;i++){
            total+=(y1[i]+n1[i]);
        }
        for(int i=0;i< y1.length;i++){
            double val = ((double) (y1[i]+n1[i])/total)*info[i];

            entro += val;
        }
        return entro;
    }

    public static double gain(double info, double entrophy){
        return info - entrophy;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of features : ");
        int feature=sc.nextInt();
        int counter=0;
        double[] gainArr=new double[feature];
        while(counter<feature){
            System.out.println("Enter Parameters for "+counter+" : ");
            int row=sc.nextInt();
            int[][] globeArr= new int[row][2];
            int[] yArr=new int[row];
            int[] nArr=new int[row];
            for(int i=0;i<row;i++){
                for(int j=0;j<2;j++){
                    globeArr[i][j]=sc.nextInt();
                }

            }
            for(int i=0;i<row;i++){
                yArr[i]=globeArr[i][0];
                nArr[i]=globeArr[i][1];
            }

            for(int j=0;j< yArr.length;j++){
                totalYes += yArr[j];
            }
            for(int j=0;j< nArr.length;j++){
                totalNo += nArr[j];
            }
            double info = info((totalYes/feature),(totalNo/feature));
            double[] entrophy = calculateEntrophy(yArr,nArr);
            double entro = Entrophy(yArr,nArr,entrophy);
            System.out.println(gain(info, entro));
            double result = gain(info, entro);
            gainArr[counter]=result;
            counter++;
        }

        double max = 0;
        for(int i=0;i<gainArr.length;i++){
            if(i==0) max =gainArr[i];
            else if (max<gainArr[i]) {
                max=gainArr[i];
            }
        }
        for (int i=0;i<gainArr.length;i++){
            if(max==gainArr[i]) System.out.println("you should continue with feature: "+i);
        }
    }
}




//Enter number of features:
//        3
//
//Enter Parameters for 0:
//        3
//        1 2
//        3 4
//        5 6
//
//Enter Parameters for 1:
//        2
//        2 1
//        1 3
//
//Enter Parameters for 2:
//        4
//        4 3
//        2 1
//        6 5
//        8 7


package Clustering;

import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class CWMTSP {
    public static int[] count =new int[init.N];
    public static int[] arr = new int[init.N];
    public static double[][] zx =new double[init.N][2];
    public static double[][] ozx =new double[init.N][2];
    public static double[][] paixu =new double[init.N][2];
//    public static double[][] sum =new double[init.N][2];
    public static int Number_types;
    public static boolean r=true;
    private static int Z=0;

    public static void main(String[] args) {
        Classification();
        paixu();
        for(int i=0;i<init.N;i++){
            System.out.print(init.locate[i][0]+"  "+init.locate[i][1]+"  "+arr[i]);
        }

    }

    public static void Classification(){
        double sum=0;
        for(int i = 0; i<init.Demand.length;i++){
            sum = sum+init.Demand[i];
        }
        Number_types = (int)(sum/5.0)+1;
        Random R= new Random();
        for(int i = 1; i<init.N; i++){               //随机划分组
            int j=Math.abs(R.nextInt())%Number_types;
            arr[i]=j+1;
        }


        //查看分组情况
        for(int i=0;i<init.N;i++){
            System.out.println(arr[i]);
        }

        //计算质心
        ClassiFicateZhixin();
        while(r){
            Z++;
            System.out.println("Z   "+Z);
            distance();
            ClassiFicateZhixin();
            if(Calculating_Centroid_Distance()){
                r=false;
            }

            if(Z>100){
                break;
            }

        }

        //接下来开始将所有已经归类好的数组进行分组排列
//        for(int i= 1;i<=Number_types;i++){
//            for(int j=1;j<init.N;j++){
//                if(arr[j]==i){
//
//                }
//            }
//        }


    }

    public static void ClassiFicateZhixin(){
        double[][] sum =new double[init.N][2];
        for(int i=0;i<init.N;i++) count[i] = 0;
        for(int i=1;i<init.N;i++){
            ozx[i][0] = zx[i][0];
            ozx[i][1] = zx[i][1];
        }
        for(int i=1;i<init.N;i++){   //为每一类的聚类点计算总的横纵坐标的总和
            sum[arr[i]][0] = sum[arr[i]][0]+init.locate[i][0];
            sum[arr[i]][1] = sum[arr[i]][1]+init.locate[i][1];
            count[arr[i]]++;
        }

        for(int i=1;i<=Number_types;i++){
            zx[i][0] = sum[i][0]/count[i];
            zx[i][1] = sum[i][1]/count[i];
        }

        //查看质心的分布情况
        for(int i=1;i<init.N;i++){
            System.out.println(zx[i][0]+"  "+zx[i][1]);
        }

    }

    public static void distance(){   //计算质心与各个点之间的距离
        double[][] mindis = new double[init.N][2];
        for(int i=0;i<init.N;i++){
            mindis[i][0] = 99999999;
        }
        double[][] distance = new double[init.N][Number_types+1];
        for(int i=1;i<init.N;i++){
            for(int j=1;j<=Number_types;j++){
                distance[i][j] = sqrt(pow((init.locate[i][0]-zx[i][0]),2)+pow((init.locate[i][1]-zx[i][1]),2));
                if(distance[i][j]<mindis[i][0]){
                    mindis[i][0] = distance[i][j];
                    mindis[i][1] = j;
                }
            }
        }
        for(int i=1;i<init.N;i++){
            arr[i] = (int) mindis[i][1];
        }
    }


    //计算新旧的质心之间的偏差距离，如果偏差在一定的范围内，那么则可以退出聚类算法的过程
    public static boolean Calculating_Centroid_Distance(){
        double dis;
        for(int i=1;i<=Number_types;i++){
            dis = sqrt(pow((zx[i][0]-ozx[i][0]),2)+pow((zx[i][1]-ozx[i][1]),2));
            if(abs(dis)<0.1){
                continue;
            }
            else
                return true;
        }
        return false;
    }

    public static void paixu(){
        boolean flag = true;
        while(flag){
            int temp;
            double temp1;
            for(int i =1;i<arr.length-1;i++){
                for(int j=0;j<arr.length-i-1;j++){
                    if(arr[j+1]<arr[j]){
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;

                        temp1 = init.locate[j+1][0];
                        init.locate[j+1][0] = init.locate[j][0];
                        init.locate[j][0] = temp1;

                        temp1 = init.locate[j+1][1];
                        init.locate[j+1][1] = init.locate[j][1];
                        init.locate[j][1] = temp1;

                    }
                }
            }
        }
    }
}

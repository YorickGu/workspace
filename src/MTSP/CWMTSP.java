package MTSP;
import java.util.Random;

public class CWMTSP {
    public static int[] arr = new int[init.N];
    public static void main(String[] args) {
        Classification();

    }

    public static void Classification(){
        double sum=0;
        for(int i=0;i<init.Demand.length;i++){
            sum = sum+init.Demand[i];
        }
        int Number_types = (int)(sum/5.0);
        Random R= new Random();
        for(int i=0;i<init.N;i++){               //随机划分组
            int j=Math.abs(R.nextInt())%Number_types;
            arr[i]=j;
        }




    }
}

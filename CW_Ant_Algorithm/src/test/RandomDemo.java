package test;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random r = new Random();
        int x=0;
        final int end = 5;
        while (x<end) {
            System.out.println(r.nextInt(100)+"\t");
            x++;
        }
    }

}

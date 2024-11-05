import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println(Moore_Year(Moore()));
    }

    public static int Moore() {
        int months = 18;
        int power = 1;
        int total = 0;

        while(power < 101){
            total += months;

            power ++;



        }
        return total;
    }

    public static int Moore_Year(int months){
        return months / 12;
    }
}

import java.util.Scanner;

public class FirstLab {
    static int a;
    static int b;
    static float del_x;
    static Scanner scanner = new Scanner(System.in);
    public static double setX_I(double i){ // values of x
        return a + (i * del_x);
    }
    public static double function(double i){ // f(xi) = ai
        return 2.0 * Math.sin(Math.toRadians(setX_I(i)));
    }
    public static double b(double i){ //coefficient b
        return ((-3.0 * function(i)) + (4.0 * function(i + 0.5)) - function(i + 1)) / del_x;
    }
    public static double c(double i){ //coefficient c
        return ((2.0 * function(i)) - (4.0 * function(i + 0.5)) + (2.0 * function(i + 1))) / Math.pow(del_x,2);
    }
    public static double spline(double i){ //formula of spline
        return (c(i) * Math.pow((((3.0 * del_x) / 4.0) + setX_I(i)) - setX_I(i),2)) + (b(i) * ((((3.0 * del_x) / 4.0) + setX_I(i)) - setX_I(i))) + function(i);
    }
    public static double delI(int i){ //formula of delta i
        return Math.abs(function(i + (0.75 * del_x)) - spline(i + (0.75 * del_x)));
    }
    public static void main(String[] args){
        System.out.print("Enter a: ");
        a = scanner.nextInt();
        System.out.print("Enter b: ");
        b = scanner.nextInt();
        int[] N = {10, 20};//to check dependency from N
        for (int j = 0; j < 2; j++) {
            del_x = ((b - a) * 1.0f / N[j]);
            System.out.print("\nFunctions: \n");
            for (int i = 0; i <= N[j]; i++) {
                System.out.println(function(i) + "  ");
            }
            System.out.print("\nSplines: \n");
            for (int i = 0; i < N[j]; i++) {
                System.out.println(spline(i) + "  ");
            }
            double delta = 0;
            for (int i = 0; i < N[j]; i++) {
                delta = delta + (delI(i) / N[j]);
            }
            System.out.print("\nDelta: " + delta);
        }
    }
}

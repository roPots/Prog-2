
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
        System.out.println("Enter the coordinates of three points that make up a triangle:");
        Scanner in = new Scanner(System.in);

        Point[] points = new Point[3];
        for (int i=0;i<3;i++) {
            System.out.println("Point " + (i+1) + ": ");
            try {
                float x = in.nextFloat();
                float y = in.nextFloat();
                points[i] = new Point(x,y);
            } catch (InputMismatchException e){
                System.err.println(e.toString());
                System.err.println("entered value is not a number");
                points[i] = null;
            }
        }

        Triangle t = null;
        try {
            t = new Triangle(points[0],points[1],points[2]);
        } catch (IllegalArgumentException e) {
            System.err.println(e.toString());
            System.err.println("Points can't make up a triangle");
            System.out.println("[" + points[0] + ";" + points[1] + ";" + points[2] + "]");
            System.exit(0);
        }

        System.out.println("Triangle: " + t.toString());
        System.out.println("Sides length: " + Arrays.toString(t.sidesLen()));
        System.out.println("Type: " + t.type());
    }

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        if (isTriangle(a,b,c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else throw new IllegalArgumentException();
    }

    private boolean isTriangle(Point a, Point b, Point c) {
        float ab = Point.distanceBetween(a,b);
        float bc = Point.distanceBetween(b,c);
        float ca = Point.distanceBetween(c,a);
        return (ab<(bc+ca)&&bc<(ab+ca)&&ca<(ab+bc));
    }

    public float[] sidesLen() {
        float[] ret = new float[3];
        ret[0] = Point.distanceBetween(this.a,this.b);
        ret[1] = Point.distanceBetween(this.b,this.c);
        ret[2] = Point.distanceBetween(this.c,this.a);
        return ret;
    }

    private static boolean sidesAreEqual(float s1,float s2) {
        return Math.abs(s1-s2) < 1e-6;
    }

    public int type() {
        float[] sides = this.sidesLen();

        int ret = 0;

        if (sidesAreEqual(sides[0],sides[1])||sidesAreEqual(sides[0],sides[2])) ret++;
        if (sidesAreEqual(sides[1],sides[2])||sidesAreEqual(sides[1],sides[0])) ret++;
        if (sidesAreEqual(sides[2],sides[0])||sidesAreEqual(sides[2],sides[1])) ret++;

        return ret;

    }

    @Override
    public String toString() {
        return "[" + this.a.toString() + ";" + this.b.toString() + ";" + this.c.toString() + "]";
    }
}

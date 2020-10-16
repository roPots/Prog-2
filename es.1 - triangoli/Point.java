
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static double distanceBetween(Point a, Point b) {
        double x1 = a.getX();
        double x2 = b.getX();
        double y1 = a.getY();
        double y2 = b.getY();
        return Math.sqrt(((Math.pow((x2-x1),2))+Math.pow((y2-y1),2)));
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}

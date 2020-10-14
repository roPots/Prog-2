
public class Point {
    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public static float distanceBetween(Point a, Point b) {
        float x1 = a.getX();
        float x2 = b.getX();
        float y1 = a.getY();
        float y2 = b.getY();
        return (float) Math.sqrt(((Math.pow((x2-x1),2))+Math.pow((y2-y1),2)));
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}

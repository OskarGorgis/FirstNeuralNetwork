public class Point {

    public int x;
    public int y;
    public int target;

    public Point(int X, int Y) {
        x = X;
        y = Y;
        target = 0;
    }

    public Point(int X, int Y, int target) {
        x = X;
        y = Y;
        this.target = target;
    }
}

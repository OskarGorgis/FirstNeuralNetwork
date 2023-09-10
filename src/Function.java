import java.util.Random;

public class Function {

    int a;
    int b;
    int[] domain = new int[2];

    Function(int a, int b, int min, int max){
        this.a = a;
        this.b = b;
        domain[0] = min;
        domain[1] = max;
    }

    public String show(){
        if (b<0){
            return "y="+a+"x-"+b;
        } else if (b==0) {
            return "y="+a+"x";
        } else {
            return "y="+a+"x+"+b;
        }
    }

    private int f(int x){
        return a*x+b;
    }

    public int check_point(int x, int y){
        if (f(x) > y){
            return -1;
        } else if (f(x) < y) {
            return 1;
        } else {
            return 0;
        }
    }

    public Point generate_higher(){
        Random random = new Random();
        int X = random.nextInt(domain[1]) + domain[0];
        // tutaj coś kontynuowac miałem
    }

}

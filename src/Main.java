public class Main {
    public static void main(String[] args) {

        testing_matrix();

    }

    public static void testing_matrix() {
        Matrix m1 = new Matrix(2,3, false);
        Matrix m2 = new Matrix(3, 2, false);
        m1.matrix[0][0] = 1;
        m1.matrix[0][1] = 2;
        m1.matrix[0][2] = 3;
        m1.matrix[1][0] = 3;
        m1.matrix[1][1] = 4;
        m1.matrix[1][2] = 1.5;
        m2.matrix[0][0] = 5;
        m2.matrix[0][1] = 0.75;
        m2.matrix[1][0] = 6;
        m2.matrix[1][1] = 0.1;
        m2.matrix[2][0] = -1;
        m2.matrix[2][1] = -6;
        m1.show();
        System.out.println("____________________");
        m2.show();
        System.out.println("____________________");
        Matrix m3 = new Matrix(2,4,false);
        m3.show();
        System.out.println("____________________");
        Matrix m4 = Matrix.transpose(m3);
        m4.show();
    }

    public static void testing_one_neuron(){
        Training_arena tr_a = new Training_arena(20);
        tr_a.neuron = new Neuron(2, 0.1);
        double mistake_rate;
        int attempt = 1;
        do {
            mistake_rate = tr_a.train();
            System.out.println(attempt+" try:\nMistake rate: "+mistake_rate);
            attempt += 1;
        } while (mistake_rate > 0.05);
    }


}
import java.util.Random;

public class Neuron {

    private final double[] inputs_weights;
    public int inputs_amount;
    private final double learning_rate;

    public Neuron(int inputs_amount, double lr) {
        this.inputs_amount = inputs_amount;
        inputs_weights = new double[inputs_amount];
        learning_rate = lr;

        Random random = new Random();
        for (int i=0; i< inputs_amount; i++) {
            inputs_weights[i] = random.nextDouble();
        }

    }

    public int get_output(double[] inputs) /*throws IllegalAccessException*/ {
        /*if (inputs.length != inputs_amount) {
            throw new IllegalAccessException();
        }*/
        double sum = 0;
        for (int i=0; i < inputs_amount; i++) {
            sum += inputs_weights[i] * inputs[i];
        }
        return sign(sum);
    }

    // The activation function
    private int sign(double n) {
        if (n >= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        String table = "[";
        for (int i=0; i < inputs_amount; i++) {
            table += inputs_weights[i];
            if (i+1 != inputs_amount){
                table += ", ";
            }
        }
        table += "]";
        return "Weights:\n"+table;
    }

    boolean train(double[] inputs, int answer) {
        int guess = get_output(inputs);
        int error = answer - guess;
        if (error != 0) {
            for (int i=0; i < inputs_amount; i++) {
                inputs_weights[i] += error * inputs[i] * learning_rate;
            }
            return false;
        } else {
            return true;
        }
    }

}

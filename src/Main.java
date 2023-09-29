public class Main {
    public static void main(String[] args) {
        Training_arena tr_a = new Training_arena(20);
        Neuron neuron = new Neuron(2, 0.1);
        tr_a.neuron = neuron;
        double mistake_rate;
        int attempt = 1;
        do {
            mistake_rate = tr_a.train();
            System.out.println(attempt+" try:\nMistake rate: "+mistake_rate);
            attempt += 1;
        } while (mistake_rate > 0.05);

    }


}
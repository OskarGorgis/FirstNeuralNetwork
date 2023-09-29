public class Training_arena {

    public Function function;
    public Point[] points;
    public Neuron neuron;

    public Training_arena(int size) {
        generate_function();
        generate_points(size);
    }

    private void generate_function() {
        function = new Function(2, -1, -100, 100);
    }

    private void generate_points(int size) {
        points = new Point[size];
        boolean above;
        for (int i=0; i < points.length; i++) {
            above = i % 2 == 0;
            points[i] = function.generate_point(above);
        }
    }

    public double train() {
        double[] inputs;
        int mistakes = 0;
        for (Point point: points) {
            inputs = new double[]{point.x, point.y};
            if (!neuron.train(inputs, point.target)) {
                mistakes += 1;
            }
        }
        return ((double)mistakes)/((double)points.length);
    }

}

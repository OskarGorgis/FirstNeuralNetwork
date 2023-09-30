import java.util.Random;

public class Matrix {

    int rows;
    int columns;
    double[][] matrix;

    public Matrix(int rows, int columns, boolean isRandom) {
        this.rows = rows;
        this.columns = columns;
        matrix = new double[rows][];
        if (isRandom) {
            generate_randoms();
        } else {
            generate_all_zeros();
        }
    }

    private void generate_randoms() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            matrix[i] = new double[columns];
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextDouble(-1, 1);
            }
        }
    }

    private void generate_all_zeros() {
        for (int i = 0; i < rows; i++) {
            matrix[i] = new double[columns];
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static Matrix multiply_matrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.columns != matrix2.rows) {
            System.out.println("Wrong matrix sizes!");
            return new Matrix(1, 1, false);
        }
        Matrix result = new Matrix(matrix1.rows, matrix2.columns, false);

        for (int k = 0; k < matrix2.columns; k++) {
            for (int i = 0; i < matrix1.rows; i++) {
                double sum = 0;
                for (int j = 0; j < matrix1.columns; j++) {
                    sum += matrix1.matrix[i][j] * matrix2.matrix[j][k];
                }
                result.matrix[i][k] = sum;
            }
        }

        return result;
    }

    public static Matrix transpose(Matrix m) {
        Matrix result = new Matrix(m.columns, m.rows, false);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                result.matrix[j][i] = m.matrix[i][j];
            }
        }
        return result;
    }

    public void show() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}

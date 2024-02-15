import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {
    Matrix weightsInputHiddenLayer , weightsHiddenLayerOutput , biasHiddenLayer , biasOutput;

    public NeuralNetwork(int i,int h,int o) {
        weightsInputHiddenLayer = new Matrix(h, i);
        weightsHiddenLayerOutput = new Matrix(o, h);

        biasHiddenLayer = new Matrix(h, 1);
        biasOutput = new Matrix(o, 1);
    }

    public List<Double> predict(double[] X) {
        Matrix input = Matrix.fromArray(X);
        Matrix hidden = Matrix.multiply(weightsInputHiddenLayer, input);
        hidden.add(biasHiddenLayer);
        hidden.sigmoid();

        Matrix output = Matrix.multiply(weightsHiddenLayerOutput,hidden);
        output.add(biasOutput);
        output.sigmoid();

        return output.toArray();
    }

    public static void main(String[] args) {
        NeuralNetwork neuralNetwork = new NeuralNetwork(2, 10, 1);
        double [][] input ={{0 , 0} , {0 , 1} , {1 , 0}, {1 , 1}};
        for(double[] d : input) {
            System.out.println(neuralNetwork.predict(d).toString());
        }
    }
}

class Matrix {
    double [][]data;
    int rows,cols;

    public Matrix(int rows, int cols) {
        data = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                data[i][j] = Math.random() * 2 - 1;
            }
        }
    }

    public void add(Matrix m) {
        if(cols != m.cols || rows != m.rows) {
            System.out.println("Shape Mismatch");
            return;
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                this.data[i][j] += m.data[i][j];
            }
        }
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        Matrix temp = new Matrix(a.rows, b.cols);
        for(int i = 0; i < temp.rows; i++) {
            for(int j = 0; j < temp.cols; j++) {
                double sum=0;
                for(int k=0;k<a.cols;k++) {
                    sum += a.data[i][k] * b.data[k][j];
                }
                temp.data[i][j]=sum;
            }
        }
        return temp;
    }

    public void sigmoid() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++)
                this.data[i][j] = 1/(1+Math.exp(-this.data[i][j]));
        }
    }

    public static Matrix fromArray(double[]x) {
        Matrix temp = new Matrix(x.length,1);
        for(int i = 0; i < x.length; i++)
            temp.data[i][0] = x[i];
        return temp;

    }

    public List<Double> toArray() {
        List<Double> temp= new ArrayList<Double>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                temp.add(data[i][j]);
            }
        }
        return temp;
    }
}

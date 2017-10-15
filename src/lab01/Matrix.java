package lab01;

import lab05.MatrixWithExceptions.MatrixDimensionsException;

public class Matrix {

    public int ttt[][];
    public int columns, rows;

    public Matrix() {
    }

    public Matrix(int[][] ttt, int rows, int columns) {
        this.ttt = ttt;
        this.columns = columns;
        this.rows = rows;
    }

    Matrix(int rows, int columns, int... j) {
        this.rows = rows;
        this.columns = columns;
        ttt = new int[rows][columns];
        int i = 0;

        for (int z = 0; z < rows; z++) {
            for (int x = 0; x < columns; x++) {
                ttt[z][x] = j[i];
                i++;
            }
        }
    }

    protected Matrix add(Matrix B) throws MatrixDimensionsException {
        int[][] C = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                C[i][j] = ttt[i][j] + B.ttt[i][j];
            }
        }
        return new Matrix(C, rows, columns);
    }

    Matrix sub(Matrix B) {
        int[][] C = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                C[i][j] = ttt[i][j] - B.ttt[i][j];
            }
        }
        return new Matrix(C, rows, columns);
    }

    protected Matrix mul(Matrix B) throws MatrixDimensionsException {
        int[][] C = new int[columns][B.rows];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < B.rows; j++) {
                int result = 0;
                for (int d = 0; d < rows; d++) {
                    result += ttt[i][d] * B.ttt[d][j];
                }
                C[i][j] = result;
            }
        }
        return new Matrix(C, columns, B.rows);
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int z = 0; z < rows; z++) {
            for (int x = 0; x < columns; x++) {
                output.append(ttt[z][x]).append(" ");
            }
            output.append(System.getProperty("line.separator"));
        }
        return output.toString();
    }
}

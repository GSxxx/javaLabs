package lab05.DummyMatrix;

import lab01.Matrix;
import lab05.MatrixWithExceptions.MatrixDimensionsException;
import lab05.MatrixWithExceptions.UpgradedMatrix;

import java.io.BufferedReader;
import java.io.IOException;

public class DummyMatrix extends UpgradedMatrix {
    DummyMatrix(BufferedReader reader) throws IOException {
        super(reader);
    }

    @Override
    public Matrix mul(Matrix B) throws MatrixDimensionsException {
        if (this.columns != B.rows) {
            int difference = B.rows - columns;
            if (difference > 0) {
                int[][] tmp = new int[B.rows - difference][B.columns];
                for (int i = 0; i < B.rows - difference; i++) {
                    for (int d = 0; d < B.columns; d++) {
                        tmp[i][d] = B.ttt[i][d];
                    }
                }
                B.ttt = tmp;
                B.rows = B.rows - difference;
            } else {
                int[][] tmp = new int[columns][B.columns];
                for (int i = 0; i < columns; i++) {
                    for (int d = 0; d < B.columns; d++) {
                        if (i >= B.rows) {
                            tmp[i][d] = 1;
                        } else {
                            tmp[i][d] = B.ttt[i][d];
                        }
                    }
                }
                B.ttt = tmp;
                B.rows = columns;
            }
            throw new MatrixDimensionsException("Wrong Dimensions in multiplication", this.mul(B));
        }
        return super.mul(B);
    }
}

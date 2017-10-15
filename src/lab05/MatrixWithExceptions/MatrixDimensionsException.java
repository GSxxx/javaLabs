package lab05.MatrixWithExceptions;

import lab01.Matrix;

public class MatrixDimensionsException extends Exception {
    MatrixDimensionsException(String message) {
        super(message);
    }
    public MatrixDimensionsException(String message, Matrix A) {
        super(message);
        System.out.println("-----------");
        System.out.println(A.toString());
    }
}

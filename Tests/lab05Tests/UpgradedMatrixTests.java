package lab05Tests;


import lab05.MatrixWithExceptions.MatrixDimensionsException;
import lab05.MatrixWithExceptions.UpgradedMatrix;
import org.junit.Test;

public class UpgradedMatrixTests {

    @Test(expected = MatrixDimensionsException.class)
    public void MatrixWrongDimensionsMultiplicationTest() throws MatrixDimensionsException {
        UpgradedMatrix first = new UpgradedMatrix(3, 3, 3, 4, 5, 6, 7, 8, 3, 3, 3);
        UpgradedMatrix second = new UpgradedMatrix(2, 2, 6, 5, 4, 3);

        first.mul(second);
    }
}

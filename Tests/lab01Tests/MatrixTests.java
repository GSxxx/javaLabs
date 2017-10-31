package lab01Tests;

import lab01.Matrix;
import lab05.MatrixWithExceptions.MatrixDimensionsException;
import org.junit.Test;
import org.junit.Assert;

public class MatrixTests {

    @Test
    public void MatrixBasicMultiplicationTest(){
        Matrix first= new Matrix(2,3,3,4,5,6,7,8);
        Matrix second= new Matrix(3,2,6,5,4,3,2,1);

        Matrix result = null;
        try {
            result = first.mul(second);
        } catch (MatrixDimensionsException e) {
            Assert.fail();
        }

        Assert.assertEquals("Incorrect multiplication!","44 32 \r\n80 59 \r\n",result.toString());}
}

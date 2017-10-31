package lab05.MatrixWithExceptions;

import lab01.Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class UpgradedMatrix extends Matrix {

    protected UpgradedMatrix(BufferedReader reader) throws IOException {
        String line;
        int rows = 0, columns = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            columns = 0;
            int count = tokenizer.countTokens();
            while (count > 0) {
                list.add(Integer.parseInt(tokenizer.nextToken()));
                columns++;
                count--;
            }
            rows++;
        }
        int[][] matrix = new int[rows][columns];
        int iterator = 0;
        for (int i = 0; i < rows; i++) {
            for (int d = 0; d < columns; d++) {
                matrix[i][d] = list.get(iterator);
                iterator++;
            }
        }
        this.ttt = matrix;
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    protected Matrix add(Matrix B) throws MatrixDimensionsException {
        if (this.rows != B.rows || this.columns != B.columns)
            throw new MatrixDimensionsException("Wrong Dimensions in adding!!!");
        return super.add(B);
    }

    @Override
    public Matrix mul(Matrix B) throws MatrixDimensionsException {
        if (this.columns != B.rows)
            throw new MatrixDimensionsException("Wrong Dimensions in multiplication!!!");
        return super.mul(B);
    }
}


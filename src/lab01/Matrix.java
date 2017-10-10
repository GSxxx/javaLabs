package lab01;

class Matrix {

    private int ttt[][];
    private int c, w;

    public Matrix(int[][] ttt, int c, int w) {
        this.ttt = ttt;
        this.c = c;
        this.w = w;
    }

    Matrix(int c, int w, int... j) {
        this.c = c;
        this.w = w;
        ttt = new int[c][w];
        int i = 0;

        for (int z = 0; z < c; z++) {
            for (int x = 0; x < w; x++) {
                ttt[z][x] = j[i];
                i++;
            }
        }
    }

    Matrix add(Matrix B) {
        int[][] C = new int[c][w];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < w; j++) {
                C[i][j] = ttt[i][j] + B.ttt[i][j];
            }
        }
        return new Matrix(C, c, w);
    }

    Matrix sub(Matrix B) {
        int[][] C = new int[c][w];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < w; j++) {
                C[i][j] = ttt[i][j] - B.ttt[i][j];
            }
        }
        return new Matrix(C, c, w);
    }

    Matrix mul(Matrix B) {
        int[][] C = new int[c][B.w];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < B.w; j++) {
                int result = 0;
                for (int d = 0; d < w; d++) {
                    result += ttt[i][d] * B.ttt[d][j];
                }
                C[i][j] = result;
            }
        }
        return new Matrix(C, c, B.w);
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int z = 0; z < c; z++) {
            for (int x = 0; x < w; x++) {
                output.append(ttt[z][x]).append(" ");
            }
            output.append(System.getProperty("line.separator"));
        }
        return output.toString();
    }
}

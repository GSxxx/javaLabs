package lab01;

class Matrix {

    int ttt[][];
    int c, w;

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

    Matrix add(Matrix input) {
//        Matrix output= new Matrix(c,w,null);
//        for (int z = 0; z < c; z++) {
//            for (int x = 0; x < w; x++) {
//                output[z][x] = j[i];
//                i++;
//            }
//        }
        return null;
    }

    Matrix sub(Matrix input) {

        return null;
    }

    Matrix mul(Matrix input) {

        return null;
    }

    @Override
    public String toString() {
        StringBuilder output= new StringBuilder();
        for (int z = 0; z < c; z++) {
            for (int x = 0; x < w; x++) {
                output.append(ttt[z][x]).append(" ");
            }
            output.append(System.getProperty("line.separator"));
        }
        return output.toString();
    }
}

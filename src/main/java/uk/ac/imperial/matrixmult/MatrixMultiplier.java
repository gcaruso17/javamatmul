package uk.ac.imperial.matrixmult;

/**
 * A class containing a utility method used to multiply two matrices
 */

public class MatrixMultiplier {

  public static Matrix multiply(Matrix a, Matrix b) throws Exception {
    SimpleMatrix c = new SimpleMatrix(a.getNumRows(), b.getNumColumns());
    for (int i = 0; i < a.getNumRows(); i++) {
      for (int k = 0; k < a.getNumColumns(); k++) {
        for (int j = 0; j < b.getNumColumns(); j++) {
          c.set(i, j, c.get(i,j) + (a.get(i, k) * b.get(k, j)));
        }
      }
    }
    return c;
  }

}
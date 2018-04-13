package uk.ac.imperial.matrixmult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * A class used to multiply two matrices
 */

public class MatrixMultiplier {

  //Sets the max number of usable threads according to the available cores
  private final static int MAX_NUM_OF_THREADS = Runtime.getRuntime().availableProcessors();

  public static Matrix multiply(Matrix a, Matrix b) throws Exception {
    int aSize = a.getNumRows() * a.getNumColumns();
    int bSize = b.getNumRows() * b.getNumColumns();
    //Switch between serial and concurrent according to the job size
    if (aSize <= 64 && bSize <= 64) {
      return ikj(a, b);
    } else {
      return threadMultiply(a, b);
    }
  }

  private static Matrix ikj(Matrix a, Matrix b) {
    SimpleMatrix c = new SimpleMatrix(a.getNumRows(), b.getNumColumns());
    for (int i = 0; i < a.getNumRows(); i++) {
      for (int k = 0; k < a.getNumColumns(); k++) {
        double aik = a.get(i, k); //Stores the current value of a[i][k] to improve temporal locality
        for (int j = 0; j < b.getNumColumns(); j++) {
          c.set(i, j, c.get(i,j) + (aik * b.get(k, j)));
        }
      }
    }
    return c;
  }

  private static Matrix threadMultiply(Matrix a, Matrix b) throws Exception {
    SimpleMatrix c = new SimpleMatrix(a.getNumRows(), b.getNumColumns());
    ExecutorService pool = Executors.newFixedThreadPool(MAX_NUM_OF_THREADS);
    for (int i = 0; i < a.getNumRows(); i++) {
      Multiplier m = new Multiplier(a, b, c, i);
      pool.execute(m);
    }
    pool.shutdown();
    pool.awaitTermination(2, TimeUnit.MINUTES);
    return c;
  }
}

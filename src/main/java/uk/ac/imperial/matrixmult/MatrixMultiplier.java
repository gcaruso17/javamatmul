package uk.ac.imperial.matrixmult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * A class containing a utility method used to multiply two Matrices
 */

public class MatrixMultiplier {

  private final static int MAX_NUM_OF_THREADS = Runtime.getRuntime().availableProcessors();

  public static Matrix multiply(Matrix a, Matrix b) throws Exception {
    int aSize = a.getNumRows() * a.getNumColumns();
    int bSize = b.getNumRows() * b.getNumColumns();
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

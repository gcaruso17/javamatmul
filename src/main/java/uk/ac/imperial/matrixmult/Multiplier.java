package uk.ac.imperial.matrixmult;

public class Multiplier implements Runnable {

  private Matrix a;
  private Matrix b;
  private Matrix c;
  private int i;

  public Multiplier(Matrix a, Matrix b, Matrix c, int i) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.i = i;
  }

  @Override
  public void run() {
    for (int k = 0; k < a.getNumColumns(); k++) {
      for (int j = 0; j < b.getNumColumns(); j++) {
        c.set(i, j, c.get(i,j) + (a.get(i, k) * b.get(k, j)));
      }
    }
  }

}
package uk.ac.imperial.matrixmult;

/**
 * A simple data structure to represent a Matrix
 */

public class SimpleMatrix implements uk.ac.imperial.matrixmult.Matrix {

  private double[][] matrix;

  public SimpleMatrix(int row, int column) {
    this.matrix = new double[row][column];
  }

  public SimpleMatrix(double[][] matrix) {
    this.matrix = matrix;
  }

  @Override
  public double get(int row, int column) {
    return matrix[row][column];
  }

  @Override
  public void set(int row, int column, double value) {
    matrix[row][column] = value;
  }

  @Override
  public int getNumRows() {
    return matrix.length;
  }

  @Override
  public int getNumColumns() {
    return matrix[0].length;
  }

}

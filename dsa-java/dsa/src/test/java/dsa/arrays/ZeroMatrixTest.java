package dsa.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZeroMatrixTest {
  @Test
  public void testSetZeros_V1() {
    int[][] matrix = {{1, 0, 3, 4}, {5, 6, 0, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    int[][] expected = {{0, 0, 0, 0}, {0, 0, 0, 0}, {9, 0, 0, 12}, {13, 0, 0, 16}};

    ZeroMatrix.setZeros_V1(matrix);

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        assertEquals(expected[i][j], matrix[i][j]);
      }
    }
  }

  @Test
  public void testSetZeros_V2() {
    int[][] matrix = {{1, 0, 3, 4}, {5, 6, 0, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    int[][] expected = {{0, 0, 0, 0}, {0, 0, 0, 0}, {9, 0, 0, 12}, {13, 0, 0, 16}};

    ZeroMatrix.setZeros_V2(matrix);

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        assertEquals(expected[i][j], matrix[i][j]);
      }
    }
  }
}
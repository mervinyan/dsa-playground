package dsa.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatrixRotationTest {
  @Test
  public void testRotate() {
    int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    int[][] expected = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7,  3}, {16, 12, 8, 4}};
    boolean success = MatrixRotation.rotate(matrix);
    assertEquals(true, success);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        assertEquals(expected[i][j], matrix[i][j]);
      }
    }

  }
}
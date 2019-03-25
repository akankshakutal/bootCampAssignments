package matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixTest {
  private List<List<Integer>> matrix = new ArrayList<>();
  private List<List<Integer>> otherMatrix = new ArrayList<>();

  @BeforeEach
  void setUp() {
    matrix.add(Arrays.asList(1, 2, 3));
    matrix.add(Arrays.asList(1, 2, 3));
    matrix.add(Arrays.asList(1, 2, 3));

    otherMatrix.add(Arrays.asList(1, 2, 3));
    otherMatrix.add(Arrays.asList(1, 2, 3));
    otherMatrix.add(Arrays.asList(1, 2, 3));

  }

  @Test
  void shouldAddMatrix() {
    Matrix matrixOperations = new Matrix(matrix);
    List<List<Integer>> resultedMatrix = new ArrayList<>();
    resultedMatrix.add(Arrays.asList(2, 4, 6));
    resultedMatrix.add(Arrays.asList(2, 4, 6));
    resultedMatrix.add(Arrays.asList(2, 4, 6));

    Matrix expected = new Matrix(resultedMatrix);
    Matrix actual = matrixOperations.add(new Matrix(otherMatrix));

    assertEquals(expected, actual);
  }

  @Test
  void shouldSubtractMatrix() {
    Matrix matrixOperations = new Matrix(matrix);
    List<List<Integer>> resultedMatrix = new ArrayList<>();
    resultedMatrix.add(Arrays.asList(0, 0, 0));
    resultedMatrix.add(Arrays.asList(0, 0, 0));
    resultedMatrix.add(Arrays.asList(0, 0, 0));

    Matrix expected = new Matrix(resultedMatrix);
    Matrix actual = matrixOperations.subtract(new Matrix(otherMatrix));

    assertEquals(expected, actual);
  }

  @Test
  void shouldMultiplyMatrix() {
    Matrix matrixOperations = new Matrix(matrix);
    List<List<Integer>> resultedMatrix = new ArrayList<>();
    resultedMatrix.add(Arrays.asList(6, 12, 18));
    resultedMatrix.add(Arrays.asList(6, 12, 18));
    resultedMatrix.add(Arrays.asList(6, 12, 18));

    Matrix expected = new Matrix(resultedMatrix);
    Matrix actual = matrixOperations.multiply(new Matrix(otherMatrix));

    assertEquals(expected, actual);
  }

  @Test
  void shouldMultiplyDifferentSizeMatrix() {
    List<List<Integer>> matrixToMultiply = new ArrayList<>();
    matrixToMultiply.add(Arrays.asList(1, 2, 3));
    matrixToMultiply.add(Arrays.asList(4, 5, 6));

    List<List<Integer>> matrixToMultiply2 = new ArrayList<>();
    matrixToMultiply2.add(Arrays.asList(7, 8));
    matrixToMultiply2.add(Arrays.asList(9, 10));
    matrixToMultiply2.add(Arrays.asList(11, 12));

    List<List<Integer>> resultedMatrix = new ArrayList<>();
    resultedMatrix.add(Arrays.asList(58, 64));
    resultedMatrix.add(Arrays.asList(139, 154));

    Matrix matrix = new Matrix(matrixToMultiply);
    Matrix expected = new Matrix(resultedMatrix);
    Matrix actual = matrix.multiply(new Matrix(matrixToMultiply2));

    assertEquals(expected, actual);
  }

  @Test
  void shouldTransposeTheMatrix() {
    Matrix matrix = new Matrix(this.matrix);

    List<List<Integer>> resultedMatrix = new ArrayList<>();
    resultedMatrix.add(Arrays.asList(1, 1, 1));
    resultedMatrix.add(Arrays.asList(2, 2, 2));
    resultedMatrix.add(Arrays.asList(3, 3, 3));

    Matrix expected = new Matrix(resultedMatrix);
    Matrix actual = matrix.transpose();

    assertEquals(expected, actual);
  }

  @Test
  void shouldTransposeNonSquareMatrix() {
    List<List<Integer>> nonSquareMatrix = new ArrayList<>();
    nonSquareMatrix.add(Arrays.asList(1, 1));
    nonSquareMatrix.add(Arrays.asList(2, 2));
    nonSquareMatrix.add(Arrays.asList(3, 3));

    Matrix matrix = new Matrix(nonSquareMatrix);

    List<List<Integer>> resultedMatrix = new ArrayList<>();
    resultedMatrix.add(Arrays.asList(1, 2, 3));
    resultedMatrix.add(Arrays.asList(1, 2, 3));

    Matrix expected = new Matrix(resultedMatrix);
    Matrix actual = matrix.transpose();

    assertEquals(expected, actual);
  }

  @Test
  void shouldThrowExceptionIfMatrixIsNotSquare() {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(Arrays.asList(1, 2,3));

    Matrix matrixOperations = new Matrix(matrix);
    assertThrows(NoSquareException.class,()-> matrixOperations.determinant(matrixOperations));
  }

  @Test
  void shouldReturnElementIfMatrixSizeIsOne() throws NoSquareException {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(Collections.singletonList(1));

    Matrix matrixOperations = new Matrix(matrix);
    assertEquals(1,matrixOperations.determinant(matrixOperations));
  }

  @Test
  void shouldReturnDeterminantIfMatrixSizeIsFour() throws NoSquareException {
    List<List<Integer>> matrix = new ArrayList<>();
    matrix.add(Arrays.asList(1,2));
    matrix.add(Arrays.asList(1,2));

    Matrix matrixOperations = new Matrix(matrix);
    assertEquals(0.0,matrixOperations.determinant(matrixOperations));
  }

  @Test
  void shouldReturnDeterminant() throws NoSquareException {
    List<List<Integer>> data = new ArrayList<>();
    data.add(Arrays.asList(1, 2, 3));
    data.add(Arrays.asList(4, 5, 6));
    data.add(Arrays.asList(7, 8, 9));

    Matrix matrix = new Matrix(data);
    assertEquals(0.0,matrix.determinant(matrix));
  }
}
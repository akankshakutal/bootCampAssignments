package matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Matrix {
  private MatrixOperation addElements = (a, b) -> a + b;
  private MatrixOperation subtractElements = (a, b) -> a - b;
  private List<List<Integer>> matrix;

  Matrix(List<List<Integer>> matrix) {
    this.matrix = matrix;
  }

  Matrix add(Matrix otherMatrix) {
    return this.performOperation(otherMatrix, addElements);
  }

  Matrix subtract(Matrix otherMatrix) {
    return this.performOperation(otherMatrix, subtractElements);
  }

  private Matrix performOperation(Matrix otherMatrix, MatrixOperation operation) {
    List<List<Integer>> list = new ArrayList<>();
    Matrix resultedMatrix = new Matrix(list);
    for (int row = 0; row < this.matrix.size(); row++) {
      List<Integer> thisMatrixRow = this.matrix.get(row);
      List<Integer> otherMatrixRow = otherMatrix.matrix.get(row);
      List<Integer> operationResult = doOperation(thisMatrixRow, otherMatrixRow, operation);
      resultedMatrix.matrix.add(operationResult);
    }
    return resultedMatrix;
  }

  private List<Integer> doOperation(List<Integer> thisRow, List<Integer> otherRow, MatrixOperation operation) {
    List<Integer> result = new ArrayList<>();
    for (int row = 0; row < this.matrix.size(); row++) {
      Integer resultedElement = operation.perform(thisRow.get(row), otherRow.get(row));
      result.add(resultedElement);
    }
    return result;
  }

  Matrix multiply(Matrix otherMatrix) {
    List<List<Integer>> list = new ArrayList<>();
    Matrix resultedMatrix = new Matrix(list);

    for (int index = 0; index < this.matrix.size(); index++) {
      List<Integer> resultRow = getMultipliedRows(otherMatrix, index);
      resultedMatrix.matrix.add(resultRow);
    }
    return resultedMatrix;
  }

  private List<Integer> getMultipliedRows(Matrix otherMatrix, int index) {
    List<Integer> resultRow = new ArrayList<>();
    for (int row = 0; row < this.matrix.size(); row++) {
      int sumOfMultiplication = multiplyAndAdd(otherMatrix, index, row);
      resultRow.add(sumOfMultiplication);
    }
    return resultRow;
  }

  private int multiplyAndAdd(Matrix otherMatrix, int index, int row) {
    int sumOfMultiplication = 0;
    for (int column = 0; column < otherMatrix.matrix.size(); column++) {
      sumOfMultiplication += (this.matrix.get(index).get(column) * otherMatrix.matrix.get(column).get(row));
    }
    return sumOfMultiplication;
  }

  Matrix transpose() {
    List<List<Integer>> list = new ArrayList<>();
    Matrix resultedMatrix = new Matrix(list);
    for (int row = 0; row < this.matrix.get(0).size(); row++) {
      resultedMatrix.matrix.add(getTransposedRow(row));
    }
    return resultedMatrix;
  }

  private List<Integer> getTransposedRow(int row) {
    List<Integer> resultRow = new ArrayList<>();
    for (List<Integer> rowElements : this.matrix) {
      resultRow.add(rowElements.get(row));
    }
    return resultRow;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Matrix matrix1 = (Matrix) o;
    return Objects.equals(addElements, matrix1.addElements) &&
            Objects.equals(subtractElements, matrix1.subtractElements) &&
            Objects.equals(matrix, matrix1.matrix);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addElements, subtractElements, matrix);
  }

  double determinant(Matrix matrix) throws NoSquareException {
    if (!matrix.isSquare())
      throw new NoSquareException();
    if (matrix.size() == 1) {
      return matrix.matrix.get(0).get(0);
    }
    if (matrix.size() == 4) {
      return (matrix.matrix.get(0).get(0) * matrix.matrix.get(1).get(1)) -
              (matrix.matrix.get(0).get(1) * matrix.matrix.get(1).get(0));
    }
    double sum = 0.0;
    for (int i = 0; i < matrix.matrix.get(0).size(); i++) {
      sum += changeSign(i) * matrix.matrix.get(0).get(i) *
              determinant(createSubMatrix(matrix, i));
    }
    return sum;
  }

  private Matrix createSubMatrix(Matrix matrix,int excluding_col) {
    List<List<Integer>> data = new ArrayList<>();
    Matrix mat = new Matrix(data);
    int r = -1;
    for (int i = 0; i < matrix.matrix.size(); i++) {
      List<Integer> rows = new ArrayList<>(matrix.matrix.get(0).size()-1);
      if (i == 0)
        continue;
      r++;
      int c = -1;
      for (int j = 0; j < matrix.matrix.get(0).size(); j++) {
        if (j == excluding_col)
          continue;
        rows.add(++c, matrix.matrix.get(i).get(j));
      }
      mat.matrix.add(r, rows);
    }
    return mat;
  }


  private int changeSign(int i) {
    if (i % 2 == 0) return 1;
    return -1;
  }

  private int size() {
    return matrix.size() * matrix.get(0).size();
  }

  private boolean isSquare() {
    return matrix.size() == matrix.get(0).size();
  }

  interface MatrixOperation {
    Integer perform(Integer a, Integer b);
  }
}

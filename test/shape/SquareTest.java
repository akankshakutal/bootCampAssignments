package shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTest {

  @Test
  void shouldReturnArea() throws InvalidValueException {
    Dimension dimension = new Dimension(10);
    Square square = new Square(dimension);
    assertEquals(100, square.calculateArea());
  }

  @Test
  void shouldReturnPerimeter() throws InvalidValueException {
    Dimension dimension = new Dimension(10);
    Square square = new Square(dimension);
    assertEquals(40, square.calculatePerimeter());
  }
}
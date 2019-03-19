package shape;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {
  private Dimension width, height;
  private Rectangle rectangle;

  @BeforeEach
  void setUp() throws Exception {
    width = new Dimension(10D);
    height = new Dimension(10D);
    rectangle = new Rectangle(width, height);
  }

  @Test
  void shouldReturnValidOutput() {
    assertEquals(100, rectangle.calculateArea());
  }

  @Test
  void shouldReturnPerimeter() {
    assertEquals(40, rectangle.calculatePerimeter());
  }
}
package shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DimensionTest {

  @Test
  void ShouldNotThrowAnException() {
    assertDoesNotThrow(() -> new Dimension(10));
  }


  @Test
  void ShouldThrowExceptionIfValueIsLessThan0() {
    assertThrows(InvalidValueException.class, () -> {
      new Dimension(-10);
    });
  }

}
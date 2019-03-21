package lengthComparator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuantityTest {

  @Test
  void shouldReturnTrueIfTwoFeetAreEqual() {
    Quantity quantity = new Quantity(new BigDecimal(1), Unit.FEET);
    Quantity quantity1 = new Quantity(new BigDecimal(1), Unit.FEET);
    assertTrue(quantity.compare(quantity1));
  }

  @Test
  void shouldReturnFalseIfTwoFeetAreNotEqual() {
    Quantity quantity = new Quantity(new BigDecimal(1), Unit.FEET);
    Quantity quantity1 = new Quantity(new BigDecimal(2), Unit.FEET);
    assertFalse(quantity.compare(quantity1));
  }

  @Test
  void shouldReturnTrueIfTwoInchAreEqual() {
    Quantity quantity = new Quantity(new BigDecimal(1), Unit.INCH);
    Quantity quantity1 = new Quantity(new BigDecimal(1), Unit.INCH);
    assertTrue(quantity.compare(quantity1));
  }

  @Test
  void shouldReturnFalseIfTwoInchAreNotEqual() {
    Quantity quantity = new Quantity(new BigDecimal(1), Unit.INCH);
    Quantity quantity1 = new Quantity(new BigDecimal(3), Unit.INCH);
    assertFalse(quantity.compare(quantity1));
  }

  @Test
  void shouldReturnTrueIfFeetIsEqualToInch() {
    Quantity quantity = new Quantity(new BigDecimal(1), Unit.FEET);
    Quantity quantity1 = new Quantity(new BigDecimal(12), Unit.INCH);
    assertTrue(quantity.compare(quantity1));
  }


  @Test
  void shouldReturnFalseIfFeetIsNotEqualToInch() {
    Quantity quantity = new Quantity(new BigDecimal(1), Unit.FEET);
    Quantity quantity1 = new Quantity(new BigDecimal(13), Unit.INCH);
    assertFalse(quantity.compare(quantity1));
  }

  @Test
  void shouldReturnTrueIfInchAndCmAreEqual() {
    Quantity quantity = new Quantity(new BigDecimal(5), Unit.CM);
    Quantity quantity1 = new Quantity(new BigDecimal(2), Unit.INCH);
    assertTrue(quantity.compare(quantity1));
  }

  @Test
  void shouldReturnFalseIfInchAndCmAreNotEqual() {
    Quantity quantity = new Quantity(new BigDecimal(4), Unit.CM);
    Quantity quantity1 = new Quantity(new BigDecimal(2), Unit.INCH);
    assertFalse(quantity.compare(quantity1));
  }

  @Test
  void shouldReturnTrueIfCmAndMmAreEqual() {
    Quantity quantity = new Quantity(new BigDecimal(2), Unit.CM);
    Quantity quantity1 = new Quantity(new BigDecimal(20), Unit.MM);
    assertTrue(quantity.compare(quantity1));
  }

  @Test
  void shouldReturnFalseIfCmAndMmAreNotEqual() {
    Quantity quantity = new Quantity(new BigDecimal(1), Unit.CM);
    Quantity quantity1 = new Quantity(new BigDecimal(20), Unit.MM);
    assertFalse(quantity.compare(quantity1));
  }

  @Test
  void shouldReturnTrueIfFeetAndMmAreEqual() {
    Quantity quantity = new Quantity(new BigDecimal(1), Unit.FEET);
    Quantity quantity1 = new Quantity(new BigDecimal(300), Unit.MM);
    assertTrue(quantity.compare(quantity1));
  }

}
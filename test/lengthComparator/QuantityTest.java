package lengthComparator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

  @Test
  void shouldReturnTrueIfTwoFeetAreEqual() {
    Quantity feet1 = new Quantity(new BigDecimal(1), Unit.FEET);
    Quantity feet2 = new Quantity(new BigDecimal(1), Unit.FEET);
    assertTrue(feet1.compare(feet2));
  }

  @Test
  void shouldReturnFalseIfTwoFeetAreNotEqual() {
    Quantity oneFeet = new Quantity(new BigDecimal(1), Unit.FEET);
    Quantity twoFeet = new Quantity(new BigDecimal(2), Unit.FEET);
    assertFalse(oneFeet.compare(twoFeet));
  }

  @Test
  void shouldReturnTrueIfTwoInchAreEqual() {
    Quantity inch1 = new Quantity(new BigDecimal(1), Unit.INCH);
    Quantity inch2 = new Quantity(new BigDecimal(1), Unit.INCH);
    assertTrue(inch1.compare(inch2));
  }

  @Test
  void shouldReturnFalseIfTwoInchAreNotEqual() {
    Quantity oneInch = new Quantity(new BigDecimal(1), Unit.INCH);
    Quantity threeInches = new Quantity(new BigDecimal(3), Unit.INCH);
    assertFalse(oneInch.compare(threeInches));
  }

  @Test
  void shouldReturnTrueIfFeetIsEqualToInch() {
    Quantity oneFoot = new Quantity(new BigDecimal(1), Unit.FEET);
    Quantity twelveInches = new Quantity(new BigDecimal(12), Unit.INCH);
    assertTrue(oneFoot.compare(twelveInches));
  }


  @Test
  void shouldReturnFalseIfFeetIsNotEqualToInch() {
    Quantity oneFoot = new Quantity(new BigDecimal(1), Unit.FEET);
    Quantity thirteenInches = new Quantity(new BigDecimal(13), Unit.INCH);
    assertFalse(oneFoot.compare(thirteenInches));
  }

  @Test
  void shouldReturnTrueIfInchAndCmAreEqual() {
    Quantity fiveCm = new Quantity(new BigDecimal(5), Unit.CM);
    Quantity twoInches = new Quantity(new BigDecimal(2), Unit.INCH);
    assertTrue(fiveCm.compare(twoInches));
  }

  @Test
  void shouldReturnFalseIfInchAndCmAreNotEqual() {
    Quantity fourCm = new Quantity(new BigDecimal(4), Unit.CM);
    Quantity twoInches = new Quantity(new BigDecimal(2), Unit.INCH);
    assertFalse(fourCm.compare(twoInches));
  }

  @Test
  void shouldReturnTrueIfCmAndMmAreEqual() {
    Quantity twoInches = new Quantity(new BigDecimal(2), Unit.CM);
    Quantity twentyInches = new Quantity(new BigDecimal(20), Unit.MM);
    assertTrue(twoInches.compare(twentyInches));
  }

  @Test
  void shouldReturnFalseIfCmAndMmAreNotEqual() {
    Quantity oneCm = new Quantity(new BigDecimal(1), Unit.CM);
    Quantity twentyMm = new Quantity(new BigDecimal(20), Unit.MM);
    assertFalse(oneCm.compare(twentyMm));
  }

  @Test
  void shouldReturnTrueIfFeetAndMmAreEqual() {
    Quantity oneFoot = new Quantity(new BigDecimal(1), Unit.FEET);
    Quantity threeHundredMm = new Quantity(new BigDecimal(300), Unit.MM);
    assertTrue(oneFoot.compare(threeHundredMm));
  }

  @Test
  void shouldReturnTrueIfGallonAndLiterAreEqual() {
    Quantity oneGallon = new Quantity(new BigDecimal(1), Unit.GALLON);
    Quantity threeLiter = new Quantity(new BigDecimal(3.78541), Unit.LITER);
    assertTrue(oneGallon.compare(threeLiter));
  }

  @Test
  void shouldReturnFalseIfGallonAndLiterAreNotEqual() {
    Quantity twoGallon = new Quantity(new BigDecimal(2), Unit.GALLON);
    Quantity threeLiter = new Quantity(new BigDecimal(3.78541), Unit.LITER);
    assertFalse(twoGallon.compare(threeLiter));
  }

  @Test
  void shouldNotCompareVolumeToLengthTypeQuantity() {
    Quantity oneLiter = new Quantity(new BigDecimal(1), Unit.LITER);
    Quantity oneCm = new Quantity(new BigDecimal(1000), Unit.CM);
    assertFalse(oneLiter.compare(oneCm));
  }

  @Test
  void shouldReturnAdditionOfTwoSameQuantity() throws TypeNotMatchException {
    Quantity inch1 = new Quantity(new BigDecimal(2), Unit.INCH);
    Quantity inch2 = new Quantity(new BigDecimal(2), Unit.INCH);
    Quantity expected = new Quantity(new BigDecimal(4), Unit.INCH);
    assertEquals(expected, inch1.add(inch2));
  }

  @Test
  void shouldThrowTypeNotMatchExceptionForAdditionOfDifferentTypeQuantities() {
    Quantity twoInches = new Quantity(new BigDecimal(2), Unit.INCH);
    Quantity twoLiters = new Quantity(new BigDecimal(2), Unit.LITER);
    assertThrows(TypeNotMatchException.class, () -> twoInches.add(twoLiters));
  }
}
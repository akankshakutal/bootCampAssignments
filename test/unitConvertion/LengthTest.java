package unitConvertion;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LengthTest {

  @Test
  void shouldReturnTrueIfTwoFeetAreEqual() {
    Quantity feet1 = new Length(new BigDecimal(1), Length.LengthUnits.FEET);
    Quantity feet2 = new Length(new BigDecimal(1), Length.LengthUnits.FEET);
    assertEquals(feet1, feet2);
  }

  @Test
  void shouldReturnFalseIfTwoFeetAreNotEqual() {
    Quantity twoFeet = new Length(new BigDecimal(2), Length.LengthUnits.FEET);
    Quantity twelveFeet = new Length(new BigDecimal(12), Length.LengthUnits.FEET);
    assertNotEquals(twoFeet, twelveFeet);
  }

  @Test
  void shouldReturnTrueIfTwoInchAreEqual() {
    Quantity inch1 = new Length(new BigDecimal(12), Length.LengthUnits.INCH);
    Quantity inch2 = new Length(new BigDecimal(12), Length.LengthUnits.INCH);
    assertEquals(inch1, inch2);
  }

  @Test
  void shouldReturnFalseIfTwoInchesAreNotEqual() {
    Quantity twoInches = new Length(new BigDecimal(2), Length.LengthUnits.INCH);
    Quantity twelveInches = new Length(new BigDecimal(12), Length.LengthUnits.INCH);
    assertNotEquals(twoInches, twelveInches);
  }

  @Test
  void shouldReturnTrueIfFeetIsEqualToInch() {
    Quantity oneFeet = new Length(new BigDecimal(1), Length.LengthUnits.FEET);
    Quantity twelveInches = new Length(new BigDecimal(12), Length.LengthUnits.INCH);
    assertEquals(oneFeet, twelveInches);
  }

  @Test
  void shouldReturnFalseIfFeetIsNotEqualToInch() {
    Quantity twoFeet = new Length(new BigDecimal(2), Length.LengthUnits.FEET);
    Quantity twelveInches = new Length(new BigDecimal(12), Length.LengthUnits.INCH);
    assertNotEquals(twoFeet, twelveInches);
  }

  @Test
  void shouldReturnTrueIfInchAndCmAreEqual() {
    Quantity fiveCm = new Length(new BigDecimal(5), Length.LengthUnits.CM);
    Quantity twoInches = new Length(new BigDecimal(2), Length.LengthUnits.INCH);
    assertEquals(fiveCm, twoInches);
  }

  @Test
  void shouldReturnFalseIfInchAndCmAreNotEqual() {
    Quantity fiveCm = new Length(new BigDecimal(5), Length.LengthUnits.CM);
    Quantity twoInches = new Length(new BigDecimal(3), Length.LengthUnits.INCH);
    assertNotEquals(fiveCm, twoInches);
  }

  @Test
  void shouldReturnTrueIfCmAndMmAreEqual() {
    Quantity fiveCm = new Length(new BigDecimal(2), Length.LengthUnits.CM);
    Quantity twoInches = new Length(new BigDecimal(20), Length.LengthUnits.MM);
    assertEquals(fiveCm, twoInches);
  }

  @Test
  void shouldReturnFalseIfCmAndMmAreNotEqual() {
    Quantity fiveCm = new Length(new BigDecimal(5), Length.LengthUnits.CM);
    Quantity twoInches = new Length(new BigDecimal(20), Length.LengthUnits.INCH);
    assertNotEquals(fiveCm, twoInches);
  }

  @Test
  void shouldReturnTrueIfFeetAndMmAreEqual() {
    Quantity fiveCm = new Length(new BigDecimal(300), Length.LengthUnits.MM);
    Quantity twoInches = new Length(new BigDecimal(1), Length.LengthUnits.FEET);
    assertEquals(fiveCm, twoInches);
  }

}
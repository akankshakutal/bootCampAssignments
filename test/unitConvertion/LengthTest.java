package unitConvertion;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LengthTest {

  @Test
  void shouldReturnTrueIfTwoFeetAreEqual() {
    Length feet1 = new Length(new BigDecimal(1), Length.LengthUnits.FEET);
    Length feet2 = new Length(new BigDecimal(1), Length.LengthUnits.FEET);
    assertEquals(feet1, feet2);
  }

  @Test
  void shouldReturnFalseIfTwoFeetAreNotEqual() {
    Length twoFeet = new Length(new BigDecimal(2), Length.LengthUnits.FEET);
    Length twelveFeet = new Length(new BigDecimal(12), Length.LengthUnits.FEET);
    assertNotEquals(twoFeet, twelveFeet);
  }

  @Test
  void shouldReturnTrueIfTwoInchAreEqual() {
    Length inch1 = new Length(new BigDecimal(12), Length.LengthUnits.INCH);
    Length inch2 = new Length(new BigDecimal(12), Length.LengthUnits.INCH);
    assertEquals(inch1, inch2);
  }

  @Test
  void shouldReturnFalseIfTwoInchesAreNotEqual() {
    Length twoInches = new Length(new BigDecimal(2), Length.LengthUnits.INCH);
    Length twelveInches = new Length(new BigDecimal(12), Length.LengthUnits.INCH);
    assertNotEquals(twoInches, twelveInches);
  }

  @Test
  void shouldReturnTrueIfFeetIsEqualToInch() {
    Length oneFeet = new Length(new BigDecimal(1), Length.LengthUnits.FEET);
    Length twelveInches = new Length(new BigDecimal(12), Length.LengthUnits.INCH);
    assertEquals(oneFeet, twelveInches);
  }

  @Test
  void shouldReturnFalseIfFeetIsNotEqualToInch() {
    Length twoFeet = new Length(new BigDecimal(2), Length.LengthUnits.FEET);
    Length twelveInches = new Length(new BigDecimal(12), Length.LengthUnits.INCH);
    assertNotEquals(twoFeet, twelveInches);
  }

  @Test
  void shouldReturnTrueIfInchAndCmAreEqual() {
    Length fiveCm = new Length(new BigDecimal(5), Length.LengthUnits.CM);
    Length twoInches = new Length(new BigDecimal(2), Length.LengthUnits.INCH);
    assertEquals(fiveCm, twoInches);
  }

  @Test
  void shouldReturnFalseIfInchAndCmAreNotEqual() {
    Length fiveCm = new Length(new BigDecimal(5), Length.LengthUnits.CM);
    Length twoInches = new Length(new BigDecimal(3), Length.LengthUnits.INCH);
    assertNotEquals(fiveCm, twoInches);
  }

  @Test
  void shouldReturnTrueIfCmAndMmAreEqual() {
    Length fiveCm = new Length(new BigDecimal(2), Length.LengthUnits.CM);
    Length twoInches = new Length(new BigDecimal(20), Length.LengthUnits.MM);
    assertEquals(fiveCm, twoInches);
  }

  @Test
  void shouldReturnFalseIfCmAndMmAreNotEqual() {
    Length fiveCm = new Length(new BigDecimal(5), Length.LengthUnits.CM);
    Length twoInches = new Length(new BigDecimal(20), Length.LengthUnits.INCH);
    assertNotEquals(fiveCm, twoInches);
  }

  @Test
  void shouldReturnTrueIfFeetAndMmAreEqual() {
    Length fiveCm = new Length(new BigDecimal(300), Length.LengthUnits.MM);
    Length twoInches = new Length(new BigDecimal(1), Length.LengthUnits.FEET);
    assertEquals(fiveCm, twoInches);
  }

}
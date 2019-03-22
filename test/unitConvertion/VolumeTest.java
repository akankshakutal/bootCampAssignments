package unitConvertion;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class VolumeTest {

  @Test
  void shouldReturnTrueIfTwoGallonsAreEqual() {
    Quantity oneGallon = new Volume(new BigDecimal(1), Volume.VolumeUnits.GALLON);
    Quantity liter = new Volume(new BigDecimal(1), Volume.VolumeUnits.GALLON);
    assertEquals(oneGallon, liter);
  }

  @Test
  void shouldReturnFalseIfTwoGallonsAreNotEqual() {
    Quantity oneGallon = new Volume(new BigDecimal(2), Volume.VolumeUnits.GALLON);
    Quantity liter = new Volume(new BigDecimal(0.26), Volume.VolumeUnits.GALLON);
    assertNotEquals(oneGallon, liter);
  }

  @Test
  void shouldReturnFalseIfTwoLitersAreNotEqual() {
    Quantity oneGallon = new Volume(new BigDecimal(2), Volume.VolumeUnits.LITER);
    Quantity liter = new Volume(new BigDecimal(0.26), Volume.VolumeUnits.LITER);
    assertNotEquals(oneGallon, liter);
  }

  @Test
  void shouldReturnTrueIfTwoLiterAreEqual() {
    Quantity oneGallon = new Volume(new BigDecimal(2), Volume.VolumeUnits.LITER);
    Quantity liter = new Volume(new BigDecimal(2), Volume.VolumeUnits.LITER);
    assertEquals(oneGallon, liter);
  }

  @Test
  void shouldReturnTrueIfGallonAndLiterAreEqual() {
    Quantity oneGallon = new Volume(new BigDecimal(1), Volume.VolumeUnits.GALLON);
    Quantity liter = new Volume(new BigDecimal(0.264172), Volume.VolumeUnits.LITER);
    assertEquals(oneGallon, liter);
  }

  @Test
  void shouldReturnFalseIfGallonAndLiterAreNotEqual() {
    Quantity oneGallon = new Volume(new BigDecimal(2), Volume.VolumeUnits.GALLON);
    Quantity liter = new Volume(new BigDecimal(0.26), Volume.VolumeUnits.LITER);
    assertNotEquals(oneGallon, liter);
  }
}
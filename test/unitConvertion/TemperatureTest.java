package unitConvertion;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

  @Test
  void shouldReturnTrueIfTwoCelsiusAreEqual() {
    Quantity oneGallon = new Temperature(new BigDecimal(1), Temperature.TemperatureUnits.CELSIUS);
    Quantity liter = new Temperature(new BigDecimal(1), Temperature.TemperatureUnits.CELSIUS);
    assertEquals(oneGallon, liter);
  }

  @Test
  void shouldReturnFalseIfTwoFahrenheitAreNotEqual() {
    Quantity oneGallon = new Temperature(new BigDecimal(2), Temperature.TemperatureUnits.FAHRENHEIT);
    Quantity liter = new Temperature(new BigDecimal(0.26), Temperature.TemperatureUnits.FAHRENHEIT);
    assertNotEquals(oneGallon, liter);
  }

  @Test
  void shouldReturnFalseIfTwoCelsiusAreNotEqual() {
    Quantity oneGallon = new Temperature(new BigDecimal(2), Temperature.TemperatureUnits.CELSIUS);
    Quantity liter = new Temperature(new BigDecimal(0.26), Temperature.TemperatureUnits.CELSIUS);
    assertNotEquals(oneGallon, liter);
  }

  @Test
  void shouldReturnTrueIfTwoFahrenheitAreEqual() {
    Quantity oneGallon = new Temperature(new BigDecimal(2), Temperature.TemperatureUnits.FAHRENHEIT);
    Quantity liter = new Temperature(new BigDecimal(2), Temperature.TemperatureUnits.FAHRENHEIT);
    assertEquals(oneGallon, liter);
  }

  @Test
  void shouldReturnTrueIfFahrenheitAndCelsiusAreEqual() {
    Quantity oneGallon = new Temperature(new BigDecimal(212), Temperature.TemperatureUnits.FAHRENHEIT);
    Quantity liter = new Temperature(new BigDecimal(100), Temperature.TemperatureUnits.CELSIUS);
    assertEquals(oneGallon, liter);
  }

  @Test
  void shouldReturnFalseIfCelsiusAndFahrenheitAreNotEqual() {
    Quantity oneGallon = new Temperature(new BigDecimal(2), Temperature.TemperatureUnits.FAHRENHEIT);
    Quantity liter = new Temperature(new BigDecimal(0.26), Temperature.TemperatureUnits.CELSIUS);
    assertNotEquals(oneGallon, liter);
  }

}
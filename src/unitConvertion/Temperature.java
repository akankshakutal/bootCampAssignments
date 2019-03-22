package unitConvertion;


import java.math.BigDecimal;

public class Temperature implements Quantity{

  private BigDecimal value;
  private TemperatureUnits unit;

  Temperature(BigDecimal value, TemperatureUnits unit) {
    this.value = value;
    this.unit = unit;
  }

  @Override
  public BigDecimal convertToBase() {
    return unit.calculateBaseValue(value);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    Temperature temperature = (Temperature) other;
    BigDecimal baseOfThis = this.convertToBase();
    BigDecimal baseOfAnotherVolume = temperature.convertToBase();
    return baseOfThis.equals(baseOfAnotherVolume);
  }

  enum TemperatureUnits {
    FAHRENHEIT(new BigDecimal(0.56),new BigDecimal(32)),
    CELSIUS(new BigDecimal(1),new BigDecimal(0));

    private BigDecimal ratio;
    private BigDecimal scale;

    TemperatureUnits(BigDecimal ratio,BigDecimal scale) {
      this.ratio = ratio;
      this.scale = scale;
    }

    BigDecimal calculateBaseValue(BigDecimal value) {
      return BigDecimal.valueOf(value.subtract(this.scale).multiply(this.ratio).intValue());
    }
  }
}

package shape;

class Dimension {
  private double value;

  Dimension(double value) throws InvalidValueException {
    validate(value);
    this.value = value;
  }

  private void validate(double value) throws InvalidValueException {
    if (value < 0)
      throw new InvalidValueException();
  }

  double getValue() {
    return value;
  }

}

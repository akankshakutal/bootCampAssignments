package shape;

public class Square implements Shape {
  private static final int NUM_OF_SIDES = 4;
  private Dimension side;

  Square(Dimension side) {
    this.side = side;
  }

  @Override
  public double calculateArea() {
    return side.getValue() * side.getValue();
  }

  @Override
  public double calculatePerimeter() {
    return NUM_OF_SIDES * side.getValue();
  }
}

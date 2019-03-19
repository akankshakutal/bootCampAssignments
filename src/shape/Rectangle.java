package shape;

public class Rectangle implements Shape {

  private Dimension width, height;

  Rectangle(Dimension width, Dimension height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public double calculateArea() {
    return width.getValue() * height.getValue();
  }

  @Override
  public double calculatePerimeter() {
    return 2 * (width.getValue() + height.getValue());
  }

}

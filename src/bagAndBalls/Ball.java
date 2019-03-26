package bagAndBalls;

class Ball {
  private Color color;

  private Ball(Color color) {
    this.color = color;
  }

  static Ball yellowBall() {
    return new Ball(Color.YELLOW);
  }

  static Ball blueBall() {
    return new Ball(Color.BLUE);
  }

  static Ball greenBall() {
    return new Ball(Color.GREEN);
  }

  static Ball redBall() {
    return new Ball(Color.RED);
  }

  static Ball blackBall() {
    return new Ball(Color.BLACK);
  }

  boolean isOfColor(Color other) {
    return color.equals(other);
  }
}

package bag;

class Ball {
  private BallType type;

  Ball(BallType type) {
    this.type = type;
  }

  BallType getType() {
    return this.type;
  }
}
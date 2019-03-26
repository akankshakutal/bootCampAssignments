package bagAndBalls;

class Bag {
  private final Balls balls;
  private int numberOfAllowedBalls;
  private Rules rules;

  Bag(int numberOfAllowedBalls, Rules rules) {
    this.numberOfAllowedBalls = numberOfAllowedBalls;
    this.rules = rules;
    this.balls = new Balls();
  }

  boolean add(Ball ball) throws AddBallException {
    if (isFull())
      throw new BagFullException();
    for (Rule rule : rules) {
      rule.canBallBeAdded(ball, balls);
    }
    return balls.add(ball);
  }

  private boolean isFull() {
    if (balls.numberOfBallsOfColor(Color.BLACK) == 1) {
      return (balls.size() + 1) >= numberOfAllowedBalls;
    }
    return balls.size() >= numberOfAllowedBalls;
  }
}

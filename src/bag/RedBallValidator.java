package bag;

class RedBallValidator extends BallValidator {
  RedBallValidator() {
    super(BallType.RED);
  }

  @Override
  boolean isValid(Ball ball, Countable balls) {
    int greenBallCount = balls.getCount(BallType.GREEN);
    int redBallCount = balls.getCount(BallType.RED);
    return redBallCount <= (2 * greenBallCount);
  }
}
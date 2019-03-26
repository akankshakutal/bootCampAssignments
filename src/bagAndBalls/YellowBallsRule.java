package bagAndBalls;


class YellowBallsRule implements Rule {

  private double threshold;

  YellowBallsRule(double threshold) {
    this.threshold = threshold;
  }

  @Override
  public boolean canBallBeAdded(Ball thisBall, BallsContainer balls) throws AddBallException {
    if (thisBall.isOfColor(Color.YELLOW)) {
      int numberOfBalls = balls.count() + 1;
      int numberOfYellowBalls = balls.numberOfBallsOfColor(Color.YELLOW) + 1;

      if (numberOfYellowBalls / (float) numberOfBalls > threshold)
        throw new TooManyYellowBallsException();
    }

    return true;
  }
}

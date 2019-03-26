package bagAndBalls;


class GreenBallsRule implements Rule {

  @Override
  public boolean canBallBeAdded(Ball thisBall, BallsContainer balls) throws AddBallException {
    if (balls.numberOfBallsOfColor(Color.GREEN) >= 3)
      throw new TooManyGreenBallsException();
    return true;
  }
}

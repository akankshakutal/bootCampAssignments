package bagAndBalls;

class RedBallsRule implements Rule {

  @Override
  public boolean canBallBeAdded(Ball thisBall, BallsContainer balls) throws AddBallException {
    if (thisBall.isOfColor(Color.RED)) {
      int numberOfGreenBalls = balls.numberOfBallsOfColor(Color.GREEN);
      int numberOFRedBalls = balls.numberOfBallsOfColor(Color.RED) + 1;
      if (numberOFRedBalls > (numberOfGreenBalls * 2))
        throw new TooManyRedBallsException();
    }
    return true;
  }
}

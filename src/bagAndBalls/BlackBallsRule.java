package bagAndBalls;


class BlackBallsRule implements Rule {

  @Override
  public boolean canBallBeAdded(Ball thisBall, BallsContainer balls) throws AddBallException {
    if ( thisBall.isOfColor(Color.BLACK) && balls.numberOfBallsOfColor(Color.BLACK) == 1)
      throw new TooManyBlackBallsException();
    return true;
  }
}

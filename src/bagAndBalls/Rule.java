package bagAndBalls;

interface Rule {
  boolean canBallBeAdded(Ball thisBall, BallsContainer balls) throws AddBallException;
}

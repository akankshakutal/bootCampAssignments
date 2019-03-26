package bagAndBalls;

class TooManyYellowBallsException extends AddBallException {
  TooManyYellowBallsException() {
    super("Yellow ball limit is exceeded");
  }
}

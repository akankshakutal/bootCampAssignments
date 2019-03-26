package bagAndBalls;

class TooManyBlackBallsException extends AddBallException {
  TooManyBlackBallsException() {
    super("Black ball limit is exceeded");
  }
}

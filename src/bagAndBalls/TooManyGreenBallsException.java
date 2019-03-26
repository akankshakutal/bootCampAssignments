package bagAndBalls;

class TooManyGreenBallsException extends AddBallException {
  TooManyGreenBallsException() {
    super("Green ball limit is exceeded");
  }
}

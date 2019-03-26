package bagAndBalls;

class TooManyRedBallsException extends AddBallException {
  TooManyRedBallsException() {
    super("Red ball limit is exceeded");
  }
}

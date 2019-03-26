package bag;

abstract class BallValidator {
  BallType type;

  BallValidator(BallType type) {
    this.type = type;
  }

  abstract boolean isValid(Ball ball, Countable balls);

  BallType getType() {
    return this.type;
  }
}

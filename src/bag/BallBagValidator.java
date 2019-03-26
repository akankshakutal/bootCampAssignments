package bag;

import java.util.HashMap;
import java.util.Map;

class BallBagValidator {
  private Map<BallType, BallValidator> ballValidators;

  BallBagValidator() {
    this.ballValidators = new HashMap<>();
  }

  boolean isValid(Ball ball, Countable balls) {
    return ballValidators.get(ball.getType()).isValid(ball, balls);
  }

  void addValidator(BallValidator ballValidator) {
    this.ballValidators.put(ballValidator.getType(), ballValidator);
  }
}

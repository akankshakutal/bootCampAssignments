package bag;

import java.util.*;

class Balls implements Countable {
  private List<Ball> balls;
  private Map<BallType, Integer> ballsDetails;

  Balls() {
    this.balls = new ArrayList<>();
    this.ballsDetails = new HashMap<>();
  }

  private boolean isAvailable(BallType ballType) {
    return this.ballsDetails.get(ballType) != null;
  }

  public void add(Ball ball) {
    int numOfBall = 1;
    if (isAvailable(ball.getType())) {
      numOfBall = this.ballsDetails.get(ball.getType()) + 1;
    }
    this.ballsDetails.put(ball.getType(), numOfBall);
    balls.add(ball);
  }

  @Override
  public int getCount(BallType ballType) {
    if (!isAvailable(ballType)) {
      return 0;
    }
    return ballsDetails.get(ballType);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Balls balls1 = (Balls) o;
    return Objects.equals(balls, balls1.balls) &&
            Objects.equals(ballsDetails, balls1.ballsDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balls, ballsDetails);
  }
}
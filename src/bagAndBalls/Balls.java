package bagAndBalls;

import java.util.ArrayList;

class Balls extends ArrayList<Ball> implements BallsContainer {

  @Override
  public int numberOfBallsOfColor(Color color) {
    int numberOfBalls = 0;
    for (Ball ball : this) {
      if (ball.isOfColor(color))
        numberOfBalls++;
    }
    return numberOfBalls;
  }

  @Override
  public int count() {
    return this.size();
  }
}
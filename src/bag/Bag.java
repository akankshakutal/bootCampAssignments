package bag;

import java.util.Objects;

public class Bag {
  private Balls balls;
  private BallBagValidator ballValidator;

  Bag(Balls balls, BallBagValidator ballValidator) {
    this.balls = balls;
    this.ballValidator = ballValidator;
  }

  public void add(Ball ball) {
    if (!ballValidator.isValid(ball, this.balls)) return;
    this.balls.add(ball);
  }


  Balls getSummary() {
    return this.balls;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Bag bag = (Bag) o;
    return Objects.equals(balls, bag.balls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balls);
  }
}


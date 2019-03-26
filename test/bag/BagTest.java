package bag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BagTest {
  private BallBagValidator ballValidator;
  private Bag bag;

  @BeforeEach
  void setUp() {
    ballValidator = new BallBagValidator();
    Balls balls = new Balls();
    bag = new Bag(balls, ballValidator);

  }

  @Test
  void shouldAddGivenBallToTheBag() {
    RedBallValidator redBallValidator = new RedBallValidator();
    ballValidator.addValidator(redBallValidator);
    Ball redBall = new Ball(BallType.RED);
    bag.add(redBall);
    Balls expectedBalls = new Balls();

    expectedBalls.add(redBall);

    assertEquals(expectedBalls, bag.getSummary());
  }
}
package bagAndBalls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BagTest {
  private static final int NUMBER_OF_ALLOWED_BALLS = 12;
  private Bag bag = null;

  @BeforeEach
  void setUp() {
    Rules rules = new Rules();
    rules.add(new RedBallsRule());
    rules.add(new YellowBallsRule(0.4));
    rules.add(new GreenBallsRule());
    rules.add(new BlackBallsRule());
    bag = new Bag(NUMBER_OF_ALLOWED_BALLS, rules);
  }

  @Test
  void testCanAddASingleAllowedBall() throws AddBallException {
    assertTrue(bag.add(Ball.blueBall()));
  }

  @Test
  void testCannotAddSingleYellowBall() {
    assertThrows(TooManyYellowBallsException.class, () -> bag.add(Ball.yellowBall()));
  }

  @Test
  void testWhenYellowBallsExceedsLimit() throws AddBallException {
    bag.add(Ball.blueBall());
    assertThrows(TooManyYellowBallsException.class, () -> bag.add(Ball.yellowBall()));
  }


  @Test
  void testCannotAddMoreBallsThanLimit() throws AddBallException {
    for (int ball = 0; ball < NUMBER_OF_ALLOWED_BALLS; ball++) {
      bag.add(Ball.blueBall());
    }
    assertThrows(BagFullException.class, () -> bag.add(Ball.blueBall()));

  }

  @Test
  void testWhenYellowBallsIsWithinItsLimits() throws AddBallException {
    bag.add(Ball.blueBall());
    bag.add(Ball.blueBall());
    assertTrue(bag.add(Ball.yellowBall()));
  }

  @Test
  void testCannotAddMoreBlackBallsThan1() throws AddBallException {
    bag.add(Ball.blackBall());
    assertThrows(TooManyBlackBallsException.class, () -> bag.add(Ball.blackBall()));
  }

  @Test
  void shouldAllowToAddSizeMinusOneBallToBagIfBagContainsOneBlackBall() throws AddBallException {
    Rules rules = new Rules();
    rules.add(new RedBallsRule());
    rules.add(new YellowBallsRule(0.4));
    rules.add(new GreenBallsRule());
    rules.add(new BlackBallsRule());
    bag = new Bag(3, rules);
    bag.add(Ball.blackBall());
    bag.add(Ball.blueBall());
    assertThrows(AddBallException.class, () -> bag.add(Ball.blueBall()));
  }
}
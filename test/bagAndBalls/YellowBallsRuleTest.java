package bagAndBalls;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class YellowBallsRuleTest {

  @Test
  void testCheckWhenYellowBallAddedToEmptyBag() {
    Rule rule = new YellowBallsRule(0.4);
    Balls balls = new Balls();
    assertThrows(TooManyYellowBallsException.class, () -> rule.canBallBeAdded(Ball.yellowBall(), balls));
  }

  @Test
  void testCheckWhenYellowBallsAreFewerThanLimit() throws Exception {
    Rule rule = new YellowBallsRule(0.4);
    Balls balls = new Balls();
    balls.add(Ball.blueBall());
    balls.add(Ball.blueBall());
    assertTrue(rule.canBallBeAdded(Ball.yellowBall(), balls));
  }

}
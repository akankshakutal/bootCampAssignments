package bagAndBalls;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RedBallsRuleTest {

  @Test
  void testRedBallsCanBeAddedWhenThereIsOnlyOneGreenBall() throws Exception {
    Balls balls = new Balls();
    balls.add(Ball.greenBall());
    RedBallsRule rule = new RedBallsRule();
    assertTrue(rule.canBallBeAdded(Ball.redBall(), balls));
  }

  @Test
  void testRedBallsCannotExceedTwiceTheNumberOfGreenBalls()  {
    Balls balls = new Balls();
    balls.add(Ball.greenBall());
    balls.add(Ball.redBall());
    balls.add(Ball.redBall());
    RedBallsRule rule = new RedBallsRule();
    assertThrows(TooManyRedBallsException.class, () -> rule.canBallBeAdded(Ball.redBall(), balls));
  }
}
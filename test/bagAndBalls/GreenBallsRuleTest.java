package bagAndBalls;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GreenBallsRuleTest {

    @Test
    void testFewerThanThreeGreenBallsCanBeAdded() throws Exception {
        Balls balls = new Balls();
        GreenBallsRule greenBallsRule = new GreenBallsRule();
        assertTrue(greenBallsRule.canBallBeAdded(Ball.greenBall(),balls));
    }

    @Test
    void testMoreThanThreeGreenBallsCantBeAdded()  {
        Balls balls = new Balls();
        balls.add(Ball.greenBall());
        balls.add(Ball.greenBall());
        balls.add(Ball.greenBall());
        GreenBallsRule greenBallsRule = new GreenBallsRule();
       assertThrows(TooManyGreenBallsException.class,()->greenBallsRule.canBallBeAdded(Ball.greenBall(),balls));
    }

}
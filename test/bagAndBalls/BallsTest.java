package bagAndBalls;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BallsTest {

  @Test
  void testNumberOfBallsOfSingleColor() {
    Balls balls = new Balls();
    balls.add(Ball.blueBall());
    balls.add(Ball.blueBall());
    assertEquals(2, balls.numberOfBallsOfColor(Color.BLUE));
  }

  @Test
  void testNumberOfBallsOfMultipleColors() {
    Balls balls = new Balls();
    balls.add(Ball.blueBall());
    balls.add(Ball.yellowBall());
    assertEquals(1, balls.numberOfBallsOfColor(Color.BLUE));
    assertEquals(1, balls.numberOfBallsOfColor(Color.YELLOW));
  }
}
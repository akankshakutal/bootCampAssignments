package bagAndBalls;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BallTest {

  @Test
  void testIsOfColor() throws Exception {
    assertTrue(Ball.blueBall().isOfColor(Color.BLUE));
  }
}
package htmlTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyTest {
  @Test
  void ShouldRefreshTheEntireBody() {
    Body body = new Body();
    body.add(new SidePanel());
    body.add(new Content());
    body.add(new BottomPanel());
    String expected = "Body is refreshing SidePanel is refreshing Content is refreshing BottomPanel is refreshing ";
    assertEquals(expected,body.refresh());
  }
}
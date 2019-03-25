package htmlTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextTest {
  @Test
  void shouldRefreshTheText() {
    Text text = new Text();
    String expected = "Text is refreshing ";
    assertEquals(expected,text .refresh());
  }
}
package htmlTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {

  @Test
  void shouldRefreshTheImage() {
    Image image = new Image();
    String expected = "Image is refreshing ";
    assertEquals(expected,image .refresh());
  }
}
package htmlTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContentTest {

  @Test
  void refreshTheContentAndTheLowerElements() {
    Content content= new Content();
    content.add(new Image());
    content.add(new Text());
    String expected = "Content is refreshing Image is refreshing Text is refreshing ";
    assertEquals(expected,content.refresh());
  }
}
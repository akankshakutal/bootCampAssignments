package htmlTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottomPanelTest {

  @Test
  void shouldRefreshTheBottomPanel() {
    BottomPanel bottomPanel = new BottomPanel();
    String expected = "BottomPanel is refreshing ";
    assertEquals(expected,bottomPanel.refresh());
  }
}
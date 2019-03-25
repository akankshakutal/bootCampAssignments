package htmlTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SidePanelTest {
  @Test
  void shouldRefreshTheSidePanel() {
    SidePanel sidePanel = new SidePanel();
    String expected = "SidePanel is refreshing ";
    assertEquals(expected,sidePanel.refresh());
  }
}
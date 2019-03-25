package htmlTree;

import java.util.ArrayList;
import java.util.List;

public class BottomPanel implements Element {
  private List<Element> bottomPanelElements;

  BottomPanel() {
    bottomPanelElements = new ArrayList<>();
  }

  @Override
  public void add(Element element) {
    bottomPanelElements.add(element);
  }

  public String refresh(){
    return "BottomPanel is refreshing ";
  }
}
package htmlTree;

import java.util.ArrayList;
import java.util.List;

class SidePanel implements Element {
  private List<Element> sidePanelElements;

  SidePanel() {
    this.sidePanelElements = new ArrayList<>();
  }

  @Override
  public void add(Element element) {
    sidePanelElements.add(element);
  }

  @Override
  public String refresh() {
    StringBuilder sidePanelRefresh = new StringBuilder("SidePanel is refreshing ");
    for (Element bodyElement : sidePanelElements) {
      sidePanelRefresh.append(bodyElement.refresh());
    }
    return String.valueOf(sidePanelRefresh);
  }
}

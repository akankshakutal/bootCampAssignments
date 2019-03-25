package htmlTree;

import java.util.ArrayList;
import java.util.List;

class Content implements Element {
  private List<Element> contents;

  Content() {
    this.contents = new ArrayList<>();
  }

  @Override
  public void add(Element element) {
    contents.add(element);
  }

  @Override
  public String refresh() {
    StringBuilder sidePanelRefresh = new StringBuilder("Content is refreshing ");
    for (Element content : contents) {
      sidePanelRefresh.append(content.refresh());
    }
    return String.valueOf(sidePanelRefresh);
  }
}

package htmlTree;

import java.util.ArrayList;
import java.util.List;

class Body implements Element {

  private List<Element> bodyElements;

  Body() {
    bodyElements = new ArrayList<>();
  }

  @Override
  public void add(Element element){
    bodyElements.add(element);
  }

  @Override
  public String refresh() {
    StringBuilder bodyRefresh = new StringBuilder("Body is refreshing ");
    for (Element bodyElement : bodyElements) {
      bodyRefresh.append(bodyElement.refresh());
    }
    return String.valueOf(bodyRefresh);
  }
}

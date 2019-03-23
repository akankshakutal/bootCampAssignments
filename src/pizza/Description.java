package pizza;

import java.util.ArrayList;
import java.util.List;

class Description {
  private List<String> description = new ArrayList<>();

  void add(String text) {
    description.add(text);
  }

  String getDescription() {
    StringBuilder desc = new StringBuilder();
    for (String toppingName : description) {
      desc.append(toppingName).append(" ");
    }
    return desc.toString();
  }
}

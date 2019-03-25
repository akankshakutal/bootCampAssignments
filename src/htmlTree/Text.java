package htmlTree;

class Text implements Element {

  @Override
  public void add(Element element) {
  }

  @Override
  public String refresh() {
    return "Text is refreshing ";
  }
}

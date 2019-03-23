package pizza;

class Pizza {
  private int price;
  private Toppings toppings;
  private Description description;

  Pizza() {
    this.price = 50;
    this.toppings = new Toppings();
    this.description = new Description();
  }

  void addTopping(ToppingType topping) {
    toppings.add(topping);
    description.add(topping.toString());
  }

  Integer calculateTotalCost() {
    return this.price + toppings.calculateTotalPrice();
  }

  String getDescription() {
    return description.getDescription();
  }


  enum ToppingType {
    VEGETABLE(20),
    CHICKEN(30),
    MOZZARELLA(10),
    TOMATO_SAUCE(5),
    EXTRA_CHEESE(25),
    JALAPENO(40);

    private int price;

    ToppingType(int price) {
      this.price = price;
    }

    public Integer getPrice() {
      return this.price;
    }
  }

}

package pizza;

import java.util.ArrayList;
import java.util.List;

class Toppings {
  private List<Pizza.ToppingType> allToppings;

  Toppings() {
    this.allToppings = new ArrayList<>();
  }

  void add(Pizza.ToppingType topping) {
    this.allToppings.add(topping);
  }

  Integer calculateTotalPrice() {
    Integer totalPrice = 0;
    for (Pizza.ToppingType topping : allToppings) {
      totalPrice += topping.getPrice();
    }
    return totalPrice;
  }

}

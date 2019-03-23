package pizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaTest {

  private Pizza pizza;

  @BeforeEach
  void setUp() {
    pizza = new Pizza();
  }

  @Test
  void shouldReturnTotalPriceOfPizza() {
    assertEquals(50, pizza.calculateTotalCost());
  }


  @Test
  void shouldReturnTotalPriceOfPizzaWhenToppingIsAdded() {
    pizza.addTopping(Pizza.ToppingType.EXTRA_CHEESE);
    assertEquals(75, pizza.calculateTotalCost());
  }

  @Test
  void shouldReturnStringRepresentationOfDescription() {
    pizza.addTopping(Pizza.ToppingType.EXTRA_CHEESE);
    pizza.addTopping(Pizza.ToppingType.VEGETABLE);
    assertEquals("EXTRA_CHEESE VEGETABLE ", pizza.getDescription());
  }
}
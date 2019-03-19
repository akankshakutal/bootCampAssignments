package probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

  @Test
  void shouldCreateObjectIfProbabilityIsValid() {
    assertDoesNotThrow(() -> new Chance(0.4));
  }

  @Test
  void shouldThrowExceptionIfProbabilityIsGreaterThan1() {
    assertThrows(InvalidProbabilityException.class, () -> new Chance(1.5));
  }

  @Test
  void shouldThrowExceptionIfProbabilityIsLessThan0() {
    assertThrows(InvalidProbabilityException.class, () -> new Chance(-1));
  }

  @Test
  void shouldReturnNotOfProbability() throws InvalidProbabilityException {
    Chance chance = new Chance(0.6);
    Chance chanceOfNotGetting = new Chance(0.4);
    assertEquals(chanceOfNotGetting, chance.not());
  }

  @Test
  void shouldReturnAndResultForGivenProbability() throws InvalidProbabilityException {
    Chance probabilityForOne = new Chance(0.5);
    Chance probabilityForTwo = new Chance(0.5);
    Chance expected = new Chance(0.25);
    assertEquals(expected, probabilityForOne.and(probabilityForTwo));
  }

  @Test
  void shouldReturnOrResultForGivenProbability() throws InvalidProbabilityException {
    Chance probabilityForOne = new Chance(0.5);
    Chance probabilityForTwo = new Chance(0.5);
    Chance expected = new Chance(0.75);
    assertEquals(expected, probabilityForOne.or(probabilityForTwo));
  }
}
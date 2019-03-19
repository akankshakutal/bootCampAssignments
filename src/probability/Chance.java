package probability;

import java.util.Objects;

class Chance {
  private static final int UPPER_BOUND = 1;
  private static final int LOWER_BOUND = 0;
  private double probability;

  Chance(double probability) throws InvalidProbabilityException {
    validate(probability);
    this.probability = probability;
  }

  private void validate(double probability) throws InvalidProbabilityException {
    if (probability > UPPER_BOUND || probability < LOWER_BOUND) {
      throw new InvalidProbabilityException();
    }
  }

  Chance not() throws InvalidProbabilityException {
    return new Chance(UPPER_BOUND - this.probability);
  }

  @Override
  public boolean equals(Object otherChance) {
    if (this == otherChance) return true;
    if (otherChance == null || getClass() != otherChance.getClass()) return false;
    Chance chance = (Chance) otherChance;
    return Double.compare(chance.probability, probability) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(probability);
  }

  Chance and(Chance otherChance) throws InvalidProbabilityException {
    return new Chance(this.probability * otherChance.probability);
  }


  Chance or(Chance otherChance) throws InvalidProbabilityException {
    return new Chance(UPPER_BOUND - this.and(otherChance).probability);
  }
}

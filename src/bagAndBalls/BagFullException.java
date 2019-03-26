package bagAndBalls;

class BagFullException extends AddBallException {
  BagFullException() {
    super("Bag is full");
  }
}

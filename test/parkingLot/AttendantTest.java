package parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {
  @Test
  void shouldParkCarInParkingLot() {
    Attendant attendant = new Attendant();
    int parkingLotId = 1;
    ParkingLot parkingLot = new ParkingLot(5, parkingLotId, attendant);
    attendant.addParkingLot(parkingLot);
    Car car = new Car(1234);
    assertEquals(0,attendant.park(car));
  }

  @Test
  void shouldParkCarInFreeParkingLot() {
    Attendant attendant = new Attendant();
    MockParkingLot parkingLot = new MockParkingLot(5, 1, attendant);
    attendant.addParkingLot(parkingLot);

    attendant.park(new Car(1234));
    assertTrue(parkingLot.isCalled);
  }
}

class MockParkingLot extends ParkingLot{
  boolean isCalled;

  MockParkingLot(int size, int id, Attendant attendant) {
    super(size, id, attendant);
  }

  @Override
  int park(Car car) {
    this.isCalled = true;
    return 0;
  }
}
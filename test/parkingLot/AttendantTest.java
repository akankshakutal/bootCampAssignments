package parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttendantTest {
  @Test
  void shouldParkCarInParkingLot() throws ParkingLotFull {
    Attendant attendant = new Attendant();
    int parkingLotId = 1;
    ParkingLot parkingLot = new ParkingLot(5, parkingLotId, attendant);
    attendant.addParkingLot(parkingLot);
    Car car = new Car(1234);
    assertEquals(0,attendant.park(car));
  }

  @Test
  void shouldParkCarInFreeParkingLot() throws ParkingLotFull {
    Attendant attendant = new Attendant();
    MockParkingLot parkingLot = new MockParkingLot(5, 1, attendant);
    attendant.addParkingLot(parkingLot);

    attendant.park(new Car(1234));
    assertTrue(parkingLot.isParkCalled);
  }

  @Test
  void shouldUnParkCar() throws ParkingLotFull {
    Attendant attendant = new Attendant();
    MockParkingLot parkingLot = new MockParkingLot(5, 1, attendant);
    attendant.addParkingLot(parkingLot);

    attendant.park(new Car(1234));
    attendant.unPark(1234);
    assertTrue(parkingLot.isUnParkCalled);
  }
}

class MockParkingLot extends ParkingLot{
  boolean isParkCalled;
  boolean isUnParkCalled;

  MockParkingLot(int size, int id, Attendant attendant) {
    super(size, id, attendant);
  }

  @Override
  int park(Car car) {
    this.isParkCalled = true;
    return 0;
  }

  Car unPark(int carId){
    this.isUnParkCalled = true;
    return null;
  }
}
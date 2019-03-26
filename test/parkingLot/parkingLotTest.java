package parkingLot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class parkingLotTest {
  ParkingLot parkingLot;
  @BeforeEach
  void setUp() {
    int parkingLotId = 1;
    Attendant attendant = new Attendant();
    parkingLot = new ParkingLot(2,parkingLotId, attendant);
  }

  @Test
  void shouldAddCarToParkingLot() {
    Car car = new Car(1234);
    assertEquals(0,parkingLot.park(car));
  }

  @Test
  void shouldNotAllowToAddCarToParkingLotIfLotIsFull() {
    Car car1 = new Car(1234);
    parkingLot.park(car1);
    parkingLot.park(car1);
    Car car2 = new Car(1235);
    assertEquals(-1,parkingLot.park(car2));
  }

  @Test
  void shouldNotifyAttendant() {
    class Attendant extends parkingLot.Attendant {
      boolean called;
      void notify(ParkingLot parkingLot) {
        this.called = true;
      }
    }

    Attendant attendant = new Attendant();
    ParkingLot parkingLot = new ParkingLot(1, 1, attendant);
    Car car1 = new Car(1234);
    parkingLot.park(car1);
    Car car2 = new Car(1235);
    parkingLot.park(car2);
    assertTrue(attendant.called);
  }
}
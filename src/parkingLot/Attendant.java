package parkingLot;

import java.util.ArrayList;
import java.util.List;

class Attendant {
  private List<ParkingLot> availableParkingLots;
  private List<ParkingLot> fullParkingLots;

  Attendant() {
    availableParkingLots = new ArrayList<>();
    fullParkingLots = new ArrayList<>();
  }

  void notify(ParkingLot parkingLot) {
    availableParkingLots.remove(parkingLot);
    fullParkingLots.add(parkingLot);
    System.out.println("Parking lot is full");
  }

  void addParkingLot(ParkingLot parkingLot) {
    this.availableParkingLots.add(parkingLot);
  }

  int park(Car car) {
    return availableParkingLots.get(0).park(car);
  }
}

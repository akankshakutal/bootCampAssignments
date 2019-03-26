package parkingLot;

import java.util.ArrayList;
import java.util.List;

class Attendant implements Observer {
  private List<ParkingLot> availableParkingLots;
  private List<ParkingLot> fullParkingLots;

  Attendant() {
    availableParkingLots = new ArrayList<>();
    fullParkingLots = new ArrayList<>();
  }

  @Override
  public void update(ParkingLot parkingLot) {
    availableParkingLots.remove(parkingLot);
    fullParkingLots.add(parkingLot);
    System.out.println("Notified by " + parkingLot.getId());
  }

  void addParkingLot(ParkingLot parkingLot) {
    this.availableParkingLots.add(parkingLot);
  }

  int park(Car car) throws ParkingLotFull {
    return availableParkingLots.get(0).park(car);
  }
}

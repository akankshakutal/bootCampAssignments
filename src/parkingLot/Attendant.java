package parkingLot;

import java.util.ArrayList;
import java.util.List;

class Attendant implements Observer {
  private List<ParkingLot> parkingLots;
  private List<ParkingLot> availableParkingLots;

  Attendant() {
    availableParkingLots = new ArrayList<>();
    parkingLots = new ArrayList<>();
  }

  @Override
  public void parkingLotIsFull(ParkingLot parkingLot) {
    availableParkingLots.remove(parkingLot);
    System.out.println("Parking lot " + parkingLot.getId() + " is Full");
  }

  @Override
  public void parkingLotIsFree(ParkingLot parkingLot) {
    availableParkingLots.add(parkingLot);
    System.out.println("Parking lot " + parkingLot.getId() + " is free");

  }

  void addParkingLot(ParkingLot parkingLot) {
    this.availableParkingLots.add(parkingLot);
    this.parkingLots.add(parkingLot);
  }

  int park(Car car) throws ParkingLotFull {
    return availableParkingLots.get(0).park(car);
  }

  Car unPark(int carId) {
    for (ParkingLot parkingLot : parkingLots) {
      Car car = parkingLot.unPark(carId);
      if (car != null) {
        return car;
      }
    }
    return null;
  }
}

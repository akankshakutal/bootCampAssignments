package parkingLot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
  private int size;
  private int id;
  private Attendant attendant;
  private List<Car> parkingLot;

  ParkingLot(int size, int id, Attendant attendant) {
    this.size = size;
    this.id = id;
    this.attendant = attendant;
    this.parkingLot = new ArrayList<>(this.size);
  }

  int park(Car car) throws ParkingLotFull {
    if (isFull()) throw new ParkingLotFull();
    parkingLot.add(car);
    if (isFull()) attendant.update(this);
    return parkingLot.indexOf(car);
  }

  int getId() {
    return id;
  }

  private boolean isFull() {
    return parkingLot.size() == this.size;
  }
}

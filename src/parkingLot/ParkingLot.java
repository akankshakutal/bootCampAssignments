package parkingLot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
  private int size;
  private int id;
  private Attendant attendant;
  private List<Car> register;

  ParkingLot(int size,int id, Attendant attendant) {
    this.size = size;
    this.id = id;
    this.attendant = attendant;
    this.register = new ArrayList<>(this.size);
  }

  int park(Car car) {
    if (isFull()) {
      attendant.notify(this);
      return -1;
    }
    register.add(car);
    return register.indexOf(car);
  }

  int getId() {
    return id;
  }

  private boolean isFull() {
    return register.size() == this.size;
  }
}

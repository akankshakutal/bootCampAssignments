package parkingLot;

interface Observer {
  void parkingLotIsFull(ParkingLot parkingLot);

  void parkingLotIsFree(ParkingLot parkingLot);
}

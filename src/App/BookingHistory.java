package App;

import java.time.LocalDateTime;

public
class BookingHistory {
    private final String bookingId;
    private final String passengerName;
    private final String driverName;
    private final LocalDateTime cabBookedTime;
    private LocalDateTime cabReachedTime;
    private final Location fromLocation;
    private final Location toLocation;
    private CabBookingStatus cabBookingStatus;
    private final CabServiceType cabServiceType;
    private VehicleInfo vehicleInfo;

    public BookingHistory(String passengerName, String driverName, CabServiceType cabServiceType, LocalDateTime cabBookedTime,
                          Location fromLocation, Location toLocation, VehicleInfo vehicleInfo){
        this.passengerName = passengerName;
        this.driverName = driverName;
        this.cabBookedTime = cabBookedTime;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.vehicleInfo = vehicleInfo;
        this.cabServiceType = cabServiceType;
        this.cabBookingStatus = CabBookingStatus.WAITINGFORCONFIRMATION;
        this.bookingId = IdGenerator.generateBookingId(this);

    }
    public String getPassengerName() {
        return passengerName;
    }

    public String getDriverName() {
        return driverName;
    }

    public LocalDateTime getCabBookedTime() {
        return cabBookedTime;
    }

    public LocalDateTime getCabReachedTime() {
        return cabReachedTime;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public CabBookingStatus getCabBookingStatus() {
        return cabBookingStatus;
    }

    public void setCabBookingStatus(CabBookingStatus cabBookingStatus) {
        this.cabBookingStatus = cabBookingStatus;
    }

    public void setCabReachedTime(LocalDateTime cabReachedTime) {
        this.cabReachedTime = cabReachedTime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public CabServiceType getCabServiceType() {
        return cabServiceType;
    }

    public VehicleInfo getVehicleInfo() {
        return vehicleInfo;
    }
}

package App;

public class RentalServiceProvider {
    private  int miniRentalPackagePerHour;
    private  int sedanRentalPackagePerHour;
    private  int suvRentalPackagePerHour;

    public RentalServiceProvider(int hour){
        this.miniRentalPackagePerHour = 320 * hour;
        this.sedanRentalPackagePerHour = 360 * hour;
        this.suvRentalPackagePerHour = 448 * hour;
    }

    public int getMiniRentalPackagePerHour() {
        return miniRentalPackagePerHour;
    }

    public int getSedanRentalPackagePerHour() {
        return sedanRentalPackagePerHour;
    }

    public int getSuvRentalPackagePerHour() {
        return suvRentalPackagePerHour;
    }
}

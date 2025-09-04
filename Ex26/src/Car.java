public class Car {
    private String licenseNumber;
    private Chassis chassis;
    public Car(String licenseNumber, Chassis chassis){
        this.licenseNumber = licenseNumber;
        this.chassis = chassis;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
    }
}

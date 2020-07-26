package vn.edu.ntu.vancuong.ontap_bai2.model;

public class Contact {

    int id;
    String Name, Brith, PhoneNumber, Address;

    public Contact() {
    }

    public Contact(int id, String name, String brith, String phoneNumber, String Address) {
        this.id = id;
        Name = name;
        Brith = brith;
        PhoneNumber = phoneNumber;
        this.Address = Address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBrith() {
        return Brith;
    }

    public void setBrith(String brith) {
        Brith = brith;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
}

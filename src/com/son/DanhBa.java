package com.son;

public class DanhBa {
    private String name;
    private String phonenumber;
    private String address;
    private String gmail;

    public DanhBa(){}
    public DanhBa(String name, String phonenumber, String address, String gmail) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.address = address;
        this.gmail = gmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String toString() {
        return "DanhBa{" +
                "name='" + name + '\'' +
                ", phonenumber=" + phonenumber +
                ", address='" + address + '\'' +
                ", gmail='" + gmail + '\'' +
                '}';
    }

    public String ghi(){
        return name + "," + phonenumber + "," + address + "," + gmail;
    }
}

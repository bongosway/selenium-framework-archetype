package uk.bongosway.selenium.data;

public class Address {

  private String address;
  private String city;
  private String state;
  private String zipCode;

  public Address(String address, String city, String state, String zipCode) {
    this.address = address;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
  }

  @Override
  public String toString() {
    return "Address{" +
        "address='" + address + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", zipCode='" + zipCode + '\'' +
        '}';
  }
}

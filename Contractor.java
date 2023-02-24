//David Nguyen - A class representing a contractor, including their name, address, contact person, and balance//
public class Contractor {
  
  //A field representing the contractor's name//
  private String name;
  //A field representing the contractor's address
  private String address;
  //A field representing the contractors' contact person
  private String contact;
  //A field representing the balance of the contractor
  private double balance;
  //A field representing the amount paid to the contractor
  private double amount;
  
  //A constructor that creates a contractor//
  public Contractor (String name, String address, String contact) {
    this.name = name;
    this.address = address;
    this.contact = contact;
  }
  
  //A method that returns the name of the contractor//
  public String getName () {
    return this.name;
  }
  //A method that sets the name of the contractor//
  //The variable name represents the desired name that will be set to the contractor//
  public void setName (String name) {
    this.name = name;
  }
  
  //A method that returns the address of the contractor
  public String getAddress () {
    return this.address;
  }
  
  //A method that sets the address of the contractor//
  //The variable address represents the desired address that will be set to the contractor//
  public void setAddress (String address) {
    this.address = address;
  }
  
  //A method that returns the contact person of the contractor//
  public String getContact () {
    return this.contact;
  }
  
  //A method that sets the name of the contact person of the contractor
  //The variable name represents the name of the contact person of the contractor
  public void setContact (String contact) {
    this.contact = contact;
  }
  
  //A method that returns the amount that has been paid to the contractor
  public double getAmountPaid () {
    return this.amount;
  }
  
  //A method that pays the contractor the specified amount
  //The variable amount represents the specified amount paid to the contractor
  public void pay (double amount) {
    this.amount = this.amount + amount;
    this.balance = this.balance + this.amount;
  }
  
  //A method that override the inherited toString method to represent the contractor name, address, and contact
  public String toString() {
    return getName() + ", " + getAddress() + ", " + getContact();
  }
  
  /* A method that override the inherited equals method to determine if the two contractor instances are equal 
  (if their names are equal)*/
  public boolean equals(Object o) {
    if (o instanceof Contractor) {
      Contractor c = (Contractor)o;
      if (this.getName() == c.getName())
        return true;
      else
        return false;
    }
    return false;
  }
}
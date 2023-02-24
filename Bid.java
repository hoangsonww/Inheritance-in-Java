//David Nguyen - The class Bid represents a bid that a contractor makes for a contract//
public class Bid{
  //The contract field represents the contract name for the bid
  Contract contract;
  //The contractor field represents the contractor's name
  Contractor contractor;
  //The value field represents the value of the bid
  Double value;
  
  //A constructor that creates a bid//
  public Bid (Contract contract, Contractor contractor, double value) {
    this.contract = contract;
    this.contractor = contractor;
    this.value = value; 
  }
  
  //A method that returns the contract for the bid
  public Contract contract() {
    return contract;
  }
  
  //A method that returns the contractor for the bid
  public Contractor contractor() {
    return this.contractor;
  }
  
  //A method that returns the value of the bid//
  public double value() {
    return this.value;
  } 
}
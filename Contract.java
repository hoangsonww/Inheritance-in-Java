//David Nguyen - A class that represents a contract
public class Contract {
  //The id field represents the ID of the contract
  String contractID;
  //The minValue field represents the minimum value of the contract
  double minValue;
  //The maxValue field represents the maximum value of the contract
  double maxValue;
  //The bonus field represents the per-day bonus associated with the contract
  double bonus;
  //The penalty field represents the per-day penalty associated with the contract
  double penalty;
  //The deadline field represents the deadline for the contract
  Date deadline;
  //The bidAccept field stores whether the contract is still accepting bids or not
  boolean bidAccept;
  //The bestBid field stores the best bid so far for the contract
  Bid bestBid;
  //The complete field stores whether the contract is completed or not
  boolean complete;
  //The completedDay stores the day on which the contract is completed
  Date completedDate;
  
 //A constructor that creates a Contract//
  public Contract (String contractID, double minValue, double maxValue, double bonus, double penalty, Date deadline) {
    this.contractID = contractID;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.bonus = bonus;
    this.penalty = penalty;
    this.deadline = deadline;
    this.bidAccept = true;
    this.bestBid = null;
    this.complete = false;
    this.completedDate = null;
  }
 
  //A method that gets the ID of the contract
  public String getID() {
    return this.contractID;
  }
  
  //A method that gets the minimum value of the contract
  public double getMinValue() {
    return this.minValue;
  }
  
  //A method that sets the minimum value for the contract
  public void setMinValue (double value) {
    this.minValue = value;
  }
  
  //A method that gets the maximum value of the contract
  public double getMaxValue() {
    return this.maxValue;
  }
  
  //A method that sets the maximum value for the contract
  public void setMaxValue(double value) {
    this.maxValue = value;
  }
  
  //A method that gest the per-day bonus associated with the contract
  public double getBonus() {
    return this.bonus;
  }
  
  //A method that sets the per-day bonus
  public void setBonus(double bonus) {
    this.bonus = bonus;
  }
  
  //A method that gets the per-day penalty
  public double getPenalty() {
    return this.penalty;
  }
  
  //A method that sets the per-day penalty
  public void setPenalty (double penalty) {
    this.penalty = penalty;
  }
  
  //A method that gets the deadline for the contract
  public Date getDeadline() {
    return this.deadline;
  }
  
  //A method that sets the deadline for the contract
  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }
  
  //A method that returns true if a contractor may submit a bid for the contract
  public boolean isAcceptingBids() {
    return this.bidAccept;
  }
  
  //A method that returns the best bid so far for the contract. It returns null if there've been no acceptable bids
  public Bid getBestBid() {
    if (bidAccept == true)
      return this.bestBid;
    else
      return null;
  }
  
  /*A method that returns true if the bid is accepted and becomes the current best bid. However, it returns false 
  if the bid is not accepted*/
  public boolean makeBid (Bid bid) {
    Bid bestBidSoFar = getBestBid();
    if (bidAccept == false){
      return false;
    }
    else
      if (this.minValue <= bid.value &&  bid.value <= this.maxValue) {
        if (bestBidSoFar == null) {
          this.bestBid = bestBidSoFar;
          return true;
        }
        else {
          if (bid != bestBidSoFar) {
            this.bestBid = bestBidSoFar;
            return true;
          }
        }
      }
    return false;
  }
  
  //A method that indicates that the contract is no longer accepting bid
  public void awardContract () {
    this.bidAccept = false;
  }
  
  //A method that returns true if the contract has been completed, or false if not
  public boolean isComplete () {
    return complete;
  }
  
  //A method that returns the date on which the contract was completed, returns null if the contract is not completed
  public Date completeDate () {
    if (this.complete = true) {
      return this.completedDate;
    }
    else {
      return null;
    }
  }
  
  /*A method that sets the contract to completed, sets the completed date for the contract,
  and pay the contractor of the best bid the required amount, which is the sum of the best bid & penalty or bonus*/
  public void setComplete (Date completedDate) {
    this.completedDate = completedDate;
    this.complete = true;
    //A variable that stores the amount to be paid to the contractor//
    double amountPay = getBestBid().value;
    int daysLateOrBeforeDeadline = Date.difference(getDeadline(), completedDate);
    //An if-statement that determines the amount to be paid to the contractor based on bonus & bid & penalty
    if (daysLateOrBeforeDeadline > 0) {
      double penalty = getPenalty() * daysLateOrBeforeDeadline;
      amountPay = amountPay + penalty;
    }
    if (daysLateOrBeforeDeadline < 0) {
      double bonus = getBonus() * daysLateOrBeforeDeadline;
      amountPay = amountPay - bonus;
    }
  }
}
  
//David Nguyen - Date class: A class that represents a date (With Extra Credit)//
public class Date {
  
  //A field that represents the day of the date//
  private int day;
  //A field that represents the month of the date//
  private Month month;
  //A field that represents the year of the date//
  private int year;
  //A field that represents the current date//
  private String date; 
  //A variable storing whether the date is being displayed in a US format
  boolean isInUSFormat;
  
  //Extra-Credit Attempt: An enum type that represents the months in a year from January to December
  public enum Month {
   //Declaring the maximum number of days for each month
      JAN(31),
      FEB(28),
      MAR(31),
      APR(30),
      MAY(31),
      JUN(30),
      JUL(31),
      AUG(31),
      SEP(30),
      OCT(31),
      NOV(30),
      DEC(31);
      
      //A variable that stores the maximum number of days of each month
      private final int numDays;
      
      //A constructor that sets the maximum number of days of each month
      Month(int numDays) {
        this.numDays = numDays;
      }
      
      //A method that returns the maximum number of days of each month
      public int getNumDayOfMonth(Month month) {
        return this.numDays;
      }
      
      //A method returning the number of days between December 31st of previous year and the 1st of the selected month
      public static int dayOfYear(Month month) {
        //A variable that stores the number of days between December 31st of previous year and the 1st of this month.
        int numDaysFromDec31;
        //Calculating the number of days from December 31st of previous year and the 1st of this month
        if (month == JAN) 
          numDaysFromDec31 = 1;
        else if (month == FEB)
          numDaysFromDec31 = 1 + 31;
        else if (month == MAR)
          numDaysFromDec31 = 1 + 31 + 28;
        else if (month == APR)
          numDaysFromDec31 = 1 + 31 + 28 + 31;
        else if (month == MAY)
          numDaysFromDec31 = 1 + 31 + 28 + 31 + 30;
        else if (month == JUN)
          numDaysFromDec31 = 1 + 31 + 28 + 31 + 30 + 31;
        else if (month == JUL)
          numDaysFromDec31 = 1 + 31 + 28 + 31 + 30 + 31 + 30;
        else if (month == AUG)
          numDaysFromDec31 = 1 + 31 + 28 + 31 + 30 + 31 + 30 + 31;
        else if (month == SEP)
          numDaysFromDec31 = 1 + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
        else if (month == OCT)
          numDaysFromDec31 = 1 + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
        else if (month == NOV)
          numDaysFromDec31 = 1 + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
        else
          numDaysFromDec31 = 1 + 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
        return numDaysFromDec31;
      }
  }
      
  //A constructor that creates a Date object with the int inputs being the day, month, and year of the date//
  public Date (int day, Month month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
    this.date = this.month + "/" + this.day + "/" + this.year;
    this.isInUSFormat = false;
  }
  
  //A method that returns the number of days between this Date and January 1 of the same year//
  public int daysFromJan1() {
      //A variable that stores the number of days from Jan 1
    int numberOfDays;
      //A statement that adds the number of days that have passed from Jan 1 to the current date to calculate days from Jan 1//
    numberOfDays = Month.dayOfYear(this.month) + this.day;
    return numberOfDays;
      }
  
  /*A method that returns the day of the date. If the day falls outside the range 0-31, 
   the day is invalid and program returns 00*/
  public int getDay () {
    if (1 < this.day && this.day < 31)
      return this.day;
    else
      return 0;
  }
  
  /*A method that returns the month of the date*/
  public Month getMonth() {
    return this.month;
  }
  
  //A method that returns the year of the date//
  public int getYear () {
    return this.year;
  }
  
  //A method that sets the date to the US date formatting. If the input is true, change to US Formatting and vice versa
  public void setUSFormat(boolean useUSFormat) {
    if (useUSFormat == false) {
      this.date = this.date;
    }
    else {
      this.date = this.month + "/" + this.day + "/" + this.year;
    }
  }
  
  //A method that checks whether the date is being displayed in a US format//
  public boolean isUSFormat() {
    /*An if-statement that returns true & set the value of the variable isInUSFormat to true if the date is displayed 
     in the US Format and vice versa*/
    if (this.date == this.month + "/" + this.day + "/" + this.year) {
      isInUSFormat = true;
    }
    else {
      isInUSFormat = false;
    }
    return isInUSFormat;
  }
  
  //A method that takes 2 dates and returns the difference in days between the two//
  public static int difference(Date date1, Date date2) {
    //A variable that stores the difference in terms of year between the two dates//
    int yearDifference = date1.year - date2.year;
    //A variable that stores the difference in days between the two given dates//
    int totalDays = 0;
    //A variable that stores the difference in terms of days between the two dates in the same year//
    int dayDifference = date1.daysFromJan1() - date2.daysFromJan1();
    /*An if-statement that calculates the difference in terms of days between the two days*/
    if (yearDifference < 0)
      totalDays = (yearDifference * 365) + dayDifference;
    else
      totalDays = (yearDifference * 365) + dayDifference;
    return totalDays;
  }
  
  //A method that override the inherited toString() method to display the date based on the desired format//
  public String toString() {
    if (isInUSFormat == true) {
      return (this.getMonth() + " " + this.getDay() + ", " + this.getYear());
    }
    else {
      return (this.getDay() + " " + this.getMonth() + ", " + this.getYear());
    }
  }
  
  /*A method that override the inherited equals() method to compare the two date instances.
  The two dates are equal if they have the same day, month, year values, and vice versa*/
  public boolean equals(Object o) {
    if (o instanceof Date) {
      Date d = (Date)o;
      if (this.getDay() == d.getDay() && this.getMonth() == d.getMonth() && this.getYear() == d.getYear())
        return true;
      else
        return false;
    }
    return false;
  }
}
package com.molavec.greet;

public class Greet {

  private String greet = "hello";

  public Greet(){}

  public Greet(String greet){
    this.greet = greet;
  }

  public String getGreet(){
    System.out.println("Debug: " + this.greet);
    return greet;
  }

  public void setGreet(String greet){

    this.greet = greet;
    System.out.println("Debug: " + this.greet);
  }

  public void printToConsole(){
    System.out.println(this.greet);
  }

}

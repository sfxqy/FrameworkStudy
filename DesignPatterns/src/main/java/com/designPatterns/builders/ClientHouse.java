package com.designPatterns.builders;

/**
 * @author sfx
 * @Description
 */
public class ClientHouse {


  public static void main(String[] args) {

    CommonHouse commonHouse = new CommonHouse();
    HouseDirector houseDirector = new HouseDirector(commonHouse);
    House house = houseDirector.constructHouse();
    System.out.println(house.getBaise());

    HouseDirector houseDirector1 = new HouseDirector(new HightHouse());
    House house1 = houseDirector1.constructHouse();
    System.out.println(house1.getBaise());

  }

}

/**
 * @author  Hangyul Yi
 * @version 1.1
 * @since   1.0
 */

package edu.ucalgary.oop;

import java.util.ArrayList;
/**
 * Represents a Location in the system.
 * Each Location has a list of occupants and supplies
 * Users can add/remove occupants and supplies
 */
public class Location {
   private String name;
   private String address;
   private ArrayList<DisasterVictim> occupants;
   private ArrayList<Supply> supplies;

   /* Constructor */
   public Location(String name, String address) {
      this.name = name;
      this.address = address;
      this.occupants = new ArrayList<>();
      this.supplies = new ArrayList<>();
   }

   /* Setters */
   public void setName(String name) {
      this.name = name;
   }

   public void setOccupants(ArrayList<DisasterVictim> occupants) {
      this.occupants = occupants;
   }

   public void setSupplies(ArrayList<Supply> supplies) {
      this.supplies = supplies;
   }

   /* Getters */
   public String getName() { return this.name; }
   public String getAddress() { return this.address; }
   public ArrayList<DisasterVictim> getOccupants() { return this.occupants; }
   public ArrayList<Supply> getSupplies() { return this.supplies; }

   /**
    * This method is used to add an occupant to this Location
    * @param occupant
    */
   public void addOccupant(DisasterVictim occupant) {
      occupants.add(occupant);
   }

   /**
    * This method is used to remove an occupant from this Location
    * @param occupant
    */
   public void removeOccupant(DisasterVictim occupant) {
      occupants.remove(occupant);
   }

   /**
    * This method is used to add Supply to this Location
    * @param supply
    */
   public void addSupply(Supply supply) {
      supplies.add(supply);
   }

   /**
    * This method is used to remove Supply from this Location
    * @param supply
    */
   public void removeSupply(Supply supply) {
      supplies.remove(supply);
   }
}

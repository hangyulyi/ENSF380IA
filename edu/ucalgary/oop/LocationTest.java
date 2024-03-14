package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class LocationTest {
   private Location location;
   private DisasterVictim victim1;
   private DisasterVictim victim2;
   private Supply supply1;
   private Supply supply2;

   @Before
   public void setUp() {
      location = new Location("Shelter", "this address");
      victim1 = new DisasterVictim("John", "2024-03-01", 30);
      victim2 = new DisasterVictim("Bob", "2024-01-20", 30);
      supply1 = new Supply("Water", 10);
      supply2 = new Supply("Blanket", 2);
   }

   @Test
   public void testAddOccupant() {
      location.addOccupant(victim1);
      assertEquals("Occupant should be added to location", 1, location.getOccupants().size());
      assertEquals(victim1, location.getOccupants().get(0));
   }

   @Test
   public void testRemoveOccupant() {
      location.addOccupant(victim1);
      location.removeOccupant(victim1);
      assertEquals("Occupant should be removed", 0, location.getOccupants().size());
   }

   @Test
   public void testAddSupply() {
      location.addSupply(supply1);
      assertEquals("Supply should be added", 1, location.getSupplies().size());
      assertEquals(supply1, location.getSupplies().get(0));
   }

   @Test
   public void testRemoveSupply() {
      location.addSupply(supply1);
      location.removeSupply(supply1);
      assertEquals("Supply should be removed from location", 0, location.getSupplies().size());
   }

   @Test
   public void testUpdateLocation() {
      location.updateLocation("New shelter", "New address");
      assertEquals("Location name should be updated", "New shelter", location.getName());
      assertEquals("Location address should be updated", "New address", location.getAddress());
   }

   @Test
   public void testAllocateSupply() {
      location.addOccupant(victim1);
      location.addSupply(supply1);
      location.allocateSupply(victim1, supply1);
      assertEquals("Supply should be allocated to occupant", 0, location.getSupplies().size());
      assertEquals(1, victim1.getPersonalBelongings().size());
      assertEquals(supply1, victim1.getPersonalBelongings().get(0));
   }
}

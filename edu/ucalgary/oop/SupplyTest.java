package edu.ucalgary.oop;

import static org.junit.Assert.*;
import org.junit.*;

public class SupplyTest {

   private Supply supply;

   @Before
   public void setUp() {
      supply = new Supply("Water", 100);
   }

   @Test
   public void testConstructorPositiveQuantity() {
      Supply supply = new Supply("Water", 10);
      assertEquals("Water", supply.getType());
      assertEquals(10, supply.getQuantity());
      assertTrue(supply.isAvailable());
   }

   @Test(expected = IllegalArgumentException.class)
   public void testConstructorNegaviteQuantity() {
      new Supply("Water", -10);
   }

   @Test
   public void testSetQuantityPositive() {
      supply.setQuantity(11);
      assertEquals(11, supply.getQuantity());
      assertTrue(supply.isAvailable());
   }

   @Test(expected = IllegalArgumentException.class)
   public void testSetQuantityNegative() {
      supply.setQuantity(-10);
   }

   @Test
   public void testSetQuantityZero() {
      supply.setQuantity(0);
      assertEquals(0, supply.getQuantity());
      assertFalse(supply.isAvailable());
   }

   @Test
   public void testSetAvailableTrue() {
      supply.setAvailable(true);
      assertTrue(supply.isAvailable());
   }

   @Test
   public void testSetAvailableFalse() {
      supply.setAvailable(false);
      assertFalse(supply.isAvailable());
   }
}

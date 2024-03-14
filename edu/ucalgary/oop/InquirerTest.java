package edu.ucalgary.oop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class InquirerTest {
   private Inquirer inquirer;

   @Before
   public void setUp() {
      inquirer = new Inquirer("John", "Doe", "123-456-7890", "Extra info");
   }

   @Test
   public void testGetInfo() {
      assertEquals("Extra info", inquirer.getInfo());
   }

   @Test
   public void testGetServicesPhoneNum() {
      assertEquals("123-456-7890", inquirer.getServicesPhoneNum());
   }

   @Test
   public void testAddInteraction() {
      inquirer.addInteraction("Call for help");
      assertEquals(1, inquirer.getInteractionLog().size());
      assertTrue(inquirer.getInteractionLog().contains("Call for help"));
   }

   @Test
   public void testGetLogDetails() {
      inquirer.addInteraction("Help");
      inquirer.addInteraction("Got information");
      String expectedLogDetails = "Help\nGot information\n";
      assertEquals(expectedLogDetails, inquirer.getLogDetails());
   }
}

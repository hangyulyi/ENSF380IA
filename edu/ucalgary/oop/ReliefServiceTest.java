package edu.ucalgary.oop;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ReliefServiceTest {
   private Inquirer inquirer;
   private DisasterVictim missingPerson;
   private Location location;
   private ReliefService reliefService;

   @Before
   public void setUp() {
      inquirer = new Inquirer("John", "Doe", "123-123-1234", "Important info");
      missingPerson = new DisasterVictim("Bob", "2023-12-23", 23);
      location = new Location("Shelter", "Real address");
      reliefService = new ReliefService(inquirer, missingPerson, "2023-12-23", "Information", location);
   }

   @Test
   public void testGetInquirer() {
      assertEquals(inquirer, reliefService.getInquirer());
   }

   @Test
   public void testSetInquirer() {
      Inquirer newInquirer = new Inquirer("Billy", "Joe", "234-123-2345", "New info");
      reliefService.setInquirer(newInquirer);
      assertEquals(newInquirer, reliefService.getInquirer());
   }

   @Test
   public void testGetMissingPerson() {
      assertEquals(missingPerson, reliefService.getMissingPerson());
   }

   @Test
   public void testSetMissingPerson() {
      DisasterVictim newMissingPerson = new DisasterVictim("Jerry", "2013-12-23", 12);
      reliefService.setMissingPerson(newMissingPerson);
      assertEquals(newMissingPerson, reliefService.getMissingPerson());
   }

   @Test
   public void testGetDateOfInquiry() {
      assertEquals("2023-12-23", reliefService.getDateOfInquiry());
   }

   @Test(expected = IllegalArgumentException.class)
   public void testSetDateOfInquiryInvalid() {
      reliefService.setDateOfInquiry("2023/12/23");
   }

   @Test
   public void testGetInfoProvided() {
      assertEquals("Information", reliefService.getInfoProvided());
   }

   @Test
   public void testSetInfoProvided() {
      reliefService.setInfoProvided("New info");
      assertEquals("New info", reliefService.getInfoProvided());
   }

   @Test
   public void testGetLastKnownLocation() {
      assertEquals(location, reliefService.getLastKnownLocation());
   }

   @Test
   public void testSetLastKnownLocation() {
      Location newLocation = new Location("new", "new address");
      reliefService.setLastKnownLocation(newLocation);
      assertEquals(newLocation, reliefService.getLastKnownLocation());
   }

   @Test
   public void testInquirerLog() {
      String expectedLog = "Inquirer: John Doe\nMissing person: Bob\nDate of Inquiry: 2023-12-23\nInformation: Information\nLast known location: Shelter\n";
      assertEquals(expectedLog, reliefService.inquirerLog());
   }
}

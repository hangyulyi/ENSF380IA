package edu.ucalgary.oop;

import static org.junit.Assert.*;
import org.junit.Test;

public class MedicalRecordTest {
   Location expectedLocation = new Location("Shelter", "Real address");
   private String expectedTreatmentDetails = "Broken arm";
   private String expectedDateOfTreatment = "2024-01-19";
   private String invalidDate = "2024/12/23";
   MedicalRecord medicalRecord = new MedicalRecord(expectedLocation, expectedTreatmentDetails, expectedDateOfTreatment);

   @Test
   public void testObjectCreation() {
      assertNotNull(medicalRecord);
   }

   @Test
   public void testGetLocation() {
      assertEquals("getLocation should return the corrent Location", expectedLocation, medicalRecord.getLocation());
   }

   @Test
   public void testSetLocation() {
      Location newLocation = new Location("New shelter", "Different address");
      medicalRecord.setLocation(newLocation);
      assertEquals("setLocation should update the Location", newLocation.getName(), medicalRecord.getLocation().getName());
   }

   @Test
   public void testGetTreatmentDetails() {
      assertEquals("getTreatmentDetails should return the correct treatment details", expectedTreatmentDetails, medicalRecord.getTreatmentDetails());
   }

   @Test
   public void testSetTreatmentDetails() {
      String newTreatment = "New treatment";
      medicalRecord.setTreatmentDetails(newTreatment);
      assertEquals("setTreatmentDetails should update the treatment details", newTreatment, medicalRecord.getTreatmentDetails());
   }

   @Test
   public void testGetDateOfTreatment() {
      assertEquals("getDateOfTreatment should return the correct date", expectedDateOfTreatment, medicalRecord.getDateOfTreatment());
   }

   @Test
   public void testSetDateOfTreatement() {
      String newDate = "2024-03-12";
      medicalRecord.setDateOfTreatment(newDate);
      assertEquals("setDateOfTreatment should update", newDate, medicalRecord.getDateOfTreatment());
   }

   @Test
   public void testSetDateOfTreatmentFormat() {
      boolean correctValue = false;
      String failureReason = "no exception was thrown";

      try {
         medicalRecord.setDateOfTreatment(invalidDate); // Should throw IllegalArgumentException
      }
      catch (IllegalArgumentException e) {
         correctValue = true;
      }
      catch (Exception e) {
         failureReason = "the wrong type of exception was thrown";
      }

      String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid date format '" + invalidDate + "' but " + failureReason + ".";
      assertTrue(message, correctValue); 

   }
}

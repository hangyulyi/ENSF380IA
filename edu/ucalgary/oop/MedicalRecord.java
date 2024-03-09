/**
 * @author  Hangyul Yi
 * @version 1.1
 * @since   1.0
 */

package edu.ucalgary.oop;

/**
 * Represenss a MedicalRecord in the system.
 * 
 * Records the location, treatment, and date of treatment for a DisasterVictim
 */
public class MedicalRecord {
   private Location location;
   private String treatmentDetails;
   private String dateOfTreatment;

   private static final String DATE_FORMAT_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

   /* Constructor */
   // Makes sure dateOfTreatment is in correct format.
   public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) throws IllegalArgumentException {
      this.location = location;
      this.treatmentDetails = treatmentDetails;

      if(dateOfTreatment.matches(DATE_FORMAT_REGEX)) {
         this.dateOfTreatment = dateOfTreatment;
         return;
      }
      else {
         throw new IllegalArgumentException("Invalid date format. Must be in YYYY-MM-DD.");
      }
   }

   /* Setters */
   public void setLocation(Location location) {
      this.location = location;
   }

   public void setTreatmentDetails(String treatmentDetails) {
      this.treatmentDetails = treatmentDetails;
   }

   public void setDateOfTreatment(String dateOfTreatment) throws IllegalArgumentException {
      if (dateOfTreatment.matches(DATE_FORMAT_REGEX)) {
         this.dateOfTreatment = dateOfTreatment;
         return;
      }
      throw new IllegalArgumentException("Invalid date format. Must be in YYYY-MM-DD.");
   }

   /* Getters */
   public Location getLocation() { return this.location; }
   public String getTreatmentDetails() { return this.treatmentDetails; }
   public String getDateOfTreatment() { return this.dateOfTreatment; }
}

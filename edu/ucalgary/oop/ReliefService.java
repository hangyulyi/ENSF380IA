/**
 * @author  Hangyul Yi
 * @version 1.2
 * @since   1.0
 */

package edu.ucalgary.oop;

/**
 * This represents a ReliefService in the system.
 * 
 * Users are able to record information about an inquirer, missing person, date of inquiry, information procided, and location
 */
public class ReliefService {
   private Inquirer inquirer;
   private DisasterVictim missingPerson;
   private String dateOfInquiry;
   private String infoProvided;
   private Location lastKnownLocation;

   private static final String DATE_FORMAT_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

   /* Constructor */
   public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation) {
      this.inquirer = inquirer;
      this.missingPerson = missingPerson;
      this.dateOfInquiry = dateOfInquiry;
      this.infoProvided = infoProvided;
      this.lastKnownLocation = lastKnownLocation;
   }

   /* Setters and Getters */
   public Inquirer getInquirer() {
      return inquirer;
   }

   public void setInquirer(Inquirer inquirer) {
      this.inquirer = inquirer;
   }

   public DisasterVictim getMissingPerson() {
      return missingPerson;
   }

   public void setMissingPerson(DisasterVictim missingPerson) {
      this.missingPerson = missingPerson;
   }

   public String getDateOfInquiry() {
      return dateOfInquiry;
   }

   public void setDateOfInquiry(String dateOfInquiry) throws IllegalArgumentException {
      if (dateOfInquiry.matches(DATE_FORMAT_REGEX)) {
         this.dateOfInquiry = dateOfInquiry;
         return;
      }
      throw new IllegalArgumentException("Invalid date format. Must be in YYYY-MM-DD format");
   }

   public String getInfoProvided() {
      return infoProvided;
   }

   public void setInfoProvided(String infoProvided) {
      this.infoProvided = infoProvided;
   }

   public Location getLastKnownLocation() {
      return lastKnownLocation;
   }

   public void setLastKnownLocation(Location lastKnowLocation) {
      this.lastKnownLocation = lastKnowLocation;
   }

   /**
    * This method generates a log entry for the inquiry
    * @return log
    */
   public String inquirerLog() {
      StringBuilder log = new StringBuilder();
      log.append("Inquirer: ").append(inquirer.getFirstName()).append(" ").append(inquirer.getLastName()).append("\n");
      log.append("Missing person: ").append(missingPerson.getFirstName()).append(" ").append("\n");
      log.append("Date of Inquiry: ").append(dateOfInquiry).append("\n");
      log.append("Information: ").append(infoProvided).append("\n");
      log.append("Last known location: ").append(lastKnownLocation.getName()).append("\n");
      return log.toString();
   }
}

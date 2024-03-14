/**
 * @author  Hangyul Yi
 * @version 1.2
 * @since   1.0
 */

package edu.ucalgary.oop;

import java.util.*;

/**
 * Represents an Inquirer in the system.
 * 
 * Records information such as name, phone number, and addition information
 */
public class Inquirer extends Entity{
   private String INFO;
   private String SERVICES_PHONE;
   private ArrayList<String> InteractionLog;

   /**
    * Constructor
    * @param FIRST_NAME
    * @param LAST_NAME
    * @param SERVICES_PHONE
    * @param INFO
    */
   public Inquirer(String FIRST_NAME, String LAST_NAME, String SERVICES_PHONE, String INFO) {
      super(FIRST_NAME, LAST_NAME);
      this.SERVICES_PHONE = SERVICES_PHONE;
      this.INFO = INFO;
      this.InteractionLog = new ArrayList<>();
   }

   /* Getter */
   public String getInfo() { return this.INFO; }
   public String getServicesPhoneNum() { return this.SERVICES_PHONE; }
   public ArrayList<String> getInteractionLog() { return this.InteractionLog; }

   /**
    * This method adds a log entry to the interactions had with this Inquirer
    * @param logEntry
    */
   public void addInteraction(String logEntry) {
      this.InteractionLog.add(logEntry);
   }

   /**
    * This method will retrieve all the log details
    * @return
    */
   public String getLogDetails() {
      StringBuilder details = new StringBuilder();
      for(String log : InteractionLog) {
         details.append(log).append("\n");
      }
      return details.toString();
   }

   /**
    * This method will print the log details
    */
   public void printLogDetails(){
      System.out.println(getLogDetails());
   }
}

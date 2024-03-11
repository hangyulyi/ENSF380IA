/**
 * @author  Hangyul Yi
 * @version 1.1
 * @since   1.0
 */

package edu.ucalgary.oop;

/**
 * Represents an Inquirer in the system.
 * 
 * Records information such as name, phone number, and addition information
 */
public class Inquirer {
   private String FIRST_NAME;
   private String LAST_NAME;
   private String INFO;
   private String SERVICES_PHONE;

   /**
    * Constructor
    * @param FIRST_NAME
    * @param LAST_NAME
    * @param SERVICES_PHONE
    * @param INFO
    */
   public Inquirer(String FIRST_NAME, String LAST_NAME, String SERVICES_PHONE, String INFO) {
      this.FIRST_NAME = FIRST_NAME;
      this.LAST_NAME = LAST_NAME;
      this.SERVICES_PHONE = SERVICES_PHONE;
      this.INFO = INFO;
   }

   /* Getter */
   public String getFirstName() { return this.FIRST_NAME; }
   public String getLastName() { return this.LAST_NAME; }
   public String getInfo() { return this.INFO; }
   public String getServicesPhoneNum() { return this.SERVICES_PHONE; }
}

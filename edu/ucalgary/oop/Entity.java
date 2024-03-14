/**
 * @author  Hangyul Yi
 * @version 1.1
 * @since   1.0
 */

package edu.ucalgary.oop;

public class Entity {
   
   private String firstName;
   private String lastName;

   /* Constructor */
   public Entity(String firstName) {
      this.firstName = firstName;
   }

   /* Setters */
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   /* Getters */
   public String getFirstName() { return this.firstName; }
   public String getLastName() { return this.lastName; }
}

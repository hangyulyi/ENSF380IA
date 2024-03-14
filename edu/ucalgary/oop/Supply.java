/**
 * @author  Hangyul Yi
 * @version 1.1
 * @since   1.0
 */

package edu.ucalgary.oop;

public class Supply {
   private String type;
   private int quantity;
   private boolean available;

   /* Constructor */
   public Supply(String type, int quantity) {
      this.type = type;
      this.quantity = quantity;
      if(quantity > 0) {
         this.available = true;
      }
      else {
         this.available = false;
      }
   }

   /* Getters and setters */
   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public boolean isAvailable() {
      return available;
   }

   public void setAvailable(boolean available) {
      this.available = available;
   }
}

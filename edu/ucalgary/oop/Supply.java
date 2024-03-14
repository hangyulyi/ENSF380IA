/**
 * @author  Hangyul Yi
 * @version 1.1
 * @since   1.0
 */

package edu.ucalgary.oop;

import java.util.Objects;

public class Supply {
   private String type;
   private int quantity;
   private boolean available;

   /* Constructor */
   public Supply(String type, int quantity) throws IllegalArgumentException {
      this.type = type;
      if(quantity < 0) {
         throw new IllegalArgumentException("Quantity cannot be negative");
      }
      this.quantity = quantity;
      this.available = quantity > 0;
   }

   /* Override equals() and hashCode() */
   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Supply supply = (Supply) o;
      return quantity == supply.quantity && available == supply.available && Objects.equals(type, supply.type);
   }

   @Override
   public int hashCode() {
      return Objects.hash(type, quantity, available);
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

   public void setQuantity(int quantity) throws IllegalArgumentException {
      if (quantity < 0) {
         throw new IllegalArgumentException("Quantity cannot be negative");
      }
      this.quantity = quantity;
      this.available = quantity > 0;
   }

   public boolean isAvailable() {
      return available;
   }

   public void setAvailable(boolean available) {
      this.available = available;
   }
}

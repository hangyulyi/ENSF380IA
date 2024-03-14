/**
 * @author  Hangyul Yi
 * @version 1.3
 * @since   1.0
 */

package edu.ucalgary.oop;

import java.util.Objects;

/**
 * Represents a FamilyRelation between two DisasterVictims
 * 
 * User can get/set relationships
 */
public class FamilyRelation {
   private DisasterVictim personOne;
   private String relationshipTo;
   private DisasterVictim personTwo;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      FamilyRelation that = (FamilyRelation) o;
      return Objects.equals(personOne, that.personOne) &&
             Objects.equals(relationshipTo, that.relationshipTo) &&
             Objects.equals(personTwo, that.personTwo);
   }

   @Override
   public int hashCode() {
      return Objects.hash(personOne, relationshipTo, personTwo);
   }

   /* Constructor */
   public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
      this.personOne = personOne;
      this.relationshipTo = relationshipTo;
      this.personTwo = personTwo;
   }

   /* Setters */
   public void setPersonOne(DisasterVictim personOne) {
      this.personOne = personOne;
   }

   public void setRelationshipTo(String relationshipTo) {
      this.relationshipTo = relationshipTo;
   }

   public void setPersonTwo(DisasterVictim personTwo) {
      this.personTwo = personTwo;
   }

   /* Getters */
   public DisasterVictim getPersonOne() { return this.personOne; }
   public String getRelationshipTo() { return this.relationshipTo; }
   public DisasterVictim getPersonTwo() { return this.personTwo; }

}

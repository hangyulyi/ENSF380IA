/**
 * @author  Hangyul Yi
 * @version 1.2
 * @since   1.0
 */

package edu.ucalgary.oop;

/**
 * Represents a FamilyRelation between two DisasterVictims
 * 
 * User can get/set relationships
 */
public class FamilyRelation {
   private DisasterVictim personOne;
   private String relationshipTo;
   private DisasterVictim personTwo;

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

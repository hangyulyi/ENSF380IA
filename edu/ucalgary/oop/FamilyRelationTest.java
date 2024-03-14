package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class FamilyRelationTest {
   private DisasterVictim personOne = new DisasterVictim("John", "2024-01-19", 30);
   private DisasterVictim personTwo = new DisasterVictim("Jane", "2024-01-25", 30);
   private String relationshipTo = "sibling";
   private FamilyRelation testFamilyRelationObject = new FamilyRelation(personOne, relationshipTo, personTwo);

   @Test
   public void testObjectCreation() {
      assertNotNull(testFamilyRelationObject);
   }

   @Test
   public void testSetAndGetPersonOne() {
      DisasterVictim newPersonOne = new DisasterVictim("New", "2024-03-21", 30);
      testFamilyRelationObject.setPersonOne(newPersonOne);
      assertEquals("setPersonOne should update personOne", newPersonOne, testFamilyRelationObject.getPersonOne());
   }

   @Test
   public void testSetAndGetPersonTwo() {
      DisasterVictim newPersonTwo = new DisasterVictim("Testing", "2024-01-31", 12);
      testFamilyRelationObject.setPersonTwo(newPersonTwo);
      assertEquals("setPersonTwo should update personTwo", newPersonTwo, testFamilyRelationObject.getPersonTwo());
   }

   @Test
   public void testSetAndGetRelationshipTo() {
      String newRelationship = "parent";
      testFamilyRelationObject.setRelationshipTo(newRelationship);
      assertEquals("setRelationshipTo should update the relationship", newRelationship, testFamilyRelationObject.getRelationshipTo());
   }
}

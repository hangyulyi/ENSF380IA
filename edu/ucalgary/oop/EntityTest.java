package edu.ucalgary.oop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EntityTest {

   private String first;
   private String last;

   @Before
   public void setUp() {
      first = "John";
      last = "Bob";
   }

   @Test
   public void testEntityConstructorFirstName() {
      Entity entity = new Entity(first);

      assertEquals(first, entity.getFirstName());
      assertEquals(null, entity.getLastName());
   }

   @Test
   public void testEntityConstructorFullName() {
      Entity entity = new Entity(first, last);

      assertEquals(first, entity.getFirstName());
      assertEquals(last, entity.getLastName());
   }

   @Test
   public void testSetAndGetFirstName() {
      Entity entity = new Entity("Bob");
      String newFirst = "Billy";

      entity.setFirstName(newFirst);
      assertEquals(newFirst, entity.getFirstName());
   }

   @Test
   public void testSetAndGetLastName() {
      Entity entity = new Entity(first, last);
      String newLast = "Last";
      entity.setLastName(newLast);
      assertEquals(newLast, entity.getLastName());
   }
}

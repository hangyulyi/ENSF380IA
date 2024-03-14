package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class DisasterVictimTest {
   private DisasterVictim victimAge;
   private DisasterVictim victimBirth;
   private List<Supply> suppliesToSet;
   
   private String EXPECTED_ENTRY_DATE = "2024-01-18";
   private String validDate = "2024-01-15";
   private String invalidDate = "15/13/2024";
   private String expectedComments = "Needs medical attention";

   @Before
   public void setUp() {
      victimAge = new DisasterVictim("John", "2024-03-13", 30);
      victimAge.loadGenderOptions("GenderOptions.txt");
      victimBirth = new DisasterVictim("Jane", "2024-03-13", "1999-01-19");

      suppliesToSet = new ArrayList<>();
      suppliesToSet.add(new Supply("Water Bottle", 10));
      suppliesToSet.add(new Supply("Blanket", 5));
   }

   @Test(expected = IllegalArgumentException.class)
   public void testSetDateOfBirthWithInvalidFormat() {
      victimBirth.setDateOfBirth(invalidDate); // should cause exception
   }

   @Test
   public void testSetDateOfBirth() {
      String newDateOfBirth = validDate;
      victimBirth.setDateOfBirth(newDateOfBirth);
      assertEquals("setDateOfBirth should correctly update", newDateOfBirth, victimBirth.getDateOfBirth());
   }

   @Test
   public void testGetComments() {
      victimBirth.setComments(expectedComments);
      assertEquals("get Comments should return correct comments", expectedComments, victimBirth.getComments());
   }


   @Test
   public void testSetAndGetGender() {
      String expectedGender = "girl";
      victimAge.setGender(expectedGender);
      assertEquals("getGender should return correct gender", expectedGender, victimAge.getGender());
   }
}

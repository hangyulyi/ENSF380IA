/**
 * @author  Hangyul Yi
 * @version 1.3
 * @since   1.0
 */

package edu.ucalgary.oop;

import java.util.*;
import java.io.*;

public class DisasterVictim extends Entity {
   enum DietaryRestrictions {
      AVML,
      DBML,
      GFML,
      KSML,
      LSML,
      MOML,
      PFML,
      VGML,
      VJML
   }

   private DietaryRestrictions dietaryRestriction;

   private String dateOfBirth;
   private int approxAge;
   private String gender;
   private static List<String> genderOptions;
   private String comments;
   private int ASSIGNED_SOCIAL_ID;
   private ArrayList<MedicalRecord> medicalRecords;
   private Map<DisasterVictim, Set<FamilyRelation>> familyConnections;

   private String ENTRY_DATE;
   private ArrayList<Supply> personalBelongings;
   private static int counter;
   private static final String DATE_FORMAT_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

   /**
    * Constructor with approxAge
    * @param firstName
    * @param ENTRY_DATE
    * @param approxAge
    * @throws IllegalArgumentException
    */
   public DisasterVictim(String firstName, String ENTRY_DATE, int approxAge) throws IllegalArgumentException {
      super(firstName);
      this.approxAge = approxAge;
      if(ENTRY_DATE.matches(DATE_FORMAT_REGEX)) { this.ENTRY_DATE = ENTRY_DATE; }
      else {
         throw new IllegalArgumentException("Invalid date format. Should be in YYYY-MM-DD");
      }
      this.personalBelongings = new ArrayList<>();
      this.medicalRecords = new ArrayList<>();
      this.familyConnections = new HashMap<>();
      this.ASSIGNED_SOCIAL_ID = counter;
      counter++;

      loadGenderOptions("edu/ucalgary/oop/GenderOptions.txt");
   }

   /**
    * Constructor with dateOfBirth
    * @param firstName
    * @param ENTRY_DATE
    * @param dateOfBirth
    * @throws IllegalArgumentException
    */
   public DisasterVictim(String firstName, String ENTRY_DATE, String dateOfBirth) throws IllegalArgumentException {
      super(firstName);
      this.dateOfBirth = dateOfBirth;
      if (ENTRY_DATE.matches(DATE_FORMAT_REGEX)) { this.ENTRY_DATE = ENTRY_DATE; }
      else {
         throw new IllegalArgumentException("Invalid date format. Should be in YYYY-MM-DD");
      }
      this.personalBelongings = new ArrayList<>();
      this.medicalRecords = new ArrayList<>();
      this.familyConnections = new HashMap<>();
      this.ASSIGNED_SOCIAL_ID = counter;
      counter++;

      loadGenderOptions("edu/ucalgary/oop/GenderOptions.txt");
   }

   /**
    * Constructor for if both age and date of birth was provided
    * @param firstName
    * @param ENTRY_DATE
    * @param age
    * @param birth
    * @throws IllegalArgumentException
    */
   public DisasterVictim(String firstName, String ENTRY_DATE, int age, String birth) throws IllegalArgumentException {
      super(firstName);
      throw new IllegalArgumentException("Only age or date of birth should be provided, not both");
   }

   /* Setters */
   // Make sure date of birth is in correct format of YYYY-MM-DD
   public void setDateOfBirth(String dob) throws IllegalArgumentException {
      if(dob.matches(DATE_FORMAT_REGEX)) {
         this.dateOfBirth = dob;
         return;
      }
      throw new IllegalArgumentException("Date not in correct format, YYYY-MM-DD.");
   }

   public void setComments(String comments) {
      this.comments = comments;
   }

   public void setApproxAge(int approxAge) {
      this.approxAge = approxAge;
   }

   public void setMedicalRecords(MedicalRecord[] medicalRecords) {
      this.medicalRecords.addAll(Arrays.asList(medicalRecords));
   }

   public void setFamilyConnections(Map<DisasterVictim, Set<FamilyRelation>> familyConnections) {
      this.familyConnections = familyConnections;
   }

   public void setDietaryRestriction(DietaryRestrictions dietaryRestriction) {
      this.dietaryRestriction = dietaryRestriction;
   }

   // Make sure gender is in the list of options from the file
   public void setGender(String gender) throws IllegalArgumentException {
      boolean isValid = false;
      for (String option : genderOptions) {
         if (option.equalsIgnoreCase(gender.trim())) {
            isValid = true;
            break;
         }
      }

      if (isValid) {
         this.gender = gender;
      } else {
         throw new IllegalArgumentException("Gender option not included in the list");
      }
   }

   /* Getters */
   public String getDateOfBirth() { return this.dateOfBirth; }
   public int getApproxAge() { return this.approxAge; }
   public String getComments() { return this.comments; }
   public String getEntryDate() { return this.ENTRY_DATE; }
   public int getAssignedSocialID() { return this.ASSIGNED_SOCIAL_ID; }
   public String getGender() { return gender; }
   public static List<String> getGenderOptions() {
      return genderOptions;
   }
   public List<Supply> getPersonalBelongings() { return personalBelongings; }

   public DietaryRestrictions getDietaryRestrictions() { 
      return dietaryRestriction; 
   }

   public Set<FamilyRelation> getFamilyConnections() {
      Set<FamilyRelation> connections = new HashSet<>();
      for (Set<FamilyRelation> relations : familyConnections.values()) {
         connections.addAll(relations);
      }
      return connections;
   }

   /**
    * This method will add FamilyRelation to this DisasterVictim
    * @param relative
    * @param relationshipTo
    */
   public void addFamilyConnection(DisasterVictim relative, String relationshipTo) {
      FamilyRelation newRelation = new FamilyRelation(this, relationshipTo, relative);

      Set<FamilyRelation> relations = familyConnections.getOrDefault(relative, new HashSet<>());

      if(!relations.contains(newRelation)) {
         relations.add(newRelation);
         familyConnections.put(this, relations);
      }

      Set<FamilyRelation> reverseRelations = familyConnections.getOrDefault(this, new HashSet<>());
      reverseRelations.add(new FamilyRelation(relative, relationshipTo, this));

      familyConnections.put(this, reverseRelations);
   }

   /**
    * This method will retrieve the set of family relations and check if the given familyRelation is present in the set and if found, remove from the set.
    * @param familyRelation
    */
   public void removeFamilyConnection(FamilyRelation familyRelation) {
      DisasterVictim victim1 = familyRelation.getPersonOne();
      DisasterVictim victim2 = familyRelation.getPersonTwo();

      // remove relations from the first victim
      Set<FamilyRelation> victim1Relations = familyConnections.getOrDefault(victim1, new HashSet<>());
      victim1Relations.remove(familyRelation);
      familyConnections.put(victim1, victim1Relations);

      Set<FamilyRelation> victim2Relations = familyConnections.getOrDefault(victim2, new HashSet<>());
      victim2Relations.remove(familyRelation);
      familyConnections.put(victim2, victim2Relations);
   }

   /**
    * Method to add a supply to personal belongings
    * @param supply
    */
   public void addSupply(Supply supply) {
      personalBelongings.add(supply);
   }

   /**
    * Method to remove a supply from personal belongings
    * @param supply
    */
   public void removeSupply(Supply supply) {
      personalBelongings.remove(supply);
   }

   /**
    * This method will read a file and throw exception if not able to be read
    * @param filename
    */
   public static List<String> loadGenderOptions(String filename) {
      genderOptions = new ArrayList<>();
      try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
         String line;
         while ((line = reader.readLine()) != null) {
            genderOptions.add(line.trim());
         }
         
      } catch (IOException e) {
         System.err.println("Error reading file: " + e.getMessage());
      }
      return genderOptions;
   }
}

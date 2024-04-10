/**
 * @author  Hangyul Yi
 * @version 1.4
 * @since   1.0
 */

package edu.ucalgary.oop;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.*;

import edu.ucalgary.oop.DisasterVictim.DietaryRestrictions;

import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.*;

public class DisasterVictimGUI extends JFrame implements ActionListener, MouseListener {
   private ArrayList<DisasterVictim> disasterVictims;
   private JList<String> victimList;

   private DefaultListModel<String> listModel;

   private JTextField fnInput, lnInput, entryInput, ageOrDOBInput;
   private JComboBox<String> genderComboBox;
   private JComboBox<DietaryRestrictions> dietComboBox;
   private JTextArea commentInput;
   private JTextArea medicalRecordsTextArea;
   private JTextField relativeInput, relationshipInput;
   private JButton addFamilyConnectionButton;


   private JLabel fnLabel;
   private JLabel lnLabel;
   private JLabel entryLabel;
   private JLabel ageOrDOBLabel;
   private JLabel genderLabel;
   private JLabel dietLabel;
   private JLabel commentLabel;
   private JCheckBox dietCheckBox;

   private JLabel instructions;
   private JButton submitButton;


   private JPanel cardPanel;
   private CardLayout cardLayout;

   public DisasterVictimGUI(){
      disasterVictims = new ArrayList<>();
      
      setTitle("Disaster Victim");
      setSize(600, 700);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      cardLayout = new CardLayout();
      cardPanel = new JPanel(cardLayout);
      add(cardPanel, BorderLayout.CENTER);

      createHomePage();
      createAddVictimPage();
      createEditVictimPage();
      createReliefServicePage();

      showHomePage();
      setVisible(true);
   }

   /**
    * Create Victim Info Panel that displays all information user can edit on a Disaster Victim
    */
   private JPanel VictimInfoPanel() {
      fnLabel = new JLabel("First name:");
      lnLabel = new JLabel("Last Name:");
      entryLabel = new JLabel("Entry Date:");
      ageOrDOBLabel = new JLabel("Age / Date of birth:");
      genderLabel = new JLabel("Gender:");
      dietLabel = new JLabel("Dietary Restrictions:");
      commentLabel = new JLabel("Additional comments:");

      dietCheckBox = new JCheckBox();
      dietCheckBox.addActionListener(e -> dietComboBox.setEnabled(dietCheckBox.isSelected()));

      fnInput = new JTextField(10);
      lnInput = new JTextField(10);
      entryInput = new JTextField(10);
      ageOrDOBInput = new JTextField(10);
      genderComboBox = new JComboBox<>();
      dietComboBox = new JComboBox<>(DietaryRestrictions.values());
      commentInput = new JTextArea(5, 10);
      medicalRecordsTextArea = new JTextArea(5, 10);
      relativeInput = new JTextField(10);
      relationshipInput = new JTextField(10);
      addFamilyConnectionButton = new JButton("Add Family Connection");  

      JPanel headerPanel = new JPanel(new BorderLayout());
      headerPanel.add(new JLabel("Disaster Victim Information"), BorderLayout.CENTER);

      JPanel inputPanel = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.anchor = GridBagConstraints.WEST;
      gbc.insets = new Insets(5, 5, 5, 5);
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 2;

      // Add labels and inputs for basic victim info
      gbc.gridwidth = 1;

      gbc.gridy++;
      inputPanel.add(fnLabel, gbc);
      gbc.gridy++;
      inputPanel.add(lnLabel, gbc);
      gbc.gridy++;
      inputPanel.add(entryLabel, gbc);
      gbc.gridy++;
      inputPanel.add(ageOrDOBLabel, gbc);
      gbc.gridy++;
      inputPanel.add(genderLabel, gbc);
      gbc.gridy++;
  
      inputPanel.add(dietLabel, gbc);
      gbc.gridy++;
      inputPanel.add(commentLabel, gbc);

      gbc.gridx = 1;
      gbc.gridy = 1;
      inputPanel.add(fnInput, gbc);
      gbc.gridy++;
      inputPanel.add(lnInput, gbc);
      gbc.gridy++;
      inputPanel.add(entryInput, gbc);
      gbc.gridy++;
      inputPanel.add(ageOrDOBInput, gbc);
      gbc.gridy++;
      
      inputPanel.add(genderComboBox, gbc);
      gbc.gridy++;
      inputPanel.add(dietCheckBox, gbc);
      gbc.gridx++;
      dietComboBox.setEnabled(false);
      inputPanel.add(dietComboBox, gbc);
      gbc.gridy++;
      gbc.gridx--;
      gbc.fill = GridBagConstraints.BOTH;
      inputPanel.add(new JScrollPane(commentInput), gbc);


      // Add labels and inputs for medical records
      gbc.gridy++;
      gbc.gridx = 0;
      inputPanel.add(new JLabel("Medical Records:"), gbc);
      gbc.gridx++;
      inputPanel.add(new JScrollPane(medicalRecordsTextArea), gbc);

      // Add labels and inputs for family connections
      gbc.gridy++;
      gbc.gridx = 0;
      inputPanel.add(new JLabel("Relative Name:"), gbc);
      gbc.gridx++;
      inputPanel.add(relativeInput, gbc);
      gbc.gridy++;
      gbc.gridx = 0;
      inputPanel.add(new JLabel("Relationship To:"), gbc);
      gbc.gridx++;
      inputPanel.add(relationshipInput, gbc);
      gbc.gridy++;
      gbc.gridx = 0;
      gbc.gridwidth = 2;
      inputPanel.add(addFamilyConnectionButton, gbc);
      addFamilyConnectionButton.addActionListener(this);

      loadGenderOptions();

      return inputPanel;
   }

   /**
    * Load Gender Combo Box with options indicated in file
   */
   private void loadGenderOptions() {
      List<String> genderOptions = DisasterVictim.loadGenderOptions("edu/ucalgary/oop/GenderOptions.txt");
      for (String option : genderOptions) {
         genderComboBox.addItem(option);
      }
   }

   /**
    * Initial Home Page
    * User can add a new disaster victim or navigate to relief services
    */
   private void createHomePage(){
      JPanel homePage = new JPanel();
      homePage.setLayout(new BoxLayout(homePage, BoxLayout.Y_AXIS));
      homePage.setAlignmentX(Component.CENTER_ALIGNMENT);

      homePage.add(Box.createVerticalStrut(50));

      JLabel titleLabel = new JLabel("Disaster Victim Management System");
      titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      homePage.add(titleLabel);

      homePage.add(Box.createVerticalStrut(20));

      JPanel buttonsPanel = new JPanel();
      buttonsPanel.setLayout(new GridLayout(2, 2));
      JButton addVictimButton = new JButton("Add new Disaster Victim");
      JButton reliefServicesButton = new JButton("Relief Services");
      JButton editVictimButton = new JButton("Edit Disaster Victim information");

      addVictimButton.addActionListener(this);
      reliefServicesButton.addActionListener(this);
      editVictimButton.addActionListener(this);
      
      buttonsPanel.add(addVictimButton);
      buttonsPanel.add(reliefServicesButton);
      buttonsPanel.add(editVictimButton);

      homePage.add(buttonsPanel);

      cardPanel.add(homePage, "homePage");
   }

   /**
    * Add new Disaster Victim Page
    */
   private void createAddVictimPage() {
      JPanel addVictimPage = new JPanel((new BorderLayout()));
      addVictimPage.add(new JLabel("Add new Disaster Victim Page"));

      cardPanel.add(addVictimPage, "addVictimPage");

      JPanel victimInfoPanel = VictimInfoPanel();
      addVictimPage.add(victimInfoPanel, BorderLayout.CENTER);

      instructions = new JLabel("<html><div style='text-align: left;'>Please enter the Disaster Victim information.<br/>The following information is necessary: First name, Age/DOB, Entry Date.</div></html>");

      submitButton = new JButton("Add");
      submitButton.addActionListener(this);
      
      // GUI layout
      JPanel headerPanel = new JPanel(new BorderLayout());
      headerPanel.add(Box.createVerticalStrut(50), BorderLayout.NORTH);

      JPanel submitPanel = new JPanel();
      submitPanel.setLayout(new FlowLayout());

      instructions.setHorizontalAlignment(SwingConstants.LEFT);
      headerPanel.add(instructions, BorderLayout.CENTER);

      // go back button
      JButton backButton = new JButton("Back");
      backButton.addActionListener(e -> cardLayout.show(cardPanel, "homePage"));
      submitPanel.add(backButton);

      submitPanel.add(submitButton);

      addVictimPage.add(headerPanel, BorderLayout.NORTH);
      addVictimPage.add(submitPanel, BorderLayout.SOUTH);

      cardPanel.add(addVictimPage, "addVictimPage");
   }

   /**
    * Edit an existing Victim information
    */
   private void createEditVictimPage() {
      JPanel editVictimPage = new JPanel(new BorderLayout());

      JButton saveButton = new JButton("Save");
      
      DefaultListModel<String> listModel = new DefaultListModel<>();
      for (DisasterVictim victim : disasterVictims) {
         listModel.addElement(victim.getFirstName());
      }

      victimList = new JList<>(listModel);
      victimList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      victimList.addListSelectionListener(e -> {
         if (!e.getValueIsAdjusting()) {
            int selectedIndex = victimList.getSelectedIndex();
            if (selectedIndex != -1) {
                  DisasterVictim selectedVictim = disasterVictims.get(selectedIndex);
                  JPanel editInfoPanel = VictimInfoPanel();

                  editVictimPage.add(editInfoPanel, BorderLayout.CENTER);
                  populateVictimInfo(selectedVictim);
                  saveButton.addActionListener(saveEvent -> updateVictimInformation(selectedVictim));
                  cardLayout.show(cardPanel, "editVictimInfoPage");
            }
         }
      });

      JScrollPane scrollPane = new JScrollPane(victimList);

      JButton backButton = new JButton("Back");
      backButton.addActionListener(e -> cardLayout.show(cardPanel, "homePage"));

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(backButton);
      buttonPanel.add(saveButton);

      editVictimPage.add(scrollPane,BorderLayout.WEST);
      editVictimPage.add(buttonPanel, BorderLayout.SOUTH);

      cardPanel.add(editVictimPage, "editVictimPage");
   }

   /**
    * Populate input fields with information of selected Disaster Victim.
    * @param victim
    */
   private void populateVictimInfo(DisasterVictim victim) {
      fnInput.setText(victim.getFirstName());
      lnInput.setText(victim.getLastName());
      entryInput.setText(victim.getEntryDate());
      
      if(victim.getDateOfBirth() != null) {
         ageOrDOBInput.setText(victim.getDateOfBirth());
      }
      else {
         ageOrDOBInput.setText(String.valueOf(victim.getApproxAge()));
      }

      genderComboBox.setSelectedItem(victim.getGender());
      commentInput.setText(victim.getComments());
      if(victim.getDietaryRestrictions() != null) {
         dietCheckBox.setSelected(true);
         dietComboBox.setSelectedItem(victim.getDietaryRestrictions());
      }
   }

   private void updateVictimInformation(DisasterVictim victim) {
      String first = fnInput.getText();
      String last = lnInput.getText().isEmpty() ? null : lnInput.getText();
      String entryDate = entryInput.getText();
      String ageOrDOB = ageOrDOBInput.getText();
      String gender = (String) genderComboBox.getSelectedItem();
      String comment = commentInput.getText().isEmpty() ? null : commentInput.getText();
      String medRecords = medicalRecordsTextArea.getText();


      // checkbox indicates if user has dietary restrictions or not
      DietaryRestrictions diet = null;
      if (dietCheckBox.isSelected()) {
         diet = (DietaryRestrictions) dietComboBox.getSelectedItem();
      }
      
      System.out.println("First Name: " + first);
      System.out.println("Last Name: " + last);
      System.out.println("Entry Date: " + entryDate);
      System.out.println("Age/DOB: " + ageOrDOB);
      System.out.println("Gender: " + gender);
      System.out.println("Comment: " + comment);
      System.out.println("Diet: " + diet);

      // is age
      if(isValidAge(ageOrDOB)) {
         int age = Integer.parseInt(ageOrDOB);
         victim.setApproxAge(age);;
      }
      else {
         victim.setDateOfBirth(ageOrDOB);
      }

      victim.setLastName(last);
      victim.setGender(gender);
      victim.setDietaryRestriction(diet);
      victim.setComments(comment);
      
      if(!medRecords.isEmpty()) {
         setMedicalRecordsFromInput(medRecords, victim);
      }
      
      // Update the list model
      DefaultListModel<String> listModel = new DefaultListModel<>();
      for (DisasterVictim existingVictim : disasterVictims) {
         listModel.addElement(existingVictim.getFirstName());
      }

      // Set the updated model to the JList
      victimList.setModel(listModel);

      // Notify the JList that elements were added
      int lastIndex = listModel.size() - 1;
      if (lastIndex >= 0) {
         victimList.ensureIndexIsVisible(lastIndex);
      }
   }

   /**
    * Create ReliefServicePage by referring to ReliefServiceGUI.java
    */
   private void createReliefServicePage() {
      ReliefServiceGUI reliefServiceGUI = new ReliefServiceGUI(this);
      cardPanel.add(reliefServiceGUI, "reliefServiceGUI");
   }

   /**
    * Create a DisasterVictim with information input on the GUI.
    * Adds the DisasterVictim to a local list. Future good modification will be to implement a database for this.
    */
   private void createDisasterVictim() {

      String first = fnInput.getText();
      String last = lnInput.getText().isEmpty() ? null : lnInput.getText();
      String entryDate = entryInput.getText();
      String ageOrDOB = ageOrDOBInput.getText();
      String gender = (String) genderComboBox.getSelectedItem();
      String comment = commentInput.getText().isEmpty() ? null : commentInput.getText();
      String medRecords = medicalRecordsTextArea.getText();


      // checkbox indicates if user has dietary restrictions or not
      DietaryRestrictions diet = null;
      if (dietCheckBox.isSelected()) {
         diet = (DietaryRestrictions) dietComboBox.getSelectedItem();
      }
      
      System.out.println("First Name: " + first);
      System.out.println("Last Name: " + last);
      System.out.println("Entry Date: " + entryDate);
      System.out.println("Age/DOB: " + ageOrDOB);
      System.out.println("Gender: " + gender);
      System.out.println("Comment: " + comment);
      System.out.println("Diet: " + diet);
      

      DisasterVictim victim;

      // is age
      if(isValidAge(ageOrDOB)) {
         int age = Integer.parseInt(ageOrDOB);
         victim = new DisasterVictim(first, entryDate, age);
      }
      else {
         victim = new DisasterVictim(first, entryDate, ageOrDOB);
      }

      victim.setLastName(last);
      victim.setGender(gender);
      victim.setDietaryRestriction(diet);
      victim.setComments(comment);
      
      if(!medRecords.isEmpty()) {
         setMedicalRecordsFromInput(medRecords, victim);
      }

      disasterVictims.add(victim);
      
      // Update the list model
      DefaultListModel<String> listModel = new DefaultListModel<>();
      for (DisasterVictim existingVictim : disasterVictims) {
         listModel.addElement(existingVictim.getFirstName());
      }

      // Set the updated model to the JList
      victimList.setModel(listModel);

      // Notify the JList that elements were added
      int lastIndex = listModel.size() - 1;
      if (lastIndex >= 0) {
         victimList.ensureIndexIsVisible(lastIndex);
      }
    
   }

   /**
    * Used to determine if input is an age or date of birth by parsing as int.
    * @param ageOrDOB
    * @return
    */
   private boolean isValidAge(String ageOrDOB) {
      try {
         int age = Integer.parseInt(ageOrDOB);
         return age >= 0 && age <= 150;
      } catch (NumberFormatException e) {
         return false;
      }
   }

   /**
    * Sets Medical Records if input for Disaster Victim
    * @param inputText
    * @param victim
    */
   private void setMedicalRecordsFromInput(String inputText, DisasterVictim victim) {
      String[] recordsText = inputText.split("\\r?\\n");
      ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();

      for (String recordText : recordsText) {
         String[] parts = recordText.split(", ");
         if (parts.length == 3) {
            String locationString = parts[0].trim();
            String treatmentDetails = parts[1].trim();
            String dateOfTreatment = parts[2].trim();

            try {
               MedicalRecord record = new MedicalRecord(new Location(locationString, null), treatmentDetails, dateOfTreatment);
               medicalRecords.add(record);
            } catch (IllegalArgumentException e) {
               System.err.println("Failed to create MedicalRecord: " + e.getMessage());
            }
         } else {
            System.err.println("Invalid format for medical record: " + recordText);
         }
      }

      victim.setMedicalRecords(medicalRecords);
   }

   /**
    * Used to show Add Victim Page
    */
   private void showAddVictimPage() {
      cardLayout.show(cardPanel, "addVictimPage");
   }

   public void showHomePage() {
      cardLayout.show(cardPanel, "homePage");
   }

   private void showEditVictimPage() {
      cardLayout.show(cardPanel, "editVictimPage");
   }


   /**
    * Manage Action Listener for when buttons are
    */
   public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("Add new Disaster Victim")) {
         showAddVictimPage();
      }
      else if (e.getActionCommand().equals("Relief Services")) {
         cardLayout.show(cardPanel, "reliefServiceGUI");
      }
      else if (e.getActionCommand().equals("Edit Disaster Victim information")) {
         showEditVictimPage();
      }
      else if (e.getSource().equals(submitButton)) {
         validateInput();
         if(validateInput()) {
            createDisasterVictim();
            resetFields();
         }  
      }
      
   }

   /**
    * Used to reset input fields to blank.
    */
   public void resetFields() {
      fnInput.setText("");
      lnInput.setText("");
      entryInput.setText("");
      ageOrDOBInput.setText("");
      dietCheckBox.setSelected(false);
      commentInput.setText("");
      medicalRecordsTextArea.setText("");
      relativeInput.setText("");
      relationshipInput.setText("");
   }

   /**
    * Ensure all input values are valid.
    * Make sure first name, entry date, and age/DOB are filled
    * @return boolean value
    */
   private boolean validateInput() {
      try {
         String first = fnInput.getText();
         if (first.isEmpty()) {
            throw new IllegalArgumentException("First name is required.");
         }

         String ageOrDOB = ageOrDOBInput.getText();
         if (ageOrDOB.isEmpty()) {
            throw new IllegalArgumentException("Age or Date of birth is required.");
         }

         String entryDate = entryInput.getText();
         if (entryDate.isEmpty()) {
            throw new IllegalArgumentException("Entry Date is required (YYYY-MM-DD).");
         }

         return true;
      } catch (IllegalArgumentException e) {
         JOptionPane.showMessageDialog(this, e.getMessage());
      }

      return false;
   }
   
   public void mouseClicked(MouseEvent e) {}
   public void mouseEntered(MouseEvent event){}
   public void mouseExited(MouseEvent event){}
   public void mousePressed(MouseEvent event){}
   public void mouseReleased(MouseEvent event){}

   public static void main(String[] args) {
      SwingUtilities.invokeLater(DisasterVictimGUI::new);
   }
}

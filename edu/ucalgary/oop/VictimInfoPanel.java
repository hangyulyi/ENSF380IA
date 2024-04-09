package edu.ucalgary.oop;

import javax.swing.*;

import edu.ucalgary.oop.DisasterVictim.DietaryRestrictions;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VictimInfoPanel extends JPanel {
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

   public VictimInfoPanel() {
      initComponents();
      layoutComponents();
   }

   private void initComponents() {
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
   }

   private void layoutComponents() {
      setLayout(new BorderLayout());

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

      // Add inputPanel and headerPanel to this panel
      add(headerPanel, BorderLayout.NORTH);
      add(inputPanel, BorderLayout.CENTER);

      loadGenderOptions();
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

   public void updateVictimList(ArrayList<DisasterVictim> victims) {
      listModel.clear();
      for (DisasterVictim victim : victims) {
         listModel.addElement(victim.getFirstName());
      }
   }

   /**
    * Getters
    */

   public DisasterVictim getSelectedVictim() {
      int selectedIndex = victimList.getSelectedIndex();
      if (selectedIndex != -1) {

      }
      return null;
   }

   public String getFnInput() {
      return fnInput.getText();
   }

   public String getLnInput() {
      return lnInput.getText();
   }

   public String getEntryInput() {
      return entryInput.getText();
   }

   public String getAgeOrDOBInput() {
      return ageOrDOBInput.getText();
   }

   public String getSelectedGender() {
      return (String) genderComboBox.getSelectedItem();
   }

   public boolean isDietSelected() {
      return dietCheckBox.isSelected();
   }

   public DietaryRestrictions getSelectedDiet() {
      return isDietSelected() ? (DietaryRestrictions) dietComboBox.getSelectedItem() : null;
   }

   public String getCommentInput() {
      return commentInput.getText();
   }

   public String getMedicalRecordsTextArea() {
      return medicalRecordsTextArea.getText();
   }

   public String getRelativeInput() {
      return relativeInput.getText();
   }

   public String getRelationshipInput() {
      return relationshipInput.getText();
   }

   public JButton getAddFamilyConnectionButton() {
      return addFamilyConnectionButton;
   }

   /* Setters */
   public void setFnInput(String text) {
      fnInput.setText(text);
   }

   public void setLnInput(String text) {
      lnInput.setText(text);
   }

   public void setEntryInput(String text) {
      entryInput.setText(text);
   }

   public void setAgeOrDOBInput(String text) {
      ageOrDOBInput.setText(text);
   }

   public void setSelectedGender(String gender) {
      genderComboBox.setSelectedItem(gender);
   }

   public void setDietSelected(boolean selected) {
      dietCheckBox.setSelected(selected);
   }

   public void setSelectedDiet(DietaryRestrictions diet) {
      dietComboBox.setSelectedItem(diet);
   }

   public void setCommentInput(String text) {
      commentInput.setText(text);
   }

   public void setMedicalRecordsTextArea(String text) {
      medicalRecordsTextArea.setText(text);
   }

   public void setRelativeInput(String text) {
      relativeInput.setText(text);
   }

   public void setRelationshipInput(String text) {
      relationshipInput.setText(text);
   }
}

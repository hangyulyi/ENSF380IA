/**
 * @author  Hangyul Yi
 * @version 1.2
 * @since   1.0
 */

package edu.ucalgary.oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;

import edu.ucalgary.oop.DisasterVictim.DietaryRestrictions;

import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.*;

public class DisasterVictimGUI extends JFrame implements ActionListener, MouseListener {

   private JLabel instructions;
   private JLabel fnLabel;
   private JLabel lnLabel;
   private JLabel entryLabel;
   private JLabel ageOrDOBLabel;
   private JLabel genderLabel;
   private JLabel dietLabel;
   private JLabel commentLabel;

   private JTextField fnInput;
   private JTextField lnInput;
   private JTextField entryInput;
   private JTextField ageOrDOBInput;
   private JComboBox<DietaryRestrictions> dietComboBox;
   private JComboBox<String> genderComboBox;
   private JTextArea commentInput;
   private JButton submitButton;

   // Database connection


   public DisasterVictimGUI(){
      setTitle("Disaster Victim");
      setSize(500, 550);

      instructions = new JLabel("<html><div style='text-align: left;'>Please enter the Disaster Victim information.<br/>The following information is necessary: First name, Age/DOB, Entry Date.</div></html>");
      fnLabel = new JLabel("First name:");
      lnLabel = new JLabel("Last Name:");
      entryLabel = new JLabel("Entry Date:");
      ageOrDOBLabel = new JLabel("Age / Date of birth:");
      genderLabel = new JLabel("Gender:");
      dietLabel = new JLabel("Dietary Restrictions:");
      commentLabel = new JLabel("Additional comments:");

      fnInput = new JTextField(10);
      lnInput = new JTextField(10);
      entryInput = new JTextField(10);
      ageOrDOBInput = new JTextField(10);
      genderComboBox = new JComboBox<>();
      dietComboBox = new JComboBox<>(DietaryRestrictions.values());
      commentInput = new JTextArea(5, 10);

      fnInput.addMouseListener(this);
      lnInput.addMouseListener(this);
      entryInput.addMouseListener(this);
      ageOrDOBInput.addMouseListener(this);
      commentInput.addMouseListener(this);

      submitButton = new JButton("Add");
      submitButton.addActionListener(this);

      JPanel headerPanel = new JPanel();
      headerPanel.setLayout(new FlowLayout());

      JPanel inputPanel = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.anchor = GridBagConstraints.WEST;
      gbc.insets = new Insets(5, 5, 5, 5);
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 2;
      

      JPanel submitPanel = new JPanel();
      submitPanel.setLayout(new FlowLayout());

      headerPanel.add(instructions);
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
      inputPanel.add(dietComboBox, gbc);
      gbc.gridy++;
      gbc.fill = GridBagConstraints.BOTH;
      inputPanel.add(new JScrollPane(commentInput), gbc);

      submitPanel.add(submitButton);

      this.add(headerPanel, BorderLayout.NORTH);
      this.add(inputPanel, BorderLayout.CENTER);
      this.add(submitPanel, BorderLayout.PAGE_END);

      loadGenderOptions();
   }

   /**
    * Load Gender Combo Box with options indicated in file
    */
   private void loadGenderOptions() {
      List<String> genderOptions = DisasterVictim.getGenderOptions();
      for (String option : genderOptions) {
         genderComboBox.addItem(option);
      }
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == submitButton) {
         // Retrieve input from text fields
         // String firstName = fnInput.getText();
         // String entryDate = entryInput.getText();
         // String ageOrDOB = ageOrDOBInput.getText();
         // String gender = (String) genderComboBox.getSelectedItem();
         // DietaryRestrictions dietaryRestriction = (DietaryRestrictions) dietComboBox.getSelectedItem(); // Get selected dietary restriction

         
      }
   }


   
   public void mouseClicked(MouseEvent e) {
      
   }
   public void mouseEntered(MouseEvent event){}
   public void mouseExited(MouseEvent event){}
   public void mousePressed(MouseEvent event){}
   public void mouseReleased(MouseEvent event){}

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         DisasterVictimGUI gui = new DisasterVictimGUI();
         gui.setVisible(true);
      });
   }
}

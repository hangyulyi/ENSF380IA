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

   private JLabel instructions;
   private JButton submitButton;

   private VictimInfoPanel victimInfoPanel;
   private JPanel cardPanel;
   private CardLayout cardLayout;

   public DisasterVictimGUI(){
      disasterVictims = new ArrayList<>();
      
      setTitle("Disaster Victim");
      setSize(500, 700);
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

      victimInfoPanel = new VictimInfoPanel();

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

      addVictimPage.add(victimInfoPanel, BorderLayout.CENTER);

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

      victimInfoPanel = new VictimInfoPanel();
      
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

                  // set existing victim's information in VictimInfoPanel fields
                  victimInfoPanel.setFnInput(selectedVictim.getFirstName());
                  victimInfoPanel.setLnInput(selectedVictim.getLastName());

                  cardLayout.show(cardPanel, "editVictimInfoPage");
            }
         }
      });

      JScrollPane scrollPane = new JScrollPane(victimList);

      JButton backButton = new JButton("Back");
      backButton.addActionListener(e -> cardLayout.show(cardPanel, "homePage"));

      JButton editButton = new JButton("Edit");
      // editButton.addActionListener(e -> updateVictimInformation());

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(backButton);
      buttonPanel.add(editButton);

      editVictimPage.add(buttonPanel, BorderLayout.SOUTH);

      cardPanel.add(editVictimPage, "editVictimPage");
   }

   private void displayVictimInformation(DisasterVictim victim) {

      JTextArea familyConnectionsTextArea = new JTextArea(5, 20);
      familyConnectionsTextArea.setEditable(false);
      JScrollPane familyConnectionsScrollPane = new JScrollPane(familyConnectionsTextArea);

      JTextArea medicalRecordsTextArea = new JTextArea(5, 20);
      medicalRecordsTextArea.setEditable(false);
      JScrollPane medicalRecordsScrollPane = new JScrollPane(medicalRecordsTextArea);

      Set<FamilyRelation> familyConnections = victim.getFamilyConnections();
      StringBuilder familyConnectionsText = new StringBuilder();
      for (FamilyRelation relation : familyConnections) {
         familyConnectionsText.append(relation.toString()).append("\n");
      }
      familyConnectionsTextArea.setText(familyConnectionsText.toString());

      JPanel infoPanel = new JPanel(new GridLayout(2, 1));
      infoPanel.add(familyConnectionsScrollPane);
      infoPanel.add(medicalRecordsScrollPane);

      cardPanel.add(infoPanel, "editVictimInfoPage");
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

      String first = victimInfoPanel.getFnInput();
      String last = victimInfoPanel.getLnInput().isEmpty() ? null : victimInfoPanel.getLnInput();
      String entryDate = victimInfoPanel.getEntryInput();
      String ageOrDOB = victimInfoPanel.getAgeOrDOBInput();
      String gender = victimInfoPanel.getSelectedGender();
      String comment = victimInfoPanel.getCommentInput().isEmpty() ? null : victimInfoPanel.getCommentInput();

      DietaryRestrictions diet = victimInfoPanel.getSelectedDiet();
      
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
         Integer.parseInt(ageOrDOB);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
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
         createDisasterVictim();
      }
      
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

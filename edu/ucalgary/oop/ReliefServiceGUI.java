/**
 * @author  Hangyul Yi
 * @version 1.3
 * @since   1.0
 */
package edu.ucalgary.oop;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ReliefServiceGUI extends JPanel implements ActionListener {
   private CardLayout cardLayout;
   private JPanel cardPanel;

   private DisasterVictimGUI disasterVictimGUI;

   public ReliefServiceGUI(DisasterVictimGUI disasterVictimGUI) {
      this.disasterVictimGUI = disasterVictimGUI; // Store the reference
      setLayout(new GridBagLayout());

      // Title label
      JLabel titleLabel = new JLabel("Relief Services");
      titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally

      // Add titleLabel to this ReliefServiceGUI panel
      GridBagConstraints titleGbc = new GridBagConstraints();
      titleGbc.gridx = 0;
      titleGbc.gridy = 0;
      titleGbc.anchor = GridBagConstraints.PAGE_START; // Place the title at the top
      titleGbc.weighty = 0.2; // Add some vertical space above the title
      add(titleLabel, titleGbc);

      // Create a panel for the buttons
      JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10)); // Two rows, one column
      buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add some padding

      // creating buttons
      JButton newInquiryButton = new JButton("New Inquiry");
      JButton searchPeopleButton = new JButton("Search people");

      // add action listeners
      newInquiryButton.addActionListener(e -> cardLayout.show(cardPanel, "newInquiryPage"));
      searchPeopleButton.addActionListener(e -> searchPeople());

      // Add buttons to buttonPanel
      buttonPanel.add(newInquiryButton);
      buttonPanel.add(searchPeopleButton);

      // Add buttonPanel to this ReliefServiceGUI panel
      GridBagConstraints buttonPanelGbc = new GridBagConstraints();
      buttonPanelGbc.gridx = 0;
      buttonPanelGbc.gridy = 1; // Place the buttonPanel below the title
      buttonPanelGbc.weighty = 0.8; // Fill the remaining vertical space with the buttonPanel
      add(buttonPanel, buttonPanelGbc);

      // go back button
      JButton backButton = new JButton("Back");
      backButton.addActionListener(e -> {
         disasterVictimGUI.showHomePage(); // Use the reference to navigate back
      });
      GridBagConstraints backButtonGbc = new GridBagConstraints();
      backButtonGbc.gridx = 0;
      backButtonGbc.gridy = 2; // Place the backButton below the buttonPanel
      backButtonGbc.anchor = GridBagConstraints.PAGE_END; // Place the backButton at the bottom
      backButtonGbc.weighty = 0.1; // Add some vertical space below the backButton
      add(backButton, backButtonGbc);
   }

   private void searchPeople() {
      
   }
}

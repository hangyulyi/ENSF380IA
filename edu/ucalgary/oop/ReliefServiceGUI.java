package edu.ucalgary.oop;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ReliefServiceGUI extends JPanel implements ActionListener {
   private CardLayout cardLayout;
   private JPanel cardPanel;

   private DisasterVictimGUI disasterVictimGUI;

   public ReliefServiceGUI(DisasterVictimGUI disasterVictimGUI) {
      this.disasterVictimGUI = disasterVictimGUI;
      setLayout(new FlowLayout());

      JLabel titleLabel = new JLabel("Relief Services");
      add(titleLabel);

      cardLayout = new CardLayout();
      cardPanel = new JPanel(cardLayout);

      // creating buttons
      JButton newInquiryButton = new JButton("New Inquiry");
      JButton searchPeopleButton = new JButton("Search people");

      // add action listeners
      newInquiryButton.addActionListener(e -> cardLayout.show(cardPanel, "newInquiryPage"));
      searchPeopleButton.addActionListener(e -> cardLayout.show(cardPanel, "searchPeoplePage"));

      JPanel homePagePanel = new JPanel(new GridLayout(2, 1));
      homePagePanel.add(newInquiryButton);
      homePagePanel.add(searchPeopleButton);

      // go back button
      JButton backButton = new JButton("Back");
      backButton.addActionListener(e -> {
         disasterVictimGUI.showHomePage();
      });
      homePagePanel.add(backButton);

      cardPanel.add(homePagePanel, "homePage");

      add(cardPanel);

      cardLayout.show(cardPanel, "homePage");
   }
}

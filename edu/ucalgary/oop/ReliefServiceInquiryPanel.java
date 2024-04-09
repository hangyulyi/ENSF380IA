package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ReliefServiceInquiryPanel {

   public final String DBURL;
   public final String USERNAME;
   public final String PASSWORD;

   private Connection dbConnect;
   
   private JComboBox<Inquirer> inquirerComboBox;
   private JTextArea interactionLogTextArea;

   public ReliefServiceInquiryPanel() {
      
   }
}

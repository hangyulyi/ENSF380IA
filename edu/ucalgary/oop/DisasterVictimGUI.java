/**
 * @author  Hangyul Yi
 * @version 1.2
 * @since   1.0
 */

package edu.ucalgary.oop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.util.*;

public class DisasterVictimGUI extends JFrame implements ActionListener, MouseListener {

   private JLabel instructions;
   private JLabel fnLabel;
   private JLabel lnLabel;
   private JLabel ageLabel;
   private JLabel dobLabel;
   private JLabel genderLabel;
   private JLabel dietLabel;
   private JLabel commentLabel;

   private JTextField fnInput;
   private JTextField lnInput;
   private JTextField dobInput;
   private JTextField ageInput;
   private JComboBox<String> dietComboBox;
   private JComboBox<String> genderComboBox;
   private JTextArea commentInput;

   // Database connection


   public void setupGUI(){
      instructions = new JLabel("Please enter the Disaster Victim information.");
      fnLabel = new JLabel("First name:");

      List<String> genderOptions = DisasterVictim.getGenderOptions();
   }
}

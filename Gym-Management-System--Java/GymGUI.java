
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class GymGUI {

    private JFrame startMenu, addMembersFrame, methodsFrame;
    private JButton startAddMembersButton, startMethodsButton, regularAddButton, regularClearButton, addPremiumButton, clearPremiumButton, activateButton, deactivateButton, resetButton, MarkButton, DisplayButton, UpgradeButton, regularRevertbutton, displayButton, calculateDiscountButton, resettButton, premiumRevertButton, payButton, saveButton, readFilesButton;
    private JPanel aMainPanel1, aMainPanel2, aTitlePanel1, aTitlePanel2, aFormPanel1, aFormPanel2, regularDobPanel, regularGenderPanel, regularStartDatePanel, premiumDobPanel, premiumGenderPanel, premiumStartDatePanel, regularPanel, premiumPanel, regularTitlePanel, premiumTitlePanel, regularMethodsFormPanel, premiumMethodsFormPanel;
    private JLabel addTitleLabel1, addTitleLabel2, regularIdLabel, regularNameLabel, regularlocationLabel, regularPhoneLabel, regularEmailLabel, regularDobLabel, regularGenderLabel, regularStartDateLabel, regularReferralLabel, premiumIdLabel, premiumNameLabel, premiumLocationLabel, premiumPhoneLabel, premiumEmailLabel, premiumDobLabel, premiumGenderLabel, premiumStartDateLabel, trainerLabel, regulartTitleLabel, regularMethodIdLabel, removalReasonLabel, payLabel;
    private JTextField regularIdField, regularNameField, regularLocationField, regularPhoneField, regularEmailField, regularReferralField, premiumIdField, premiumNameField, premiumLocationField, premiumPhoneField, premiumEmailField, trainerField, regularMethodIdField, payTextField;
    private JComboBox regularDobYear, regularDobMonth, regularDobDay, regularStartYear, regularStartMonth, regularStartDay, premiumDobYear, premiumDobMonth, premiumDobDay, premiumStartYear, premiumStartMonth, premiumStartDay, upgradeComboBox;
    private JRadioButton regularMale, regularFemale, regularOthers, premiumMale, premiumFemale, premiumOthers;
    private JTextArea removalReasonArea;
    private ArrayList<GymMember> arraylist = new ArrayList<>();

    public GymGUI() {
        startMenu = new JFrame("Gym Management");
        startMenu.setBounds(0, 0, 800, 500);
        startMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startMenu.setLayout(new GridLayout(2, 1, 0, 0));

        startAddMembersButton = new JButton("Add Members");
        startAddMembersButton.setBackground(Color.pink);
        startAddMembersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMembersGUI();
            }
        });

        startMethodsButton = new JButton("Access Methods");
        startMethodsButton.setBackground(Color.white);
        startMethodsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                methodsGUI();
            }
        });
        startMenu.add(startAddMembersButton);
        startMenu.add(startMethodsButton);

        startMenu.setVisible(true);
    }

    public void addMembersGUI() {
        addMembersFrame = new JFrame();
        addMembersFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        addMembersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addMembersFrame.setLayout(new GridLayout(1, 2)); // 2 columns for 2 main panels

        // MAIN PANEL 1 - Regular Members
        aMainPanel1 = new JPanel(new BorderLayout());

        aTitlePanel1 = new JPanel(new FlowLayout());
        addTitleLabel1 = new JLabel("Add Regular Member");
        aTitlePanel1.add(addTitleLabel1);

        aFormPanel1 = new JPanel(new GridBagLayout());
        aFormPanel1.setBackground(Color.white);

        GridBagConstraints aGBC = new GridBagConstraints();
        aGBC.insets = new Insets(12, 12, 12, 12);

        regularIdLabel = new JLabel("Id");
        aGBC.gridx = 0;
        aGBC.gridy = 0;
        aFormPanel1.add(regularIdLabel, aGBC);

        regularIdField = new JTextField(30);
        aGBC.gridx = 1;
        aGBC.gridy = 0;
        aFormPanel1.add(regularIdField, aGBC);

        regularNameLabel = new JLabel("Full Name");
        aGBC.gridx = 0;
        aGBC.gridy = 1;
        aFormPanel1.add(regularNameLabel, aGBC);

        regularNameField = new JTextField(30);
        aGBC.gridx = 1;
        aGBC.gridy = 1;
        aFormPanel1.add(regularNameField, aGBC);

        regularlocationLabel = new JLabel("Location");
        aGBC.gridx = 0;
        aGBC.gridy = 2;
        aFormPanel1.add(regularlocationLabel, aGBC);

        regularLocationField = new JTextField(30);
        aGBC.gridx = 1;
        aGBC.gridy = 2;
        aFormPanel1.add(regularLocationField, aGBC);

        regularPhoneLabel = new JLabel("Phone");
        aGBC.gridx = 0;
        aGBC.gridy = 3;
        aFormPanel1.add(regularPhoneLabel, aGBC);

        regularPhoneField = new JTextField(30);
        aGBC.gridx = 1;
        aGBC.gridy = 3;
        aFormPanel1.add(regularPhoneField, aGBC);

        regularEmailLabel = new JLabel("Email");
        aGBC.gridx = 0;
        aGBC.gridy = 4;
        aFormPanel1.add(regularEmailLabel, aGBC);

        regularEmailField = new JTextField(30);
        aGBC.gridx = 1;
        aGBC.gridy = 4;
        aFormPanel1.add(regularEmailField, aGBC);

        // Label
        regularDobLabel = new JLabel("Date of Birth");
        aGBC.gridx = 0;
        aGBC.gridy = 5;
        aFormPanel1.add(regularDobLabel, aGBC);

// Panel to hold 3 dropdowns
        regularDobPanel = new JPanel();
        aGBC.gridx = 1;
        aGBC.gridy = 5;
        aFormPanel1.add(regularDobPanel, aGBC);

// Initialize combo boxes
        regularDobYear = new JComboBox<>();
        regularDobMonth = new JComboBox<>();
        regularDobDay = new JComboBox<>();

// Add years from 2025 to 1980
        for (int i = 2025; i >= 1980; i--) {
            regularDobYear.addItem(String.valueOf(i));
        }

// Add months from 1 to 12
        for (int i = 1; i <= 12; i++) {
            regularDobMonth.addItem(String.valueOf(i));
        }

// Add days from 1 to 31
        for (int i = 1; i <= 31; i++) {
            regularDobDay.addItem(String.valueOf(i));
        }

// Add combo boxes to the panel
        regularDobPanel.add(regularDobYear);
        regularDobPanel.add(regularDobMonth);
        regularDobPanel.add(regularDobDay);

        regularGenderLabel = new JLabel("Gender");
        aGBC.gridx = 0;
        aGBC.gridy = 6;
        aFormPanel1.add(regularGenderLabel, aGBC);

        regularGenderPanel = new JPanel();
        aGBC.gridx = 1;
        aGBC.gridy = 6;

        regularMale = new JRadioButton("Male");
        regularFemale = new JRadioButton("Female");
        regularOthers = new JRadioButton("Others");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(regularMale);
        genderGroup.add(regularFemale);
        genderGroup.add(regularOthers);

        regularGenderPanel.add(regularMale);
        regularGenderPanel.add(regularFemale);
        regularGenderPanel.add(regularOthers);
        aFormPanel1.add(regularGenderPanel, aGBC);

        aFormPanel1.add(regularGenderPanel, aGBC);

        regularStartDateLabel = new JLabel("Membership Start Date");
        aGBC.gridx = 0;
        aGBC.gridy = 7;
        aFormPanel1.add(regularStartDateLabel, aGBC);

        regularStartDatePanel = new JPanel();
        aGBC.gridx = 1;
        aGBC.gridy = 7;
        aFormPanel1.add(regularStartDatePanel, aGBC);

// Initialize combo boxes
        regularStartYear = new JComboBox<>();
        regularStartMonth = new JComboBox<>();
        regularStartDay = new JComboBox<>();

// Add years from 2025 to 1980
        for (int i = 2025; i >= 1980; i--) {
            regularStartYear.addItem(String.valueOf(i));
        }

// Add months from 1 to 12
        for (int i = 1; i <= 12; i++) {
            regularStartMonth.addItem(String.valueOf(i));
        }

// Add days from 1 to 31
        for (int i = 1; i <= 31; i++) {
            regularStartDay.addItem(String.valueOf(i));
        }

// Add combo boxes to the panel
        regularStartDatePanel.add(regularStartYear);
        regularStartDatePanel.add(regularStartMonth);
        regularStartDatePanel.add(regularStartDay);

        regularReferralLabel = new JLabel("Referral Source");
        aGBC.gridx = 0;
        aGBC.gridy = 8;
        aFormPanel1.add(regularReferralLabel, aGBC);

        regularReferralField = new JTextField(30);
        aGBC.gridx = 1;
        aGBC.gridy = 8;
        aFormPanel1.add(regularReferralField, aGBC);

        regularClearButton = new JButton("Clear");
        aGBC.gridx = 0;
        aGBC.gridy = 9;
        regularClearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regularIdField.setText("");
                regularNameField.setText("");
                regularLocationField.setText("");
                regularPhoneField.setText("");
                regularEmailField.setText("");
                regularReferralField.setText("");
                regularDobYear.setSelectedIndex(0);
                regularDobMonth.setSelectedIndex(0);
                regularDobDay.setSelectedIndex(0);

                regularStartYear.setSelectedIndex(0);
                regularStartMonth.setSelectedIndex(0);
                regularStartDay.setSelectedIndex(0);

                regularMale.setSelected(false);
                regularFemale.setSelected(false);
                regularOthers.setSelected(false);

            }
        });
        aFormPanel1.add(regularClearButton, aGBC);

        regularAddButton = new JButton("Add Regular Member");
        aGBC.gridx = 1;
        aGBC.gridy = 9;
        regularAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(regularIdField.getText());
                    String fullname = regularNameField.getText();
                    String location = regularLocationField.getText();
                    String phone = regularPhoneField.getText();
                    String Email = regularEmailField.getText();
                    String dob = regularDobYear.getSelectedItem() + " " + regularDobMonth.getSelectedItem() + " " + regularDobDay.getSelectedItem();
                    String gender = "";

                    if (regularMale.isSelected()) {
                        gender = "Male";
                    } else if (regularFemale.isSelected()) {
                        gender = "Female";
                    } else if (regularOthers.isSelected()) {
                        gender = "Others";
                    }

                    String startDate = regularStartYear.getSelectedItem() + " " + regularStartMonth.getSelectedItem() + " " + regularStartDay.getSelectedItem();
                    String referral = regularReferralField.getText();

                    if (regularIdField.getText().isEmpty() || fullname.isEmpty() || location.isEmpty() || phone.isEmpty() || Email.isEmpty() || dob.isEmpty() || gender.isEmpty() || startDate.isEmpty() || referral.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fill Out all the fields!!!! ", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    for (GymMember member : arraylist) {
                        if (member.getId() == id) {
                            JOptionPane.showMessageDialog(null, "Id already in use!!!", "Error", JOptionPane.ERROR_MESSAGE);
                            return; // Return early if ID is not unique
                        }
                    }

                    RegularMember regularMember = new RegularMember(id, fullname, location, phone, Email, gender, dob, startDate, referral);
                    arraylist.add(regularMember);
                    JOptionPane.showMessageDialog(null, "Member added Successfully", "Successfull", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Input valid ID", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        aFormPanel1.add(regularAddButton, aGBC);

        aMainPanel1.add(aTitlePanel1, BorderLayout.NORTH);
        aMainPanel1.add(aFormPanel1, BorderLayout.CENTER);

        // MAIN PANEL 2 - Premium Members
        aMainPanel2 = new JPanel(new BorderLayout());

        aTitlePanel2 = new JPanel(new FlowLayout());
        addTitleLabel2 = new JLabel("Add Premium Members");
        aTitlePanel2.add(addTitleLabel2);

        aFormPanel2 = new JPanel(new GridLayout());
        aFormPanel2.setLayout(new GridBagLayout());
        GridBagConstraints pGBC = new GridBagConstraints();
        pGBC.insets = new Insets(12, 12, 12, 12);

        // Premium Member Form Setup
        premiumIdLabel = new JLabel("Id");
        pGBC.gridx = 0;
        pGBC.gridy = 0;
        aFormPanel2.add(premiumIdLabel, pGBC);

        premiumIdField = new JTextField(30);
        pGBC.gridx = 1;
        pGBC.gridy = 0;
        aFormPanel2.add(premiumIdField, pGBC);

        premiumNameLabel = new JLabel("Full Name");
        pGBC.gridx = 0;
        pGBC.gridy = 1;
        aFormPanel2.add(premiumNameLabel, pGBC);

        premiumNameField = new JTextField(30);
        pGBC.gridx = 1;
        pGBC.gridy = 1;
        aFormPanel2.add(premiumNameField, pGBC);

        premiumLocationLabel = new JLabel("Location");
        pGBC.gridx = 0;
        pGBC.gridy = 2;
        aFormPanel2.add(premiumLocationLabel, pGBC);

        premiumLocationField = new JTextField(30);
        pGBC.gridx = 1;
        pGBC.gridy = 2;
        aFormPanel2.add(premiumLocationField, pGBC);

        premiumPhoneLabel = new JLabel("Phone");
        pGBC.gridx = 0;
        pGBC.gridy = 3;
        aFormPanel2.add(premiumPhoneLabel, pGBC);

        premiumPhoneField = new JTextField(30);
        pGBC.gridx = 1;
        pGBC.gridy = 3;
        aFormPanel2.add(premiumPhoneField, pGBC);

        premiumEmailLabel = new JLabel("Email");
        pGBC.gridx = 0;
        pGBC.gridy = 4;
        aFormPanel2.add(premiumEmailLabel, pGBC);

        premiumEmailField = new JTextField(30);
        pGBC.gridx = 1;
        pGBC.gridy = 4;
        aFormPanel2.add(premiumEmailField, pGBC);

// Date of Birth Panel
        premiumDobLabel = new JLabel("Date of Birth");
        pGBC.gridx = 0;
        pGBC.gridy = 5;
        aFormPanel2.add(premiumDobLabel, pGBC);

        premiumDobPanel = new JPanel();
        pGBC.gridx = 1;
        pGBC.gridy = 5;
        aFormPanel2.add(premiumDobPanel, pGBC);

        premiumDobYear = new JComboBox<>();
        premiumDobMonth = new JComboBox<>();
        premiumDobDay = new JComboBox<>();

        for (int i = 2025; i >= 1980; i--) {
            premiumDobYear.addItem(String.valueOf(i));
        }
        for (int i = 1; i <= 12; i++) {
            premiumDobMonth.addItem(String.valueOf(i));
        }
        for (int i = 1; i <= 31; i++) {
            premiumDobDay.addItem(String.valueOf(i));
        }

        premiumDobPanel.add(premiumDobYear);
        premiumDobPanel.add(premiumDobMonth);
        premiumDobPanel.add(premiumDobDay);

// Gender Selection
        premiumGenderLabel = new JLabel("Gender");
        pGBC.gridx = 0;
        pGBC.gridy = 6;
        aFormPanel2.add(premiumGenderLabel, pGBC);

        premiumGenderPanel = new JPanel();
        pGBC.gridx = 1;
        pGBC.gridy = 6;

        premiumMale = new JRadioButton("Male");
        premiumFemale = new JRadioButton("Female");
        premiumOthers = new JRadioButton("Others");

        ButtonGroup premiumGenderGroup = new ButtonGroup();
        premiumGenderGroup.add(premiumMale);
        premiumGenderGroup.add(premiumFemale);
        premiumGenderGroup.add(premiumOthers);

        premiumGenderPanel.add(premiumMale);
        premiumGenderPanel.add(premiumFemale);
        premiumGenderPanel.add(premiumOthers);

        aFormPanel2.add(premiumGenderPanel, pGBC);

// Membership Start Date
        premiumStartDateLabel = new JLabel("Membership Start Date");
        pGBC.gridx = 0;
        pGBC.gridy = 7;
        aFormPanel2.add(premiumStartDateLabel, pGBC);

        premiumStartDatePanel = new JPanel();
        pGBC.gridx = 1;
        pGBC.gridy = 7;
        aFormPanel2.add(premiumStartDatePanel, pGBC);

        premiumStartYear = new JComboBox<>();
        premiumStartMonth = new JComboBox<>();
        premiumStartDay = new JComboBox<>();

        for (int i = 2025; i >= 1980; i--) {
            premiumStartYear.addItem(String.valueOf(i));
        }
        for (int i = 1; i <= 12; i++) {
            premiumStartMonth.addItem(String.valueOf(i));
        }
        for (int i = 1; i <= 31; i++) {
            premiumStartDay.addItem(String.valueOf(i));
        }

        premiumStartDatePanel.add(premiumStartYear);
        premiumStartDatePanel.add(premiumStartMonth);
        premiumStartDatePanel.add(premiumStartDay);

// Referral Field
        trainerLabel = new JLabel("Trainer");
        pGBC.gridx = 0;
        pGBC.gridy = 8;
        aFormPanel2.add(trainerLabel, pGBC);

        trainerField = new JTextField(30);
        pGBC.gridx = 1;
        pGBC.gridy = 8;
        aFormPanel2.add(trainerField, pGBC);

        addPremiumButton = new JButton("Add Premium Member");
        pGBC.gridx = 1;
        pGBC.gridy = 9;
        addPremiumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse ID
                    int id = Integer.parseInt(premiumIdField.getText().trim());

                    // Fetch input values
                    String fullname = premiumNameField.getText().trim();
                    String location = premiumLocationField.getText().trim();
                    String phone = premiumPhoneField.getText().trim();
                    String email = premiumEmailField.getText().trim();
                    String dob = premiumDobYear.getSelectedItem() + " " + premiumDobMonth.getSelectedItem() + " " + premiumDobDay.getSelectedItem();
                    String gender = "";

                    if (premiumMale.isSelected()) {
                        gender = "Male";
                    } else if (premiumFemale.isSelected()) {
                        gender = "Female";
                    } else if (premiumOthers.isSelected()) {
                        gender = "Others";
                    }

                    String startDate = premiumStartYear.getSelectedItem() + " " + premiumStartMonth.getSelectedItem() + " " + premiumStartDay.getSelectedItem();
                    String trainer = trainerField.getText().trim();

                    // Validation: check if any required field is empty
                    if (fullname.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty()
                            || gender.isEmpty() || dob.isEmpty() || startDate.isEmpty() || trainer.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fill out all the fields!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Check if ID already exists
                    for (GymMember member : arraylist) {
                        if (member.getId() == id) {
                            JOptionPane.showMessageDialog(null, "ID already in use!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    // Create and add the premium member
                    PremiumMember premiumMember = new PremiumMember(id, fullname, location, phone, email, gender, dob, startDate, trainer);
                    arraylist.add(premiumMember);

                    JOptionPane.showMessageDialog(null, "Premium member added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid numeric ID!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        aFormPanel2.add(addPremiumButton, pGBC);

        clearPremiumButton = new JButton("Clear");
        pGBC.gridx = 0;
        pGBC.gridy = 9;
        clearPremiumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear text fields
                premiumIdField.setText("");
                premiumNameField.setText("");
                premiumLocationField.setText("");
                premiumPhoneField.setText("");
                premiumEmailField.setText("");
                trainerField.setText("");

                // Reset combo boxes to first index
                premiumDobYear.setSelectedIndex(0);
                premiumDobMonth.setSelectedIndex(0);
                premiumDobDay.setSelectedIndex(0);

                premiumStartYear.setSelectedIndex(0);
                premiumStartMonth.setSelectedIndex(0);
                premiumStartDay.setSelectedIndex(0);

                // Clear gender radio button selection
                premiumMale.setSelected(false);
                premiumFemale.setSelected(false);
                premiumOthers.setSelected(false);
            }
        });
        aFormPanel2.add(clearPremiumButton, pGBC);
        aFormPanel2.setBackground(Color.PINK);

        aMainPanel2.add(aTitlePanel2, BorderLayout.NORTH);
        aMainPanel2.add(aFormPanel2, BorderLayout.CENTER);

        // Add both main panels to frame
        addMembersFrame.add(aMainPanel1);
        addMembersFrame.add(aMainPanel2);
        addMembersFrame.setVisible(true);
    }

    public void checkAndCallMemberMethod(String action) {
        String idText = regularMethodIdField.getText().trim();

        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Member ID.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int enteredId;
          try {
            enteredId = Integer.parseInt(idText);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID must be a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean found = false;
        for (GymMember member : arraylist) {
            if (member.getId() == enteredId) {
                found=true;

                if (action.equals("activate")) {
                    member.activateMembership();
                    JOptionPane.showMessageDialog(null, "Membership activated for ID: " + enteredId, "Success", JOptionPane.INFORMATION_MESSAGE);
                } else if (action.equals("deactivate")) {
                    member.deactivateMembership();
                    JOptionPane.showMessageDialog(null, "Membership deactivated for ID: " + enteredId, "Success", JOptionPane.INFORMATION_MESSAGE);
                } else if (action.equals("reset")) {
                    member.resetMember();
                    JOptionPane.showMessageDialog(null, "Membership resetted for ID: " + enteredId, "Success", JOptionPane.INFORMATION_MESSAGE);

                } else if (action.equals("display")) {
                    if (member instanceof PremiumMember) {
                        String message = member.display(); // Calls PremiumMember's overridden method
                        JOptionPane.showMessageDialog(null, "Premium Membership details shown for ID: " + enteredId + "\n" + message, "Premium Member", JOptionPane.INFORMATION_MESSAGE);
                    } else if (member instanceof RegularMember) {
                        String message = member.display(); // Calls RegularMember's overridden method
                        JOptionPane.showMessageDialog(null, "Regular Membership details shown for ID: " + enteredId + "\n" + message, "Regular Member", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Unknown member type for ID: " + enteredId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (action.equals("mark")) {
                    if (member instanceof PremiumMember ) {
                        if (member.activeStatus) {
                            
                            member.markAttendance(); // Calls RegularMember's overridden method
                            JOptionPane.showMessageDialog(null, "Attendance Successfully Marked for Member Id " + enteredId, "Premium Member", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Member should be activated first " + enteredId, "Premium Member", JOptionPane.WARNING_MESSAGE);

                        }  
                       
                    } else if (member instanceof RegularMember ) {
                        if (member.activeStatus) {
                            
                            member.markAttendance(); // Calls RegularMember's overridden method
                            JOptionPane.showMessageDialog(null, "Attendance Successfully Marked for Member Id " + enteredId, "Regular Member", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Member should be activated first " + enteredId, "Regular Member", JOptionPane.WARNING_MESSAGE);

                        }                    }
                } else if (action.equals("upgrade")) {
                    String selectedPlan = (String) upgradeComboBox.getSelectedItem();

                    if (selectedPlan == null) {
                        JOptionPane.showMessageDialog(null,
                                "Please select a plan to upgrade.",
                                "No Plan Selected", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // System.out.println("Upgrade action triggered for plan: " + selectedPlan);
                    if (member instanceof RegularMember) {
                        RegularMember regular = (RegularMember) member; // REQUIRED cast
                        String message = regular.upgradePlan(selectedPlan.toLowerCase());
                        System.out.println(message);
                        JOptionPane.showMessageDialog(null,
                                message, "Upgrade Result", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Only Regular Members can upgrade plans.",
                                "Invalid Action", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (action.equals("revert")) {
                    if (member instanceof RegularMember && !removalReasonArea.getText().isEmpty()) {
                        RegularMember regular = (RegularMember) member; // REQUIRED cast
                        regular.revertRegularMember(removalReasonArea.getText());
                        JOptionPane.showMessageDialog(null,
                                "Regular Member Reverted Successfully", "Revert Result", JOptionPane.INFORMATION_MESSAGE);
                    } else if (member instanceof RegularMember && removalReasonArea.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Please fill Removal Reason field as well.", "Revert Result", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Premium Member cannot be reverted from here.", "Revert Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (action.equals("revert premium")) {
                    if (member instanceof PremiumMember) {
                        PremiumMember premiumMember = (PremiumMember) member; // REQUIRED cast
                        premiumMember.revertPremiumMember();
                        JOptionPane.showMessageDialog(null,
                                "Premium Member Reverted Successfully", "Revert Result", JOptionPane.INFORMATION_MESSAGE);
                    } else if (member instanceof RegularMember) {
                        JOptionPane.showMessageDialog(null,
                                "Regular Member cannot be reverted from here.", "Revert Result", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Unknown member type. Cannot perform revert.", "Revert Result", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (action.equals("calculate")) {
                    if (member instanceof PremiumMember) {
                        PremiumMember premiumMember = (PremiumMember) member; // REQUIRED cast
                        String message = premiumMember.calculateDiscount();
                        JOptionPane.showMessageDialog(null,
                                message, "Discount", JOptionPane.INFORMATION_MESSAGE);
                    } else if (member instanceof RegularMember) {
                        JOptionPane.showMessageDialog(null,
                                "Regular Member cannot have Discount!!!", "Discount", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Unknown member type. Cannot perform revert.", "Revert Result", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (action.equals("pay")) {
                    if (member instanceof PremiumMember) {
                        
                        try {
                            String input = payTextField.getText().trim();
    
                            if (input.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Please enter an amount to pay.", "Input Error", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
    
                            double amount = Double.parseDouble(input);
                            PremiumMember premiumMember = (PremiumMember) member; // REQUIRED cast
                            String message = premiumMember.payDueAmount(amount); // ✅ Correct type
    
                            JOptionPane.showMessageDialog(null, message, "Payment Result", JOptionPane.INFORMATION_MESSAGE);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Regular Member cannot pay due amount!!", "Premium Member", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (action.equals("save")) {


                }

                break;

            }

            
        }

        if (!found) {
                JOptionPane.showMessageDialog(null, "No member found with ID: " + enteredId, "Not Found", JOptionPane.INFORMATION_MESSAGE);
            }
    }

    public void methodsGUI() {
        methodsFrame = new JFrame();
        regularPanel = new JPanel();
        regularPanel.setLayout(new BorderLayout());
        regularTitlePanel = new JPanel();
        regularTitlePanel.setLayout(new FlowLayout());
        regulartTitleLabel = new JLabel(" Member Methods");
        regularTitlePanel.add(regulartTitleLabel);

        regularMethodsFormPanel = new JPanel();
        regularMethodsFormPanel.setLayout(new GridBagLayout());
        regularMethodsFormPanel.setBackground(Color.pink);
        GridBagConstraints regularGBC = new GridBagConstraints();
        regularGBC.insets = new Insets(12, 12, 12, 12);
        regularMethodIdLabel = new JLabel("Member ID");
        regularGBC.gridx = 0;
        regularGBC.gridy = 0;
        regularMethodsFormPanel.add(regularMethodIdLabel, regularGBC);

        regularMethodIdField = new JTextField(20);
        regularGBC.gridx = 1;
        regularGBC.gridy = 0;
        regularMethodsFormPanel.add(regularMethodIdField, regularGBC);

        activateButton = new JButton("Activate Membership");
        regularGBC.gridx = 0;
        regularGBC.gridy = 2;
        activateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAndCallMemberMethod("activate");
            }
        });
        regularMethodsFormPanel.add(activateButton, regularGBC);

        deactivateButton = new JButton("Deactivate Membership");
        regularGBC.gridx = 0;
        regularGBC.gridy = 3;
        deactivateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAndCallMemberMethod("deactivate");
            }
        });
        regularMethodsFormPanel.add(deactivateButton, regularGBC);

        resettButton = new JButton("Reset Membership");
        regularGBC.gridx = 0;
        regularGBC.gridy = 4;
        resettButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAndCallMemberMethod("reset");
            }
        });
        regularMethodsFormPanel.add(resettButton, regularGBC);

        MarkButton = new JButton("Mark Attendance");
        regularGBC.gridx = 1;
        regularGBC.gridy = 7;
        MarkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAndCallMemberMethod("mark");
            }
        });
        regularMethodsFormPanel.add(MarkButton, regularGBC);

        saveButton = new JButton("Save to file");
        regularGBC.gridx = 1;
        regularGBC.gridy = 8;
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 File file = new File("MemberDetails.txt");
                    try {
                        FileWriter writer = new FileWriter(file); // no 'true' = overwrite mode

                        // Header row
                        writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-25s %-10s %-10s %-10s %-15s %-10s %-17s %-15s %-15s\n",
                                "ID", "Name", "Location", "Phone", "Email", "Membership Start Date", "Plan", "Price",
                                "Attendance", "Loyalty Points", "Active", "Referral/Trainer", "Discount", "Net Paid"));

                        for (GymMember member : arraylist) {
                            if (member instanceof RegularMember) {
                                RegularMember regularMember = (RegularMember) member;

                                writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-25s %-10s %-10.2f %-10d %-15.0f %-10s %-17s %-15s %-15s\n",
                                        regularMember.getId(),
                                        regularMember.getName(),
                                        regularMember.getLocation(),
                                        regularMember.getPhone(),
                                        regularMember.getEmail(),
                                        regularMember.getMembershipStartDate(),
                                        regularMember.getPlan(),
                                        regularMember.getPrice(),
                                        regularMember.getAttendance(),
                                        regularMember.getLoyaltyPoints(),
                                        regularMember.getActiveStatus() ? "Yes" : "No",
                                        regularMember.getReferralSource(),
                                        "-", // Discount
                                        "-" // Paid
                                ));
                            } else if (member instanceof PremiumMember) {
                                PremiumMember premiumMember = (PremiumMember) member;

                                writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-25s %-10s %-10.2f %-10d %-15.0f %-10s %-17s %-15.2f %-15.2f\n",
                                        premiumMember.getId(),
                                        premiumMember.getName(),
                                        premiumMember.getLocation(),
                                        premiumMember.getPhone(),
                                        premiumMember.getEmail(),
                                        premiumMember.getMembershipStartDate(),
                                        "Premium",
                                        premiumMember.getPremiumCharge(),
                                        premiumMember.getAttendance(),
                                        premiumMember.getLoyaltyPoints(),
                                        premiumMember.getActiveStatus() ? "Yes" : "No",
                                        premiumMember.getPersonalTrainer(),
                                        premiumMember.getDiscountAmount(),
                                        premiumMember.getPaidAmount()
                                ));
                            }
                        }

                        writer.close();
                        JOptionPane.showMessageDialog(null, "Members saved to memberDetails.txt", "Success", JOptionPane.INFORMATION_MESSAGE);

                    } catch (IOException exception) {
                        JOptionPane.showMessageDialog(null, "Error writing to file!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
        regularMethodsFormPanel.add(saveButton, regularGBC);

        readFilesButton = new JButton("Read All Members");
        regularGBC.gridx = 1;
        regularGBC.gridy = 9;
        readFilesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File file = new File("MemberDetails.txt");

    if (!file.exists()) {
        JOptionPane.showMessageDialog(null, "File not found!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        Scanner scanner = new Scanner(file);
        String content = "";

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            content = content + line + "\n";
        }

        scanner.close();

        JTextArea textArea = new JTextArea(content);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(800, 400));

        JOptionPane.showMessageDialog(null, scrollPane, "Member Details", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception exx) {
        JOptionPane.showMessageDialog(null, "Error reading file!", "Error", JOptionPane.ERROR_MESSAGE);
    }
            }
        });
        regularMethodsFormPanel.add(readFilesButton, regularGBC);

        displayButton = new JButton("Display");
        regularGBC.gridx = 1;
        regularGBC.gridy = 2;
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAndCallMemberMethod("display");
            }
        });
        regularMethodsFormPanel.add(displayButton, regularGBC);

        upgradeComboBox = new JComboBox<>();
        upgradeComboBox.addItem("Basic");
        upgradeComboBox.addItem("Standard");
        upgradeComboBox.addItem("Deluxe");
        regularGBC.gridx = 1;
        regularGBC.gridy = 3;
        regularMethodsFormPanel.add(upgradeComboBox, regularGBC);

        UpgradeButton = new JButton("Upgrade");
        regularGBC.gridx = 1;
        regularGBC.gridy = 4;
        UpgradeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAndCallMemberMethod("upgrade");
            }
        });
        regularMethodsFormPanel.add(UpgradeButton, regularGBC);

        removalReasonArea = new JTextArea(5, 15);
        regularGBC.gridx = 1;
        regularGBC.gridy = 5;
        regularMethodsFormPanel.add(removalReasonArea, regularGBC);

        removalReasonLabel = new JLabel("Removal Reason");
        regularGBC.gridx = 0;
        regularGBC.gridy = 5;
        regularMethodsFormPanel.add(removalReasonLabel, regularGBC);

        regularRevertbutton = new JButton("Revert Regular");
        regularGBC.gridx = 1;
        regularGBC.gridy = 6;
        regularRevertbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAndCallMemberMethod("revert");
            }
        });
        regularMethodsFormPanel.add(regularRevertbutton, regularGBC);

        premiumRevertButton = new JButton("Revert Premium");
        regularGBC.gridx = 2;
        regularGBC.gridy = 2;
        premiumRevertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAndCallMemberMethod("revert premium");
            }
        });
        regularMethodsFormPanel.add(premiumRevertButton, regularGBC);

        calculateDiscountButton = new JButton("Calculate Discount");
        regularGBC.gridx = 2;
        regularGBC.gridy = 3;
        calculateDiscountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAndCallMemberMethod("calculate");
            }
        });
        regularMethodsFormPanel.add(calculateDiscountButton, regularGBC);

        payLabel = new JLabel("Paid Amount");
        regularGBC.gridx = 2;
        regularGBC.gridy = 4;
        regularMethodsFormPanel.add(payLabel, regularGBC);

        payTextField = new JTextField(20);
        regularGBC.gridx = 3;
        regularGBC.gridy = 4;
        regularMethodsFormPanel.add(payTextField, regularGBC);

        payButton = new JButton("Pay");
        regularGBC.gridx = 4;
        regularGBC.gridy = 4;
        payButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAndCallMemberMethod("pay");
            }
        });
        regularMethodsFormPanel.add(payButton, regularGBC);

        regularPanel.add(regularMethodsFormPanel, BorderLayout.CENTER);
        regularPanel.add(regularTitlePanel, BorderLayout.NORTH);
        methodsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        methodsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        methodsFrame.setLayout(new GridLayout());

        methodsFrame.setVisible(true);

        methodsFrame.add(regularPanel);
        // methodsFrame.add(premiumPanel);
    }

    public static void main(String[] args) {
        new GymGUI();
    }
}

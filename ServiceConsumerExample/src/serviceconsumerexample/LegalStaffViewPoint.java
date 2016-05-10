package serviceconsumerexample;

import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.osgi.framework.BundleContext;

import javax.swing.JLabel;
 
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
 
import javax.swing.JTextField;
 
import java.awt.Insets;
 
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.JButton;
 
import java.awt.Font;
import java.awt.CardLayout;
 
 
 
 
import javax.swing.JTabbedPane;
 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
 
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
 
 
 
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
 
import java.awt.FlowLayout;
import java.util.LinkedList;
 
import javax.swing.JComboBox;
import javax.swing.JList;
 
 
public class LegalStaffViewPoint extends JFrame {
 
    private JPanel contentPane;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTable tableViewClients;
    private JTextField textField_client_id;
    private JTextField textField_case_name;
    int clientRequest=0;
    boolean caseUpdated = false;
 
    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    LegalStaffViewPoint frame = new LegalStaffViewPoint();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
// 
    /**
     * Create the frame.
     */
    public LegalStaffViewPoint(BundleContext context) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 363);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));
     
         JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, "name_591593275427828");
        panel_1.setLayout(null);
         
        JLabel lblOptions = new JLabel("Options");
        lblOptions.setBounds(10, 11, 328, 14);
        lblOptions.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblOptions);
         
        JButton btnBack = new JButton("Log Out");
        btnBack.setBounds(321, 7, 93, 23);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		LoginViewPoint lvp = new LoginViewPoint(context);
				lvp.setVisible(true);
				 dispose();
                 
            }
        });
        panel_1.add(btnBack);
         
        JButton btnNewButton = new JButton("Clients");
        btnNewButton.setBounds(10, 49, 93, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)contentPane.getLayout();
                cl.next(contentPane);
             
            }
        });
        panel_1.add(btnNewButton);
         
        JButton btnWarnings = new JButton("Warnings");
        btnWarnings.setBounds(126, 49, 93, 23);
        btnWarnings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)contentPane.getLayout()).next(contentPane);
                ((CardLayout)contentPane.getLayout()).next(contentPane);
            }
        });
        panel_1.add(btnWarnings);
         
        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(10, 36, 404, 2);
        panel_1.add(separator_3);
         
        JButton btnCases = new JButton("Cases");
        btnCases.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                caseUpdated=true;
                ((CardLayout)contentPane.getLayout()).next(contentPane);
                ((CardLayout)contentPane.getLayout()).next(contentPane);
                ((CardLayout)contentPane.getLayout()).next(contentPane);
            }
        });
        btnCases.setBounds(10, 94, 89, 23);
        panel_1.add(btnCases);
         
        JPanel panel_add_clients = new JPanel();
        contentPane.add(panel_add_clients, "name_595899363601160");
        panel_add_clients.setLayout(new BorderLayout(0, 0));
         
        final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        panel_add_clients.add(tabbedPane, BorderLayout.CENTER);
         
         
        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("New tab", null, panel_2, null);
         
         
        tabbedPane.addTab("Add Client", null, panel_2, null);
        panel_2.setLayout(new GridLayout(0, 2, 0, 10));
         
        JLabel lblNewLabel_1 = new JLabel("Name");
        panel_2.add(lblNewLabel_1);
         
        textField_2 = new JTextField();
        panel_2.add(textField_2);
        textField_2.setColumns(10);
         
        JLabel lblNewLabel_2 = new JLabel("Surname");
        panel_2.add(lblNewLabel_2);
         
        textField_3 = new JTextField();
        panel_2.add(textField_3);
        textField_3.setColumns(10);
         
        JLabel lblNewLabel_3 = new JLabel("Id");
        panel_2.add(lblNewLabel_3);
         
        textField_4 = new JTextField();
        panel_2.add(textField_4);
        textField_4.setColumns(10);
         
        JLabel lblNewLabel_4 = new JLabel("Nationality");
        panel_2.add(lblNewLabel_4);
         
        textField_5 = new JTextField();
        panel_2.add(textField_5);
        textField_5.setColumns(10);
         
        JLabel lblNewLabel_5 = new JLabel("Telephone Number");
        panel_2.add(lblNewLabel_5);
         
        textField_6 = new JTextField();
        panel_2.add(textField_6);
        textField_6.setColumns(10);
         
        JLabel lblNewLabel_6 = new JLabel("Sex");
        panel_2.add(lblNewLabel_6);
         
        JRadioButton rdbtnMale = new JRadioButton("Male");
        panel_2.add(rdbtnMale);
         
        JLabel lblNewLabel_7 = new JLabel("");
        panel_2.add(lblNewLabel_7);
         
        JRadioButton rdbtnFemale = new JRadioButton("Female");
        panel_2.add(rdbtnFemale);
         
        ButtonGroup gr = new ButtonGroup ();
        gr.add(rdbtnFemale);
        gr.add(rdbtnMale);
          
        JLabel lblCountry = new JLabel("Country");
        panel_2.add(lblCountry);
         
        textField_7 = new JTextField();
        panel_2.add(textField_7);
        textField_7.setColumns(10);
         
        JLabel lblNewLabel_8 = new JLabel("City");
        panel_2.add(lblNewLabel_8);
         
        textField_8 = new JTextField();
        panel_2.add(textField_8);
        textField_8.setColumns(10);
         
        JLabel lblPostCode = new JLabel("Post Code");
        panel_2.add(lblPostCode);
         
        textField_9 = new JTextField();
        panel_2.add(textField_9);
        textField_9.setColumns(10);
         
        JLabel lblNewLabel_9 = new JLabel("Street");
        panel_2.add(lblNewLabel_9);
         
        textField_10 = new JTextField();
        panel_2.add(textField_10);
        textField_10.setColumns(10);
         
        JLabel lblComments = new JLabel("Comments");
        panel_2.add(lblComments);
         
        JTextArea textArea = new JTextArea();
        panel_2.add(textArea);
         
        JLabel lblSuspicious = new JLabel("Suspicious");
        panel_2.add(lblSuspicious);
         
        JCheckBox chckbxMoneyLaundring = new JCheckBox("money laundring");
        panel_2.add(chckbxMoneyLaundring);
         
        JButton btnSubmit_1 = new JButton("Submit");
        panel_2.add(btnSubmit_1);
         
        JButton btnUpdate = new JButton("Update");
        panel_2.add(btnUpdate);
         
        JPanel panel_3 = new JPanel();
        tabbedPane.addTab("View Clients", null, panel_3, null);
        panel_3.setLayout(new BorderLayout(0, 0));
         
        JScrollPane scrollPane = new JScrollPane();
        panel_3.add(scrollPane);
         
        tableViewClients = new JTable();
        panel_3.add(tableViewClients);
         
        JButton btnUpdateClient = new JButton("Update Client");
        btnUpdateClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientRequest=JOptionPane.showConfirmDialog(null, "Is this a client request?.");
                tabbedPane.setSelectedIndex(0);
            }
        });
        panel_3.add(btnUpdateClient, BorderLayout.SOUTH);
         
        JButton btnDelete = new JButton("Delete");
        panel_3.add(btnDelete, BorderLayout.EAST);
         
         
 
        JLabel lblNewLabel = new JLabel("Clients");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel_add_clients.add(lblNewLabel, BorderLayout.NORTH);
         
        JButton btnBack_1 = new JButton("Back");
        btnBack_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)contentPane.getLayout()).previous(contentPane);
            }
        });
        panel_add_clients.add(btnBack_1, BorderLayout.SOUTH);
         
        JPanel panel_view_warnings = new JPanel();
        contentPane.add(panel_view_warnings, "name_665717062983827");
        panel_view_warnings.setLayout(null);
         
        JLabel lblStrategyWarningsAnd = new JLabel("Strategy Warnings and Side Effects");
        lblStrategyWarningsAnd.setHorizontalAlignment(SwingConstants.CENTER);
        lblStrategyWarningsAnd.setBounds(45, 0, 270, 32);
        panel_view_warnings.add(lblStrategyWarningsAnd);
         
        final JComboBox <String> comboBoxStrategies = new JComboBox <String>() ;
        comboBoxStrategies.setBounds(274, 48, 126, 32);
        panel_view_warnings.add(comboBoxStrategies);
         
        comboBoxStrategies.addItem("Strategy 1");
        comboBoxStrategies.addItem("Strategy 2");
        comboBoxStrategies.addItem("Strategy 3");
        comboBoxStrategies.addItem("Strategy 4");
        comboBoxStrategies.addItem("Strategy 5");
        JLabel lblSelectAStrategy = new JLabel("Select a Strategy");
        lblSelectAStrategy.setBounds(20, 48, 138, 33);
        panel_view_warnings.add(lblSelectAStrategy);
         
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(20, 151, 380, 152);
        panel_view_warnings.add(scrollPane_1);
         
        final JList<String> list = new JList<String>();
        scrollPane_1.setViewportView(list);
        JButton btnShowSideEffects = new JButton("Show side Effects");
        btnShowSideEffects.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultListModel <String> warnings = new DefaultListModel <String>();
                warnings.addElement("Warning: "+comboBoxStrategies.getSelectedItem().toString());
                list.setModel(warnings);
            }
        });
        btnShowSideEffects.setBounds(274, 91, 126, 23);
        panel_view_warnings.add(btnShowSideEffects);
         
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 138, 390, 2);
        panel_view_warnings.add(separator_1);
 
         
         
        JLabel lblKnownSideEffects = new JLabel("Known Side Effects");
        lblKnownSideEffects.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPane_1.setColumnHeaderView(lblKnownSideEffects);
         
        JButton btnBack_2 = new JButton("Back");
        btnBack_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)contentPane.getLayout()).previous(contentPane);
                ((CardLayout)contentPane.getLayout()).previous(contentPane);
                 
            }
        });
        btnBack_2.setBounds(325, 5, 89, 23);
        panel_view_warnings.add(btnBack_2);
         
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 35, 404, 2);
        panel_view_warnings.add(separator_2);
         
        JPanel panel = new JPanel();
        contentPane.add(panel, "name_672911158115229");
        panel.setLayout(null);
         
        JLabel lblCases = new JLabel("Cases");
        lblCases.setBounds(183, 11, 46, 14);
        panel.add(lblCases);
         
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 33, 404, 2);
        panel.add(separator);
         
        JButton btnBack_3 = new JButton("Back");
        btnBack_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.previous(contentPane);
                cl.previous(contentPane);
                cl.previous(contentPane);
                 
            }
        });
        btnBack_3.setBounds(325, 7, 89, 23);
        panel.add(btnBack_3);
         
        JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane_1.setBounds(0, 36, 424, 278);
        panel.add(tabbedPane_1);
         
        JPanel panel_4 = new JPanel();
        tabbedPane_1.addTab("Add Case", null, panel_4, null);
        panel_4.setLayout(null);
         
        JLabel lblClientId = new JLabel("Client ID");
        lblClientId.setBounds(10, 21, 46, 14);
        panel_4.add(lblClientId);
         
        textField_client_id = new JTextField();
        textField_client_id.setBounds(63, 18, 86, 20);
        panel_4.add(textField_client_id);
        textField_client_id.setColumns(10);
         
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10, 63, 46, 14);
        panel_4.add(lblName);
         
        textField_case_name = new JTextField();
        textField_case_name.setBounds(63, 60, 86, 20);
        panel_4.add(textField_case_name);
        textField_case_name.setColumns(10);
         
        JLabel lblDetails = new JLabel("Details");
        lblDetails.setBounds(10, 105, 46, 14);
        panel_4.add(lblDetails);
         
        JTextArea textArea_details = new JTextArea();
        textArea_details.setBounds(63, 100, 148, 107);
        panel_4.add(textArea_details);
         
        JLabel lblIsClosed = new JLabel("Is closed");
        lblIsClosed.setBounds(10, 225, 46, 14);
        panel_4.add(lblIsClosed);
         
        JCheckBox checkBox_closed = new JCheckBox("");
        checkBox_closed.setBounds(63, 221, 97, 23);
        panel_4.add(checkBox_closed);
         
        JButton btnNewButton_submit = new JButton("Submit");
        btnNewButton_submit.setBounds(320, 221, 89, 23);
        panel_4.add(btnNewButton_submit);
         
        JPanel panel_5 = new JPanel();
        tabbedPane_1.addTab("View Cases", null, panel_5, null);
        panel_5.setLayout(null);
         
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(0, 0, 322, 250);
        panel_5.add(scrollPane_2);
         
        JList list_1 = new JList();
        scrollPane_2.setViewportView(list_1);
         
        JButton btnUpdate_1 = new JButton("Update");
        btnUpdate_1.setBounds(330, 11, 89, 23);
        panel_5.add(btnUpdate_1);
         
         
    }
}
package serviceconsumerexample;

import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.osgi.framework.BundleContext;

import java.awt.CardLayout;
 
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
 
 
 
 
import javax.swing.JScrollPane;
import javax.swing.JList;
 
 
 
public class ReceptionistViewPoint extends JFrame {
 
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_date;
    private JTextField textField_client;
    private JTextField textField_case_id;
    private JTextField textField_1;
    String lawyerId;
 
    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    ReceptionistViewPoint frame = new ReceptionistViewPoint();
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
    public ReceptionistViewPoint(BundleContext context) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));
         
        JPanel panel = new JPanel();
        contentPane.add(panel, "name_669222450517246");
        panel.setLayout(null);
         
        JLabel lblOptions = new JLabel("Options");
        lblOptions.setBounds(196, 11, 46, 14);
        panel.add(lblOptions);
         
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 36, 404, 2);
        panel.add(separator);
         
        JButton btnAppointments = new JButton("Appointments");
        btnAppointments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.next(contentPane);
                cl.next(contentPane);
            }
        });
        btnAppointments.setBounds(258, 90, 125, 23);
        panel.add(btnAppointments);
         
        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		LoginViewPoint lvp = new LoginViewPoint(context);
				lvp.setVisible(true);
				dispose();
         
            }
        });
        btnLogout.setBounds(325, 7, 89, 23);
        panel.add(btnLogout);
         
        JButton btnFindClients = new JButton("Find Clients");
        btnFindClients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.next(contentPane);
            }
        });
        btnFindClients.setBounds(43, 90, 125, 23);
        panel.add(btnFindClients);
         
        JButton btnGenerateRecommendations = new JButton("Generate Recommendations / Legal Opinions");
        btnGenerateRecommendations.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.next(contentPane);
                cl.next(contentPane);
                cl.next(contentPane);
            }
        });
        btnGenerateRecommendations.setBounds(43, 124, 340, 23);
        panel.add(btnGenerateRecommendations);
         
        JButton btnNewButton = new JButton("Add Dispute / Legal Incident");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.next(contentPane);
                cl.next(contentPane);
                cl.next(contentPane);
                cl.next(contentPane);
            }
        });
        btnNewButton.setBounds(43, 158, 340, 23);
        panel.add(btnNewButton);
         
        JButton btnGenerateListOf = new JButton("Generate list of people that didn't attend consultation");
        btnGenerateListOf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.next(contentPane);
                cl.next(contentPane);
                cl.next(contentPane);
                cl.next(contentPane);
                cl.next(contentPane);
            }
        });
        btnGenerateListOf.setBounds(43, 192, 340, 23);
        panel.add(btnGenerateListOf);
         
        JPanel panel_viewClients = new JPanel();
        contentPane.add(panel_viewClients, "name_669557048224126");
        panel_viewClients.setLayout(null);
         
        JLabel lblFindAClient = new JLabel("Find a Client");
        lblFindAClient.setBounds(136, 7, 89, 14);
        panel_viewClients.add(lblFindAClient);
         
        JLabel lblNewLabel = new JLabel("Client Id");
        lblNewLabel.setBounds(10, 34, 74, 19);
        panel_viewClients.add(lblNewLabel);
         
        textField = new JTextField();
        textField.setBounds(101, 32, 201, 23);
        panel_viewClients.add(textField);
        textField.setColumns(10);
         
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(10, 71, 404, 2);
        panel_viewClients.add(separator_1);
         
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(10, 84, 46, 14);
        panel_viewClients.add(lblName);
         
        JLabel label_client_name = new JLabel("");
        label_client_name.setBounds(66, 84, 46, 14);
        panel_viewClients.add(label_client_name);
         
        JLabel lblNationality = new JLabel("Nationality:");
        lblNationality.setBounds(10, 109, 89, 14);
        panel_viewClients.add(lblNationality);
         
        JLabel label_client_nationality = new JLabel("");
        label_client_nationality.setBounds(76, 109, 46, 14);
        panel_viewClients.add(label_client_nationality);
         
        JLabel lblSex = new JLabel("Sex:");
        lblSex.setBounds(10, 134, 46, 14);
        panel_viewClients.add(lblSex);
         
        JLabel label_client_sex = new JLabel("");
        label_client_sex.setBounds(45, 134, 46, 14);
        panel_viewClients.add(label_client_sex);
         
        JLabel lblTelephoneNumber = new JLabel("Telephone Number:");
        lblTelephoneNumber.setBounds(10, 159, 112, 14);
        panel_viewClients.add(lblTelephoneNumber);
         
        JLabel label_client_number = new JLabel("");
        label_client_number.setBounds(132, 159, 46, 14);
        panel_viewClients.add(label_client_number);
         
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(10, 195, 74, 14);
        panel_viewClients.add(lblAddress);
         
        JLabel label_client_address = new JLabel("");
        label_client_address.setBounds(66, 195, 46, 14);
        panel_viewClients.add(label_client_address);
         
        JLabel lblSuspicious = new JLabel("Suspicious:");
        lblSuspicious.setBounds(10, 220, 74, 14);
        panel_viewClients.add(lblSuspicious);
         
        JLabel label_client_suspicious = new JLabel("");
        label_client_suspicious.setBounds(76, 220, 46, 14);
        panel_viewClients.add(label_client_suspicious);
         
        JLabel lblComments = new JLabel("Comments");
        lblComments.setBounds(309, 78, 60, 14);
        panel_viewClients.add(lblComments);
         
        JTextArea textArea_client_comments = new JTextArea();
        textArea_client_comments.setBounds(270, 104, 144, 136);
        panel_viewClients.add(textArea_client_comments);
        JButton btnFind = new JButton("Find");
        btnFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnFind.setBounds(325, 45, 89, 23);
        panel_viewClients.add(btnFind);
 
         
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.previous(contentPane);
                 
            }
        });
        btnBack.setBounds(325, 11, 89, 23);
        panel_viewClients.add(btnBack);
         
        JPanel panel_appointments = new JPanel();
        contentPane.add(panel_appointments, "name_671290986354254");
        panel_appointments.setLayout(null);
         
        JLabel lblScheduleAppointments = new JLabel("Schedule Appointments");
        lblScheduleAppointments.setBounds(161, 11, 129, 14);
        panel_appointments.add(lblScheduleAppointments);
         
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 30, 404, 2);
        panel_appointments.add(separator_2);
        final JCheckBox chckbxIsDropIn;
        final JCheckBox chckbxAttended;
        JButton btnSubmit = new JButton("Submit");
         
        btnSubmit.setBounds(219, 228, 89, 23);
        panel_appointments.add(btnSubmit);
         
        JButton btnBack_1 = new JButton("Back");
        btnBack_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.previous(contentPane);
                cl.previous(contentPane);
            }
        });
        btnBack_1.setBounds(325, 228, 89, 23);
        panel_appointments.add(btnBack_1);
         
        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(10, 43, 46, 14);
        panel_appointments.add(lblDate);
         
        textField_date = new JTextField();
        textField_date.setBounds(54, 43, 86, 20);
        panel_appointments.add(textField_date);
        textField_date.setColumns(10);
         
        JLabel lblDropin = new JLabel("Drop-In");
        lblDropin.setBounds(10, 84, 46, 14);
        panel_appointments.add(lblDropin);
         
         chckbxIsDropIn = new JCheckBox("Is drop in");
        chckbxIsDropIn.setBounds(54, 80, 97, 23);
        panel_appointments.add(chckbxIsDropIn);
         
        JLabel lblAttendation = new JLabel("Attendance");
        lblAttendation.setBounds(10, 122, 75, 14);
        panel_appointments.add(lblAttendation);
         
         chckbxAttended = new JCheckBox("Attended");
        chckbxAttended.setBounds(72, 118, 97, 23);
        panel_appointments.add(chckbxAttended);
         
        textField_client = new JTextField();
        textField_client.setBounds(54, 154, 86, 20);
        panel_appointments.add(textField_client);
        textField_client.setColumns(10);
         
        JLabel lblClient = new JLabel("Client");
        lblClient.setBounds(10, 157, 46, 14);
        panel_appointments.add(lblClient);
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField_client.setText("");
                textField_date.setText("");
                chckbxAttended.setSelected(false);
                chckbxIsDropIn.setSelected(false);
            }
        });
         
        JPanel panel_recommendations = new JPanel();
        contentPane.add(panel_recommendations, "name_671644671767094");
        panel_recommendations.setLayout(null);
         
        JLabel lblRecommendations = new JLabel("Recommendations");
        lblRecommendations.setBounds(159, 11, 154, 14);
        panel_recommendations.add(lblRecommendations);
         
        JLabel lblCaseId = new JLabel("Case ID");
        lblCaseId.setBounds(10, 40, 46, 14);
        panel_recommendations.add(lblCaseId);
         
        textField_case_id = new JTextField();
        textField_case_id.setBounds(66, 40, 86, 20);
        panel_recommendations.add(textField_case_id);
        textField_case_id.setColumns(10);
         
        JLabel lblClientId = new JLabel("Client ID");
        lblClientId.setBounds(10, 83, 46, 14);
        panel_recommendations.add(lblClientId);
         
        textField_1 = new JTextField();
        textField_1.setBounds(66, 80, 86, 20);
        panel_recommendations.add(textField_1);
        textField_1.setColumns(10);
         
        JLabel lblDetails = new JLabel("Details");
        lblDetails.setBounds(10, 140, 46, 14);
        panel_recommendations.add(lblDetails);
         
        JTextArea textArea = new JTextArea();
        textArea.setBounds(66, 135, 120, 105);
        panel_recommendations.add(textArea);
         
        JButton btnBack_2 = new JButton("Back");
        btnBack_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.previous(contentPane);
                cl.previous(contentPane);
                cl.previous(contentPane);
            }
        });
        btnBack_2.setBounds(213, 217, 89, 23);
        panel_recommendations.add(btnBack_2);
         
        JButton btnSubmit_1 = new JButton("Submit");
        btnSubmit_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (true){
                    lawyerId=JOptionPane.showInputDialog("This customer is unwilling to the specific stategy, override?");
                }
            }
        });
        btnSubmit_1.setBounds(325, 217, 89, 23);
        panel_recommendations.add(btnSubmit_1);
         
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, "name_187787490267116");
        panel_1.setLayout(null);
         
        JLabel lblNewLabel_1 = new JLabel("Dispute / Legal Incident");
        lblNewLabel_1.setBounds(155, 5, 134, 14);
        panel_1.add(lblNewLabel_1);
         
        JLabel lblDetails_1 = new JLabel("Details");
        lblDetails_1.setBounds(10, 49, 46, 14);
        panel_1.add(lblDetails_1);
         
        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(10, 74, 219, 169);
        panel_1.add(textArea_1);
         
        JLabel lblIsIncident = new JLabel("Is incident");
        lblIsIncident.setBounds(252, 49, 68, 14);
        panel_1.add(lblIsIncident);
         
        JCheckBox checkBox = new JCheckBox("");
        checkBox.setBounds(250, 79, 97, 23);
        panel_1.add(checkBox);
         
        JButton btnSubmit_2 = new JButton("Submit");
        btnSubmit_2.setBounds(325, 183, 89, 23);
        panel_1.add(btnSubmit_2);
         
        JButton btnBack_3 = new JButton("Back");
        btnBack_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.previous(contentPane);
                cl.previous(contentPane);
                cl.previous(contentPane);
                cl.previous(contentPane);
            }
        });
        btnBack_3.setBounds(325, 220, 89, 23);
        panel_1.add(btnBack_3);
         
        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, "name_188212191570820");
        panel_2.setLayout(null);
         
        JLabel lblPeopleThatDint = new JLabel("People that didn't attend a consultation");
        lblPeopleThatDint.setBounds(10, 11, 293, 14);
        panel_2.add(lblPeopleThatDint);
         
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 35, 392, 205);
        panel_2.add(scrollPane);
         
        JList list = new JList();
        scrollPane.setViewportView(list);
         
        JButton btnBack_4 = new JButton("Back");
        btnBack_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPane.getLayout();
                cl.previous(contentPane);
                cl.previous(contentPane);
                cl.previous(contentPane);
                cl.previous(contentPane);
                cl.previous(contentPane);
            }
        });
        btnBack_4.setBounds(313, 7, 89, 23);
        panel_2.add(btnBack_4);
    }
}
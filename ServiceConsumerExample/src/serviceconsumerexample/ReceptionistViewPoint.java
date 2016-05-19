package serviceconsumerexample;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import generalServices.IServices;
import javafx.scene.layout.Border;
import types.Appointment;
import types.Client;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.DefaultListModel;
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
	String lawyerId;

	private JTextField textField_CID;
	private JLabel l_c_name;
	private JLabel l_c_nation;
	private JLabel l_c_sex;
	private JLabel l_c_tel;
	private JLabel l_c_add;
	private JLabel l_c_suspicious;
	private JTextArea textArea_client_comments;

	private JTextField r_caseid;
	private JTextField r_clientid;
	private JTextArea r_details;

	private JTextArea li_details;
	private JCheckBox li_is_incident;
	
	
	private JTextField a_date;
	private JCheckBox a_is_drop_in;
	private JCheckBox a_atended;
	private JTextField a_client_id;
	
	
	JList<String> applist;
	DefaultListModel<Appointment> appc;
	DefaultListModel<String> app_id;
	JScrollPane scrollPane = new JScrollPane();
	int aci;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ReceptionistViewPoint(BundleContext context) {
		ServiceReference iser = context.getServiceReference(IServices.class.getName());
		IServices ise = (IServices) context.getService(iser);

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

		JButton btnGenerateListOf = new JButton("Generate list of people that didn't attend Appointments");
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

		// find client

		JLabel lblFindAClient = new JLabel("Find a Client");
		lblFindAClient.setBounds(136, 7, 89, 14);
		panel_viewClients.add(lblFindAClient);

		JLabel lblNewLabel = new JLabel("Client Id");
		lblNewLabel.setBounds(10, 34, 74, 19);
		panel_viewClients.add(lblNewLabel);

		// client id
		textField_CID = new JTextField();
		textField_CID.setBounds(101, 32, 201, 23);
		panel_viewClients.add(textField_CID);
		textField_CID.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 71, 404, 2);
		panel_viewClients.add(separator_1);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 84, 46, 14);
		panel_viewClients.add(lblName);

		// client name
		l_c_name = new JLabel("");
		l_c_name.setBounds(66, 84, 100, 14);
		panel_viewClients.add(l_c_name);

		JLabel lblNationality = new JLabel("Nationality:");
		lblNationality.setBounds(10, 109, 89, 14);
		panel_viewClients.add(lblNationality);

		// nationality
		l_c_nation = new JLabel("");
		l_c_nation.setBounds(76, 109, 46, 14);
		panel_viewClients.add(l_c_nation);

		JLabel lblSex = new JLabel("Sex:");
		lblSex.setBounds(10, 134, 46, 14);
		panel_viewClients.add(lblSex);

		// sex
		l_c_sex = new JLabel("");
		l_c_sex.setBounds(45, 134, 46, 14);
		panel_viewClients.add(l_c_sex);

		JLabel lblTelephoneNumber = new JLabel("Telephone Number:");
		lblTelephoneNumber.setBounds(10, 159, 112, 14);
		panel_viewClients.add(lblTelephoneNumber);

		// tele
		l_c_tel = new JLabel("");
		l_c_tel.setBounds(132, 159, 46, 14);
		panel_viewClients.add(l_c_tel);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 195, 74, 14);
		panel_viewClients.add(lblAddress);

		// address
		l_c_add = new JLabel("");
		l_c_add.setBounds(66, 195, 46, 14);
		panel_viewClients.add(l_c_add);

		JLabel lblSuspicious = new JLabel("Suspicious:");
		lblSuspicious.setBounds(10, 220, 74, 14);
		panel_viewClients.add(lblSuspicious);

		// suspicious
		l_c_suspicious = new JLabel("");
		l_c_suspicious.setBounds(76, 220, 46, 14);
		panel_viewClients.add(l_c_suspicious);

		JLabel lblComments = new JLabel("Comments");
		lblComments.setBounds(309, 78, 60, 14);
		panel_viewClients.add(lblComments);

		// comment
		textArea_client_comments = new JTextArea();
		textArea_client_comments.setBounds(270, 104, 144, 136);
		panel_viewClients.add(textArea_client_comments);

		textArea_client_comments.setEnabled(false);

		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_CID.getText().compareTo("") != 0) {
					int tmpid = Integer.parseInt(textField_CID.getText());
					if (tmpid != 0) {
						Client tmp = ise.GET_CLIENT(tmpid);
						if (tmp != null) {
							l_c_name.setText(tmp.getFirstName() + " " + tmp.getLastName());
							l_c_nation.setText(tmp.getNationality());
							if (tmp.getSex() == 1) {
								l_c_sex.setText("Male");
							} else {
								l_c_sex.setText("Female");

							}
							l_c_tel.setText(tmp.getTel());
							l_c_add.setText(tmp.getCountry() + " " + tmp.getStreet() + " " + tmp.getCity());
							if (tmp.getHasIllegal() == 1) {
								l_c_suspicious.setText("Yes");
							} else {
								l_c_suspicious.setText("No");
							}
							textArea_client_comments.setText(tmp.getComments());

						} else {
							System.out.println("no such client.");
						}

					}
					tmpid = 0;

				} else {
					System.out.println("No such client");
				}

			}
		});
		btnFind.setBounds(325, 45, 89, 23);
		panel_viewClients.add(btnFind);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
				textField_CID.setText("");
				l_c_name.setText("");
				l_c_nation.setText("");
				l_c_sex.setText("");
				l_c_tel.setText("");
				l_c_add.setText("");
				l_c_suspicious.setText("");
				textArea_client_comments.setText("");
			}
		});
		btnBack.setBounds(325, 11, 89, 23);
		panel_viewClients.add(btnBack);

		JPanel panel_appointments = new JPanel();
		contentPane.add(panel_appointments, "name_671290986354254");
		panel_appointments.setLayout(null);

		// schedule appoin
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

		// date
		a_date = new JTextField();
		a_date.setBounds(54, 43, 86, 20);
		panel_appointments.add(a_date);
		a_date.setColumns(10);

		// is drop in
		a_is_drop_in = new JCheckBox("Is drop in");
		a_is_drop_in.setBounds(54, 80, 97, 23);
		panel_appointments.add(a_is_drop_in);

		// is attended
		a_atended = new JCheckBox("Attended");
		a_atended.setBounds(54, 118, 97, 23);
		panel_appointments.add(a_atended);

		// client id
		a_client_id = new JTextField();
		a_client_id.setBounds(54, 154, 86, 20);
		panel_appointments.add(a_client_id);
		a_client_id.setColumns(10);

		JLabel lblClient = new JLabel("Client ID");
		lblClient.setBounds(10, 157, 46, 14);
		panel_appointments.add(lblClient);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// add appointment
				if(a_date.getText().isEmpty()||a_client_id.getText().isEmpty()){
					System.out.println("Fill all");
				}
				else{
					int idi;
					int att;
					if(a_is_drop_in.isSelected()){
						idi=1;
					}else{
						idi=0;
					}
					
					if(a_atended.isSelected()){
						att=1;
					}else{
						att=0;
					}
					
					ise.INSERT_APPOINTMENT(a_date.getText(), idi, att, Integer.parseInt(a_client_id.getText()), 1);
					System.out.println("appontment added.");
					
					a_date.setText("");
					a_is_drop_in.setSelected(false);
					a_atended.setSelected(false);
					a_client_id.setText("");
					
				}
				
				
				
				
				
			}
		});

		// recommendations
		JPanel panel_recommendations = new JPanel();
		contentPane.add(panel_recommendations, "name_671644671767094");
		panel_recommendations.setLayout(null);

		JLabel lblRecommendations = new JLabel("Recommendations");
		lblRecommendations.setBounds(159, 11, 154, 14);
		panel_recommendations.add(lblRecommendations);

		JLabel lblCaseId = new JLabel("Case ID");
		lblCaseId.setBounds(10, 40, 46, 14);
		panel_recommendations.add(lblCaseId);

		// case id
		r_caseid = new JTextField();
		r_caseid.setBounds(66, 40, 86, 20);
		panel_recommendations.add(r_caseid);
		r_caseid.setColumns(10);

		JLabel lblclientid = new JLabel("Client ID");
		lblclientid.setBounds(10, 83, 46, 14);
		panel_recommendations.add(lblclientid);

		// client id
		r_clientid = new JTextField();
		r_clientid.setBounds(66, 80, 86, 20);
		panel_recommendations.add(r_clientid);
		r_clientid.setColumns(10);

		JLabel lblDetails = new JLabel("Details");
		lblDetails.setBounds(10, 140, 46, 14);
		panel_recommendations.add(lblDetails);

		// details
		r_details = new JTextArea();
		r_details.setBounds(66, 135, 120, 105);
		panel_recommendations.add(r_details);

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
				if (r_caseid.getText().isEmpty()||r_clientid.getText().isEmpty()||r_details.getText().isEmpty()) {
					System.out.println("fill all.");
				}
				else{
					ise.INSERT_RECOMMENDATION(1, Integer.parseInt(r_caseid.getText()), r_details.getText(),
							Integer.parseInt(r_clientid.getText()));
					System.out.println("Recommendations added");
					r_caseid.setText("");
					r_clientid.setText("");
					r_details.setText("");
				}
			}
		});
		btnSubmit_1.setBounds(325, 217, 89, 23);
		panel_recommendations.add(btnSubmit_1);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "name_187787490267116");
		panel_1.setLayout(null);

		// Legal Incident
		JLabel lblNewLabel_1 = new JLabel("Dispute / Legal Incident");
		lblNewLabel_1.setBounds(155, 5, 134, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblDetails_1 = new JLabel("Details");
		lblDetails_1.setBounds(10, 49, 46, 14);
		panel_1.add(lblDetails_1);

		// Details
		li_details = new JTextArea();
		li_details.setBounds(10, 74, 219, 169);
		panel_1.add(li_details);

		JLabel lblIsIncident = new JLabel("Is incident");
		lblIsIncident.setBounds(252, 49, 68, 14);
		panel_1.add(lblIsIncident);

		// is incident
		li_is_incident = new JCheckBox("");
		li_is_incident.setBounds(250, 79, 97, 23);
		panel_1.add(li_is_incident);

		JButton btnSubmit_2 = new JButton("Submit");
		btnSubmit_2.setBounds(325, 183, 89, 23);
		panel_1.add(btnSubmit_2);
		// submit
		btnSubmit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!li_details.getText().isEmpty()){
					if(li_is_incident.isSelected()){
						ise.INSERT_INCIDENT_DISPUTES(li_details.getText(), 1);

					}else{
						ise.INSERT_INCIDENT_DISPUTES(li_details.getText(), 0 );
					}
					System.out.println("legal incodent added.");
					li_details.setText("");
					li_is_incident.setSelected(false);
				}
				else{
					System.out.println("fill details.");
				}
				
				
				

			}
		});

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
		panel_2.setLayout(new BorderLayout(0, 0));


		JLabel lblPeopleThatDint = new JLabel("People that didn't attend a Appointment");
		panel_2.add(lblPeopleThatDint,BorderLayout.NORTH);

		
		
		
		
		

		panel_2.add(scrollPane,BorderLayout.CENTER);
		
		applist=new JList<String>();
		appc=ise.LIST_APPOINTMENT();
		app_id=new DefaultListModel<String>();
		
		for (int i = 0; i < appc.size(); i++) {
			app_id.addElement(appc.getElementAt(i).getAppointmentID().toString()+"   "+appc.getElementAt(i).getDate().toString()+"      "+appc.getElementAt(i).getClientID());
		}
		
		applist.setModel(app_id);
		
		
		
		
		scrollPane.setViewportView(applist);

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
//		btnBack_4.setBounds(313, 7, 89, 23);
		panel_2.add(btnBack_4,BorderLayout.EAST);
	}
}
package serviceconsumerexample;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import generalServices.IServices;
import types.Client;
import types.OfficeCase;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;

public class LegalStaffViewPoint extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtsur;
	private JTextField txtid;
	private JTextField txtnation;
	private JTextField txttele;
	private JTextField txtcountry;
	private JTextField txtcity;
	private JTextField txtpostcode;
	private JTextField txtstreet;
	private JTextField birthday;

	private JTable tableViewClients;
	private JTextField textField_client_id;

	private JTextField textField_case_name;
	int clientRequest = 0;
	boolean caseUpdated = false;
	JTextArea textArea_details;
	JCheckBox checkBox_closed;

	JList<String> clientlist;
	DefaultListModel<Client> c;
	DefaultListModel<String> client_id;
	JScrollPane scrollPane = new JScrollPane();
	int uci;

	JList<String> caselist;
	DefaultListModel<OfficeCase> casec;
	DefaultListModel<String> case_id;
	JScrollPane scrollPaneCase = new JScrollPane();
	int cis;

	
	/**
	 * Creates the GUI frame all the buttons text boxes and labels.
	 * Each buttons corresponds to a specific service which calls an SP in the DB
	 */
	public LegalStaffViewPoint(BundleContext context) {
		ServiceReference iser = context.getServiceReference(IServices.class.getName());
		IServices ise = (IServices) context.getService(iser);

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
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);

			}
		});
		panel_1.add(btnNewButton);

		JButton btnWarnings = new JButton("Warnings");
		btnWarnings.setBounds(126, 49, 93, 23);
		btnWarnings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).next(contentPane);
				((CardLayout) contentPane.getLayout()).next(contentPane);
			}
		});
		panel_1.add(btnWarnings);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 36, 404, 2);
		panel_1.add(separator_3);

		JButton btnCases = new JButton("Cases");
		btnCases.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				caseUpdated = true;
				((CardLayout) contentPane.getLayout()).next(contentPane);
				((CardLayout) contentPane.getLayout()).next(contentPane);
				((CardLayout) contentPane.getLayout()).next(contentPane);
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

		txtname = new JTextField();
		panel_2.add(txtname);
		txtname.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Surname");
		panel_2.add(lblNewLabel_2);

		txtsur = new JTextField();
		panel_2.add(txtsur);
		txtsur.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Id");
		panel_2.add(lblNewLabel_3);

		txtid = new JTextField();
		panel_2.add(txtid);
		txtid.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Birthday");
		panel_2.add(lblNewLabel_10);

		birthday = new JTextField();
		panel_2.add(birthday);
		birthday.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Nationality");
		panel_2.add(lblNewLabel_4);

		txtnation = new JTextField();
		panel_2.add(txtnation);
		txtnation.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Telephone Number");
		panel_2.add(lblNewLabel_5);

		txttele = new JTextField();
		panel_2.add(txttele);
		txttele.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Sex");
		panel_2.add(lblNewLabel_6);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		panel_2.add(rdbtnMale);

		JLabel lblNewLabel_7 = new JLabel("");
		panel_2.add(lblNewLabel_7);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		panel_2.add(rdbtnFemale);

		ButtonGroup gr = new ButtonGroup();
		gr.add(rdbtnFemale);
		gr.add(rdbtnMale);

		JLabel lblCountry = new JLabel("Country");
		panel_2.add(lblCountry);

		txtcountry = new JTextField();
		panel_2.add(txtcountry);
		txtcountry.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("City");
		panel_2.add(lblNewLabel_8);

		txtcity = new JTextField();
		panel_2.add(txtcity);
		txtcity.setColumns(10);

		JLabel lblPostCode = new JLabel("Post Code");
		panel_2.add(lblPostCode);

		txtpostcode = new JTextField();
		panel_2.add(txtpostcode);
		txtpostcode.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Street");
		panel_2.add(lblNewLabel_9);

		txtstreet = new JTextField();
		panel_2.add(txtstreet);
		txtstreet.setColumns(10);

		JLabel lblComments = new JLabel("Comments");
		panel_2.add(lblComments);

		JTextArea textArea = new JTextArea();
		panel_2.add(textArea);

		JLabel lblSuspicious = new JLabel("Suspicious");
		panel_2.add(lblSuspicious);

		JCheckBox chckbxMoneyLaundring = new JCheckBox("money laundring");
		panel_2.add(chckbxMoneyLaundring);

		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ise.INSERT_CLIENT(Integer.parseInt(txtid.getText()), txtname.getText(), txtsur.getText(),
						birthday.getText(), rdbtnMale.isSelected(), txttele.getText(), txtnation.getText(),
						txtcountry.getText(), txtcity.getText(), txtpostcode.getText(), txtstreet.getText(),
						textArea.getText(), chckbxMoneyLaundring.isSelected(), 0);

				txtname.setText("");
				txtsur.setText("");
				txtid.setText("");
				txtnation.setText("");
				txttele.setText("");
				txtcountry.setText("");
				txtcity.setText("");
				txtpostcode.setText("");
				txtstreet.setText("");
				birthday.setText("");
				textArea.setText("");
				chckbxMoneyLaundring.setSelected(false);

				clientlist = new JList<String>();
				c = ise.GET_ALL_CLIENTS();
				client_id = new DefaultListModel<String>();

				for (int i = 0; i < c.size(); i++) {
					client_id.addElement(c.getElementAt(i).getClientID() + " " + c.getElementAt(i).getFirstName() + " "
							+ c.getElementAt(i).getLastName());
				}
				clientlist.setModel(client_id);
				scrollPane.setViewportView(clientlist);

			}
		});
		panel_2.add(btnSubmit_1);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uci == 0) {
					JOptionPane.showMessageDialog(null, "Please select a client.");
					return;
				}
				System.out.println(uci);
				System.out.println("update");
				ise.UPDATE_CLIENT(uci, Integer.parseInt(txtid.getText()), txtname.getText(), txtsur.getText(),
						birthday.getText(), rdbtnMale.isSelected(), txttele.getText(), txtnation.getText(),
						txtcountry.getText(), txtcity.getText(), txtpostcode.getText(), txtstreet.getText(),
						textArea.getText(), chckbxMoneyLaundring.isSelected(), 0);
				System.out.println("done");

				txtname.setText("");
				txtsur.setText("");
				txtid.setText("");
				txtnation.setText("");
				txttele.setText("");
				txtcountry.setText("");
				txtcity.setText("");
				txtpostcode.setText("");
				txtstreet.setText("");
				birthday.setText("");
				textArea.setText("");
				chckbxMoneyLaundring.setSelected(false);

				clientlist = new JList<String>();
				c = ise.GET_ALL_CLIENTS();
				client_id = new DefaultListModel<String>();

				for (int i = 0; i < c.size(); i++) {
					client_id.addElement(c.getElementAt(i).getClientID() + " " + c.getElementAt(i).getFirstName() + " "
							+ c.getElementAt(i).getLastName());
				}
				clientlist.setModel(client_id);
				scrollPane.setViewportView(clientlist);
				uci = 0;

			}
		});

		panel_2.add(btnUpdate);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("View Clients", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));

		// JScrollPane scrollPane = new JScrollPane();
		// scrollPane.setBounds(0, 0, 350, 220);

		panel_3.add(scrollPane, BorderLayout.CENTER);

		clientlist = new JList<String>();
		c = ise.GET_ALL_CLIENTS();
		client_id = new DefaultListModel<String>();

		for (int i = 0; i < c.size(); i++) {
			client_id.addElement(c.getElementAt(i).getClientID() + " " + c.getElementAt(i).getFirstName() + " "
					+ c.getElementAt(i).getLastName());
		}
		clientlist.setModel(client_id);

		scrollPane.setViewportView(clientlist);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		// tableViewClients = new JTable();
		// panel_3.add(tableViewClients);

		JButton btnUpdateClient = new JButton("Update Client");
		btnUpdateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientRequest = JOptionPane.showConfirmDialog(null, "Is this a client request?.");
				if (clientRequest == 0) {
					System.out.println(clientlist.getSelectedValue());

					int selected = clientlist.getSelectedIndex();
					Client tmp = c.getElementAt(selected);

					txtname.setText(tmp.getFirstName());
					txtsur.setText(tmp.getLastName());
					txtid.setText(tmp.getNationalID().toString());
					txtnation.setText(tmp.getNationality());
					txttele.setText(tmp.getTel());
					txtcountry.setText(tmp.getCountry());
					txtcity.setText(tmp.getCity());
					txtpostcode.setText(tmp.getPostCode());
					txtstreet.setText(tmp.getStreet());
					birthday.setText(tmp.getBirthDate().toString());
					textArea.setText(tmp.getComments());
					uci = tmp.getClientID();
					System.out.println(uci);

					if (tmp.getSex() == 1) {
						rdbtnMale.setSelected(true);
					} else {
						rdbtnFemale.setSelected(true);
					}

					if (tmp.getHasIllegal() == 1) {
						chckbxMoneyLaundring.setSelected(true);
					} else {
						chckbxMoneyLaundring.setSelected(false);
					}

					tabbedPane.setSelectedIndex(0);

				}

			}
		});
		panel_3.add(btnUpdateClient, BorderLayout.SOUTH);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientRequest = JOptionPane.showConfirmDialog(null, "Are you sure?");
				if (clientRequest == 0) {
					int selected = clientlist.getSelectedIndex();
					ise.DELETE_CLIENT(c.getElementAt(selected).getClientID());
					c.remove(selected);
					client_id.remove(selected);

				}

			}
		});

		panel_3.add(btnDelete, BorderLayout.EAST);

		JLabel lblNewLabel = new JLabel("Clients");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_add_clients.add(lblNewLabel, BorderLayout.NORTH);

		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).previous(contentPane);
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

		final JComboBox<String> comboBoxStrategies = new JComboBox<String>();
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
				DefaultListModel<String> warnings = new DefaultListModel<String>();
				warnings.addElement("Warning: " + comboBoxStrategies.getSelectedItem().toString());
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
				((CardLayout) contentPane.getLayout()).previous(contentPane);
				((CardLayout) contentPane.getLayout()).previous(contentPane);

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

		textArea_details = new JTextArea();
		textArea_details.setBounds(63, 100, 148, 107);
		panel_4.add(textArea_details);

		JLabel lblIsClosed = new JLabel("Is closed");
		lblIsClosed.setBounds(10, 225, 46, 14);
		panel_4.add(lblIsClosed);

		checkBox_closed = new JCheckBox("");
		checkBox_closed.setBounds(63, 221, 97, 23);
		panel_4.add(checkBox_closed);

		JButton btnNewButton_submit = new JButton("Submit");

		// submit

		btnNewButton_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// isert case
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				System.out.println(dateFormat.format(date)); // 2014/08/06

				if (cis == 0) {

					ise.INSERT_OFFICE_CASE(Integer.parseInt(textField_client_id.getText()),
							textField_case_name.getText(), textArea_details.getText(), checkBox_closed.isSelected(),
							dateFormat.format(date), 1);
				}
				else{
					System.out.println(cis);
					ise.UPDATE_OFFICE_CASE(cis, Integer.parseInt(textField_client_id.getText()),
							textField_case_name.getText(), textArea_details.getText(), checkBox_closed.isSelected(),
							dateFormat.format(date), 1);
					cis=0;
				}

				System.out.println("Inserted");
				textField_client_id.setText("");
				textField_case_name.setText("");
				textArea_details.setText("");
				checkBox_closed.setSelected(false);

				caselist = new JList<String>();
				casec = ise.LIST_OFFICE_CASE();
				case_id = new DefaultListModel<String>();

				for (int i = 0; i < casec.size(); i++) {
					case_id.addElement(casec.getElementAt(i).getCaseID() + " " + casec.getElementAt(i).getClientID()
							+ " " + casec.getElementAt(i).getName());
				}
				caselist.setModel(case_id);

				scrollPaneCase.setViewportView(caselist);

			}
		});

		btnNewButton_submit.setBounds(320, 221, 89, 23);
		panel_4.add(btnNewButton_submit);

		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("View Cases", null, panel_5, null);
		panel_5.setLayout(new BorderLayout(0, 0));

		// JScrollPane scrollPane_2 = new JScrollPane();
		// scrollPane_2.setBounds(0, 0, 322, 250);
		panel_5.add(scrollPaneCase, BorderLayout.CENTER);

		caselist = new JList<String>();
		casec = ise.LIST_OFFICE_CASE();
		case_id = new DefaultListModel<String>();

		for (int i = 0; i < casec.size(); i++) {
			case_id.addElement(casec.getElementAt(i).getCaseID() + " " + casec.getElementAt(i).getClientID()
					+ " " + casec.getElementAt(i).getName());
		}
		caselist.setModel(case_id);

		scrollPaneCase.setViewportView(caselist);

		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// update
				clientRequest = JOptionPane.showConfirmDialog(null, "Are you Sure?.");
				if (clientRequest == 0) {
					int selected = caselist.getSelectedIndex();
					OfficeCase tmp = casec.getElementAt(selected);
					textField_client_id.setText(tmp.getClientID().toString());
					textField_case_name.setText(tmp.getName());
					textArea_details.setText(tmp.getDetails());
					if (tmp.getIsClosed() == 1) {
						checkBox_closed.setSelected(true);
					} else {
						checkBox_closed.setSelected(false);
					}

					cis = tmp.getCaseID();

					tabbedPane_1.setSelectedIndex(0);

				}

			}

		});

		// btnUpdate_1.setBounds(330, 11, 89, 23);
		panel_5.add(btnUpdate_1, BorderLayout.NORTH);

	}
}
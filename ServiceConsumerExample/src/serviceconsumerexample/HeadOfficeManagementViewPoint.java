package serviceconsumerexample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import generalServices.IServices;
import types.OfficeCase;


public class HeadOfficeManagementViewPoint extends JFrame {

	private JPanel contentPane;


	/**
	 * Creates the GUI frame all the buttons text boxes and labels.
	 */
	public HeadOfficeManagementViewPoint(BundleContext context) {
		
		
		ServiceReference iser = context.getServiceReference(IServices.class.getName());
		IServices ise = (IServices) context.getService(iser);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_672160782726362");
		panel.setLayout(null);
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setBounds(194, 11, 46, 14);
		panel.add(lblOptions);
		
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 34, 404, 2);
		panel.add(separator);
		
		JButton btnGetReports = new JButton("Get Weekly Branch Reports");
		btnGetReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next (contentPane);
			}
		});
		btnGetReports.setBounds(44, 149, 345, 23);
		panel.add(btnGetReports);
		
		JButton btnViewCaseTypes = new JButton("View Case Types and Recommendations");
		btnViewCaseTypes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next (contentPane);
				cl.next(contentPane);
			}
		});
		btnViewCaseTypes.setBounds(44, 217, 345, 23);
		panel.add(btnViewCaseTypes);
		
		JPanel panel_branchReports = new JPanel();
		contentPane.add(panel_branchReports, "name_672500800949111");
		panel_branchReports.setLayout(null);
		
		JLabel lblBranchReport = new JLabel("Branch Report");
		lblBranchReport.setBounds(142, 11, 82, 14);
		panel_branchReports.add(lblBranchReport);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous (contentPane);
			}
		});
		btnBack_1.setBounds(325, 7, 89, 23);
		panel_branchReports.add(btnBack_1);
		
		JPanel panel_cases = new JPanel();
		contentPane.add(panel_cases, "name_672545116008379");
		panel_cases.setLayout(null);
		panel_cases.setLayout(new BorderLayout(0, 0));

		JLabel lblCases = new JLabel("Cases");
		panel_cases.add(lblCases,BorderLayout.NORTH);
		
		JList <String> caseslist=new JList<String>();
		DefaultListModel<OfficeCase> casec=ise.LIST_OFFICE_CASE();
		DefaultListModel<String> case_id=new DefaultListModel<String>();
		JScrollPane scrollPane=new JScrollPane();
		
		panel_cases.add(scrollPane,BorderLayout.CENTER);
		
		for(int i=0;i<casec.size();i++){
			if(casec.getElementAt(i).getIsClosed()==1){
				case_id.addElement("CaseID: "+casec.getElementAt(i).getCaseID().toString()+" ClientID: "+casec.getElementAt(i).getClientID().toString()+" Name: "+casec.getElementAt(i).getName()+" Detail: "+casec.getElementAt(i).getDetails()+" isclosed: Yes Last Updated: "+casec.getElementAt(i).getLastUpdated().toString()+" EmployeeID: "+casec.getElementAt(i).getEmployeeID().toString());

			}else{
				case_id.addElement("CaseID: "+casec.getElementAt(i).getCaseID().toString()+" ClientID: "+casec.getElementAt(i).getClientID().toString()+" Name: "+casec.getElementAt(i).getName()+" Detail: "+casec.getElementAt(i).getDetails()+" isclosed: No Last Updated: "+casec.getElementAt(i).getLastUpdated().toString()+" EmployeeID: "+casec.getElementAt(i).getEmployeeID().toString());

			}
			
			
		}
		
		caseslist.setModel(case_id);
		scrollPane.setViewportView(caseslist);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous (contentPane);
				cl.previous (contentPane);
			}
		});
		panel_cases.add(btnBack,BorderLayout.SOUTH);
	}

}

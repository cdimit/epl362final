package serviceconsumerexample;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import generalServices.IServices;
import types.Employee;



public class Activator implements BundleActivator {

	/**
	 * Activator for the consumer example Bundle. It activates the main viewpoint which is
	 * the log in viewpoint. From there on other Viewpoints activate depending on the login
	 * credentials.
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Sample Consumer");

		LoginViewPoint lvp = new LoginViewPoint(context);
		lvp.setVisible(true);
		
	}
	

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop Sample Consumer");
	}

}

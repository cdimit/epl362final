package serviceconsumerexample;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import generalServices.IServices;
import types.Employee;



public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Sample Consumer");
		

//		ServiceReference iser=context.getServiceReference(IServices.class.getName());
//		IServices ise = (IServices) context.getService(iser);
//		
//		Employee emp = ise.GET_EMPLOYEE("cmakri06", "1234");
//		
//		if(emp==null){
//			System.out.println("Error");
//		}
//		else{
//			System.out.println(emp.getFirstName());
//		}
//		
//		
		
		LoginViewPoint lvp = new LoginViewPoint(context);
		lvp.setVisible(true);
		
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop Sample Consumer");
	}

}
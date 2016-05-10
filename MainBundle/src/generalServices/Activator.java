package generalServices;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("MainBundle Started");
	
		Activator.context = context;
		
		System.out.println("Login Class Started");
	
		System.out.println("Services Started");
		IServices services=  new Services();
		context.registerService(IServices.class.getName(), services, null);
		
		
	
	
	}
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		Activator.context = null;
		System.out.println("Login Class Stopped");
		System.out.println("MainBundle Stopped");
	}

}
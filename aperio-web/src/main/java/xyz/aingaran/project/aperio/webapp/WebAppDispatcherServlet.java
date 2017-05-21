package xyz.aingaran.project.aperio.webapp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.DispatcherServlet;

/**
* Central entry servlet class for web application
* @author Aingaran Elango
* @category Servlet
*/
public class WebAppDispatcherServlet extends DispatcherServlet {
	private static final long serialVersionUID = -1L;
	protected final Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logAllRequestParameter(request);
		super.doService(request, response);		
	}
	
	protected void logAllRequestParameter(HttpServletRequest aRequest) {
		if(logger.isDebugEnabled()) {
			Map<String, String[]> theParameterMap = aRequest.getParameterMap();
			
			StringBuilder builder = new StringBuilder();
			for(String parameterName : theParameterMap.keySet()) {
				builder.append(parameterName);
				builder.append("\n");
				String[] values = theParameterMap.get(parameterName);
				for(String value:values) {
					builder.append("\t");
					builder.append(value);
					builder.append("\n");
				}
			}
			logger.debug("RequestParameter:\n"+builder.toString());
		}
	}
}
package xyz.aingaran.project.aperio.webapp.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for viewStatus
 * @author Aingaran Elango
 * @category Controller
 */
@Controller
@RequestMapping("/viewStatus")
public class ViewStatusController extends AbstractWebController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String initView(HttpServletRequest aRequest) {
		return "viewStatus";
	}
	
	@Override
	@ModelAttribute("HOST_NAME")
	public String addHostName() {
		String theHostName = "some HostName";
		try {
			theHostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			logger.error("addHostName() failed\n"+e.getStackTrace());
		}
		return theHostName;
	}
	
}
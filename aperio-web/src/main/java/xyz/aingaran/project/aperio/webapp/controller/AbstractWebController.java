package xyz.aingaran.project.aperio.webapp.controller;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public abstract class AbstractWebController {
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	@ModelAttribute("PROP_SERVER_TIME")
	public String addServerTime() {
		LocalDateTime now = LocalDateTime.now();
		String outString = now.toString();
		logger.info("addServerTime() - Server time is "+outString);
		return outString;
	}
	
	@ModelAttribute("VERSION_APP")
	public String addApplicationVersion() {
		String outString = MessageVersion.getString("VERSION.INFO.APP.BUILD");
		logger.info("addApplicationVersion() - Version is "+outString);
		return outString;
	}
	
	@ModelAttribute("VERSION_DB")
	public String addDatabaseVersion() {
		String outString = MessageVersion.getString("VERSION.INFO.DB.BUILD");
		logger.info("addDatabaseVersion() - Version is "+outString);
		return outString;
	}
	
	@ModelAttribute("HOST_NAME")
	public String addHostName() {
		String outString = "notSetInSourceCode";
		logger.info("addHostName() - HostName is "+outString);
		return outString;
	}
}
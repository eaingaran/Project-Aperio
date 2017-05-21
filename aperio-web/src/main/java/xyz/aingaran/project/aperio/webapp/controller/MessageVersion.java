package xyz.aingaran.project.aperio.webapp.controller;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * To get Version
 * @author Aingaran Elango
 */
public class MessageVersion {
	private static final String BUNDLE_NAME = "version"; //$NON-NLS-1$
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	private MessageVersion() {
		
	}
	
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!'+key+'!';
		}
	}
	
}
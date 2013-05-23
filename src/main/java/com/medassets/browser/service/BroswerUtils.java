package com.medassets.browser.service;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.RenderingEngine;
import eu.bitwalker.useragentutils.UserAgent;

public class BroswerUtils {

	public static UserAgent parseUserAgent (String ua) {
		 UserAgent userAgent = UserAgent.parseUserAgentString(ua);
//		 userAgent.getOperatingSystem();
//		 Browser browser = userAgent.getBrowser();
//		 System.out.println ("browser: " + browser.getName());
//		 RenderingEngine engine = browser.getRenderingEngine();
		 //System.out.println ("rendering engine: " );
		 return userAgent;
	}
}

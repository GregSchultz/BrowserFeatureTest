package com.medassets.browser.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.medassets.browser.service.BroswerUtils;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;

@RequestMapping("/browserUtils")
@Controller
public class BrowseUtilsController {

	@RequestMapping(value="/detect", method = RequestMethod.GET, produces = "text/html")
    public String detect(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("xUaCompatibleTag");
		//System.out.println("Enter: x-ua-compatible-tag: "  + session.getAttribute("x-ua-compatible-tag"));
        String userAgent =  request.getHeader("User-Agent");       
        
        UserAgent userAgentObj = BroswerUtils.parseUserAgent(userAgent);
        model.addAttribute("ua", userAgent);
        model.addAttribute("userAgent", userAgentObj);
		return "browserUtils/detect";
    }

	@RequestMapping(value = "/changeDocMode", method = RequestMethod.GET, produces = "text/html")
	public String changeDocMode(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("xUaCompatibleTag");
		String userAgent = request.getHeader("User-Agent");
		UserAgent userAgentObj = BroswerUtils.parseUserAgent(userAgent);
		Browser browser = userAgentObj.getBrowser();
		if (browser.toString().equalsIgnoreCase("ie8")) {
			// String metaTag = "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=7\"/>";
			String metaTag = "http-equiv=\"X-UA-Compatible\" content=\"IE=7\"";
			session.setAttribute("xUaCompatibleTag", metaTag);
			model.addAttribute("ua", userAgent);
			model.addAttribute("userAgent", userAgentObj);
		} else {
			model.addAttribute("notie8", "This will only work if you are on IE8.");
		}
		return "browserUtils/detect";
	}
	
	@RequestMapping(value = "/changeDocModeUseHeader", method = RequestMethod.GET, produces = "text/html")
	public String changeDocModeUseHeader(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("xUaCompatibleTag");
		String userAgent = request.getHeader("User-Agent");
		UserAgent userAgentObj = BroswerUtils.parseUserAgent(userAgent);
		Browser browser = userAgentObj.getBrowser();
		if (browser.toString().equalsIgnoreCase("ie8")) {
			response.addHeader("x-ua-compatible", "IE=7"); // "IE=EmulateIE7");
			model.addAttribute("ua", userAgent);
			model.addAttribute("userAgent", userAgentObj);
		} else {
			model.addAttribute("notie8", "This will only work if you are on IE8.");
		}

		return "browserUtils/detect";
	}
	
	String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}

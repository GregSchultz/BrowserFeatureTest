package com.medassets.browser.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medassets.browser.service.BroswerUtils;

import eu.bitwalker.useragentutils.Browser;

public class AddHeaderForIEFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
//		HttpSession session = ((HttpServletRequest) request).getSession();
//		HttpServletRequest httpReq = (HttpServletRequest)request;
//		String userAgent =  httpReq.getHeader("User-Agent");
//        HttpServletResponse httpRes = (HttpServletResponse) response;
//		Browser browser = BroswerUtils.parseUserAgent(userAgent);
//		if(browser.toString().equalsIgnoreCase("ie8")) {
//			httpRes.addHeader("x-ua-compatible", "IE=7" ); // "IE=EmulateIE7");
//			System.out.println (" ie8 - put in ie 7 document mode");
//			session.setAttribute("xUaCompatibleTag", "<meta http-equiv='x-ua-compatible' content='IE=EmulateIE7' />"); 
//			session.setAttribute("something", "I wrote this"); 
//		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

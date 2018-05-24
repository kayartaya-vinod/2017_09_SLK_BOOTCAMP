package com.slk.training.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DateTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private String pattern;
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			Date dt = new Date();
			if(pattern==null) {
				out.print(dt);
			}
			else {
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				out.print(sdf.format(dt));
			}
		} catch (Exception e) {
			throw new JspException(e);
		} 
		
		return super.doStartTag();
	}

}

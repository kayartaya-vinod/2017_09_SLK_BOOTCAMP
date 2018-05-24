package com.slk.training.web;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class AuthorInfoTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			String info = "Vinod Kumar Kayartaya &lt;vinod@vinod.co&gt;";
			out.println(info);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return super.doStartTag();
	}

}

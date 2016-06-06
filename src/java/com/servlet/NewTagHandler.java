/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author wankim
 */
public class NewTagHandler extends SimpleTagSupport {

    private FormBean formBean;
	
	public void setFormBean(FormBean formBean) {
		this.formBean = formBean;
	}
    
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        PageContext context = (PageContext) getJspContext();
	JspWriter out = getJspContext().getOut();
		
		JspFragment f = getJspBody();
		HashMap hashMap = new HashMap();
		try {
			Class b = Class.forName("com.servlet.FormBean");
			Field[] fields = b.getDeclaredFields();
			for(Field field : fields) {
				String name = field.getName();
				String camelName = "get" + (name.substring(0, 1).toUpperCase()) + name.substring(1);
				Method m = b.getMethod(camelName);
				
				hashMap.put(name, m.invoke(formBean));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<Entry> s = hashMap.entrySet();
		for(Map.Entry me : s) {
			context.setAttribute("name", me.getKey());
			context.setAttribute("value", me.getValue());
			if(f != null) {
				f.invoke(out);
			}
		}
    }
    
}

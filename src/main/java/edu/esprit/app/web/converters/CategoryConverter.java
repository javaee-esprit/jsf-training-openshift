package edu.esprit.app.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edu.esprit.app.persistence.Category;
import edu.esprit.app.web.mbeans.HelperBean;




@FacesConverter("cc")
public class CategoryConverter implements Converter{
	
	

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Category equivalentCategory = null;
		if(!value.trim().equals("")){
			HelperBean helper = context.getApplication().evaluateExpressionGet(context, "#{helperBean}", HelperBean.class);
			equivalentCategory = helper.findCategoryByName(value);
		}
		return equivalentCategory;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String equivalentString = null;
		if(value == null || value.equals("")){
			equivalentString = "";
		}else{
			equivalentString = ((Category)value).getName();
		}
		return equivalentString;
	}

}

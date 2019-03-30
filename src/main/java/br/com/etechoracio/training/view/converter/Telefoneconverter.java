package br.com.etechoracio.training.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.stereotype.Component;

@Component(value="telefoneConverter")
public class Telefoneconverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		String tel = value;
		
		if(tel != null && !tel.equals("")) {
			tel = value.replaceAll("[^0-9]", "");
		}
		return tel;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		String tel = String.valueOf(value);
		
		if(tel != null && tel.length() == 10 )
			tel ="(" + tel.substring(0,3) + ")" + " " +
				tel.substring(3,7) + "-" + (7);
					
		return tel;
	}

}

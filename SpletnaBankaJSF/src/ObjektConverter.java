import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ejb.IKomitent;
import entitete.Komitent;

@FacesConverter("objektConverter")
public class ObjektConverter implements Converter {

	@EJB
	IKomitent kom;
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		FacesContext context = FacesContext.getCurrentInstance();
		Komitent k = (Komitent) context.getELContext().getELResolver().getValue(context.getELContext(), null, "k");
		return k;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return null;
	}

}

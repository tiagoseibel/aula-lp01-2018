package converter;

import dao.DepartamentoDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Departamento;

@FacesConverter("departamentoConverter")
public class DepartamentoConverter implements Converter {

    private DepartamentoDAO departamentoDAO = new DepartamentoDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return departamentoDAO.findById(Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t != null) {
            return "" + ((Departamento) t).getCodigo();
        } else {
            return "";
        }
    }

}

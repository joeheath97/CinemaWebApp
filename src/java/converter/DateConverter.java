/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.ValidatorException;

@FacesConverter("dateconverter")
public class DateConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,String value) {
        Date date = null;
        try{
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            date = format.parse(value);
        }catch(ParseException ex){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Date is formatted incorrectly (DD/MM/YYYY)","Date Error");
            throw new ValidatorException(msg);
        }
        return date;
        
    }
    @Override
    public String getAsString(FacesContext context, UIComponent component,Object value) throws ConverterException {
           
           Date date = new Date(((Date)value).getDate());
           SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
           return format.format((Date) date);
    
            
    }
}

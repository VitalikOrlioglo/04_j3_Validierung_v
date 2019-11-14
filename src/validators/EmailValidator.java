package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validators.EmailValidator") // siehe Start.xhtml validatorId
public class EmailValidator implements Validator {
	
	final static String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(String.valueOf(value));
		if (!matcher.matches()) {
			FacesMessage fm = new FacesMessage("E-Mail ungultig: " + value);
			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
			
			throw new ValidatorException(fm);
		}
	}

}

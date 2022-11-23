package br.com.fknews.config.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;

public class CustomConstraint<T> implements ConstraintViolation<T> {

	private String message;
	private MessageSource messageSource;
	
	public CustomConstraint(String message, MessageSource messageSource) {
		super();
		this.message = message;
		this.messageSource = messageSource;
	}

	@Override
	public String getMessage() {
		return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
	}

	@Override
	public String getMessageTemplate() {
		return "";
	}

	@Override
	public T getRootBean() {
		return null;
	}

	@Override
	public Class<T> getRootBeanClass() {
		return null;
	}

	@Override
	public Object getLeafBean() {
		return null;
	}

	@Override
	public Path getPropertyPath() {		
		return null;
	}

	@Override
	public Object getInvalidValue() {
		return null;
	}

	@Override
	public ConstraintDescriptor<?> getConstraintDescriptor() {
		return null;
	}

	@Override
	public String toString() {
		return "CustomConstraint [message=" + message + "]";
	}

	@Override
	public Object[] getExecutableParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getExecutableReturnValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> U unwrap(Class<U> type) {
		// TODO Auto-generated method stub
		return null;
	}

}
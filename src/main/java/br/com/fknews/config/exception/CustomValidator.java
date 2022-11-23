package br.com.fknews.config.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

@Component
public class CustomValidator {

	private final Validator validator;
	private final Set<ConstraintViolation<?>> errors;
	private final MessageSource messageSource;

	@Autowired
	public CustomValidator(Validator validator, MessageSource messageSource) {
		super();
		this.validator = validator;
		this.errors = new HashSet<>();
		this.messageSource = messageSource;
	}

	public CustomValidator validate(Object value, Class<?>... groups) {
		this.errors.addAll(validator.validate(value, groups));
		return this;
	}

	public void onErrorThrows() {
		if (!errors.isEmpty()) {
			Set<ConstraintViolation<?>> errors = new HashSet<ConstraintViolation<?>>(this.errors);
			this.errors.clear();
			throw new ConstraintViolationException(errors);
		}
	}

	public CustomValidator assertNotNull(Object value, String message) {
		if (value == null) {
			addNewCustonConstraint(message);
		}
		return this;
	}

	public CustomValidator assertTrue(boolean expression, String message) {
		if (!expression) {
			addNewCustonConstraint(message);
		}
		return this;
	}

	private void addNewCustonConstraint(String message) {
		errors.add(new CustomConstraint<Object>(message, messageSource));
	}
}
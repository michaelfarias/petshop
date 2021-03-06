package com.petshop.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javassist.tools.rmi.ObjectNotFoundException;

//@RestControllerAdvice
public class ErroValidacaoFormHandle {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroValidacaoForm> handle(MethodArgumentNotValidException exception) {
		List<ErroValidacaoForm> errors = new ArrayList<ErroValidacaoForm>();

		List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();

		fieldErros.forEach(e -> {
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroValidacaoForm erro = new ErroValidacaoForm(e.getField(), message);
			errors.add(erro);
		});
		return errors;
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ObjectNotFoundException.class)
	public ErroValidacaoForm objetoNaoEncontrado(ObjectNotFoundException exception) {

		return new ErroValidacaoForm("", exception.getMessage());
	}
}

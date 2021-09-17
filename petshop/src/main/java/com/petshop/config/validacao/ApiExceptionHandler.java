package com.petshop.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.petshop.config.validacao.Problema.Campo;

import javassist.tools.rmi.ObjectNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Problema argumentoInvalido(MethodArgumentNotValidException exception) {
		List<Campo> campos = new ArrayList<>();

		List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();

		Problema problema = new Problema();

		fieldErros.forEach(field -> {
			String nome = field.getField();
			String message = messageSource.getMessage(field, LocaleContextHolder.getLocale());
//			String message = field.getDefaultMessage()

			Campo campo = new Problema.Campo();
			campo.setMensagem(message);
			campo.setNome(nome);

			campos.add(campo);
		});

		problema.setMensagem("Um ou mais campos estão vazios");
		problema.setStatus(HttpStatus.BAD_REQUEST.value());
		problema.setCampos(campos);

		return problema;
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ObjectNotFoundException.class)
	public Problema objetoNaoEncontrado(ObjectNotFoundException exception) {

		Problema problema = new Problema();

		String mensagem = exception.getMessage();

		problema.setMensagem(mensagem);
		problema.setStatus(HttpStatus.NOT_FOUND.value());

		return problema;
	}
}

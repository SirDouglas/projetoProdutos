package br.com.caelum.produto.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {  UsuarioLogado.class })
public @interface LoginAvailable {
	  String message() default "{login_already_exists}";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};
 }

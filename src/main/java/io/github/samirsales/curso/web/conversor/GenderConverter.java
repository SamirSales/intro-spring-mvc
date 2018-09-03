package io.github.samirsales.curso.web.conversor;

import org.springframework.core.convert.converter.Converter;

import io.github.samirsales.curso.domain.Gender;

public class GenderConverter implements Converter<String, Gender>{

	@Override
	public Gender convert(String source) {
		char type = source.charAt(0);		
		return type == Gender.FEMALE.getValue() ? Gender.FEMALE : Gender.MALE;
	}
}

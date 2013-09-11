package com.indra.formacion.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.indra.formacion.spring.util.HolaMundo;

@Configuration
public class Config {
	@Bean @Scope public HolaMundo holaMundo() {
		return new HolaMundo();
	}
}

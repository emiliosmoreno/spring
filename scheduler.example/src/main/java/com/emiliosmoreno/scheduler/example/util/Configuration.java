package com.emiliosmoreno.scheduler.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@PropertySources({
    @PropertySource("classpath:scheluder.properties")
})
public class Configuration {

	@Autowired
	private static Environment env;
	
	public static final String scheluder_cron = env.getProperty("scheluder_cron");
}

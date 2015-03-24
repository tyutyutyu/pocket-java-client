package com.tyutyutyu.pocketjavaclient.integration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IntegrationTestsConfig {

	private final static IntegrationTestsConfig INSTANCE = new IntegrationTestsConfig();

	private final Properties properties;

	public static IntegrationTestsConfig get() {

		return INSTANCE;
	}

	private IntegrationTestsConfig() {

		properties = new Properties();

		try (InputStream in = IntegrationTestsConfig.class.getResourceAsStream("/integration.properties")) {
			properties.load(in);
			in.close();
		} catch (final IOException e) {
			throw new RuntimeException("Error during integration.properties initialization, " + e.getMessage());
		}
	}

	public String getConsumerKey() {

		return properties.getProperty("consumer.key");
	}

	public String getAccessToken() {

		return properties.getProperty("access.token");
	}

}

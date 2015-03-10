package com.tyutyutyu.pocketjavaclient.authorization;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import lombok.AllArgsConstructor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@AllArgsConstructor
@RunWith(Parameterized.class)
public class TokenRequestObjectTest {

	@Parameters
	public static Object[][] createTestData() {

		// @formatter:off
		return new Object[][] {
				{ null, "uri", IllegalArgumentException.class, "Consumer key must be provided" },
				{ "", "uri", IllegalArgumentException.class, "Consumer key must be provided" },
				{ null, null, IllegalArgumentException.class, "Consumer key must be provided" },
				{ "key", null, IllegalArgumentException.class, "Redirect uri must be provided" },
				{ "key", "  ", IllegalArgumentException.class, "Redirect uri must be provided" }, };
		// @formatter:on
	}

	private final String consumerKey;

	private final String redirectUri;

	private final Class<? extends Exception> expectedException;

	private final String expectedMessage;

	@SuppressWarnings({ "unused" })
	@Test
	public void shouldValidateDataOnCreation() {

		try {
			new TokenRequestObject(consumerKey, redirectUri, null);
			if (expectedException != null) {
				fail("Should throw exception");
			}
		} catch (final Exception e) {
			assertThat(e).isExactlyInstanceOf(expectedException);
			assertThat(e).hasMessage(expectedMessage);
		}
	}

}

package utils;

import net.jodah.failsafe.RetryPolicy;

import java.time.Duration;

public class RetryOnFailure {
	
	private RetryOnFailure() {
		super();
	}

	public static RetryPolicy<Object> getRetryPolicy(int timeInSeconds, int maxRetries) {
		return new RetryPolicy<>()
				  .handle(Exception.class)
				  .withDelay(Duration.ofSeconds(timeInSeconds))
				  .withMaxRetries(maxRetries);
	}	
}

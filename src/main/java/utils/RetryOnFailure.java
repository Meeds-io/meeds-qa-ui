package utils;

import java.time.Duration;

import net.jodah.failsafe.RetryPolicy;

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

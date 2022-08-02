package io.meeds.qa.ui.utils;

//import dev.failsafe.RetryPolicy;
//import dev.failsafe.internal.RetryPolicyImpl;

public class RetryOnFailure {

  private RetryOnFailure() {
    super();
  }
//
//  public static RetryPolicy<Object> getRetryPolicy(int timeInSeconds, int maxRetries) {
//    return RetryPolicy.builder()
//                      .handle(Exception.class)
//                      .withDelay(Duration.ofSeconds(timeInSeconds))
//                      .withMaxRetries(maxRetries)
//                      .build();
//  }
}

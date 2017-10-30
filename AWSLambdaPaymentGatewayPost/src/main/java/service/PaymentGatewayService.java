package service;

import api.request.AWSLambdaPaymentPostRequest;
import api.response.AWSLambdaPaymentResponse;

/**
 * Created by hussaiy on 7/07/2017.
 */
public interface PaymentGatewayService {
  AWSLambdaPaymentResponse process(AWSLambdaPaymentPostRequest request);
}

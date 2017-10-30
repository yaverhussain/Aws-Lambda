package service;

import api.request.AWSLambdaPaymentPayRequest;

/**
 * Created by hussaiy on 7/07/2017.
 */
public interface PaymentGatewayService {
  String process(AWSLambdaPaymentPayRequest request);
}

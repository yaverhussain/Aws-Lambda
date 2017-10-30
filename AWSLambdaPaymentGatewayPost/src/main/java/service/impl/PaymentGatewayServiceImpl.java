package service.impl;

import api.request.AWSLambdaPaymentPostRequest;
import api.response.AWSLambdaPaymentResponse;
import service.PaymentGatewayService;

/**
 * Created by hussaiy on 7/07/2017.
 */
public class PaymentGatewayServiceImpl implements PaymentGatewayService {

  private static final String REDIRECT_DESTINATION = "https://vm2ef4a0xl.execute-api.us-east-2.amazonaws.com/beta//payment-gateway-content";

  public AWSLambdaPaymentResponse process(AWSLambdaPaymentPostRequest request) {
    request.processValidation();

    AWSLambdaPaymentResponse response = new AWSLambdaPaymentResponse();
    response.setSuccess("1");
    response.setResponseText("APPROVED");
    response.setHelpText("Transaction Approved");
    response.setDpsTxnRef("mocktxn");
    response.setTxnRef("mocktxn");
    return response;
  }
}

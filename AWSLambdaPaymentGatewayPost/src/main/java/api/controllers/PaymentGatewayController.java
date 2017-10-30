package api.controllers;

import api.request.AWSLambdaPaymentPostRequest;
import api.response.AWSLambdaPaymentResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.apache.commons.lang3.exception.ExceptionUtils;
import service.PaymentGatewayService;
import service.impl.PaymentGatewayServiceImpl;

/**
 * Created by hussaiy on 7/07/2017.
 */
public class PaymentGatewayController {

  private PaymentGatewayService service;

  public PaymentGatewayController() {
    service = new PaymentGatewayServiceImpl();
  }

  public AWSLambdaPaymentResponse processPost(AWSLambdaPaymentPostRequest request, Context context) {
    LambdaLogger logger = context.getLogger();
    logger.log("Request:");
    logger.log(request.toString());
    try {
      return service.process(request);
    } catch (RuntimeException ex) {
      logger.log(ExceptionUtils.getStackTrace(ex));
      return buildErrorResponse(ex.getMessage(), ExceptionUtils.getStackTrace(ex));
    }
  }

  private AWSLambdaPaymentResponse buildErrorResponse(String message, String description) {
    AWSLambdaPaymentResponse response = new AWSLambdaPaymentResponse();
    response.setSuccess("0");
    response.setErrorMessage(message);
    response.setErrorDescription(description);
    response.setResponseText("Declined");
    response.setHelpText("Transaction Declined");
    return response;
  }
}

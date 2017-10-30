package api.controllers;

import api.request.AWSLambdaPaymentPayRequest;
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

  public String processPay(AWSLambdaPaymentPayRequest request, Context context) {
    LambdaLogger logger = context.getLogger();
    logger.log("Request:");
    logger.log(request.toString());
    try {
      return service.process(request);
    } catch (RuntimeException ex) {
      logger.log(ExceptionUtils.getStackTrace(ex));
      return "Error processing";
    }
  }
}

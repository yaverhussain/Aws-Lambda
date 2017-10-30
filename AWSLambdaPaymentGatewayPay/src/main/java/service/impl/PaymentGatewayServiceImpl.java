package service.impl;

import api.request.AWSLambdaPaymentPayRequest;
import org.apache.commons.codec.binary.Base64;
import service.PaymentGatewayService;

/**
 * Created by hussaiy on 7/07/2017.
 */
public class PaymentGatewayServiceImpl implements PaymentGatewayService {

  private static final String REDIRECT_DESTINATION = "https://vm2ef4a0xl.execute-api.us-east-2.amazonaws.com/beta/payment-gateway-content";

  public String process(AWSLambdaPaymentPayRequest request) {
    request.processValidation();
    return buildRedirectURL(request);
  }

  /**
   * Format
   * https://vm2ef4a0xl.execute-api.us-east-2.amazonaws.com/beta/payment-gateway-content/payment-gateway-content?
   * cancel-url=aHR0cDovL3d3dy5nb29nbGUuY29t&total-amount=25&return-url=aHR0cDovL3d3dy5nb29nbGUuY29t&type=1
   *
   * @param request
   * @return
   */

  private String buildRedirectURL(AWSLambdaPaymentPayRequest request) {
    String encodedReturnURL = Base64.encodeBase64URLSafeString(request.getUrlSuccess().getBytes());
    String encodedCancelURL = Base64.encodeBase64URLSafeString(request.getUrlFail().getBytes());

    StringBuilder redirectURL = new StringBuilder(REDIRECT_DESTINATION);
    redirectURL.append("?");
    redirectURL.append("ru=").append(encodedReturnURL).append("&");
    redirectURL.append("cu=").append(encodedCancelURL).append("&");
    redirectURL.append("total-amount=").append(request.getAmount()).append("&");
    redirectURL.append("type=").append(request.getType());

    return redirectURL.toString();
  }
}

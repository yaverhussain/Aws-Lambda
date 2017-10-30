package api.controllers;

import api.util.Helper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by hussaiy on 11/07/2017.
 */
public class PaymentGatewayContentController {

  /**
   * Render CC and AxA payment screens
   * @param inputRequestMap
      {
      //Mandatory
        "return-url" : "$input.params('ru')",
        "cancel-url" : "$input.params('cu')",
        "total-amount" : "$input.params('total-amount')",
        "type" : "$input.params('type')",

        //optional
        "httpMethod": "$context.httpMethod",
        "resourcePath": "$context.resourcePath",
        "body" : "$input.json('$')",
        "headers" : "$input.params().header",
        "query" : "$input.params().querystring",
        "params" : "$input.params().path"
        }
   * @return
   */
  public String renderPaymentPage(Map<String, Object> inputRequestMap, Context context) {
    LambdaLogger logger = context.getLogger();

    logger.log("Input parameters");
    for (Map.Entry<String, Object> entry : inputRequestMap.entrySet()) {
      logger.log("Key:" + entry.getKey() + ", Value:" + entry.getValue());
    }

    StringBuilder validationErrors = new StringBuilder();

    if (inputRequestMap == null || inputRequestMap.size() == 0) {
      validationErrors.append("Input is required.");
    }

    String encodedReturnURL = String.valueOf(inputRequestMap.get("return-url"));
    if (StringUtils.isBlank(encodedReturnURL)) {
      validationErrors.append("Return URL is blank.");
    }

    String encodedCancelURL = String.valueOf(inputRequestMap.get("cancel-url"));
    if (StringUtils.isBlank(encodedCancelURL)) {
      validationErrors.append("Cancel URL is blank.");
    }

    BigDecimal amount = new BigDecimal(String.valueOf(inputRequestMap.get("total-amount")));
    if (amount.doubleValue() == 0) {
      validationErrors.append("Amount is 0.");
    }

    if (validationErrors.length() > 0) {
      logger.log(validationErrors.toString());
      return "Invalid Request";
    }

    int type = Integer.parseInt(String.valueOf(inputRequestMap.get("type")));

    try {
      switch (type) {
        case 1:
        default:
          return Helper.creditCardHTML(encodedReturnURL, encodedCancelURL, amount);
        case 2:
          return Helper.accountHTML(encodedReturnURL, encodedCancelURL, amount);
      }
    } catch (Throwable ex) {
      logger.log(ExceptionUtils.getStackTrace(ex));
      return "Error serving request";
    }
  }
}

package generatejson;

import api.request.AWSLambdaPaymentPayRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

/**
 * Created by hussaiy on 7/07/2017.
 */
public class JSONGenerator {

  public static void main(String[] args) {

    AWSLambdaPaymentPayRequest request = new AWSLambdaPaymentPayRequest();
    request.setEmailAddress("yaver.hussain@fostermoore.com");
    request.setUrlSuccess("https://companiesoffice.govt.nz/companies/");
    request.setUrlFail("http://www.google.com");
    request.setAmount(new BigDecimal(11.11));
    request.setMerchantReference("merchantreference");
    request.setType(1);
    request.setTxnType("txtype");
    {

      try {
        ObjectMapper mapper = new ObjectMapper();
        System.out.print(mapper.writeValueAsString(request));
      } catch (Exception ex) {

      }
    }
  }
}
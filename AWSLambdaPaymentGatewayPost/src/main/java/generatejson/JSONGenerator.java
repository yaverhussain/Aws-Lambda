package generatejson;


import api.request.AWSLambdaPaymentPostRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

public class JSONGenerator {

  public static void main(String[] args) {
  try {
      ObjectMapper mapper = new ObjectMapper();
      AWSLambdaPaymentPostRequest request = new AWSLambdaPaymentPostRequest();
      request.setBillingId("billing");
      request.setAmount(new BigDecimal(100.12));
      request.setMerchantReference("mercreference");
      request.setTxnId("txnid");
      request.setTxnType("purchase");
      request.setTxnData1("setTxnData1");
      request.setTxnData2("setTxnData2");
      System.out.print(mapper.writeValueAsString(request));
    } catch (Exception ex) {

    }

  }
}
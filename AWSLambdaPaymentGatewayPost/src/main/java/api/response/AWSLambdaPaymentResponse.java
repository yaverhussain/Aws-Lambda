package api.response;

import java.io.Serializable;

/**
 * Created by hussaiy on 11/07/2017.
 */
public class AWSLambdaPaymentResponse implements Serializable {
  private static final long serialVersionUID = -3042231072586992825L;
  private String reCo;
  private String responseText;
  private String helpText;
  private String success;
  private String dpsTxnRef;
  private String txnRef;
  private String errorMessage;
  private String errorDescription;
  private String redirectUrl;
  //// TODO: 11/07/2017 Add transaction. All inportant information from there. Reference PxPostResponseBean in Cofee

  public String getRedirectUrl() {
    return redirectUrl;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  public String getReCo() {
    return reCo;
  }

  public void setReCo(String reCo) {
    this.reCo = reCo;
  }

  public String getResponseText() {
    return responseText;
  }

  public void setResponseText(String responseText) {
    this.responseText = responseText;
  }

  public String getHelpText() {
    return helpText;
  }

  public void setHelpText(String helpText) {
    this.helpText = helpText;
  }

  public String getSuccess() {
    return success;
  }

  public void setSuccess(String success) {
    this.success = success;
  }

  public String getDpsTxnRef() {
    return dpsTxnRef;
  }

  public void setDpsTxnRef(String dpsTxnRef) {
    this.dpsTxnRef = dpsTxnRef;
  }

  public String getTxnRef() {
    return txnRef;
  }

  public void setTxnRef(String txnRef) {
    this.txnRef = txnRef;
  }
}

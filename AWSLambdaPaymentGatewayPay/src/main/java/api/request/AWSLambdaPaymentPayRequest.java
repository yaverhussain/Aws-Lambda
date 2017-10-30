package api.request;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by hussaiy on 11/07/2017.
 */
public class AWSLambdaPaymentPayRequest extends AbstractAWSLambdaPaymentBaseRequest {
  private String emailAddress;
  private boolean enableAddBillCard;
  private String urlSuccess;
  private String urlFail;
  private int type;
  private static final long serialVersionUID = -3042231072586992825L;

  @Override
  public void processValidation() {
    super.processValidation();
    validator.validateMandatory("Url Fail ", this.getUrlFail());
    validator.validateMandatory("Url Success ", this.getUrlSuccess());
    String validationErrorMessage = validationErrorMessage();
    if (StringUtils.isNotBlank(validationErrorMessage)) {
      throw new RuntimeException(validationErrorMessage);
    }

    validator.validate(this.getUrlFail().indexOf("&") == -1 && this.getUrlFail().indexOf("?") == -1, "URL Fail", "Invalid ULR Parameters");
    validator.validate(this.getUrlSuccess().indexOf("&") == -1 && this.getUrlSuccess().indexOf("?") == -1, "URL Success", "Invalid ULR Parameters");
    validator.validateFieldSize("emailAddress", this.getEmailAddress(), 0, 255);
    validator.validateNumber("Type", type, 1, 3);

    validationErrorMessage = validationErrorMessage();
    if (StringUtils.isNotBlank(validationErrorMessage)) {
      throw new RuntimeException(validationErrorMessage);
    }
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public boolean isEnableAddBillCard() {
    return enableAddBillCard;
  }

  public void setEnableAddBillCard(boolean enableAddBillCard) {
    this.enableAddBillCard = enableAddBillCard;
  }

  public String getUrlSuccess() {
    return urlSuccess;
  }

  public void setUrlSuccess(String urlSuccess) {
    this.urlSuccess = urlSuccess;
  }

  public String getUrlFail() {
    return urlFail;
  }

  public void setUrlFail(String urlFail) {
    this.urlFail = urlFail;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }


}

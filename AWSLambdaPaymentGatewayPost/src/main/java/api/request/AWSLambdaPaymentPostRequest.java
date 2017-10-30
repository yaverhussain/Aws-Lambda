package api.request;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by hussaiy on 10/07/2017.
 */
public class AWSLambdaPaymentPostRequest extends AbstractAWSLambdaPaymentBaseRequest {
  private static final long serialVersionUID = -1470119674290254768L;
  private String billingId;

  public String getBillingId() {
    return billingId;
  }

  public void setBillingId(String billingId) {
    this.billingId = billingId;
  }

  public void processValidation() {
    super.processValidation();
    validator.validateMandatory("billingId", this.billingId);
    validator.validateFieldSize("billingID", this.billingId, 0, 16);

    String validationErrorMessage = validationErrorMessage();
    if (StringUtils.isNotBlank(validationErrorMessage)) {
      throw new RuntimeException(validationErrorMessage);
    }
  }
}

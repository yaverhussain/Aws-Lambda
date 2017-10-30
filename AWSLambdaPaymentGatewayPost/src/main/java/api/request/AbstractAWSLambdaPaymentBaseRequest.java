package api.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * Created by hussaiy on 11/07/2017.
 */
public abstract class AbstractAWSLambdaPaymentBaseRequest {

  protected Validator validator = new Validator();

  private BigDecimal amount;
  private String currencyInput;
  private String txnId;
  private String txnType;
  private String txnData1;
  private String txnData2;
  private String txnData3;
  private String merchantReference;

  public void processValidation() {
    validator.validateMandatory("amount", this.amount);
    validator.validateNumber("amount", this.amount, 2);
    validator.validateMandatory("Merchant Reference ", this.getMerchantReference());
    validator.validateMandatory("Transaction Type ", this.getTxnType());
    validator.validateFieldSize("Merchant reference", this.getMerchantReference(), 0, 64);
    validator.validateFieldSize("txnId", this.getTxnId(), 0, 16);
    validator.validateFieldSize("txnData1", this.getTxnData1(), 0, 255);
    validator.validateFieldSize("txnData2", this.getTxnData2(), 0, 255);
    validator.validateFieldSize("txnData3", this.getTxnData3(), 0, 255);
  }

  public String toString(){
    return ToStringBuilder.reflectionToString(this);
  }

  protected String validationErrorMessage() {
    return validator.getValidationErrorMessage();
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getCurrencyInput() {
    return currencyInput;
  }

  public void setCurrencyInput(String currencyInput) {
    this.currencyInput = currencyInput;
  }

  public String getTxnId() {
    return txnId;
  }

  public void setTxnId(String txnId) {
    this.txnId = txnId;
  }

  public String getTxnType() {
    return txnType;
  }

  public void setTxnType(String txnType) {
    this.txnType = txnType;
  }

  public String getTxnData1() {
    return txnData1;
  }

  public void setTxnData1(String txnData1) {
    this.txnData1 = txnData1;
  }

  public String getTxnData2() {
    return txnData2;
  }

  public void setTxnData2(String txnData2) {
    this.txnData2 = txnData2;
  }

  public String getTxnData3() {
    return txnData3;
  }

  public void setTxnData3(String txnData3) {
    this.txnData3 = txnData3;
  }

  public String getMerchantReference() {
    return merchantReference;
  }

  public void setMerchantReference(String merchantReference) {
    this.merchantReference = merchantReference;
  }
}

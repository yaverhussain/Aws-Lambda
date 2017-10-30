package api.request;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hussaiy on 11/07/2017.
 */
public class Validator {
  private List<String> validationErrors = new ArrayList<String>();

  public void validateMandatory(String field, Object value) {
    if (value == null) {
      validationErrors.add(field + " is blank.");
    }
  }

  public void validate(boolean condition, String field, String message) {
    if (!condition && StringUtils.isNotBlank(message)) {
      validationErrors.add("Invalid " + field + "." + message);
    }
  }

  public void validateNumber(String field, Integer value, int minimumValue, int maximumValue) {
    if (value == null || value < minimumValue || value > maximumValue) {
      validationErrors.add(field + " is invalid.");
    }
  }

  public void validateNumber(String field, BigDecimal value, int digitsAfterDecimalPoint) {
    if (value == null || value.compareTo(new BigDecimal("0")) <= 0) {
      validationErrors.add(field + " is invalid.");
    }

    String strValue = value.toString();
    int decPointPos = strValue.lastIndexOf(".");
    if (!(decPointPos > 0 && decPointPos >= strValue.length() - 3 && decPointPos < strValue.length() - digitsAfterDecimalPoint)) {
      validationErrors.add(field + " is invalid.");
    }
  }

  public void validateFieldSize(String field, String value, int minimumSize, int maximumSize) {
    if (StringUtils.isBlank(value)) {
      return;
    }

    if (value.length() > maximumSize) {
      validationErrors.add(field + " larger than maximum allowed length(" + maximumSize + ")");
    }
    if (value.length() < minimumSize) {
      validationErrors.add(field + " larger than minimum allowed length(" + maximumSize + ")");
    }
  }

  public String getValidationErrorMessage() {
    StringBuilder validationErrorMessage = new StringBuilder();
    for (String validationError : validationErrors) {
      validationErrorMessage.append(validationError).append(".");
    }
    return validationErrorMessage.toString();
  }
}

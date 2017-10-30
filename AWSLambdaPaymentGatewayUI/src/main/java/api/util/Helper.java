package api.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by hussaiy on 12/07/2017.
 */
public class Helper {
  public static String creditCardHTML(String encodedReturnURL, String encodedCancelURL, BigDecimal amount) {
    String html = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "\n" +
            "<head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "    <title>Credit Card Validation</title>\n" +
            "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans\" rel=\"stylesheet\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">        \n" +
            "\t<style>.creditCardForm { max-width: 700px; background-color: #fff; margin: 100px auto; overflow: hidden; padding: 25px; color: #4c4e56; } .creditCardForm label { width: 100%; margin-bottom: 10px; } .creditCardForm .heading h1 { text-align: center; font-family: 'Open Sans', sans-serif; color: #4c4e56; } .creditCardForm .payment { float: left; font-size: 18px; padding: 10px 25px; margin-top: 20px; position: relative; } .creditCardForm .payment .form-group { float: left; margin-bottom: 15px; } .creditCardForm .payment .form-control { line-height: 40px; height: auto; padding: 0 16px; } .creditCardForm .owner { width: 63%; margin-right: 10px; } .creditCardForm .CVV { width: 35%; } .creditCardForm #card-number-field { width: 100%; } .creditCardForm #expiration-date { width: 49%; } .creditCardForm #credit_cards { width: 50%; margin-top: 25px; text-align: right; } .creditCardForm #pay-now { width: 100%; margin-top: 25px; } .creditCardForm .payment .btn { width: 100%; margin-top: 3px; font-size: 24px; background-color: #2ec4a5; color: white; } .btn-cancel{ width: 100%; margin-top: 3px; font-size: 24px; background-color: #FF0000; color: white; } .creditCardForm .payment select { padding: 10px; margin-right: 15px; } .transparent { opacity: 0.2; } @media(max-width: 650px) { .creditCardForm .owner, .creditCardForm .CVV, .creditCardForm #expiration-date, .creditCardForm #credit_cards { width: 100%; } .creditCardForm #credit_cards { text-align: left; } } /* Examples Section */ *{ margin: 0; padding: 0; box-sizing: border-box; } body{ font: normal 18px sans-serif; color: #333; background-color: #eee; } .container-fluid{ padding:0; margin:0; } header{ box-sizing: border-box; text-align: center; width: 100%; padding: 25px 40px; background-color: #3A56B7; overflow: hidden; } header .limiter{ max-width: 1000px; margin: 0px auto; } header h3{ font: normal 24px/1.5 'Open Sans', sans-serif; float: left; color: #fff; margin:0; } header a{ color:#fff; float: right; text-decoration: none; display: inline-block; padding: 13px 50px; border-radius: 3px; font: bold 14px/1 'Open Sans', sans-serif; text-transform: uppercase; background-color:#F05283; opacity: 0.9; } header a:hover{ color: #fff; text-decoration: none; opacity: 1; } @media (max-width: 850px) { header h3{ float: none; text-align: center; } header a{ margin-top: 20px; float: none; } }</style>\n" +
            "\n" +
            "\t</head>\n" +
            "\n" +
            "<body>\n" +
            "    <div class=\"container-fluid\">\n" +
            "        <header>\n" +
            "            <div class=\"limiter\">\n" +
            "                <h3>Credit Card Payment</h3>                \n" +
            "            </div>\n" +
            "        </header>\n" +
            "        <div class=\"creditCardForm\">\n" +
            "            <div class=\"heading\">\n" +
            "                <h1>Confirm Purchase(#amount)</h1>\n" +
            "            </div>\n" +
            "            <div class=\"payment\">\n" +
            "                <form>\n" +
            "                    <div class=\"form-group owner\">\n" +
            "\t\t\t\t\t    <input type=\"hidden\" id=\"ru\" value=\"returnURLValue\">\n" +
            "\t\t\t\t\t\t<input type=\"hidden\" id=\"cu\" value=\"cancelURLValue\">\t\t\t\t\t\t\n" +
            "                        <label for=\"owner\">Owner</label>\n" +
            "                        <input type=\"text\" class=\"form-control\" id=\"owner\">\n" +
            "                    </div>\n" +
            "                    <div class=\"form-group CVV\">\n" +
            "                        <label for=\"cvv\">CVV</label>\n" +
            "                        <input type=\"text\" class=\"form-control\" id=\"cvv\" maxlength=\"4\" >\n" +
            "                    </div>\n" +
            "                    <div class=\"form-group\" id=\"card-number-field\">\n" +
            "                        <label for=\"cardNumber\">Card Number</label>\n" +
            "                        <input type=\"text\" class=\"form-control\" id=\"cardNumber\" maxlength=\"16\">\n" +
            "                    </div>\n" +
            "                    <div class=\"form-group\" id=\"expiration-date\">\n" +
            "                        <label>Expiration Date</label>\n" +
            "                        <select>\n" +
            "                            <option value=\"01\">January</option>\n" +
            "                            <option value=\"02\">February </option>\n" +
            "                            <option value=\"03\">March</option>\n" +
            "                            <option value=\"04\">April</option>\n" +
            "                            <option value=\"05\">May</option>\n" +
            "                            <option value=\"06\">June</option>\n" +
            "                            <option value=\"07\">July</option>\n" +
            "                            <option value=\"08\">August</option>\n" +
            "                            <option value=\"09\">September</option>\n" +
            "                            <option value=\"10\">October</option>\n" +
            "                            <option value=\"11\">November</option>\n" +
            "                            <option value=\"12\">December</option>\n" +
            "                        </select>\n" +
            "                        <select>\n" +
            "                            <option value=\"16\"> 2016</option>\n" +
            "                            <option value=\"17\"> 2017</option>\n" +
            "                            <option value=\"18\"> 2018</option>\n" +
            "                            <option value=\"19\"> 2019</option>\n" +
            "                            <option value=\"20\"> 2020</option>\n" +
            "                            <option value=\"21\"> 2021</option>\n" +
            "                        </select>\n" +
            "                    </div>                    \n" +
            "                    <div class=\"form-group\" id=\"pay-now\">\n" +
            "                        <button type=\"submit\" class=\"btn btn-default\" id=\"confirm-purchase\">Confirm</button>\n" +
            "\t\t\t\t\t\t<button type=\"submit\" class=\"btn-cancel\" id=\"cancel-purchase\">Cancel</button>\n" +
            "                    </div>\n" +
            "                </form>\n" +
            "            </div>\n" +
            "        </div>        \n" +
            "</body>\n" +
            "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
            "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" +
            "\t<script> $(function() {\n" +
            "    var cancelURL = $('#cu');var returnURL = $('#ru'); var cancelButton = $('#cancel-purchase'); var owner = $('#owner'); var cardNumber = $('#cardNumber'); var cardNumberField = $('#card-number-field'); var CVV = $(\"#cvv\"); var mastercard = $(\"#mastercard\"); var confirmButton = $('#confirm-purchase'); var visa = $(\"#visa\"); var amex = $(\"#amex\");    \n" +
            "    cardNumber.keyup(function() { amex.removeClass('transparent'); visa.removeClass('transparent'); mastercard.removeClass('transparent'); if ($.payform.validateCardNumber(cardNumber.val()) == false) { cardNumberField.addClass('has-error'); } else { cardNumberField.removeClass('has-error'); cardNumberField.addClass('has-success'); } if ($.payform.parseCardType(cardNumber.val()) == 'visa') { mastercard.addClass('transparent'); amex.addClass('transparent'); } else if ($.payform.parseCardType(cardNumber.val()) == 'amex') { mastercard.addClass('transparent'); visa.addClass('transparent'); } else if ($.payform.parseCardType(cardNumber.val()) == 'mastercard') { amex.addClass('transparent'); visa.addClass('transparent'); } });    \n" +
            "    confirmButton.click(function(e) { e.preventDefault(); var creditCardValue = cardNumber.val(); var ccvValue = CVV.val(); if(owner.val().length < 5){ alert(\"Wrong owner name\"); } else if (creditCardValue.length < 16 || isNaN(creditCardValue)) { alert(\"Wrong card number\"); } else if (ccvValue.length < 3 || isNaN(ccvValue)) { alert(\"Wrong CVV\"); } else { alert(\"Everything is correct\");$(location).attr('href', atob(returnURL.val())) } });\n" +
            "\tcancelButton.click(function(e) { e.preventDefault(); $(location).attr('href', atob(cancelURL.val())) });\n" +
            "});</script>\n" +
            "</html>\n";

    return substituteValues(html, encodedReturnURL, encodedCancelURL, amount);
  }

  public static String accountHTML(String encodedReturnURL, String encodedCancelURL, BigDecimal amount) {
    String html = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "\n" +
            "<head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "    <title>Bank Account Validation</title>\n" +
            "    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans\" rel=\"stylesheet\">\n" +
            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">        \n" +
            "\t<style>.creditCardForm { max-width: 700px; background-color: #fff; margin: 100px auto; overflow: hidden; padding: 25px; color: #4c4e56; } .creditCardForm label { width: 100%; margin-bottom: 10px; } .creditCardForm .heading h1 { text-align: center; font-family: 'Open Sans', sans-serif; color: #4c4e56; } .creditCardForm .payment { float: left; font-size: 18px; padding: 10px 25px; margin-top: 20px; position: relative; } .creditCardForm .payment .form-group { float: left; margin-bottom: 15px; } .creditCardForm .payment .form-control { line-height: 40px; height: auto; padding: 0 16px; } .creditCardForm .owner { width: 63%; margin-right: 10px; } .creditCardForm .CVV { width: 35%; } .creditCardForm #card-number-field { width: 100%; } .creditCardForm #expiration-date { width: 49%; } .creditCardForm #credit_cards { width: 50%; margin-top: 25px; text-align: right; } .creditCardForm #pay-now { width: 100%; margin-top: 25px; } .creditCardForm .payment .btn { width: 100%; margin-top: 3px; font-size: 24px; background-color: #2ec4a5; color: white; } .btn-cancel{ width: 100%; margin-top: 3px; font-size: 24px; background-color: #FF0000; color: white; } .creditCardForm .payment select { padding: 10px; margin-right: 15px; } .transparent { opacity: 0.2; } @media(max-width: 650px) { .creditCardForm .owner, .creditCardForm .CVV, .creditCardForm #expiration-date, .creditCardForm #credit_cards { width: 100%; } .creditCardForm #credit_cards { text-align: left; } } /* Examples Section */ *{ margin: 0; padding: 0; box-sizing: border-box; } body{ font: normal 18px sans-serif; color: #333; background-color: #eee; } .container-fluid{ padding:0; margin:0; } header{ box-sizing: border-box; text-align: center; width: 100%; padding: 25px 40px; background-color: #3A56B7; overflow: hidden; } header .limiter{ max-width: 1000px; margin: 0px auto; } header h3{ font: normal 24px/1.5 'Open Sans', sans-serif; float: left; color: #fff; margin:0; } header a{ color:#fff; float: right; text-decoration: none; display: inline-block; padding: 13px 50px; border-radius: 3px; font: bold 14px/1 'Open Sans', sans-serif; text-transform: uppercase; background-color:#F05283; opacity: 0.9; } header a:hover{ color: #fff; text-decoration: none; opacity: 1; } @media (max-width: 850px) { header h3{ float: none; text-align: center; } header a{ margin-top: 20px; float: none; } }</style>\n" +
            "\n" +
            "\t</head>\n" +
            "\n" +
            "<body>\n" +
            "    <div class=\"container-fluid\">\n" +
            "        <header>\n" +
            "            <div class=\"limiter\">\n" +
            "                <h3>Bank Account Payment(#amount)</h3>                \n" +
            "            </div>\n" +
            "        </header>\n" +
            "        <div class=\"creditCardForm\">\n" +
            "            <div class=\"heading\">\n" +
            "                <h1>Confirm Purchase</h1>\n" +
            "            </div>\n" +
            "            <div class=\"payment\">\n" +
            "                <form>\n" +
            "                    <div class=\"form-group owner\">\n" +
            "\t\t\t\t\t    <input type=\"hidden\" id=\"ru\" value=\"returnURLValue\">\n" +
            "\t\t\t\t\t\t<input type=\"hidden\" id=\"cu\" value=\"cancelURLValue\">\n" +
            "                        <label for=\"owner\">Owner</label>\n" +
            "                        <input type=\"text\" class=\"form-control\" id=\"owner\">\n" +
            "                    </div>                    \n" +
            "                    <div class=\"form-group\" id=\"card-number-field\">\n" +
            "                        <label for=\"cardNumber\">Bank Account Number</label>\n" +
            "                        <input type=\"text\" class=\"form-control\" id=\"cardNumber\" maxlength=\"16\">\n" +
            "                    </div>\n" +
            "                    <div class=\"form-group\" id=\"pay-now\">\n" +
            "                        <button type=\"submit\" class=\"btn btn-default\" id=\"confirm-purchase\">Confirm</button>\n" +
            "\t\t\t\t\t\t<button type=\"submit\" class=\"btn-cancel\" id=\"cancel-purchase\">Cancel</button>\n" +
            "                    </div>\n" +
            "                </form>\n" +
            "            </div>\n" +
            "        </div>        \n" +
            "</body>\n" +
            "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
            "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" +
            "\t<script> $(function() {\n" +
            "    var cancelURL = $('#cu');var returnURL = $('#ru'); var cancelButton = $('#cancel-purchase'); var owner = $('#owner'); var cardNumber = $('#cardNumber'); var cardNumberField = $('#card-number-field'); var CVV = $(\"#cvv\"); var mastercard = $(\"#mastercard\"); var confirmButton = $('#confirm-purchase'); var visa = $(\"#visa\"); var amex = $(\"#amex\");        \n" +
            "    confirmButton.click(function(e) { e.preventDefault(); var creditCardValue = cardNumber.val();  if(owner.val().length < 5){ alert(\"Wrong owner name\"); } else if (creditCardValue.length < 16 || isNaN(creditCardValue)) { alert(\"Wrong account number\"); } else { alert(\"Everything is correct\");$(location).attr('href', atob(returnURL.val())) } });\n" +
            "\tcancelButton.click(function(e) { e.preventDefault(); $(location).attr('href', atob(cancelURL.val())) });\n" +
            "});</script>\n" +
            "</html>\n";
    return substituteValues(html, encodedReturnURL, encodedCancelURL, amount);
  }

  private static String substituteValues(String html, String encodedReturnURL, String encodedCancelURL, BigDecimal amount) {
    html = html.replace("returnURLValue", validateEncodedURL(encodedReturnURL));
    html = html.replace("cancelURLValue", validateEncodedURL(encodedCancelURL));
    html = html.replace("#amount", "$" + String.valueOf(amount));
    return html;
  }

  private static String validateEncodedURL(String encodedURL) {
    try {
      new URL(new String(Base64.decodeBase64(encodedURL), "UTF-8")).toURI(); // validate
      return encodedURL;
    } catch (URISyntaxException ex) {
      throw new RuntimeException("Invalid encoded URL" + encodedURL, ex);
    } catch (MalformedURLException ex) {
      throw new RuntimeException("Invalid encoded URL" + encodedURL, ex);
    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException("Invalid encoded URL" + encodedURL, ex);
    }
  }
}

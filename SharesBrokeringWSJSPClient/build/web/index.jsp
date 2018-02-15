<%-- 
    Document   : index
    Created on : 05-Jan-2018, 16:30:19
    Author     : Daanny
--%>

<%@page import="org.sharesbrokering.ShareInfo"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="org.sharesbrokering.SharePrice"%>
<%@page import="org.sharesbrokering.Shares"%>
<%@page import="java.util.List"%>
<%@page import="org.sharesbrokering.Share"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css" media="all" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <title>Shares Brokering</title>
    </head>    
    <body>
        <div class="wrapper">
            <div class="container-sb">
                <div class="sb-currency">
                    <h1 style="color: green">Shares Brokering</h1>
                    <div class="update-and-currency-wrapper">
                        <form method="post">
                            <input type="submit" name="updateShares" value="Submit" class="button-update-shares">
                        </form>
                        <%
                            if (request.getParameter("buySharesButton") != null) {
                                try {
                                    org.sharesbrokering.SharesBrokeringWS_Service service = new org.sharesbrokering.SharesBrokeringWS_Service();
                                    org.sharesbrokering.SharesBrokeringWS port = service.getSharesBrokeringWSPort();
                                    int shareAmount = Integer.parseInt(request.getParameter("buyShares"));
                                    String shareSymbol = request.getParameter("shareID");
                                    int amount = shareAmount;

                                    java.lang.String sharesSymbol = shareSymbol;
                                    // TODO process result here
                                    java.util.List<org.sharesbrokering.Share> result = port.buyShares(amount, sharesSymbol);
                                } catch (Exception ex) {
                                    // TODO handle custom exceptions here
                                }
                            }
                        %>

                        <%
                            if (request.getParameter("updateShares") != null) {  
                                try {
                                    org.sharesbrokering.SharesBrokeringWS_Service service = new org.sharesbrokering.SharesBrokeringWS_Service();
                                    org.sharesbrokering.SharesBrokeringWS port = service.getSharesBrokeringWSPort();
                                    // TODO process result here
                                    java.util.List<org.sharesbrokering.Share> result = port.updateSharesRefresh();
                                } catch (Exception ex) {
                                    // TODO handle custom exceptions here
                                }
                            }
                        %>
                        <form method="get">
                            <select name="currencySelector" onchange="this.form.submit();">
                                <%
                                    try {
                                        CurrencyConversonWS.CurrencyConversionWSService service = new CurrencyConversonWS.CurrencyConversionWSService();
                                        CurrencyConversonWS.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
                                        java.util.List<java.lang.String> result = port.getCurrencyCodes();
                                        Iterator itr = result.iterator();
                                        while (itr.hasNext()) {
                                            String cc = (String) itr.next();
                                            out.println("<option id='" + cc.substring(0, 3) + "'value='" + cc.substring(0, 3) + "'>" + cc + "</option>");
                                        }
                                    } catch (Exception ex) {
                                        // TODO handle custom exceptions here
                                    }
                                %>
                            </select>
                            <script>
                                $(document).ready(function () {
                                    $url = window.location.href;
                                    $variables = $url.split("?");
                                    $variable2 = $variables[1].split("=");
                                    $currency = $variable2[1];
                                    $('#' + $currency).attr("selected", "true");
                                });
                            </script>
                        </form>   
                    </div>
                <div class="sb-all-shares">
                    <table class="sb-table">
                        <tr class="sb-table-heading">
                            <th>Comapny Name</th>
                            <th>Company Symbol</th> 
                            <th>Available Shares</th>
                            <th>Share Value</th>
                            <th>Currency</th>
                            <th></th>
                        </tr>    
                        <%
                            String selectedLanguage = "";
                            double conversionResult = 0.0;
                            if (request.getParameter("currencySelector") != null) {
                                String selectedCurrency = request.getParameter("currencySelector");
                                try {
                                    CurrencyConversonWS.CurrencyConversionWSService service = new CurrencyConversonWS.CurrencyConversionWSService();
                                    CurrencyConversonWS.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
                                    // TODO initialize WS operation arguments here
                                    java.lang.String arg1 = selectedCurrency.substring(0, 3);
                                    java.lang.String arg0 = "GBP";
                                    // TODO process result here
                                    selectedLanguage = arg1;
                                    double result = port.getConversionRate(arg0, arg1);
                                    conversionResult = result;
                                } catch (Exception ex) {
                                    // TODO handle custom exceptions here
                                }
                            }

                            try {
                                org.sharesbrokering.SharesBrokeringWS_Service service = new org.sharesbrokering.SharesBrokeringWS_Service();
                                org.sharesbrokering.SharesBrokeringWS port = service.getSharesBrokeringWSPort();
                                // TODO process result here
                                java.util.List<org.sharesbrokering.Share> result = port.getAvailableShares();
                                org.sharesbrokering.Share share = new org.sharesbrokering.Share();
                                org.sharesbrokering.SharePrice sharePrice;
                                Iterator itr = result.iterator();
                                while (itr.hasNext()) {
                                    share = (org.sharesbrokering.Share) itr.next();
                                    out.println("<tr class=\"sb-table-item\">");
                                    out.println("<td>" + "<img src='//logo.clearbit.com/" + share.getCompanyName() +".com?size=50'>" + share.getCompanyName() + "</td>");
                                    out.println("<td>" + share.getCompanySymbol() + "</td>");
                                    out.println("<td>" + share.getAvailableShares() + "</td>");
                                    Iterator itr2 = share.getSharePrice().iterator();
                                    while (itr2.hasNext()) {
                                        sharePrice = (SharePrice) itr2.next();
                                        DecimalFormat df = new DecimalFormat("0.00##");
                                        String dfResult = df.format(sharePrice.getValue() * conversionResult);
                                        out.println("<td>" + dfResult + "</td>");
                                        out.println("<td>" + selectedLanguage + "</td>");
                                        out.println("<td class='sb-buy-item'><form class='sb-buy-shares' method='post'><input type='text' value='"+share.getCompanySymbol() +"' name='shareID' hidden><input type='text' name='buyShares' class='form-buy-shares'><input type='submit' name='buySharesButton' value='Buy' class='form-buyshares-submit'></form></td>");                
                                        out.println("</tr>");}
                                }
                                //out.println("</tr>");
                            } catch (Exception ex) {
                                // TODO handle custom exceptions here
                            }
                        %>
                    </table>
                </div>
                         
                <form class="form-search-name" method="post">
                    <input type="text" name="searchName" class="form-search-input">
                    <input type="submit" name="searchNameButton" value="Submit" class="form-search-submit">
                </form>
                <table class="sb-table">
                    <tr class="sb-table-heading">
                        <th>Comapny Name</th>
                        <th>Company Symbol</th> 
                        <th>Available Shares</th>
                        <th>Share Value</th>
                        <th>Currency</th>
                    </tr> 
                    <%
                        if (request.getParameter("searchNameButton") != null) {
                            String userInput = request.getParameter("searchName");
                            try {
                                org.sharesbrokering.SharesBrokeringWS_Service service = new org.sharesbrokering.SharesBrokeringWS_Service();
                                org.sharesbrokering.SharesBrokeringWS port = service.getSharesBrokeringWSPort();
                                java.lang.String searchParameter = "";
                                java.util.List<org.sharesbrokering.Share> result = port.searchSharePriceOrName(userInput);
                                org.sharesbrokering.Share share = new org.sharesbrokering.Share();
                                org.sharesbrokering.SharePrice sharePrice;
                                Iterator itr = result.iterator();
                                while (itr.hasNext()) {
                                    share = (org.sharesbrokering.Share) itr.next();
                                    out.println("<tr class=\"sb-table-item\">");
                                    out.println("<td>" + share.getCompanyName() + "</td>");
                                    out.println("<td>" + share.getCompanySymbol() + "</td>");
                                    out.println("<td>" + share.getAvailableShares() + "</td>");
                                    Iterator itr2 = share.getSharePrice().iterator();
                                    while (itr2.hasNext()) {
                                        sharePrice = (org.sharesbrokering.SharePrice) itr2.next();
                                        out.println("<td>" + sharePrice.getValue() + "</td>");
                                        out.println("<td>" + sharePrice.getCurrency() + "</td>");
                                    }
                                }
                                out.println("</tr>");
                            } catch (Exception ex) {
                                // TODO handle custom exceptions here
                            }
                        }
                    %>
                </table>
                
                <div class="sell-shares-wrapper">
                    <form class="form-sell-share" method="post">
                        <input type="text" name="shareCompName" class="form-input-sell-share" placeholder="Company Name">
                        <input type="text" name="shareSymbol" class="form-input-sell-share" placeholder="Company Symbol">
                        <input type="text" name="shareAvailable" class="form-input-sell-share" placeholder="Available Shares">
                        <input type="text" name="shareCurrency" class="form-input-sell-share" placeholder="Currency">
                        <input type="text" name="shareValue" class="form-input-sell-share" placeholder="Value">
                        <input type="submit" name="sellShareButton" value="Submit" class="form-sell-button">
                    </form>  
                    <%
                        if (request.getParameter("sellShareButton") != null) {
                            String sellCompanyName = request.getParameter("shareCompName");
                            String sellShareSymbol = request.getParameter("shareSymbol");
                            String sellShareAvailable = request.getParameter("shareAvailable");
                            String sellShareCurrency = request.getParameter("shareCurrency");
                            String sellShareValue = request.getParameter("shareValue");
                            try {
                                org.sharesbrokering.SharesBrokeringWS_Service service = new org.sharesbrokering.SharesBrokeringWS_Service();
                                org.sharesbrokering.SharesBrokeringWS port = service.getSharesBrokeringWSPort();
                                java.lang.String companyName = sellCompanyName;
                                java.lang.String companySymbol = sellShareSymbol;
                                int availableShares = Integer.parseInt(sellShareAvailable);
                                java.lang.String currency = sellShareCurrency;
                                float value = Float.parseFloat(sellShareValue);
                                java.util.List<org.sharesbrokering.Share> result = port.sellShare(companyName, companySymbol, availableShares, currency, value);
                                out.println("Result = "+result);
                            } catch (Exception ex) {
                                // TODO handle custom exceptions here
                            }
                        }
                    %>
                </div>
                
                
                
                
                
                
            </div>
                
            <div class="container-api">
                <form class="form-company-info" method="post">
                    <input type="text" name="searchCompanyInfo" class="form-search-comp-info" placeholder="Search Company News">
                    <input type="submit" name="searchCompNameButton" value="Submit" class="form-search-compp-info">
                </form>

                <%
                    try {
                        org.sharesbrokering.SharesBrokeringWS_Service service = new org.sharesbrokering.SharesBrokeringWS_Service();
                        org.sharesbrokering.SharesBrokeringWS port = service.getSharesBrokeringWSPort();
                        String userInput = request.getParameter("searchCompanyInfo");
                        java.util.List<org.sharesbrokering.ShareInfo> result = port.getNewsOnline(userInput);
                        ShareInfo shareInfo;
                        Iterator itr = result.iterator();
                        while(itr.hasNext()) {
                            shareInfo = (ShareInfo) itr.next();
                            out.println("<div class='comp-info-wrapper'>");
                            out.println("<div class='comp-info-img'>");
                            out.println("<img class='comp-img' src='" + shareInfo.getImageURL() + "' width='200px' height='150px'>");
                            out.println("</div>");
                            out.println("<div class='comp-information'>");
                            out.println("<div class='comp-info-newstitle'>" + shareInfo.getNewsTitle() + "</div>");
                            out.println("<div class='flex-wrapper'>");
                            out.println("<div class='comp-info-author'>" + shareInfo.getNewsAuthor()+ "</div>");
                            out.println("<div class='comp-info-date'>" + shareInfo.getPublishedDate()+ "</div>");
                            out.println("</div>");
                            out.println("<div class='comp-info-description'>" + shareInfo.getNewsDescription()+ "</div>");
                            out.println("<a href='" + shareInfo.getNewsURL() + "' target='_blank'> Read More</a>");
                            out.println("</div>");
                            out.println("</div>");
                        }
                    } catch (Exception ex) {
                        // TODO handle custom exceptions here
                    }
                %>
            </div>
        </div>
    </body>
</html>

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.sharesbrokering.ShareInfo;
import java.text.DecimalFormat;
import org.sharesbrokering.SharePrice;
import org.sharesbrokering.Shares;
import java.util.List;
import org.sharesbrokering.Share;
import java.util.Iterator;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <title>Shares Brokering</title>\n");
      out.write("    </head>    \n");
      out.write("    <body>\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <div class=\"container-sb\">\n");
      out.write("                <div class=\"sb-currency\">\n");
      out.write("                    <h1 style=\"color: green\">Shares Brokering</h1>\n");
      out.write("                    <div class=\"update-and-currency-wrapper\">\n");
      out.write("                        <form method=\"post\">\n");
      out.write("                            <input type=\"submit\" name=\"updateShares\" value=\"Submit\" class=\"button-update-shares\">\n");
      out.write("                        </form>\n");
      out.write("                        ");

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
                        
      out.write("\n");
      out.write("\n");
      out.write("                        ");

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
                        
      out.write("\n");
      out.write("                        <form method=\"get\">\n");
      out.write("                            <select name=\"currencySelector\" onchange=\"this.form.submit();\">\n");
      out.write("                                ");

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
                                
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <script>\n");
      out.write("                                $(document).ready(function () {\n");
      out.write("                                    $url = window.location.href;\n");
      out.write("                                    $variables = $url.split(\"?\");\n");
      out.write("                                    $variable2 = $variables[1].split(\"=\");\n");
      out.write("                                    $currency = $variable2[1];\n");
      out.write("                                    $('#' + $currency).attr(\"selected\", \"true\");\n");
      out.write("                                });\n");
      out.write("                            </script>\n");
      out.write("                        </form>   \n");
      out.write("                    </div>\n");
      out.write("                <div class=\"sb-all-shares\">\n");
      out.write("                    <table class=\"sb-table\">\n");
      out.write("                        <tr class=\"sb-table-heading\">\n");
      out.write("                            <th>Comapny Name</th>\n");
      out.write("                            <th>Company Symbol</th> \n");
      out.write("                            <th>Available Shares</th>\n");
      out.write("                            <th>Share Value</th>\n");
      out.write("                            <th>Currency</th>\n");
      out.write("                            <th></th>\n");
      out.write("                        </tr>    \n");
      out.write("                        ");

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
                        
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                         \n");
      out.write("                <form class=\"form-search-name\" method=\"post\">\n");
      out.write("                    <input type=\"text\" name=\"searchName\" class=\"form-search-input\">\n");
      out.write("                    <input type=\"submit\" name=\"searchNameButton\" value=\"Submit\" class=\"form-search-submit\">\n");
      out.write("                </form>\n");
      out.write("                <table class=\"sb-table\">\n");
      out.write("                    <tr class=\"sb-table-heading\">\n");
      out.write("                        <th>Comapny Name</th>\n");
      out.write("                        <th>Company Symbol</th> \n");
      out.write("                        <th>Available Shares</th>\n");
      out.write("                        <th>Share Value</th>\n");
      out.write("                        <th>Currency</th>\n");
      out.write("                    </tr> \n");
      out.write("                    ");

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
                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("                \n");
      out.write("                <div class=\"sell-shares-wrapper\">\n");
      out.write("                    <form class=\"form-sell-share\" method=\"post\">\n");
      out.write("                        <input type=\"text\" name=\"shareCompName\" class=\"form-input-sell-share\" placeholder=\"Company Name\">\n");
      out.write("                        <input type=\"text\" name=\"shareSymbol\" class=\"form-input-sell-share\" placeholder=\"Company Symbol\">\n");
      out.write("                        <input type=\"text\" name=\"shareAvailable\" class=\"form-input-sell-share\" placeholder=\"Available Shares\">\n");
      out.write("                        <input type=\"text\" name=\"shareCurrency\" class=\"form-input-sell-share\" placeholder=\"Currency\">\n");
      out.write("                        <input type=\"text\" name=\"shareValue\" class=\"form-input-sell-share\" placeholder=\"Value\">\n");
      out.write("                        <input type=\"submit\" name=\"sellShareButton\" value=\"Submit\" class=\"form-sell-button\">\n");
      out.write("                    </form>  \n");
      out.write("                    ");

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
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("            <div class=\"container-api\">\n");
      out.write("                <form class=\"form-company-info\" method=\"post\">\n");
      out.write("                    <input type=\"text\" name=\"searchCompanyInfo\" class=\"form-search-comp-info\" placeholder=\"Search Company News\">\n");
      out.write("                    <input type=\"submit\" name=\"searchCompNameButton\" value=\"Submit\" class=\"form-search-compp-info\">\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

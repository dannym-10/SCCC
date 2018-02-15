 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.SharesBrokering;

import SharesBinding.Share;
import SharesBinding.SharePrice;
import SharesBinding.Shares;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.SharesInformation.ShareInfo;
import org.SharesInformation.ShareInfoList;

/**
 *
 * @author Daanny
 */
@WebService(serviceName = "SharesBrokeringWS")
@Stateless()
public class SharesBrokeringWS {

    @WebMethod(operationName = "getAvailableShares")
    public List<Share> getAvailableShares() {
        Shares allSharesList = unmarshalShares();
        List<Share> returnList = allSharesList.getShare();
        Iterator itr = returnList.iterator();
        Share nextShare;
        Shares returned = new Shares();
        List<Share> returnedList2 = returned.getShare();
        while (itr.hasNext()) {
            nextShare = (Share) itr.next();
            if (nextShare.getAvailableShares() > 0) {
                returnedList2.add(nextShare);
            }
        }
        return returnedList2;
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "unmarshalShares")
    public Shares unmarshalShares() {
        Shares shares = new Shares();
        String file = "C:\\Users\\Danny\\Documents\\NetBeansProjects\\New\\SharesBrokering\\sharesXML.xml";
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            shares = (Shares) unmarshaller.unmarshal(new java.io.File(file)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return shares;
    }

    /**
     * Web service operation
     *
     * @param amount
     * @param sharesSymbol
     * @return
     */
    @WebMethod(operationName = "buyShares")
    public List<Share> buyShares(@WebParam(name = "amount") int amount, @WebParam(name = "sharesSymbol") String sharesSymbol) {
        String filePath = "C:\\Users\\Danny\\Documents\\NetBeansProjects\\New\\SharesBrokering\\sharesXML.xml";
        File XMLFile = new File(filePath);
        int theAmount = amount;
        String theSharesSymbol = sharesSymbol.toUpperCase();
        Share share;
        Shares shares = unmarshalShares();
        List<Share> sharesList = shares.getShare();
        Iterator itr = sharesList.iterator();
        while (itr.hasNext()) {
            share = (Share) itr.next();
            if (share.getCompanySymbol().toUpperCase().equals(theSharesSymbol)) {
                share.setAvailableShares(share.getAvailableShares() - theAmount);
            }
        }
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(shares, XMLFile);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return sharesList;
    }

    /**
     * Web service operation
     *
     * @param quandlCodeName
     * @return
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    @WebMethod(operationName = "getSharesOnline")
    public Shares getSharesOnline(@WebParam(name = "quandlCodeName") String quandlCodeName) throws IOException, ParseException {
        String mainUrl = "https://www.quandl.com/api/v3/datasets/WIKI/";
        String theQuandlCodeName = quandlCodeName.toUpperCase();
        String jsonParameter = ".json?api_key=xNuuF6iy81mcxpVut_Tr&rows=8";
        String filePath = "C:\\Users\\Danny\\Documents\\NetBeansProjects\\New\\SharesBrokering\\sharesXML.xml";
        File XMLFile = new File(filePath);
        try {
            URL url = new URL(mainUrl + theQuandlCodeName + jsonParameter);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() != 200) {
                throw new IOException(conn.getResponseMessage());
            }
            JsonReader json = Json.createReader(conn.getInputStream());
            JsonObject jo = json.readObject();
            JsonObject dataset = jo.getJsonObject("dataset");
            String companySymbol = dataset.getString("dataset_code");
            String companyName = Arrays.toString(dataset.getString("name").split("\\("));
//            System.out.println(companyName.substring(0));
//            System.out.println(companyName.substring(1));
            JsonArray data = dataset.getJsonArray("data").getJsonArray(0);
            int closeValue = data.getInt(4);
            System.out.println(data.get(0));
            int volume = data.getInt(5);
            if (theQuandlCodeName.equals(companySymbol)) {
                Share share = new Share();
                SharePrice sharePrice = new SharePrice();
                share.setCompanyName(companyName);
                share.setCompanySymbol(companySymbol);
                share.setAvailableShares(volume);
                sharePrice.setCurrency("USD");
                try {
                    GregorianCalendar c = new GregorianCalendar();
                    c.setTime(new Date());
                    XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
                    sharePrice.setLastUpdate(xmlDate);
                } catch (DatatypeConfigurationException e) {
                    System.out.println(e);
                }
                sharePrice.setValue(closeValue);
                share.getSharePrice().add(sharePrice);

                Shares shares = unmarshalShares();
                List<Share> shareList = shares.getShare();
                Iterator itr = shareList.iterator();
                Share currentShare;
                while (itr.hasNext()) {
                    currentShare = (Share) itr.next();
                    SharePrice currentSharePrice;
                    Iterator itr2 = currentShare.getSharePrice().iterator();
                    while (itr2.hasNext()) {
                        currentSharePrice = (SharePrice) itr2.next();
                        if (currentShare.getCompanySymbol().equals(share.getCompanySymbol())) {
                            currentShare.setAvailableShares(share.getAvailableShares());
                            currentSharePrice.setValue(sharePrice.getValue());
                            try {
                                javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
                                javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
                                marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
                                marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                                marshaller.marshal(shares, XMLFile);
                            } catch (javax.xml.bind.JAXBException ex) {
                                // XXXTODO Handle exception
                                java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
                            }
                        }
                    }
                }
                return shares;
            }
        } catch (MalformedURLException me) {
            System.out.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe);
        }
        return null;
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "updateSharesRefresh")
    public List<Share> updateSharesRefresh() {
        Shares shares = unmarshalShares();
        Share share;
        //SharePrice sharePrice;
        List<Share> sharesList = shares.getShare();
        Iterator itr = sharesList.iterator();
        while (itr.hasNext()) {
            share = (Share) itr.next();
            try {
                getSharesOnline(share.getCompanySymbol());
            } catch (IOException ex) {
                Logger.getLogger(SharesBrokeringWS.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(SharesBrokeringWS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sharesList;
    }

    /**
     * Web service operation
     *
     * @param searchParameter
     * @return
     */
    @WebMethod(operationName = "searchSharePriceOrName")
    public List<Share> searchSharePriceOrName(@WebParam(name = "searchParameter") String searchParameter) {
        String theSearchParameter = searchParameter.toUpperCase();

        Shares shares = unmarshalShares();
        Share share;
        SharePrice sharePrice;
        List<Share> returnedList = shares.getShare();

        Shares shares2 = new Shares();
        List<Share> newReturnedList = shares2.getShare();

        Iterator itr = returnedList.iterator();
        while (itr.hasNext()) {
            share = (Share) itr.next();
            boolean checker = false;
            Iterator itr2 = share.getSharePrice().iterator();
            while (itr2.hasNext()) {
                sharePrice = (SharePrice) itr2.next();
                try {
                    if ((share.getCompanyName().toUpperCase().contains(theSearchParameter)) || (share.getCompanySymbol().toUpperCase().contains(theSearchParameter))) {
                        checker = true;
                        break;
                    } else if ((sharePrice.getValue() < Integer.parseInt(theSearchParameter)) && (sharePrice.getValue() > 0)) {
                        checker = true;
                        break;
                    }
                } catch (NumberFormatException e){
                    checker = false;
                }
            }
            if (checker == true) {
                newReturnedList.add(share);
            }
        }
        return newReturnedList;
    }

    /**
     * Web service operation
     *
     * @param companyName
     * @return
     */
    @WebMethod(operationName = "getNewsOnline")
    public List<ShareInfo> getNewsOnline(@WebParam(name = "companyName") String companyName) {
        String theCompanyName = companyName;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String theDate = dateFormat.format(date);
        String url1 = "https://newsapi.org/v2/everything?q=";
        String urlDate = "&from=" + theDate;
        String url2 = "&sortBy=popularity&apiKey=7c8d22dd11b84fd99f8b518f0ec66e86&pageSize=4";
        try {
            URL url = new URL(url1 + theCompanyName.toLowerCase() + urlDate + url2);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() != 200) {
                throw new IOException(conn.getResponseMessage());
            }
            JsonReader json = Json.createReader(conn.getInputStream());
            JsonObject jo = json.readObject();
            JsonArray articles = jo.getJsonArray("articles");
            ShareInfoList sil = new ShareInfoList();
            List<ShareInfo> shareNewsList = sil.getShareInfo();
            for (int i = 0; i < articles.size(); i++) {
                JsonObject article = articles.getJsonObject(i);            
                ShareInfo shareInfo = new ShareInfo();
                shareInfo.setNewsTitle(article.getString("title"));
                shareInfo.setNewsAuthor(article.getString("author"));
                shareInfo.setNewsDescription(article.getString("description"));
                shareInfo.setNewsURL(article.getString("url"));
                shareInfo.setImageURL(article.getString("urlToImage"));
                shareInfo.setPublishedDate(article.getString("publishedAt"));
                shareNewsList.add(shareInfo);
            }
            return shareNewsList;
        } catch (MalformedURLException me) {
            System.out.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe);
        }
        return null;
    }

    /**
     * Web service operation
     * @param companyName
     * @param companySymbol
     * @param availableShares
     * @param currency
     * @param value
     * @return 
     */
    @WebMethod(operationName = "sellShare")
    public List<Share> sellShare(@WebParam(name = "companyName") String companyName,
            @WebParam(name = "companySymbol") String companySymbol, 
            @WebParam(name = "availableShares") int availableShares,
            @WebParam(name = "currency") String currency,
            @WebParam(name = "value") float value) {
        String filePath = "C:\\Users\\Danny\\Documents\\NetBeansProjects\\New\\SharesBrokering\\sharesXML.xml";
        File file = new File(filePath);
        String theCompanyName = companyName;
        String theCompanySymbol = companySymbol;
        int theAvailableShares = availableShares;
        String theCurrency = currency;
        float theValue = value;
        Shares shares = unmarshalShares();
        List<Share> allShares = shares.getShare();
        Share newShare = new Share();
        newShare.setCompanyName(theCompanyName);
        newShare.setCompanySymbol(theCompanySymbol);
        newShare.setAvailableShares(theAvailableShares);
        SharePrice newSharePrice = new SharePrice();
        newSharePrice.setCurrency(theCurrency);
        newSharePrice.setValue(theValue);
        try{
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            newSharePrice.setLastUpdate(xmlDate);
        }catch(Exception e){
            System.out.println(e);
        }
        newShare.getSharePrice().add(newSharePrice);
        allShares.add(newShare);
        
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(shares, file);
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return allShares;
    }
}

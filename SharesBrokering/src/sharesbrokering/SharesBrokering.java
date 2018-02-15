/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharesbrokering;

import SharesBinding.Shares;
import SharesBinding.Share;
import SharesBinding.SharePrice;
import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Daanny
 */
public class SharesBrokering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File XMLFile = new File("sharesXML.xml");
        
        Shares shares = new Shares();
        List<Share> allShares = shares.getShare();
        Share share;
        SharePrice sharePrice;
        
        //Adds Apple share
        share = new Share();
        share.setCompanyName("Apple");
        share.setCompanySymbol("AAPL");
        share.setAvailableShares(1461);
        sharePrice = new SharePrice();
        sharePrice.setCurrency("GBP");
        sharePrice.setValue((float) 175.51);
        try{
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            sharePrice.setLastUpdate(xmlDate);
        }catch(Exception e){
            System.out.println(e);
        }
        
        share.getSharePrice().add(sharePrice);
        allShares.add(share);
        
        //Adds Microsoft share
        share = new Share();
        share.setCompanyName("Microsoft");
        share.setCompanySymbol("MSFT");
        share.setAvailableShares(2195);
        sharePrice = new SharePrice();
        sharePrice.setCurrency("GBP");
        sharePrice.setValue((float) 85.88);
        try{
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            sharePrice.setLastUpdate(xmlDate);
        }catch(DatatypeConfigurationException e){
            System.out.println(e);
        }
        share.getSharePrice().add(sharePrice);
        allShares.add(share);
        
        //Adds Sony share
        share = new Share();
        share.setCompanyName("Sony");
        share.setCompanySymbol("SNE");
        share.setAvailableShares(8224);
        sharePrice = new SharePrice();
        sharePrice.setCurrency("GBP");
        sharePrice.setValue((float) 45.21);
        try{
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            sharePrice.setLastUpdate(xmlDate);
        }catch(Exception e){
            System.out.println(e);
        }
        share.getSharePrice().add(sharePrice);
        allShares.add(share);

        //Adds Tesla share
        share = new Share();
        share.setCompanyName("Tesla");
        share.setCompanySymbol("TSLA");
        share.setAvailableShares(147);
        sharePrice = new SharePrice();
        sharePrice.setCurrency("GBP");
        sharePrice.setValue((float) 321.21);
        try{
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            sharePrice.setLastUpdate(xmlDate);
        }catch(Exception e){
            System.out.println(e);
        }
        share.getSharePrice().add(sharePrice);
        allShares.add(share);
        
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

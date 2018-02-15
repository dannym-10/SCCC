/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharesbrokering;

import java.io.File;
import java.util.List;
import SharesBinding.*;
import java.util.Iterator;


/**
 *
 * @author Daanny
 */
public class unmarshalShares {
    public static void main(String[] args) {
        unmarshalShares unmarshal = new unmarshalShares();
        unmarshal.getAllShares();
    }

    public List<Share> getAllShares() {
        File xmlFile = new File("sharesXML.xml");
        Shares shares = new Shares();       

        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(shares.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            shares = (Shares) unmarshaller.unmarshal(xmlFile); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        List<Share> shareList = shares.getShare();
        Share nextShare; 
        SharePrice sharePrice;
        Iterator itr = shareList.iterator();
        while(itr.hasNext()) {
            nextShare = (Share) itr.next();
            Iterator itr2 = nextShare.getSharePrice().iterator();
            while(itr2.hasNext()) {
                sharePrice = (SharePrice) itr2.next();
                if("GBP".equals(sharePrice.getCurrency())) {
                   System.out.println(nextShare.getCompanyName());
                }
            }
        }
        return shareList;
    }
}

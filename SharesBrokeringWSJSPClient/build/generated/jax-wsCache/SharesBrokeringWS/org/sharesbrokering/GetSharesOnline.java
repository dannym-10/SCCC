
package org.sharesbrokering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSharesOnline complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSharesOnline"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="quandlCodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSharesOnline", propOrder = {
    "quandlCodeName"
})
public class GetSharesOnline {

    protected String quandlCodeName;

    /**
     * Gets the value of the quandlCodeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuandlCodeName() {
        return quandlCodeName;
    }

    /**
     * Sets the value of the quandlCodeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuandlCodeName(String value) {
        this.quandlCodeName = value;
    }

}

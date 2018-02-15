
package org.sharesbrokering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchSharePriceOrName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchSharePriceOrName"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="searchParameter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchSharePriceOrName", propOrder = {
    "searchParameter"
})
public class SearchSharePriceOrName {

    protected String searchParameter;

    /**
     * Gets the value of the searchParameter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchParameter() {
        return searchParameter;
    }

    /**
     * Sets the value of the searchParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchParameter(String value) {
        this.searchParameter = value;
    }

}

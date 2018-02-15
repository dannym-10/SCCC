
package org.sharesbrokering;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Share complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Share"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="companySymbol" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="availableShares" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="sharePrice" type="{http://SharesBrokering.org/}sharePrice" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Share", propOrder = {
    "companyName",
    "companySymbol",
    "availableShares",
    "sharePrice"
})
public class Share {

    @XmlElement(required = true)
    protected String companyName;
    @XmlElement(required = true)
    protected String companySymbol;
    protected int availableShares;
    @XmlElement(nillable = true)
    protected List<SharePrice> sharePrice;

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the companySymbol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanySymbol() {
        return companySymbol;
    }

    /**
     * Sets the value of the companySymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanySymbol(String value) {
        this.companySymbol = value;
    }

    /**
     * Gets the value of the availableShares property.
     * 
     */
    public int getAvailableShares() {
        return availableShares;
    }

    /**
     * Sets the value of the availableShares property.
     * 
     */
    public void setAvailableShares(int value) {
        this.availableShares = value;
    }

    /**
     * Gets the value of the sharePrice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sharePrice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSharePrice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SharePrice }
     * 
     * 
     */
    public List<SharePrice> getSharePrice() {
        if (sharePrice == null) {
            sharePrice = new ArrayList<SharePrice>();
        }
        return this.sharePrice;
    }

}

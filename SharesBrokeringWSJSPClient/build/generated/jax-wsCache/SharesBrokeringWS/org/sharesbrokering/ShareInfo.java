
package org.sharesbrokering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shareInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shareInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="imageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newsAuthor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newsDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newsTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newsURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="publishedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shareInfo", propOrder = {
    "imageURL",
    "newsAuthor",
    "newsDescription",
    "newsTitle",
    "newsURL",
    "publishedDate"
})
public class ShareInfo {

    protected String imageURL;
    protected String newsAuthor;
    protected String newsDescription;
    protected String newsTitle;
    protected String newsURL;
    protected String publishedDate;

    /**
     * Gets the value of the imageURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Sets the value of the imageURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageURL(String value) {
        this.imageURL = value;
    }

    /**
     * Gets the value of the newsAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewsAuthor() {
        return newsAuthor;
    }

    /**
     * Sets the value of the newsAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewsAuthor(String value) {
        this.newsAuthor = value;
    }

    /**
     * Gets the value of the newsDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewsDescription() {
        return newsDescription;
    }

    /**
     * Sets the value of the newsDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewsDescription(String value) {
        this.newsDescription = value;
    }

    /**
     * Gets the value of the newsTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * Sets the value of the newsTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewsTitle(String value) {
        this.newsTitle = value;
    }

    /**
     * Gets the value of the newsURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewsURL() {
        return newsURL;
    }

    /**
     * Sets the value of the newsURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewsURL(String value) {
        this.newsURL = value;
    }

    /**
     * Gets the value of the publishedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     * Sets the value of the publishedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublishedDate(String value) {
        this.publishedDate = value;
    }

}

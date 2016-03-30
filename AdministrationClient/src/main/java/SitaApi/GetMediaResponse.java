
package SitaApi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetMediaResult" type="{http://cims.nl/}ArrayOfMedia" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getMediaResult"
})
@XmlRootElement(name = "GetMediaResponse")
public class GetMediaResponse {

    @XmlElement(name = "GetMediaResult")
    protected ArrayOfMedia getMediaResult;

    /**
     * Gets the value of the getMediaResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMedia }
     *     
     */
    public ArrayOfMedia getGetMediaResult() {
        return getMediaResult;
    }

    /**
     * Sets the value of the getMediaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMedia }
     *     
     */
    public void setGetMediaResult(ArrayOfMedia value) {
        this.getMediaResult = value;
    }

}

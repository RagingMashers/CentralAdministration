
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
 *         &lt;element name="GetMediaFResult" type="{http://cims.nl/}ArrayOfMedia" minOccurs="0"/&gt;
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
    "getMediaFResult"
})
@XmlRootElement(name = "GetMediaFResponse")
public class GetMediaFResponse {

    @XmlElement(name = "GetMediaFResult")
    protected ArrayOfMedia getMediaFResult;

    /**
     * Gets the value of the getMediaFResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMedia }
     *     
     */
    public ArrayOfMedia getGetMediaFResult() {
        return getMediaFResult;
    }

    /**
     * Sets the value of the getMediaFResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMedia }
     *     
     */
    public void setGetMediaFResult(ArrayOfMedia value) {
        this.getMediaFResult = value;
    }

}

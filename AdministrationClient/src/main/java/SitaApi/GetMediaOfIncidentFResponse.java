
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
 *         &lt;element name="GetMediaOfIncidentFResult" type="{http://cims.nl/}ArrayOfMedia" minOccurs="0"/&gt;
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
    "getMediaOfIncidentFResult"
})
@XmlRootElement(name = "GetMediaOfIncidentFResponse")
public class GetMediaOfIncidentFResponse {

    @XmlElement(name = "GetMediaOfIncidentFResult")
    protected ArrayOfMedia getMediaOfIncidentFResult;

    /**
     * Gets the value of the getMediaOfIncidentFResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMedia }
     *     
     */
    public ArrayOfMedia getGetMediaOfIncidentFResult() {
        return getMediaOfIncidentFResult;
    }

    /**
     * Sets the value of the getMediaOfIncidentFResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMedia }
     *     
     */
    public void setGetMediaOfIncidentFResult(ArrayOfMedia value) {
        this.getMediaOfIncidentFResult = value;
    }

}

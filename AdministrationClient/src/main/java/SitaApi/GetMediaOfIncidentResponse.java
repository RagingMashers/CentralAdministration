
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
 *         &lt;element name="GetMediaOfIncidentResult" type="{http://cims.nl/}ArrayOfAnyType" minOccurs="0"/&gt;
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
    "getMediaOfIncidentResult"
})
@XmlRootElement(name = "GetMediaOfIncidentResponse")
public class GetMediaOfIncidentResponse {

    @XmlElement(name = "GetMediaOfIncidentResult")
    protected ArrayOfAnyType getMediaOfIncidentResult;

    /**
     * Gets the value of the getMediaOfIncidentResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAnyType }
     *     
     */
    public ArrayOfAnyType getGetMediaOfIncidentResult() {
        return getMediaOfIncidentResult;
    }

    /**
     * Sets the value of the getMediaOfIncidentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAnyType }
     *     
     */
    public void setGetMediaOfIncidentResult(ArrayOfAnyType value) {
        this.getMediaOfIncidentResult = value;
    }

}

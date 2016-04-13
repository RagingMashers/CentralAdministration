
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
 *         &lt;element name="GetIncidentsResult" type="{http://cims.nl/}ArrayOfIncident" minOccurs="0"/&gt;
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
    "getIncidentsResult"
})
@XmlRootElement(name = "GetIncidentsResponse")
public class GetIncidentsResponse {

    @XmlElement(name = "GetIncidentsResult")
    protected ArrayOfIncident getIncidentsResult;

    /**
     * Gets the value of the getIncidentsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfIncident }
     *     
     */
    public ArrayOfIncident getGetIncidentsResult() {
        return getIncidentsResult;
    }

    /**
     * Sets the value of the getIncidentsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfIncident }
     *     
     */
    public void setGetIncidentsResult(ArrayOfIncident value) {
        this.getIncidentsResult = value;
    }

}

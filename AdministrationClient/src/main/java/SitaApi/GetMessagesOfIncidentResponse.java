
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
 *         &lt;element name="GetMessagesOfIncidentResult" type="{http://cims.nl/}ArrayOfMessage" minOccurs="0"/&gt;
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
    "getMessagesOfIncidentResult"
})
@XmlRootElement(name = "GetMessagesOfIncidentResponse")
public class GetMessagesOfIncidentResponse {

    @XmlElement(name = "GetMessagesOfIncidentResult")
    protected ArrayOfMessage getMessagesOfIncidentResult;

    /**
     * Gets the value of the getMessagesOfIncidentResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMessage }
     *     
     */
    public ArrayOfMessage getGetMessagesOfIncidentResult() {
        return getMessagesOfIncidentResult;
    }

    /**
     * Sets the value of the getMessagesOfIncidentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMessage }
     *     
     */
    public void setGetMessagesOfIncidentResult(ArrayOfMessage value) {
        this.getMessagesOfIncidentResult = value;
    }

}

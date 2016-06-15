
package SitaApi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="incident" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="directionOfMessages" type="{http://cims.nl/}DirectionType"/&gt;
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
    "incident",
    "directionOfMessages"
})
@XmlRootElement(name = "GetMessagesOfIncident")
public class GetMessagesOfIncident {

    protected int incident;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected DirectionType directionOfMessages;

    /**
     * Gets the value of the incident property.
     * 
     */
    public int getIncident() {
        return incident;
    }

    /**
     * Sets the value of the incident property.
     * 
     */
    public void setIncident(int value) {
        this.incident = value;
    }

    /**
     * Gets the value of the directionOfMessages property.
     * 
     * @return
     *     possible object is
     *     {@link DirectionType }
     *     
     */
    public DirectionType getDirectionOfMessages() {
        return directionOfMessages;
    }

    /**
     * Sets the value of the directionOfMessages property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectionType }
     *     
     */
    public void setDirectionOfMessages(DirectionType value) {
        this.directionOfMessages = value;
    }

}

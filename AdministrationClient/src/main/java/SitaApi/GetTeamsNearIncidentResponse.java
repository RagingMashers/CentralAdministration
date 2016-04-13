
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
 *         &lt;element name="GetTeamsNearIncidentResult" type="{http://cims.nl/}ArrayOfTeam" minOccurs="0"/&gt;
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
    "getTeamsNearIncidentResult"
})
@XmlRootElement(name = "GetTeamsNearIncidentResponse")
public class GetTeamsNearIncidentResponse {

    @XmlElement(name = "GetTeamsNearIncidentResult")
    protected ArrayOfTeam getTeamsNearIncidentResult;

    /**
     * Gets the value of the getTeamsNearIncidentResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTeam }
     *     
     */
    public ArrayOfTeam getGetTeamsNearIncidentResult() {
        return getTeamsNearIncidentResult;
    }

    /**
     * Sets the value of the getTeamsNearIncidentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTeam }
     *     
     */
    public void setGetTeamsNearIncidentResult(ArrayOfTeam value) {
        this.getTeamsNearIncidentResult = value;
    }

}

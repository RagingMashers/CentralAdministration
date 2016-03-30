
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
 *         &lt;element name="GetToxicationsResult" type="{http://cims.nl/}ArrayOfToxication" minOccurs="0"/&gt;
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
    "getToxicationsResult"
})
@XmlRootElement(name = "GetToxicationsResponse")
public class GetToxicationsResponse {

    @XmlElement(name = "GetToxicationsResult")
    protected ArrayOfToxication getToxicationsResult;

    /**
     * Gets the value of the getToxicationsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfToxication }
     *     
     */
    public ArrayOfToxication getGetToxicationsResult() {
        return getToxicationsResult;
    }

    /**
     * Sets the value of the getToxicationsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfToxication }
     *     
     */
    public void setGetToxicationsResult(ArrayOfToxication value) {
        this.getToxicationsResult = value;
    }

}


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
 *         &lt;element name="GetActionPlansResult" type="{http://cims.nl/}ArrayOfActionPlan" minOccurs="0"/&gt;
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
    "getActionPlansResult"
})
@XmlRootElement(name = "GetActionPlansResponse")
public class GetActionPlansResponse {

    @XmlElement(name = "GetActionPlansResult")
    protected ArrayOfActionPlan getActionPlansResult;

    /**
     * Gets the value of the getActionPlansResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfActionPlan }
     *     
     */
    public ArrayOfActionPlan getGetActionPlansResult() {
        return getActionPlansResult;
    }

    /**
     * Sets the value of the getActionPlansResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfActionPlan }
     *     
     */
    public void setGetActionPlansResult(ArrayOfActionPlan value) {
        this.getActionPlansResult = value;
    }

}

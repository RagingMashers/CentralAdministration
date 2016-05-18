
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
 *         &lt;element name="GetTasksFromActionPlanResult" type="{http://cims.nl/}ArrayOfTask" minOccurs="0"/&gt;
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
    "getTasksFromActionPlanResult"
})
@XmlRootElement(name = "GetTasksFromActionPlanResponse")
public class GetTasksFromActionPlanResponse {

    @XmlElement(name = "GetTasksFromActionPlanResult")
    protected ArrayOfTask getTasksFromActionPlanResult;

    /**
     * Gets the value of the getTasksFromActionPlanResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTask }
     *     
     */
    public ArrayOfTask getGetTasksFromActionPlanResult() {
        return getTasksFromActionPlanResult;
    }

    /**
     * Sets the value of the getTasksFromActionPlanResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTask }
     *     
     */
    public void setGetTasksFromActionPlanResult(ArrayOfTask value) {
        this.getTasksFromActionPlanResult = value;
    }

}

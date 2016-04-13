
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
 *         &lt;element name="DeleteIncidentResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "deleteIncidentResult"
})
@XmlRootElement(name = "DeleteIncidentResponse")
public class DeleteIncidentResponse {

    @XmlElement(name = "DeleteIncidentResult")
    protected boolean deleteIncidentResult;

    /**
     * Gets the value of the deleteIncidentResult property.
     * 
     */
    public boolean isDeleteIncidentResult() {
        return deleteIncidentResult;
    }

    /**
     * Sets the value of the deleteIncidentResult property.
     * 
     */
    public void setDeleteIncidentResult(boolean value) {
        this.deleteIncidentResult = value;
    }

}

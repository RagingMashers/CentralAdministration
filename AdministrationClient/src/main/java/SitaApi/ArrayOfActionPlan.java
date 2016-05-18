
package SitaApi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfActionPlan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfActionPlan"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ActionPlan" type="{http://cims.nl/}ActionPlan" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfActionPlan", propOrder = {
    "actionPlan"
})
public class ArrayOfActionPlan {

    @XmlElement(name = "ActionPlan", nillable = true)
    protected List<ActionPlan> actionPlan;

    /**
     * Gets the value of the actionPlan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actionPlan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActionPlan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActionPlan }
     * 
     * 
     */
    public List<ActionPlan> getActionPlan() {
        if (actionPlan == null) {
            actionPlan = new ArrayList<ActionPlan>();
        }
        return this.actionPlan;
    }

}

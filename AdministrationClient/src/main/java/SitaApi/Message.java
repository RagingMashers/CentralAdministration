
package SitaApi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Message complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Message"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Team" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DirectionOfMessage" type="{http://cims.nl/}DirectionType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Message", propOrder = {
    "id",
    "team",
    "description",
    "title",
    "directionOfMessage"
})
public class Message {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Team")
    protected int team;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "DirectionOfMessage", required = true)
    @XmlSchemaType(name = "string")
    protected DirectionType directionOfMessage;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the team property.
     * 
     */
    public int getTeam() {
        return team;
    }

    /**
     * Sets the value of the team property.
     * 
     */
    public void setTeam(int value) {
        this.team = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the directionOfMessage property.
     * 
     * @return
     *     possible object is
     *     {@link DirectionType }
     *     
     */
    public DirectionType getDirectionOfMessage() {
        return directionOfMessage;
    }

    /**
     * Sets the value of the directionOfMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectionType }
     *     
     */
    public void setDirectionOfMessage(DirectionType value) {
        this.directionOfMessage = value;
    }

}

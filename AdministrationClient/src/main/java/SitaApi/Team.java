
package SitaApi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Team complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Team"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Type" type="{http://cims.nl/}ServiceType"/&gt;
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="PersonsInTeam" type="{http://cims.nl/}ArrayOfPerson" minOccurs="0"/&gt;
 *         &lt;element name="ResourcesAvailableToTeam" type="{http://cims.nl/}ArrayOfResource" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Team", propOrder = {
    "id",
    "type",
    "startDate",
    "endDate",
    "longitude",
    "latitude",
    "personsInTeam",
    "resourcesAvailableToTeam"
})
public class Team {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected ServiceType type;
    @XmlElement(name = "StartDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "Longitude")
    protected double longitude;
    @XmlElement(name = "Latitude")
    protected double latitude;
    @XmlElement(name = "PersonsInTeam")
    protected ArrayOfPerson personsInTeam;
    @XmlElement(name = "ResourcesAvailableToTeam")
    protected ArrayOfResource resourcesAvailableToTeam;

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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceType }
     *     
     */
    public ServiceType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceType }
     *     
     */
    public void setType(ServiceType value) {
        this.type = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     */
    public void setLongitude(double value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the latitude property.
     * 
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     */
    public void setLatitude(double value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the personsInTeam property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPerson }
     *     
     */
    public ArrayOfPerson getPersonsInTeam() {
        return personsInTeam;
    }

    /**
     * Sets the value of the personsInTeam property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPerson }
     *     
     */
    public void setPersonsInTeam(ArrayOfPerson value) {
        this.personsInTeam = value;
    }

    /**
     * Gets the value of the resourcesAvailableToTeam property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfResource }
     *     
     */
    public ArrayOfResource getResourcesAvailableToTeam() {
        return resourcesAvailableToTeam;
    }

    /**
     * Sets the value of the resourcesAvailableToTeam property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfResource }
     *     
     */
    public void setResourcesAvailableToTeam(ArrayOfResource value) {
        this.resourcesAvailableToTeam = value;
    }

}

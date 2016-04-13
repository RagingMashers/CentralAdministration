
package SitaApi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BackupRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BackupRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="DateAndTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="FullFilled" type="{http://cims.nl/}RequestFullFilled"/&gt;
 *         &lt;element name="Longtitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RequestedService" type="{http://cims.nl/}ServiceType"/&gt;
 *         &lt;element name="TeamAssigned" type="{http://cims.nl/}Team" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BackupRequest", propOrder = {
    "id",
    "dateAndTime",
    "fullFilled",
    "longtitude",
    "latitude",
    "description",
    "requestedService",
    "teamAssigned"
})
public class BackupRequest {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "DateAndTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateAndTime;
    @XmlElement(name = "FullFilled", required = true)
    @XmlSchemaType(name = "string")
    protected RequestFullFilled fullFilled;
    @XmlElement(name = "Longtitude")
    protected double longtitude;
    @XmlElement(name = "Latitude")
    protected double latitude;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "RequestedService", required = true)
    @XmlSchemaType(name = "string")
    protected ServiceType requestedService;
    @XmlElement(name = "TeamAssigned")
    protected Team teamAssigned;

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
     * Gets the value of the dateAndTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateAndTime() {
        return dateAndTime;
    }

    /**
     * Sets the value of the dateAndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateAndTime(XMLGregorianCalendar value) {
        this.dateAndTime = value;
    }

    /**
     * Gets the value of the fullFilled property.
     * 
     * @return
     *     possible object is
     *     {@link RequestFullFilled }
     *     
     */
    public RequestFullFilled getFullFilled() {
        return fullFilled;
    }

    /**
     * Sets the value of the fullFilled property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestFullFilled }
     *     
     */
    public void setFullFilled(RequestFullFilled value) {
        this.fullFilled = value;
    }

    /**
     * Gets the value of the longtitude property.
     * 
     */
    public double getLongtitude() {
        return longtitude;
    }

    /**
     * Sets the value of the longtitude property.
     * 
     */
    public void setLongtitude(double value) {
        this.longtitude = value;
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
     * Gets the value of the requestedService property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceType }
     *     
     */
    public ServiceType getRequestedService() {
        return requestedService;
    }

    /**
     * Sets the value of the requestedService property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceType }
     *     
     */
    public void setRequestedService(ServiceType value) {
        this.requestedService = value;
    }

    /**
     * Gets the value of the teamAssigned property.
     * 
     * @return
     *     possible object is
     *     {@link Team }
     *     
     */
    public Team getTeamAssigned() {
        return teamAssigned;
    }

    /**
     * Sets the value of the teamAssigned property.
     * 
     * @param value
     *     allowed object is
     *     {@link Team }
     *     
     */
    public void setTeamAssigned(Team value) {
        this.teamAssigned = value;
    }

}

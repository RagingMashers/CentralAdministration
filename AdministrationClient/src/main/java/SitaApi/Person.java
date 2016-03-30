
package SitaApi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Person complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Person"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DayOfBirth" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="Occupation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="HomeLongitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="HomeLatitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Available" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Teams" type="{http://cims.nl/}ArrayOfTeam" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person", propOrder = {
    "id",
    "name",
    "dayOfBirth",
    "occupation",
    "homeLongitude",
    "homeLatitude",
    "available",
    "teams"
})
public class Person {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "DayOfBirth", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dayOfBirth;
    @XmlElement(name = "Occupation")
    protected String occupation;
    @XmlElement(name = "HomeLongitude")
    protected double homeLongitude;
    @XmlElement(name = "HomeLatitude")
    protected double homeLatitude;
    @XmlElement(name = "Available")
    protected boolean available;
    @XmlElement(name = "Teams")
    protected ArrayOfTeam teams;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the dayOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDayOfBirth() {
        return dayOfBirth;
    }

    /**
     * Sets the value of the dayOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDayOfBirth(XMLGregorianCalendar value) {
        this.dayOfBirth = value;
    }

    /**
     * Gets the value of the occupation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * Sets the value of the occupation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOccupation(String value) {
        this.occupation = value;
    }

    /**
     * Gets the value of the homeLongitude property.
     * 
     */
    public double getHomeLongitude() {
        return homeLongitude;
    }

    /**
     * Sets the value of the homeLongitude property.
     * 
     */
    public void setHomeLongitude(double value) {
        this.homeLongitude = value;
    }

    /**
     * Gets the value of the homeLatitude property.
     * 
     */
    public double getHomeLatitude() {
        return homeLatitude;
    }

    /**
     * Sets the value of the homeLatitude property.
     * 
     */
    public void setHomeLatitude(double value) {
        this.homeLatitude = value;
    }

    /**
     * Gets the value of the available property.
     * 
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the value of the available property.
     * 
     */
    public void setAvailable(boolean value) {
        this.available = value;
    }

    /**
     * Gets the value of the teams property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTeam }
     *     
     */
    public ArrayOfTeam getTeams() {
        return teams;
    }

    /**
     * Sets the value of the teams property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTeam }
     *     
     */
    public void setTeams(ArrayOfTeam value) {
        this.teams = value;
    }

}

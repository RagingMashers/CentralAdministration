
package SitaApi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Resource complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Resource"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Available" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="TypeOFResource" type="{http://cims.nl/}ResourseType" minOccurs="0"/&gt;
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
@XmlType(name = "Resource", propOrder = {
    "id",
    "longitude",
    "latitude",
    "available",
    "typeOFResource",
    "teams"
})
public class Resource {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Longitude")
    protected double longitude;
    @XmlElement(name = "Latitude")
    protected double latitude;
    @XmlElement(name = "Available")
    protected boolean available;
    @XmlElement(name = "TypeOFResource")
    protected ResourseType typeOFResource;
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
     * Gets the value of the typeOFResource property.
     * 
     * @return
     *     possible object is
     *     {@link ResourseType }
     *     
     */
    public ResourseType getTypeOFResource() {
        return typeOFResource;
    }

    /**
     * Sets the value of the typeOFResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourseType }
     *     
     */
    public void setTypeOFResource(ResourseType value) {
        this.typeOFResource = value;
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

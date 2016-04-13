
package SitaApi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Incident complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Incident"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="AmountVictims" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="AmountWounded" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Radius" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Dangerlevel" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BackupRequests" type="{http://cims.nl/}ArrayOfBackupRequest" minOccurs="0"/&gt;
 *         &lt;element name="MediaItems" type="{http://cims.nl/}ArrayOfMedia" minOccurs="0"/&gt;
 *         &lt;element name="ToxicElements" type="{http://cims.nl/}ArrayOfToxication" minOccurs="0"/&gt;
 *         &lt;element name="TeamsOnLocation" type="{http://cims.nl/}ArrayOfTeam" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Incident", propOrder = {
    "id",
    "amountVictims",
    "amountWounded",
    "longitude",
    "latitude",
    "radius",
    "dangerlevel",
    "description",
    "backupRequests",
    "mediaItems",
    "toxicElements",
    "teamsOnLocation"
})
public class Incident {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "AmountVictims")
    protected int amountVictims;
    @XmlElement(name = "AmountWounded")
    protected int amountWounded;
    @XmlElement(name = "Longitude")
    protected double longitude;
    @XmlElement(name = "Latitude")
    protected double latitude;
    @XmlElement(name = "Radius")
    protected int radius;
    @XmlElement(name = "Dangerlevel")
    protected int dangerlevel;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "BackupRequests")
    protected ArrayOfBackupRequest backupRequests;
    @XmlElement(name = "MediaItems")
    protected ArrayOfMedia mediaItems;
    @XmlElement(name = "ToxicElements")
    protected ArrayOfToxication toxicElements;
    @XmlElement(name = "TeamsOnLocation")
    protected ArrayOfTeam teamsOnLocation;

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
     * Gets the value of the amountVictims property.
     * 
     */
    public int getAmountVictims() {
        return amountVictims;
    }

    /**
     * Sets the value of the amountVictims property.
     * 
     */
    public void setAmountVictims(int value) {
        this.amountVictims = value;
    }

    /**
     * Gets the value of the amountWounded property.
     * 
     */
    public int getAmountWounded() {
        return amountWounded;
    }

    /**
     * Sets the value of the amountWounded property.
     * 
     */
    public void setAmountWounded(int value) {
        this.amountWounded = value;
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
     * Gets the value of the radius property.
     * 
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Sets the value of the radius property.
     * 
     */
    public void setRadius(int value) {
        this.radius = value;
    }

    /**
     * Gets the value of the dangerlevel property.
     * 
     */
    public int getDangerlevel() {
        return dangerlevel;
    }

    /**
     * Sets the value of the dangerlevel property.
     * 
     */
    public void setDangerlevel(int value) {
        this.dangerlevel = value;
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
     * Gets the value of the backupRequests property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBackupRequest }
     *     
     */
    public ArrayOfBackupRequest getBackupRequests() {
        return backupRequests;
    }

    /**
     * Sets the value of the backupRequests property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBackupRequest }
     *     
     */
    public void setBackupRequests(ArrayOfBackupRequest value) {
        this.backupRequests = value;
    }

    /**
     * Gets the value of the mediaItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMedia }
     *     
     */
    public ArrayOfMedia getMediaItems() {
        return mediaItems;
    }

    /**
     * Sets the value of the mediaItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMedia }
     *     
     */
    public void setMediaItems(ArrayOfMedia value) {
        this.mediaItems = value;
    }

    /**
     * Gets the value of the toxicElements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfToxication }
     *     
     */
    public ArrayOfToxication getToxicElements() {
        return toxicElements;
    }

    /**
     * Sets the value of the toxicElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfToxication }
     *     
     */
    public void setToxicElements(ArrayOfToxication value) {
        this.toxicElements = value;
    }

    /**
     * Gets the value of the teamsOnLocation property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTeam }
     *     
     */
    public ArrayOfTeam getTeamsOnLocation() {
        return teamsOnLocation;
    }

    /**
     * Sets the value of the teamsOnLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTeam }
     *     
     */
    public void setTeamsOnLocation(ArrayOfTeam value) {
        this.teamsOnLocation = value;
    }

}

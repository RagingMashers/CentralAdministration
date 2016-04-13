
package SitaApi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Toxication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Toxication"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ChemicalCompound" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DangerLevel" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Volatility" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Toxication", propOrder = {
    "id",
    "name",
    "description",
    "chemicalCompound",
    "dangerLevel",
    "volatility"
})
public class Toxication {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "ChemicalCompound")
    protected String chemicalCompound;
    @XmlElement(name = "DangerLevel")
    protected int dangerLevel;
    @XmlElement(name = "Volatility")
    protected double volatility;

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
     * Gets the value of the chemicalCompound property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChemicalCompound() {
        return chemicalCompound;
    }

    /**
     * Sets the value of the chemicalCompound property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChemicalCompound(String value) {
        this.chemicalCompound = value;
    }

    /**
     * Gets the value of the dangerLevel property.
     * 
     */
    public int getDangerLevel() {
        return dangerLevel;
    }

    /**
     * Sets the value of the dangerLevel property.
     * 
     */
    public void setDangerLevel(int value) {
        this.dangerLevel = value;
    }

    /**
     * Gets the value of the volatility property.
     * 
     */
    public double getVolatility() {
        return volatility;
    }

    /**
     * Sets the value of the volatility property.
     * 
     */
    public void setVolatility(double value) {
        this.volatility = value;
    }

}

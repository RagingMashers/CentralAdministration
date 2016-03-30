
package SitaApi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="FireMan"/&gt;
 *     &lt;enumeration value="Ambulance"/&gt;
 *     &lt;enumeration value="Police"/&gt;
 *     &lt;enumeration value="ME"/&gt;
 *     &lt;enumeration value="FireManAir"/&gt;
 *     &lt;enumeration value="EmergencyHelicopter"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ServiceType")
@XmlEnum
public enum ServiceType {

    @XmlEnumValue("FireMan")
    FIRE_MAN("FireMan"),
    @XmlEnumValue("Ambulance")
    AMBULANCE("Ambulance"),
    @XmlEnumValue("Police")
    POLICE("Police"),
    ME("ME"),
    @XmlEnumValue("FireManAir")
    FIRE_MAN_AIR("FireManAir"),
    @XmlEnumValue("EmergencyHelicopter")
    EMERGENCY_HELICOPTER("EmergencyHelicopter");
    private final String value;

    ServiceType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceType fromValue(String v) {
        for (ServiceType c: ServiceType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}


package SitaApi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Importance.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Importance"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="HIGH"/&gt;
 *     &lt;enumeration value="MID"/&gt;
 *     &lt;enumeration value="LOW"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "Importance")
@XmlEnum
public enum Importance {

    HIGH,
    MID,
    LOW;

    public String value() {
        return name();
    }

    public static Importance fromValue(String v) {
        return valueOf(v);
    }

}

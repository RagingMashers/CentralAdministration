
package SitaApi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DirectionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DirectionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="T"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DirectionType")
@XmlEnum
public enum DirectionType {

    T,
    E;

    public String value() {
        return name();
    }

    public static DirectionType fromValue(String v) {
        return valueOf(v);
    }

}

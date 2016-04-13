
package SitaApi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestFullFilled.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RequestFullFilled"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ARRIVED"/&gt;
 *     &lt;enumeration value="INMOTION"/&gt;
 *     &lt;enumeration value="FORMING"/&gt;
 *     &lt;enumeration value="DENIED"/&gt;
 *     &lt;enumeration value="UNSPECIFIED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RequestFullFilled")
@XmlEnum
public enum RequestFullFilled {

    ARRIVED,
    INMOTION,
    FORMING,
    DENIED,
    UNSPECIFIED;

    public String value() {
        return name();
    }

    public static RequestFullFilled fromValue(String v) {
        return valueOf(v);
    }

}


package SitaApi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MediaAccepted.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MediaAccepted"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="YES"/&gt;
 *     &lt;enumeration value="NO"/&gt;
 *     &lt;enumeration value="UNSPECIFIED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MediaAccepted")
@XmlEnum
public enum MediaAccepted {

    YES,
    NO,
    UNSPECIFIED;

    public String value() {
        return name();
    }

    public static MediaAccepted fromValue(String v) {
        return valueOf(v);
    }

}

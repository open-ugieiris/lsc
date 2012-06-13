//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.13 at 12:49:36 PM CEST 
//


package org.lsc.configuration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ldapAuthenticationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ldapAuthenticationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="SIMPLE"/>
 *     &lt;enumeration value="SASL"/>
 *     &lt;enumeration value="DIGEST-MD5"/>
 *     &lt;enumeration value="GSSAPI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ldapAuthenticationType")
@XmlEnum
public enum LdapAuthenticationType {

    NONE("NONE"),
    SIMPLE("SIMPLE"),
    SASL("SASL"),
    @XmlEnumValue("DIGEST-MD5")
    DIGEST_MD_5("DIGEST-MD5"),
    GSSAPI("GSSAPI");
    private final String value;

    LdapAuthenticationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LdapAuthenticationType fromValue(String v) {
        for (LdapAuthenticationType c: LdapAuthenticationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

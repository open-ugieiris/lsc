//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.21 at 05:33:44 PM CEST 
//


package org.lsc.configuration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ldapConnectionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ldapConnectionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://lsc-project.org/XSD/lsc-core-2.0.xsd}connectionType">
 *       &lt;sequence>
 *         &lt;element name="authentication" type="{http://lsc-project.org/XSD/lsc-core-2.0.xsd}ldapAuthenticationType" minOccurs="0"/>
 *         &lt;element name="referral" type="{http://lsc-project.org/XSD/lsc-core-2.0.xsd}ldapReferralType" minOccurs="0"/>
 *         &lt;element name="derefAliases" type="{http://lsc-project.org/XSD/lsc-core-2.0.xsd}ldapDerefAliasesType" minOccurs="0"/>
 *         &lt;element name="version" type="{http://lsc-project.org/XSD/lsc-core-2.0.xsd}ldapVersionType" minOccurs="0"/>
 *         &lt;element name="pageSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="factory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tlsActivated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="saslMutualAuthentication" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="sortedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="binaryAttributes" type="{http://lsc-project.org/XSD/lsc-core-2.0.xsd}valuesType" minOccurs="0"/>
 *         &lt;element name="recursiveDelete" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ldapConnectionType", propOrder = {
    "authentication",
    "referral",
    "derefAliases",
    "version",
    "pageSize",
    "factory",
    "tlsActivated",
    "saslMutualAuthentication",
    "sortedBy",
    "binaryAttributes",
    "recursiveDelete"
})
public class LdapConnectionType
    extends ConnectionType
{

    @XmlElement(defaultValue = "SIMPLE")
    protected LdapAuthenticationType authentication = LdapAuthenticationType.SIMPLE;
    @XmlElement(defaultValue = "IGNORE")
    protected LdapReferralType referral = LdapReferralType.IGNORE;
    @XmlElement(defaultValue = "NEVER")
    protected LdapDerefAliasesType derefAliases = LdapDerefAliasesType.NEVER;
    @XmlElement(defaultValue = "VERSION_3")
    protected LdapVersionType version = LdapVersionType.VERSION_3;
    @XmlElement(defaultValue = "-1")
    protected Integer pageSize = -1;
    @XmlElement(defaultValue = "com.sun.jndi.ldap.LdapCtxFactory")
    protected String factory = "com.sun.jndi.ldap.LdapCtxFactory";
    @XmlElement(defaultValue = "false")
    protected Boolean tlsActivated = false;
    @XmlElement(defaultValue = "false")
    protected Boolean saslMutualAuthentication = false;
    protected String sortedBy;
    protected ValuesType binaryAttributes;
    @XmlElement(defaultValue = "false")
    protected Boolean recursiveDelete = false;

    /**
     * Gets the value of the authentication property.
     * 
     * @return
     *     possible object is
     *     {@link LdapAuthenticationType }
     *     
     */
    public LdapAuthenticationType getAuthentication() {
        return authentication;
    }

    /**
     * Sets the value of the authentication property.
     * 
     * @param value
     *     allowed object is
     *     {@link LdapAuthenticationType }
     *     
     */
    public void setAuthentication(LdapAuthenticationType value) {
        this.authentication = value;
    }

    /**
     * Gets the value of the referral property.
     * 
     * @return
     *     possible object is
     *     {@link LdapReferralType }
     *     
     */
    public LdapReferralType getReferral() {
        return referral;
    }

    /**
     * Sets the value of the referral property.
     * 
     * @param value
     *     allowed object is
     *     {@link LdapReferralType }
     *     
     */
    public void setReferral(LdapReferralType value) {
        this.referral = value;
    }

    /**
     * Gets the value of the derefAliases property.
     * 
     * @return
     *     possible object is
     *     {@link LdapDerefAliasesType }
     *     
     */
    public LdapDerefAliasesType getDerefAliases() {
        return derefAliases;
    }

    /**
     * Sets the value of the derefAliases property.
     * 
     * @param value
     *     allowed object is
     *     {@link LdapDerefAliasesType }
     *     
     */
    public void setDerefAliases(LdapDerefAliasesType value) {
        this.derefAliases = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link LdapVersionType }
     *     
     */
    public LdapVersionType getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link LdapVersionType }
     *     
     */
    public void setVersion(LdapVersionType value) {
        this.version = value;
    }

    /**
     * Gets the value of the pageSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets the value of the pageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPageSize(Integer value) {
        this.pageSize = value;
    }

    /**
     * Gets the value of the factory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactory() {
        return factory;
    }

    /**
     * Sets the value of the factory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactory(String value) {
        this.factory = value;
    }

    /**
     * Gets the value of the tlsActivated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTlsActivated() {
        return tlsActivated;
    }

    /**
     * Sets the value of the tlsActivated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTlsActivated(Boolean value) {
        this.tlsActivated = value;
    }

    /**
     * Gets the value of the saslMutualAuthentication property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSaslMutualAuthentication() {
        return saslMutualAuthentication;
    }

    /**
     * Sets the value of the saslMutualAuthentication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSaslMutualAuthentication(Boolean value) {
        this.saslMutualAuthentication = value;
    }

    /**
     * Gets the value of the sortedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortedBy() {
        return sortedBy;
    }

    /**
     * Sets the value of the sortedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortedBy(String value) {
        this.sortedBy = value;
    }

    /**
     * Gets the value of the binaryAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link ValuesType }
     *     
     */
    public ValuesType getBinaryAttributes() {
        return binaryAttributes;
    }

    /**
     * Sets the value of the binaryAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValuesType }
     *     
     */
    public void setBinaryAttributes(ValuesType value) {
        this.binaryAttributes = value;
    }

    /**
     * Gets the value of the recursiveDelete property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecursiveDelete() {
        return recursiveDelete;
    }

    /**
     * Sets the value of the recursiveDelete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecursiveDelete(Boolean value) {
        this.recursiveDelete = value;
    }

}

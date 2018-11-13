/*
 ****************************************************************************
 * Ldap Synchronization Connector provides tools to synchronize
 * electronic identities from a list of data sources including
 * any database with a JDBC connector, another LDAP directory,
 * flat files...
 *
 *                  ==LICENSE NOTICE==
 *
 * Copyright (c) 2008 - 2011 LSC Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:

 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *     * Neither the name of the LSC Project nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *                  ==LICENSE NOTICE==
 *
 *               (c) 2008 - 2011 LSC Project
 *         Sebastien Bahloul <seb@lsc-project.org>
 *         Thomas Chemineau <thomas@lsc-project.org>
 *         Jonathan Clarke <jon@lsc-project.org>
 *         Remy-Christophe Schermesser <rcs@lsc-project.org>
 ****************************************************************************
 */
package org.lsc.jndi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.lsc.LscDatasets;
import org.lsc.exception.LscServiceException;

/**
 * <P>
 * Simple interface to some methods to access an LDAP directory.
 * </P>
 *
 * <P>
 * This class is available as "ldap" or "srcLdap" in several JavaScript enabled parameters in the LSC configuration. The
 * methods allow you to interact with an LDAP directory.
 * </P>
 *
 * <P>
 * Based on Rhino (JavaScript interpreter), this class is able to understand your LQL requests.
 * </P>
 *
 * <P>
 * All methods in the class use methods from {@link JndiServices}.
 * </P>
 *
 * @author Sebastien Bahloul &lt;seb@lsc-project.org&gt;
 */
public class ScriptableJndiServices extends ScriptableObject {

    /** Local jndi instance. Used to connect to the right directory. */
    private JndiServices jndiServices;

    /**
     * <P>
     * Default constructor.
     * </P>
     *
     * <P>
     * Default directory properties are based on destination.
     * </P>
     */
    public ScriptableJndiServices() {
        // jndiServices = JndiServices.getDstInstance();
    }

    /**
     * <P>
     * Default jndiServices setter.
     * </P>
     *
     * @param jndiServices
     *            the new value
     */
    public void setJndiServices(JndiServices jndiServices) {
        this.jndiServices = jndiServices;
    }

    public JndiServices getJndiServices() {
        return jndiServices;
    }

    /**
     * <P>
     * Performs a search with subtree scope on a given base DN with a given filter.
     * </P>
     *
     * @param base
     *            The base DN to search from.
     * @param filter
     *            The LDAP filter to use.
     * @return List<String> List of DNs returned by the search.
     * @throws NamingException
     */
    public List<String> search(Object base, Object filter) throws NamingException {
        return wrapString("_search", base, filter);
    }

    protected List<String> _search(String base, String filter) throws NamingException {
        return jndiServices.getDnList(base, filter, SearchControls.SUBTREE_SCOPE);
    }

    /**
     * <P>
     * Performs a search with one level scope on a given base DN with a given filter.
     * </P>
     *
     * @param base
     *            The base DN to search from.
     * @param filter
     *            The LDAP filter to use.
     * @return List<String> List of DNs returned by the search.
     * @throws NamingException
     */
    public List<String> list(Object base, Object filter) throws NamingException {
        return wrapString("_list", base, filter);
    }

    protected List<String> _list(String base, String filter) throws NamingException {
        return jndiServices.getDnList(base, filter, SearchControls.ONELEVEL_SCOPE);
    }

    /**
     * <P>
     * Retrieve an edirectory password, For a user identified by dn
     * </P>
     *
     * @param dnUser
     *            Dn of the user
     * @return Password in clear Text
     * @throws LscServiceException
     */
    public String getEdirPassword(String dnUser) throws LscServiceException {
        return _getEdirPassword(dnUser);
    }

    /**
     * <P>
     * Retrieve an edirectory password, For a user identified by dn
     * </P>
     *
     * @param dnUser
     *            Dn of the user
     * @return Password in clear Text
     * @throws LscServiceException
     * @throws NamingException
     */
    public String _getEdirPassword(String dnUser) throws LscServiceException {
        return jndiServices.getEdirPassword(dnUser);
    }

    /**
     * <P>
     * Performs a search with subtree scope on a given base DN with a given filter returning attribute values
     * </P>
     *
     * @param base
     *            The base DN to search from.
     * @param filter
     *            The LDAP filter to use.
     * @attribute attribute The attribute to search.
     * @return List<String> List of attributes values returned by the search.
     * @throws NamingException
     */
    public List<String> searchAttribute(Object base, Object filter, Object attribute) throws NamingException {
        return _searchAttribute((String) base, (String) filter, (String) attribute, SearchControls.SUBTREE_SCOPE);
    }

    /**
     * <P>
     * Performs a search with one level scope on a given base DN with a given filter returning attribute values
     * </P>
     *
     * @param base
     *            The base DN to search from.
     * @param filter
     *            The LDAP filter to use.
     * @attribute attribute The attribute to search.
     * @return List<String> List of attributes values returned by the search.
     * @throws NamingException
     */
    public List<String> listAttribute(Object base, Object filter, Object attribute) throws NamingException {
        return _searchAttribute((String) base, (String) filter, (String) attribute, SearchControls.ONELEVEL_SCOPE);
    }

    protected List<String> _searchAttribute(String base, String filter, String attribute, int scope)
            throws NamingException {

        List<String> resAttributes = new ArrayList<String>();

        List<String> attrsNames = new ArrayList<String>();
        attrsNames.add(attribute);

        // Searching attributes values
        Map<String, LscDatasets> res = jndiServices.getAttrsList(base, filter, scope, attrsNames);

        for (Map.Entry<String, LscDatasets> entry : res.entrySet()) {
            resAttributes.add(entry.getValue().getStringValueAttribute(attribute));
        }

        return resAttributes;
    }

    /**
     * <P>
     * Performs a search with base level scope on a given base DN with a given filter.
     * </P>
     *
     * @param base
     *            The base DN to search from.
     * @param filter
     *            The LDAP filter to use.
     * @return List<String> List of DNs returned by the search.
     * @throws NamingException
     */
    public List<String> read(Object base, Object filter) throws NamingException {
        return wrapString("_read", base, filter);
    }

    protected List<String> _read(String base, String filter) throws NamingException {
        return jndiServices.getDnList(base, filter, SearchControls.OBJECT_SCOPE);
    }

    /**
     * <P>
     * Tests if an entry exists with the given DN and if it matches a given LDAP filter.
     * </P>
     *
     * @param dn
     *            The DN of the entry to check.
     * @param filter
     *            The LDAP filter to check on the above DN.
     * @return List<String> List containing the DN if it exists and matches the filter, or null otherwise.
     * @throws NamingException
     */
    public List<String> exists(Object dn, Object filter) throws NamingException {
        return wrapString("_exists", dn, filter);
    }

    /**
     * <P>
     * Tests if an entry exists with the given DN.
     * </P>
     *
     * @param dn
     *            The DN of the entry to check.
     * @return List<String> List containing the DN if it exists and matches the filter, or null otherwise.
     * @throws NamingException
     */
    public List<String> exists(Object dn) throws NamingException {
        return wrapString("_exists", dn, JndiServices.DEFAULT_FILTER);
    }

    protected List<String> _exists(String dn, String filter) throws NamingException {
        if (jndiServices.exists(dn, filter)) {
            List<String> c = new ArrayList<String>();
            c.add(dn);

            return c;
        }
        return null;
    }

    /**
     * <P>
     * Performs a union on two Lists of Strings.
     * </P>
     *
     * @param a
     *            List of Strings
     * @param b
     *            List of Strings
     * @return List<String> List of Strings containing all elements from a and b.
     * @throws NamingException
     */
    public List<String> or(Object a, Object b) throws NamingException {
        return wrapList("_or", a, b);
    }

    protected List<String> _or(List<String> a, List<String> b) throws NamingException {
        List<String> c = new ArrayList<String>();
        if (a != null) {
            c.addAll(a);
        }
        if (b != null) {
            c.addAll(b);
        }

        return c;
    }

    /**
     * <P>
     * Reads the entry given by a DN, and returns the values of the given attribute.
     * </P>
     *
     * @param base
     *            The DN of the entry to read.
     * @param attrName
     *            The name of the attribute to read.
     * @return List<String> List of values of the attribute, as Strings.
     * @throws NamingException
     */
    public List<String> attribute(Object base, Object attrName) throws NamingException {
        return wrapString("_attr", base, attrName);
    }

    @SuppressWarnings({ "unchecked" })
    protected List<String> _attr(String base, String attrName) throws NamingException {
        SearchControls sc = new SearchControls();
        sc.setReturningAttributes(new String[] { attrName });
        SearchResult sr = jndiServices.readEntry(base, "objectClass=*", false, sc);

        if (sr != null && sr.getAttributes() != null && sr.getAttributes().get(attrName) != null) {
            return (List<String>) Collections.list(sr.getAttributes().get(attrName).getAll());
        }
        return null;
    }

    /**
     * <P>
     * Performs an intersection on two Lists of Strings.
     * </P>
     *
     * @param a
     *            List of Strings
     * @param b
     *            List of Strings
     * @return List<String> List of Strings containing elements that are in both a and b.
     * @throws NamingException
     */
    public List<String> and(Object a, Object b) throws NamingException {
        return wrapList("_and", a, b);
    }

    protected List<String> _and(List<String> aList, List<String> bList) throws NamingException {
        List<String> cList = new ArrayList<String>();

        if (aList.size() < bList.size()) {
            for (String tmp : aList) {
                if (bList.contains(tmp)) {
                    cList.add(tmp);
                }
            }
        } else {
            for (String tmp : bList) {
                if (aList.contains(tmp)) {
                    cList.add(tmp);
                }
            }
        }

        return cList;
    }

    /**
     * <P>
     * Removes all elements of a List of Strings b from a List of Strings a.
     * </P>
     *
     * @param a
     *            List of Strings
     * @param b
     *            List of Strings
     * @return List<String> List of Strings containing all elements from a not in b.
     * @throws NamingException
     */
    public List<String> retain(Object a, Object b) throws NamingException {
        return wrapList("_retain", a, b);
    }

    protected List<String> _retain(List<String> aList, List<String> bList) throws NamingException {
        List<String> cList = new ArrayList<String>();
        for (String aValue : aList) {
            if (!bList.contains(aValue)) {
                cList.add(aValue);
            }
        }

        return cList;
    }

    /**
     * <P>
     * Returns the parent DN on the n-th level of a given DN, in a List of Strings.
     * </P>
     *
     * <P>
     * For example, given ("uid=1234,ou=People,dc=normation,dc=com", 2), returns "dc=normation,dc=com" (in a List of
     * Strings).
     * </P>
     *
     * <P>
     * As a special case, if the requested level is 0, the result is a List of the given DN and all it's parent DNs
     * until the context DN. In the above example, this List would be ["uid=1234,ou=People,dc=normation,dc=com",
     * "ou=People,dc=normation,dc=com", "dc=normation,dc=com"], assuming that the context DN is "dc=normation,dc=com".
     * </P>
     *
     * <P>
     * This method returns null if a negative level is given.
     * </P>
     *
     * @param dn
     *            The DN whose parent we want.
     * @param level
     *            The number of levels to go up, or 0 to return all parent DNs.
     * @return List<String> List containing the parent DN, or all parent DNs if level is 0, or null if level is
     *         negative.
     * @throws NamingException
     */
    public List<String> sup(Object dn, Object level) throws NamingException {
        return wrapString("_sup", dn, level);
    }

    protected List<String> _sup(String dn, String level) throws NamingException {
        int levelValue = Integer.parseInt(level);

        return jndiServices.sup(dn, levelValue);
    }

    /**
     * <P>
     * Returns a List containing the given DN and all parent DNs that exist and match a given LDAP filter.
     * </P>
     *
     * <P>
     * This method returns the same result as sup(dn, 0), with validation that each object exists and matches the given
     * filter.
     * </P>
     *
     * @param dn
     *            The DN whose parents we want.
     * @param filter
     *            The LDAP filter to check.
     * @return List<String> List of DNs as Strings that are this entry's DN, or it's parents DN, that exist and match
     *         the given filter.
     * @throws NamingException
     */
    public List<String> fsup(Object dn, Object filter) throws NamingException {
        return wrapString("_fsup", dn, filter);
    }

    protected List<String> _fsup(String dn, String filter) throws NamingException {
        List<String> cList = new ArrayList<String>();
        List<String> dns = jndiServices.sup(dn, 0);

        if (dns == null) {
            return null;
        }

        for (String aDn : dns) {
            if (jndiServices.exists(aDn, filter)) {
                cList.add(aDn);

                return cList;
            }
        }

        return cList;
    }

    /**
     * <P>
     * Get the context DN configured for this instance.
     * </P>
     *
     * @return The context DN as a String.
     */
    public String getContextDn() {
        return jndiServices.getContextDn();
    }
}

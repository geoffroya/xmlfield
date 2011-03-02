/*
 * Copyright 2010 Capgemini
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * 
 */
package org.xmlfield.utils;

import static org.apache.commons.lang.StringUtils.substringAfterLast;
import static org.apache.commons.lang.StringUtils.substringBefore;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * Xpath manipulation methods.
 * 
 * @author Nicolas Richeton <nicolas.richeton@capgemini.com>
 */
public class XPathUtils {

    /**
     * Return element name without any selector.
     * 
     * <p>
     * Attribute names are returned with a starting '@'
     * 
     * @param xPath
     *            the XPath query
     * @return element name
     */
    public static String getElementName(String xPath) {
        String name = XPathUtils.getElementNameWithSelector(xPath);

        // Remove attribute selector
        name = substringBefore(name, "[");
        return name;
    }

    public static String getElementPrefix(String xPath) {
        String name = XPathUtils.getElementNameWithSelector(xPath);

        if (name.contains(":")) {

            return substringBefore(name, ":");
        }

        return null;

    }

    public static Map<String, String> getElementSelectorAttributes(String xPath) {
        String name = XPathUtils.getElementNameWithSelector(xPath);
        HashMap<String, String> result = null;
        if (name.contains("[@")) {
            result = new HashMap<String, String>();
            String[] attributes = StringUtils.split(name, "[@");
            for (String a : attributes) {
                if (a.contains("=")) {
                    String[] aSplitted = a.split("=");
                    int endIndex = 1;
                    switch (aSplitted[1].charAt(0)) {
                    case '\"':
                    case '\'':
                        endIndex++;

                        break;
                    default:
                    }
                    aSplitted[1] = aSplitted[1].substring(1,
                            aSplitted[1].length() - endIndex);

                    result.put(aSplitted[0], aSplitted[1]);
                }

            }

        }

        return result;
    }

    /**
     * Returns the type of the element described by this xPath query. See the
     * following examples :
     * 
     * <ul>
     * <li>/parent/tagname => TYPE_TAG
     * <li>/parent/@attrname => TYPE_ATTRIBUTE
     * <li>/parent/tagname[@attrname=attrvalue] => TYPE_TAG_WITH_ATTRIBUTE
     * </ul>
     * 
     * 
     * @param xPath
     *            the XPath query
     * @return TYPE_TAG, TYPE_TAG_WITH_ATTRIBUTE, TYPE_ATTRIBUTE
     * 
     * @see XMLFieldUtils#getElementSelectorAttributes(String)
     * @see getElementName
     * @see XPathUtils#getElementNameWithSelector(String)
     * 
     */
    public static int getElementType(String xPath) {
        String name = XPathUtils.getElementNameWithSelector(xPath);

        if (name.startsWith("@")) {
            return XPathUtils.TYPE_ATTRIBUTE;
        }

        if (name.contains("[@")) {
            return XPathUtils.TYPE_TAG_WITH_ATTRIBUTE;
        }

        return XPathUtils.TYPE_TAG;
    }

    public static final int TYPE_TAG_WITH_ATTRIBUTE = 2;
    public static final int TYPE_TAG = 1;
    public static final int TYPE_ATTRIBUTE = 3;

    public static String getElementNameWithSelector(String xPath) {
        String name = xPath;
        if (name.contains("/")) {
            name = substringAfterLast(name, "/");
        }
        return name;
    }

}
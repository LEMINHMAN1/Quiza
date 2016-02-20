
package com.zet.business.base.entities;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:simpleType xmlns:ns="http://scylla/xsd/business" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="StatusType">
 *   &lt;xs:restriction base="xs:string">
 *     &lt;xs:enumeration value="SUCCESS"/>
 *     &lt;xs:enumeration value="FAILED"/>
 *   &lt;/xs:restriction>
 * &lt;/xs:simpleType>
 * </pre>
 */
public enum StatusType {
    SUCCESS, FAILED
}

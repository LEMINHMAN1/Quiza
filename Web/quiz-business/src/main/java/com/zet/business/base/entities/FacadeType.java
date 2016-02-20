
package com.zet.business.base.entities;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:simpleType xmlns:ns="http://scylla/xsd/business" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="FacadeType">
 *   &lt;xs:restriction base="xs:string">
 *     &lt;xs:enumeration value="USER"/>
 *     &lt;xs:enumeration value="MYPAGE"/>
 *     &lt;xs:enumeration value="ANTI_COMMENT"/>
 *     &lt;xs:enumeration value="GROUP_MANAGER"/>
 *     &lt;xs:enumeration value="AUTOPOST"/>
 *   &lt;/xs:restriction>
 * &lt;/xs:simpleType>
 * </pre>
 */
public enum FacadeType {
    USER, MYPAGE, ANTI_COMMENT, GROUP_MANAGER, AUTOPOST
}

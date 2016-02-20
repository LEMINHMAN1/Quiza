
package com.zet.business.base.entities;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://scylla/xsd/business" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="AccountType">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:long" name="accTypeId" minOccurs="0"/>
 *     &lt;xs:element type="xs:long" name="userId" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="name" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="description" minOccurs="0"/>
 *     &lt;xs:element type="xs:int" name="dayLicense" minOccurs="0"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class AccountType
{
    private Long accTypeId;
    private Long userId;
    private String name;
    private String description;
    private Integer dayLicense;

    /** 
     * Get the 'accTypeId' element value.
     * 
     * @return value
     */
    public Long getAccTypeId() {
        return accTypeId;
    }

    /** 
     * Set the 'accTypeId' element value.
     * 
     * @param accTypeId
     */
    public void setAccTypeId(Long accTypeId) {
        this.accTypeId = accTypeId;
    }

    /** 
     * Get the 'userId' element value.
     * 
     * @return value
     */
    public Long getUserId() {
        return userId;
    }

    /** 
     * Set the 'userId' element value.
     * 
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 
     * Get the 'name' element value.
     * 
     * @return value
     */
    public String getName() {
        return name;
    }

    /** 
     * Set the 'name' element value.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Get the 'description' element value.
     * 
     * @return value
     */
    public String getDescription() {
        return description;
    }

    /** 
     * Set the 'description' element value.
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 
     * Get the 'dayLicense' element value.
     * 
     * @return value
     */
    public Integer getDayLicense() {
        return dayLicense;
    }

    /** 
     * Set the 'dayLicense' element value.
     * 
     * @param dayLicense
     */
    public void setDayLicense(Integer dayLicense) {
        this.dayLicense = dayLicense;
    }
}


package com.zet.business.base.entities;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://scylla/xsd/business" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="User">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:long" name="userId" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="name" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="email" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="timeAntiSpam" minOccurs="0"/>
 *     &lt;xs:element type="ns:Article" name="articles" minOccurs="0" maxOccurs="unbounded"/>
 *     &lt;xs:element type="ns:AccountType" name="accountTypes" minOccurs="0" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class User
{
    private Long userId;
    private String name;
    private String email;
    private String timeAntiSpam;
    private List<Article> articleList = new ArrayList<Article>();
    private List<AccountType> accountTypeList = new ArrayList<AccountType>();

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
     * Get the 'email' element value.
     * 
     * @return value
     */
    public String getEmail() {
        return email;
    }

    /** 
     * Set the 'email' element value.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * Get the 'timeAntiSpam' element value.
     * 
     * @return value
     */
    public String getTimeAntiSpam() {
        return timeAntiSpam;
    }

    /** 
     * Set the 'timeAntiSpam' element value.
     * 
     * @param timeAntiSpam
     */
    public void setTimeAntiSpam(String timeAntiSpam) {
        this.timeAntiSpam = timeAntiSpam;
    }

    /** 
     * Get the list of 'articles' element items.
     * 
     * @return list
     */
    public List<Article> getArticleList() {
        return articleList;
    }

    /** 
     * Set the list of 'articles' element items.
     * 
     * @param list
     */
    public void setArticleList(List<Article> list) {
        articleList = list;
    }

    /** 
     * Get the list of 'accountTypes' element items.
     * 
     * @return list
     */
    public List<AccountType> getAccountTypeList() {
        return accountTypeList;
    }

    /** 
     * Set the list of 'accountTypes' element items.
     * 
     * @param list
     */
    public void setAccountTypeList(List<AccountType> list) {
        accountTypeList = list;
    }
}

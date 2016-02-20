
package com.zet.business.base.entities;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://scylla/xsd/business" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="BusinessRequest">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:string" name="ipAddress" minOccurs="0"/>
 *     &lt;xs:element type="ns:FacadeType" name="facadeType" minOccurs="0"/>
 *     &lt;xs:element type="ns:ActionType" name="actionType" minOccurs="0"/>
 *     &lt;xs:element type="ns:User" name="users" minOccurs="0" maxOccurs="unbounded"/>
 *     &lt;xs:element type="ns:AccountType" name="accountTypes" minOccurs="0" maxOccurs="unbounded"/>
 *     &lt;xs:element type="ns:Article" name="articles" minOccurs="0" maxOccurs="unbounded"/>
 *     &lt;xs:element type="ns:Autopost" name="autoposts" minOccurs="0" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class BusinessRequest
{
    private String ipAddress;
    private FacadeType facadeType;
    private ActionType actionType;
    private List<User> userList = new ArrayList<User>();
    private List<AccountType> accountTypeList = new ArrayList<AccountType>();
    private List<Article> articleList = new ArrayList<Article>();
    private List<Autopost> autopostList = new ArrayList<Autopost>();

    /** 
     * Get the 'ipAddress' element value.
     * 
     * @return value
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /** 
     * Set the 'ipAddress' element value.
     * 
     * @param ipAddress
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /** 
     * Get the 'facadeType' element value.
     * 
     * @return value
     */
    public FacadeType getFacadeType() {
        return facadeType;
    }

    /** 
     * Set the 'facadeType' element value.
     * 
     * @param facadeType
     */
    public void setFacadeType(FacadeType facadeType) {
        this.facadeType = facadeType;
    }

    /** 
     * Get the 'actionType' element value.
     * 
     * @return value
     */
    public ActionType getActionType() {
        return actionType;
    }

    /** 
     * Set the 'actionType' element value.
     * 
     * @param actionType
     */
    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    /** 
     * Get the list of 'users' element items.
     * 
     * @return list
     */
    public List<User> getUserList() {
        return userList;
    }

    /** 
     * Set the list of 'users' element items.
     * 
     * @param list
     */
    public void setUserList(List<User> list) {
        userList = list;
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
     * Get the list of 'autoposts' element items.
     * 
     * @return list
     */
    public List<Autopost> getAutopostList() {
        return autopostList;
    }

    /** 
     * Set the list of 'autoposts' element items.
     * 
     * @param list
     */
    public void setAutopostList(List<Autopost> list) {
        autopostList = list;
    }
}

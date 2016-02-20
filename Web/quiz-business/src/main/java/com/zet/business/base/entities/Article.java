
package com.zet.business.base.entities;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://scylla/xsd/business" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Article">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:long" name="articleId" minOccurs="0"/>
 *     &lt;xs:element type="xs:long" name="userId" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="name" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="content" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="imgs" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="location" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="feeling" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="createDate" minOccurs="0"/>
 *     &lt;xs:element type="ns:Autopost" name="autoPosts" minOccurs="0" maxOccurs="unbounded"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Article
{
    private Long articleId;
    private Long userId;
    private String name;
    private String content;
    private String imgs;
    private String location;
    private String feeling;
    private String createDate;
    private List<Autopost> autoPostList = new ArrayList<Autopost>();

    /** 
     * Get the 'articleId' element value.
     * 
     * @return value
     */
    public Long getArticleId() {
        return articleId;
    }

    /** 
     * Set the 'articleId' element value.
     * 
     * @param articleId
     */
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
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
     * Get the 'content' element value.
     * 
     * @return value
     */
    public String getContent() {
        return content;
    }

    /** 
     * Set the 'content' element value.
     * 
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /** 
     * Get the 'imgs' element value.
     * 
     * @return value
     */
    public String getImgs() {
        return imgs;
    }

    /** 
     * Set the 'imgs' element value.
     * 
     * @param imgs
     */
    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    /** 
     * Get the 'location' element value.
     * 
     * @return value
     */
    public String getLocation() {
        return location;
    }

    /** 
     * Set the 'location' element value.
     * 
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /** 
     * Get the 'feeling' element value.
     * 
     * @return value
     */
    public String getFeeling() {
        return feeling;
    }

    /** 
     * Set the 'feeling' element value.
     * 
     * @param feeling
     */
    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    /** 
     * Get the 'createDate' element value.
     * 
     * @return value
     */
    public String getCreateDate() {
        return createDate;
    }

    /** 
     * Set the 'createDate' element value.
     * 
     * @param createDate
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /** 
     * Get the list of 'autoPosts' element items.
     * 
     * @return list
     */
    public List<Autopost> getAutoPostList() {
        return autoPostList;
    }

    /** 
     * Set the list of 'autoPosts' element items.
     * 
     * @param list
     */
    public void setAutoPostList(List<Autopost> list) {
        autoPostList = list;
    }
}

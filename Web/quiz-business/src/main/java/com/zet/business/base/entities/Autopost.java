
package com.zet.business.base.entities;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:complexType xmlns:ns="http://scylla/xsd/business" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="Autopost">
 *   &lt;xs:sequence>
 *     &lt;xs:element type="xs:long" name="autopostId" minOccurs="0"/>
 *     &lt;xs:element type="xs:long" name="articleId" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="type" minOccurs="0"/>
 *     &lt;xs:element type="xs:string" name="dateTimePost" minOccurs="0"/>
 *   &lt;/xs:sequence>
 * &lt;/xs:complexType>
 * </pre>
 */
public class Autopost
{
    private Long autopostId;
    private Long articleId;
    private String type;
    private String dateTimePost;

    /** 
     * Get the 'autopostId' element value.
     * 
     * @return value
     */
    public Long getAutopostId() {
        return autopostId;
    }

    /** 
     * Set the 'autopostId' element value.
     * 
     * @param autopostId
     */
    public void setAutopostId(Long autopostId) {
        this.autopostId = autopostId;
    }

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
     * Get the 'type' element value.
     * 
     * @return value
     */
    public String getType() {
        return type;
    }

    /** 
     * Set the 'type' element value.
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /** 
     * Get the 'dateTimePost' element value.
     * 
     * @return value
     */
    public String getDateTimePost() {
        return dateTimePost;
    }

    /** 
     * Set the 'dateTimePost' element value.
     * 
     * @param dateTimePost
     */
    public void setDateTimePost(String dateTimePost) {
        this.dateTimePost = dateTimePost;
    }
}

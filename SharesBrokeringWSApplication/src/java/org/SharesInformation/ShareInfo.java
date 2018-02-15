/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.SharesInformation;

import java.util.List;

/**
 *
 * @author Danny
 */
public class ShareInfo {
    protected String newsAuthor;
    protected String newsTitle;
    protected String newsDescription;
    protected String newsURL;
    protected String imageURL;
    protected String publishedDate;    
    
    public void setNewsAuthor(String value) {
        this.newsAuthor = value;
    }
    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsTitle(String value) {
        this.newsTitle = value;
    }
    public String getNewsTitle() {
        return newsTitle;
    }
    
    public void setNewsDescription(String value) {
        this.newsDescription = value;
    }
    public String getNewsDescription() {
        return newsDescription;
    }
    
    public void setNewsURL(String value) {
        this.newsURL = value;
    }
    public String getNewsURL() {
        return newsURL;
    }
    
    public void setImageURL(String value) {
        this.imageURL = value;
    }
    public String getImageURL() {
        return imageURL;
    }
    
    public void setPublishedDate(String value) {
        this.publishedDate = value;
    }
    public String getPublishedDate() {
        return publishedDate;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author EGH0158
 */
abstract public class NewBaseModel {

    String sourceUrl, captionImageUrl, articleContent, articleAuthor;

    

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getCaptionImageUrl() {
        return captionImageUrl;
    }

    public void setCaptionImageUrl(String captionImageUrl) {
        this.captionImageUrl = captionImageUrl;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processor;

import Model.CitiNewModel;
import Utils.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 *
 * @author Godfred O Sabbih
 */
public class CitiNewsPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    private Document doc;

    @Override
    public void process(Page page) {
        CitiNewModel model = new CitiNewModel();
        page.addTargetRequests(page.getHtml().links().regex("(https://citinewsroom\\.com/\\w+/\\w+/\\w+/\\w+)").all());

//        model.setDateofPublishing();

        doc=Jsoup.parse(page.getHtml().get());
        Elements art = doc.getElementsByTag("article");
        System.out.print("RESULT="+art.html());
//        for(Element e:art){
//            if(e.tagName().equals("header")){
//                for(Element h:e.getElementsByClass("entry-title")){
//                   model.setArticleheadline( h.text());
//                  
//                }
//                break;
//            }
//        }
        
//        model.setArticleheadline(page.getHtml().xpath("//article/header/h1[@itemprop='headline'AND @class='entry-title']/text()").toString());
////         model.setArticleheadline(doc.get);
////        model.setCaptionImageUrl(page.getHtml().xpath("//article//img[@class='post_layout_5_img disappear mom_appear]/@src").toString());
//        model.setSourceUrl(page.getUrl().get());
//        model.setDateofPublishing(page.getHtml().xpath("//div[@class='entry-post-meta']/div/time/text()").get());
//        model.setArticleContent(page.getHtml().xpath("//div[@class='entry-post-meta']/div/time/text()").get());
//         model.setArticleContent(page.getHtml().xpath("//div[@class='entry-content clearfix']//p/").all().toString());
//        System.out.print("RESULT="+page.getHtml().xpath("//img[@class='post_layout_5_img disappear mom_appear']/@src").toString());
        if (model.getArticleheadline() == null) {
            page.setSkip(true);
        }
        page.putField(Constants.CITINEWS_REPO_KEY, model);
//        page.putField(Constants.CITINEWS_REPO_KEY, page.getHtml().xpath("//article/header/h1[@itemprop='headline']/text()"));

    }

    @Override
    public Site getSite() {
        return site;

    }

}

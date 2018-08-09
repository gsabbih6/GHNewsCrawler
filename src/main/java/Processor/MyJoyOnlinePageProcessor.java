/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processor;

import Model.CitiNewModel;
import Model.JoyOnlineModel;
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
public class MyJoyOnlinePageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    private Document doc;

    @Override
    public void process(Page page) {
        JoyOnlineModel model = new JoyOnlineModel();
        page.addTargetRequests(page.getHtml().links().regex("(https://www.myjoyonline\\.com/\\w+/\\d+/\\S+)").all());
        doc = Jsoup.parse(page.getHtml().get());
        Elements allDivs=doc.getElementsByTag("div");
//         System.out.println("RESULT = "+allDivs.text());
        for(Element e:allDivs)
        {
//             System.out.println("RESULT = "+e.text());
            if(e.className().equals("article-heading")){
               
                Elements headingElements = e.getAllElements();
                 for(Element hE:headingElements){
                     if(hE.tagName().equals("h1")){
                         model.setArticleheadline(hE.text());
//                         System.out.println("RESULT = "+hE.text());
                     }
                     
                 }
            }
        }
        if (model.getArticleheadline() == null) {
            page.setSkip(true);
        }
        page.putField(Constants.JOYONLINE_REPO_KEY, model);
//        page.putField(Constants.CITINEWS_REPO_KEY, page.getHtml().xpath("//article/header/h1[@itemprop='headline']/text()"));

    }

    @Override
    public Site getSite() {
        return site;

    }

}

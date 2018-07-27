/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processor;

import Model.CitiNewModel;
import Utils.Constants;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 *
 * @author Godfred O Sabbih
 */
public class CitiNewsPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        CitiNewModel model = new CitiNewModel();
        page.addTargetRequests(page.getHtml().links().regex("(https://citinewsroom\\.com/2018/\\w+/\\w+/\\w+)").all());

//        model.setDateofPublishing();
        model.setArticleheadline(page.getHtml().xpath("//article/header/h1[@itemprop='headline'AND @class='entry-title']/text()").toString());
        if(model.getArticleheadline()==null){
            page.setSkip(true);
        }
//        page.putField(Constants.CITINEWS_REPO_KEY, model);
        page.putField(Constants.CITINEWS_REPO_KEY, page.getHtml().xpath("//article/header/h1[@itemprop='headline']/text()"));
        

    }

    @Override
    public Site getSite() {
        return site;

    }

}

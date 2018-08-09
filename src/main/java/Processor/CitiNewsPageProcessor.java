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

    private final Site site = Site.me().setRetryTimes(0).setSleepTime(1000);
    private Document doc;

    @Override
    public void process(Page page) {

        CitiNewModel model = new CitiNewModel();
        page.addTargetRequests(page.getHtml().links().regex("(https://citinewsroom\\.com/\\w+/\\w+/\\w+/\\w+)").all());

        doc = Jsoup.parse(page.getHtml().get());
        Elements article = doc.getElementsByTag("article");

        Elements imgs = doc.getElementsByTag("figure");
        StringBuilder s = new StringBuilder();
//        System.out.print("RESULT="+art.html());

        for (Element e : article) {
            Elements articleKids = e.getAllElements();
//             model.setDescription(e.getElementsByTag("p").last().text());
            for (Element ak : articleKids) {

                // header tag
                if (ak.tagName().equals("header")) {
                    Elements headerKids = e.getAllElements();

                    for (Element k : headerKids) {
                        if (k.tagName().equals("h1")) {
                            model.setArticleheadline(k.text());

                        }
                        if (k.tagName().equals("time")) {
                            model.setDateofPublishing(k.text());

                        }

                    }
                }

                // image url
                if (ak.tagName().equals("figure")) {
                    if (ak.className().equals("fff post-thumbnail")) {
                        Elements img = ak.getAllElements();
                        for (Element i : img) {
                            if (i.tagName().equals("img")) {
                                model.setCaptionImageUrl(i.attr("src"));
                                break;
                            }
                        }
                    }
                }

                // content
                if (ak.tagName().equals("p")) {
                    s.append(ak.ownText());
                }

            }
        }
        model.setArticleContent(s.toString());
        model.setDescription(s.toString().split("\\.")[0]);
        model.setSourceUrl(page.getUrl().get());

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

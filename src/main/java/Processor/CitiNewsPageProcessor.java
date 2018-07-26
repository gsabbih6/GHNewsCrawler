/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processor;

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
       
        
     }

    @Override
    public Site getSite() {
        return site;
 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabbih.ghnewscrawler;

import Pipeline.ElasticSearchPipeline;
import Processor.CitiNewsPageProcessor;
import Utils.Constants;
import org.apache.log4j.BasicConfigurator;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 *
 * @author EGH0158
 */
public class MainClass {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        System.out.println("tikemfsjs");
        Spider.create(new CitiNewsPageProcessor())
                .addUrl(Constants.CITINEWS_URL)
//                .addPipeline(new ElasticSearchPipeline())
                .addPipeline(new ConsolePipeline())
                .thread(5)
                .d
                .run();

    }
}

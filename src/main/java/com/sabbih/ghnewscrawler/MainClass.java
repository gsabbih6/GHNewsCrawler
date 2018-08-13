/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabbih.ghnewscrawler;

import Pipeline.ElasticSearchPipeline;
import Processor.CitiNewsPageProcessor;
import Processor.MyJoyOnlinePageProcessor;
import Utils.AppUtils;
import Utils.Constants;
import org.apache.log4j.BasicConfigurator;
import us.codecraft.webmagic.Spider;

/**
 *
 * @author EGH0158
 */
public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        BasicConfigurator.configure();
//        System.out.println("tikemfsjs");

//Scheduler s=new 
        
//        while(true){
           
           Spider s = Spider.create(new CitiNewsPageProcessor())
                .addUrl(Constants.CITINEWS_URL)
                .addPipeline(new ElasticSearchPipeline(AppUtils.restHighLevelClient()))
                   
                //                .addPipeline(new ConsolePipeline())
                .thread(5);
//                .setScheduler(new PriorityScheduler());
        s.run();
//         Thread.sleep(60000);
//        }

//       Executors.newSingleThreadScheduledExecutor().schedule(s., 10, TimeUnit.SECONDS);
    }
}

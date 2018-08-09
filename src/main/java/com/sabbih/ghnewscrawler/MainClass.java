/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabbih.ghnewscrawler;

import Pipeline.ElasticSearchPipeline;
import Processor.CitiNewsPageProcessor;
import Processor.MyJoyOnlinePageProcessor;
import Utils.Constants;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.scheduler.PriorityScheduler;

/**
 *
 * @author EGH0158
 */
public class MainClass {

    public static void main(String[] args) {
        BasicConfigurator.configure();
//        System.out.println("tikemfsjs");

//Scheduler s=new 
        Spider s = Spider.create(new MyJoyOnlinePageProcessor())
                .addUrl(Constants.JOYONLINE_URL)
                .addPipeline(new ElasticSearchPipeline())
                //                .addPipeline(new ConsolePipeline())
                .thread(5);
//                .setScheduler(new PriorityScheduler());
        s.run();

//       Executors.newSingleThreadScheduledExecutor().schedule(s., 10, TimeUnit.SECONDS);
    }
}

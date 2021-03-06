/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipeline;

import Model.CitiNewModel;
import Utils.AppUtils;
import com.google.gson.Gson;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import Utils.Constants;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 *
 * @author Sabbih
 */
public class ElasticSearchPipeline implements Pipeline {

    RestHighLevelClient restClient;

    public ElasticSearchPipeline(RestHighLevelClient client) {
        restClient = client;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        CitiNewModel citiNewModel = (CitiNewModel) resultItems.get(Constants.CITINEWS_REPO_KEY);
        // convert model to Json file format.

//         JoyOnlineModel joyOnlineModel = (JoyOnlineModel) resultItems.get(Constants.JOYONLINE_REPO_KEY);
        String json = new Gson().toJson(citiNewModel);
//        String json = new Gson().toJson(joyOnlineModel);

        // push to elastic search cluster
//        System.out.println("RESULT = " + json);

        IndexRequest request = new IndexRequest(Constants.GHNEWSINDEX, Constants.CITIFMTYPE,
                AppUtils.HashID(citiNewModel.getArticleContent()));
        request.source(json, XContentType.JSON);
        try {
            //        restClient.
            IndexResponse indexResponse =restClient.index(request);
             System.out.println("RESULTOK = " + indexResponse.toString());
        } catch (IOException ex) {
            Logger.getLogger(ElasticSearchPipeline.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

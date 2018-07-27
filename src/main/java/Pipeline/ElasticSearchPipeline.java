/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipeline;

import Model.CitiNewModel;
import com.google.gson.Gson;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import Utils.Constants;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 *
 * @author Sabbih
 */
public class ElasticSearchPipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        CitiNewModel citiNewModel = (CitiNewModel) resultItems.get(Constants.CITINEWS_REPO_KEY);
        // convert model to Json file format.
        String json = new Gson().toJson(citiNewModel);
        
        // push to elastic search cluster
        
        
        
        
    }

}

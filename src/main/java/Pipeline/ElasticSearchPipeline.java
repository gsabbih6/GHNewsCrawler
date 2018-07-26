/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pipeline;

import Interface.Pipeline;
import Model.CitiNewModel;
import com.google.gson.Gson;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;

/**
 *
 * @author Sabbih
 */
public class ElasticSearchPipeline implements Pipeline{

    @Override
    public void process(ResultItems resultItems, Task task) {
        CitiNewModel citiNewModel = (CitiNewModel)resultItems.get("citnewsRepo");
        // conver to Jso
        String json= new Gson().toJson(citiNewModel);
    }
    
}

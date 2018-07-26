/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;

/**
 *
 * @author Godfred Sabbih
 */
public interface Pipeline {
     public void process(ResultItems resultItems, Task task);
}

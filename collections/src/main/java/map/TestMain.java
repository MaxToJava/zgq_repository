package map;

import java.util.HashMap;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("zgq","come on.");
        System.out.println("start");

       /* new Thread(()->{
            map.put("zgq","first");
        }).start();

        new Thread(()->{
            map.put("zgq","second");
        }).start();

        new Thread(()->{
            map.put("zgq","thrid");
        }).start();

        new Thread(()->{
            map.put("zgq","fourth");
        }).start();
*/
        System.out.println(map);
    }


}

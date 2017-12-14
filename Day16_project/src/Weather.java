import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Weather {

    public void  find(String city) throws IOException {
        URL url = new URL("http://api.map.baidu.com/telematics/v3/weather?location="+city+"&output=json&ak=6tYzTvGZSOpYB5Oc2YGGOKt8");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        byte[] buff = new byte[1024*1024*1024];
        int len = is.read(buff);
        String result = new String(buff,0,len);
        JSONObject jsonObject = JSONObject.fromObject(result);
        Weath weath = (Weath) JSONObject.toBean(jsonObject,Weath.class);
        System.out.println(weath.getResults());
        is.close();

        }

    }




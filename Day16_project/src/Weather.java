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
        byte[] buff = new byte[1024*1024];
        StringBuffer sb = new StringBuffer();
        int len = 0;
        while (len = is.read(buff)!= -1){

        }

    }


}

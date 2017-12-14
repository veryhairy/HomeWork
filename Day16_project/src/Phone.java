import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Phone {
    public void place(String ph) throws IOException {
        URL url = new URL("http://api.k780.com/?app=phone.get&phone="+ph+"&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");
        URLConnection uc = url.openConnection();
        InputStream inputStream = uc.getInputStream();
        byte[] buff = new byte[1024*1024];
        StringBuffer buffer = new StringBuffer();

        int len = 0;
        while ((len = inputStream.read(buff))!= -1){
            buffer.append(new String(buff,0,len));
        }

        JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
        Phon phon = (Phon) JSONObject.toBean(jsonObject,Phon.class);
        Phon.ResultBean resultBean = phon.getResult();

        System.out.println(resultBean.getAtt());
        inputStream.close();


    }
}

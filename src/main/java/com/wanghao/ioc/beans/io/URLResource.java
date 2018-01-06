package com.wanghao.ioc.beans.io;/**
 * Created by Administrator on 2017/12/27.
 */

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author WangH
 * @create 2017-12-27 17:15
 **/
public class URLResource implements Resource {
    
    private final URL url;
    
    public URLResource(URL url){
        this.url=url;
    }

    /**
     *  这个得到一个输入流
     * @return
     * @throws Exception
     */
    @Override
    public InputStream getInputStream() throws Exception {
        URLConnection urlConnection=url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}

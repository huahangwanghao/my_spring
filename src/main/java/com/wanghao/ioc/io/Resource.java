package com.wanghao.ioc.io;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/12/27.
 */
public interface Resource {
    InputStream getInputStream() throws  Exception;
}

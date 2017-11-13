package com.onezao.wetest;

import com.onezao.wetest.bean.ZhihuBean;

import org.junit.Test;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zneo on 2017/11/10.
 */

public class XmlPullParserTest {
    ArrayList<ZhihuBean>  list = null;
    ZhihuBean zhihuBean = null;
    @Test
    public void pullParser() throws XmlPullParserException, IOException {
        //得到XmlPullParser解析器
        XmlPullParserFactory  xmlPullParserFactory= XmlPullParserFactory.newInstance();
        XmlPullParser parser =xmlPullParserFactory.newPullParser();
        parser.setInput(new FileInputStream(new File("zhihu.xml")),"utf-8");
        int eventType = parser.getEventType();
        eventType = parser.next();
        //执行解析方法
        while (eventType != XmlPullParser.END_DOCUMENT){
            switch (eventType){
                case XmlPullParser.START_TAG:
                    if("channel".equals(parser.getName())){
                       list = new ArrayList<ZhihuBean>();
                    } else if ("item".equals(parser.getName())){
                        zhihuBean = new ZhihuBean();
                    } else if ("title".equals(parser.getName())){
                        zhihuBean.setTitle(parser.nextText());
                    } else if ("link".equals(parser.getName())){
                        zhihuBean.setLink(parser.nextText());
                    } else if ("description".equals(parser.getName())){
                        zhihuBean.setDescription(parser.nextText());
                    } else if ("dc:creator".equals(parser.getName())){
                        zhihuBean.setDccreator(parser.nextText());
                    } else if("pubDate".equals(parser.getName())){
                        zhihuBean.setPubDate(parser.nextText());
                    } else if ("guid".equals(parser.getName())){
                        zhihuBean.setGuid(parser.nextText());
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if ("item".equals(parser.getName())){
                        list.add(zhihuBean);
                    }
                    break;
            }
            eventType = parser.next();
        }
        for (ZhihuBean zhihu: list){
            System.out.println(zhihu);
        }
    }
}

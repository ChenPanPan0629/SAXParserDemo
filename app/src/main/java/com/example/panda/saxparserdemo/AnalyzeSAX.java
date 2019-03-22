package com.example.panda.saxparserdemo;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by panpan on 2019/03/20.
 */
public class AnalyzeSAX {

    public static HashMap<String,List<OutListBean>> readXML(InputStream inputStream) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();
            XMLContentHandler handler = new XMLContentHandler();
            saxParser.parse(inputStream, handler);
            inputStream.close();
            return handler.getHashMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HashMap<String,List<OutListBean>> readXML(InputSource inputSource) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();
            XMLContentHandler handler = new XMLContentHandler();
            reader.setContentHandler(handler);
            reader.parse(inputSource);
            inputSource.getByteStream().close();
            return handler.getHashMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
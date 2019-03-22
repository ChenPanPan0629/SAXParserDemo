package com.example.panda.saxparserdemo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by panpan on 2019/03/20.
 */
public class XMLContentHandler extends DefaultHandler {

    private List<OutListBean> outList = null;//外层List
    private List<InnerListBean> innerList = new ArrayList<>();//内层List
    private OutListBean outBean;//外层Bean
    private InnerListBean innerBean;//内层Bean
    private String tagName = null;
    private HashMap<String, List<OutListBean>> hashMap;


    public HashMap<String, List<OutListBean>> getHashMap() {
        return hashMap;
    }


    @Override
    public void startDocument() throws SAXException {
        hashMap = new HashMap<>();
        outList = new ArrayList<>();
        innerList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (localName.equals("lists")) {//遇到lists节点，new一个OutListBean对象
            outBean = new OutListBean();
            outBean.setType(attributes.getValue("type"));
        }

        if (localName.equals("list")) {//遇到list节点，new一个InnerListBean对象
            innerBean = new InnerListBean();
        }
        this.tagName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (tagName != null) {
            String data = new String(ch, start, length);

            if (tagName.equals("author")) {
                innerBean.setAuthor(data);
            }
            if (tagName.equals("fileNameList")) {
                innerBean.setFileNameList(data);
            }
            if (tagName.equals("tableName")) {
                innerBean.setTableName(data);
            }
            if (tagName.equals("title")) {
                innerBean.setTitle(data);
            }
            if (tagName.equals("unit")) {
                innerBean.setUnit(data);
            }
            if (tagName.equals("date")) {
                innerBean.setDate(data);
            }

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("quoteDocument")) {
            hashMap.put("quoteDocument", outList);
            outList = new ArrayList<>();
        }
        if (localName.equals("secQuoteDocument")) {
            hashMap.put("secQuoteDocument", outList);
            outList = new ArrayList<>();
        }
        if (localName.equals("shareRefDocument")) {
            hashMap.put("shareRefDocument", outList);
            outList = new ArrayList<>();
        }
        if (localName.equals("similarDocument")) {
            hashMap.put("similarDocument", outList);
            outList = new ArrayList<>();
        }

        if (localName.equals("lists")) {
            outBean.setListBeans(innerList);
            outList.add(outBean);
            outBean = null;
            innerList = new ArrayList<>();
        }
        if (localName.equals("list")) {
            innerList.add(innerBean);
            innerBean = null;
        }
        this.tagName = null;
    }
}
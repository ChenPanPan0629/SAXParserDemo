package com.example.panda.saxparserdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.xml.sax.InputSource;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AnalyzeXMLDemo";

    private TextView mTextView;

    private InputStream inputStream;

    InnerListBean innerBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saxButton1 = (Button) findViewById(R.id.sax_button1);
        Button saxButton2 = (Button) findViewById(R.id.sax_button2);
        mTextView = (TextView) findViewById(R.id.text);

        saxButton1.setOnClickListener(this);
        saxButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String result = "";
        inputStream = getResources().openRawResource(R.raw.saxdemo);
        switch (v.getId()) {
            case R.id.sax_button1:
                if (inputStream == null) {
                    result = "inputStream is null";
                } else {
                    HashMap<String, List<OutListBean>> hashMap = AnalyzeSAX.readXML(inputStream);
                    innerBean=hashMap.get("secQuoteDocument").get(0).getListBeans().get(5);
                    result=innerBean.toString();
//                    result = hashMap.get("secQuoteDocument").get(1).getListBeans().get(0).getAuthor();
                    //获取所有key
                    Set<String> keys = hashMap.keySet();
                    Iterator<String> iterator1 = keys.iterator();
                    while (iterator1.hasNext()) {
                        Log.d("Tag", iterator1.next() + ", ");
                    }
                }
                mTextView.setText(result);
                break;
            case R.id.sax_button2:
                result += "--------- SAX2 ---------" + "\n";
                InputSource inputSource = new InputSource();
                inputSource.setByteStream(inputStream);
                if (inputSource == null) {
                    result = "inputStream is null";
                } else {
                    HashMap<String, List<OutListBean>> hashMap = AnalyzeSAX.readXML(inputStream);
                }
                mTextView.setText(result);
                break;
            default:
                break;
        }
    }

}
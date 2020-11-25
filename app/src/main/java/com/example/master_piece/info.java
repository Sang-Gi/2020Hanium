package com.example.master_piece;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class info extends AppCompatActivity {
    TextView textView; //결과를 띄어줄 TextView
    TextView reload; //reload버튼
    Elements contents;
    Document doc = null;
    String Top10;//결과를 저장할 문자열변수

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textView = (TextView) findViewById(R.id.textBox);
        reload = (TextView) findViewById(R.id.reload1);


        Bundle intent_info = getIntent().getExtras();
        reload.setText(intent_info.getString("center1"));





                new AsyncTask() {//AsyncTask객체 생성
                    @Override
                    protected Object doInBackground(Object[] params) {
                        try {
                            doc = Jsoup.connect("https://www.gunpouc.or.kr/fmcs/74").get(); //naver페이지를 불러옴
                            contents = doc.select("div table tbody tr");//셀렉터로 span태그중 class값이 ah_k인 내용을 가져옴
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Top10 = "";
                        int cnt = 0;//숫자를 세기위한 변수
                        for(Element element: contents) {
                            cnt++;
                            Top10 += "🍎"+". "+element.text() + "\n" + "\n";
                            if(cnt == 20)//10위까지 파싱하므로
                                break;
                        }
                        return null;
                    }
                    @Override
                    protected void onPostExecute(Object o) {
                        super.onPostExecute(o);
                        Log.i("TAG",""+Top10);
                        textView.setText(Top10);
                    }
                }.execute();


    }
}
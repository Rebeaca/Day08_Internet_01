package com.example.user.day08_internet_01;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.user.day08_internet_01.utils.NetworkTools;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private Button get;
    private ImageView show;
    private String URL="http://img3.iqilu.com/data/attachment/forum/201308/21/192654ai88zf6zaa60zddo.jpg";//存放网络地址
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get= (Button) findViewById(R.id.button_get);
        show= (ImageView) findViewById(R.id.imageView);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            new LoadTask().execute(URL);
            }
        });
    }
    //定义一个内部类
    private class LoadTask extends AsyncTask<String, View, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap _Bitmap = null;
            //进行网络访问
            InputStream _in = NetworkTools.getImage(params[0]);
            if (_in != null){
                //把输入流转换为Bitmap对象
                _Bitmap = BitmapFactory.decodeStream(_in);
            }
            return _Bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            show.setImageBitmap(bitmap);
        }
    }

}

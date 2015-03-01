package kimjong.un.hth2015;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

import java.net.URL;

/**
 * Created by Alex on 2/28/2015.
 */
public class WebApp extends ActionBarActivity{

    private WebView myView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webapp);

        //make it fullscreen
//        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        String extra = getIntent().getStringExtra("website");


        Log.d("Pulled URL is", extra);

        myView = new WebView(this);
        myView.getSettings().setJavaScriptEnabled(true);

        myView.loadUrl(extra);
        setContentView(myView);

    }
}

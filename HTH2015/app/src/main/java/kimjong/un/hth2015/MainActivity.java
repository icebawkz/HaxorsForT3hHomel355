package kimjong.un.hth2015;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button topleft =  (Button) (findViewById(R.id.button));
        topleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebApp.class);
                intent.putExtra("website", "http://pranavbheda.github.io/hth2015.html");
                startActivity(intent);
            }
        });

        ImageView HTHlogo = (ImageView)findViewById(R.id.imageView);
        HTHlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logointent = new Intent(MainActivity.this, WebApp.class);
                logointent.putExtra("website", "http://hackforthehomeless.com");
                startActivity(logointent);
            }
        });

        Button numbers = (Button) findViewById(R.id.button3);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numberIntent = new Intent(MainActivity.this, UsefulNumbers.class);
                startActivity(numberIntent);
            }
        });

        Button data = (Button) findViewById(R.id.data_usage);
        data.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent (android.provider.Settings.ACTION_WIRELESS_SETTINGS));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package kimjong.un.hth2015;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2/28/2015.
 */
public class UsefulNumbers extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ListView list = (ListView) findViewById(R.id.listView);
        list.setClickable(true);

        final List<Phonebook> listOfPhonebook = new ArrayList<Phonebook>();
        listOfPhonebook.add(new Phonebook("Test", "9981728"));
        listOfPhonebook.add(new Phonebook("Test1", "1234455"));
        listOfPhonebook.add(new Phonebook("Test2", "00000"));

        PhonebookAdapter adapter = new PhonebookAdapter(this, listOfPhonebook);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        list.setAdapter(adapter);
    }

}

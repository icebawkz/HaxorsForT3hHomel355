package kimjong.un.hth2015;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        final ListView list = (ListView) findViewById(R.id.listView);
        list.setClickable(true);

        final List<Phonebook> listOfPhonebook = new ArrayList<Phonebook>();
        listOfPhonebook.add(new Phonebook("Casa de Clara", "297 8330"));
        listOfPhonebook.add(new Phonebook("Family Violence Center", "277 3700"));
        listOfPhonebook.add(new Phonebook("SJ Furniture Bank", "919 345 8516"));
        listOfPhonebook.add(new Phonebook("Salvation Army", "282 1165"));
        listOfPhonebook.add(new Phonebook("American Red Cross", "577 1000"));
        listOfPhonebook.add(new Phonebook("Senior Housing Solutions", "416 0271"));
        listOfPhonebook.add(new Phonebook("Vet Center", "993 0729"));
        listOfPhonebook.add(new Phonebook("Pro Bono Project", "998 5298"));
        listOfPhonebook.add(new Phonebook("Meals Served", "293 6111"));
        listOfPhonebook.add(new Phonebook("Bill Wilson Center", "850 6140"));
        listOfPhonebook.add(new Phonebook("Ascent Employment", "257 8302"));
        listOfPhonebook.add(new Phonebook("Sobrato CET Center", "287 7924"));
        listOfPhonebook.add(new Phonebook("Non-Emergency Services", "211"));
        listOfPhonebook.add(new Phonebook("Non-Emergency Police", "311"));
        listOfPhonebook.add(new Phonebook("General Info - Police", " 277 8900"));

        PhonebookAdapter adapter = new PhonebookAdapter(this, listOfPhonebook);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                TextView phoneNumber = (TextView) view.findViewById(R.id.textView2);
                String number = phoneNumber.getText().toString();

                Toast.makeText(getApplicationContext(), "Position :" + itemPosition + "  ListItem : " + number, Toast.LENGTH_SHORT).show();

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse(number));
                startActivity(callIntent);

            }
        });

        Button addbtn = (Button) findViewById(R.id.addbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textname = (EditText) findViewById(R.id.editname);
                String name = textname.getText().toString();

                EditText textnumber = (EditText) findViewById(R.id.editnumber);
                String number = textnumber.getText().toString();

                listOfPhonebook.add(new Phonebook(name, number));

                textname.setText("");
                textnumber.setText("");
            }
        });

        list.setAdapter(adapter);
    }

}

package kimjong.un.hth2015;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alex on 2/28/2015.
 */
public class PhonebookAdapter extends BaseAdapter implements View.OnClickListener {

    private Context context;

    private List<Phonebook> listPhonebook;

    public PhonebookAdapter(Context context, List<Phonebook> listPhonebook){
        this.context = context;
        this.listPhonebook = listPhonebook;
    }

    @Override
    public int getCount() {
        return listPhonebook.size();
    }

    @Override
    public Object getItem(int position) {
        return listPhonebook.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Phonebook entry = listPhonebook.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_single_entry, null);
        }
        TextView tvContact = (TextView) convertView.findViewById(R.id.textView);
        tvContact.setText(entry.getName());

        TextView tvPhone = (TextView) convertView.findViewById(R.id.textView2);
        tvPhone.setText(entry.getPhone());

        // Set the onClick Listener on this button
//        Button btnRemove = (Button) convertView.findViewById(R.id.button5);
//        btnRemove.setFocusableInTouchMode(false);
//        btnRemove.setFocusable(false);
//        btnRemove.setOnClickListener(this);
        // Set the entry, so that you can capture which item was clicked and
        // then remove it
        // As an alternative, you can use the id/position of the item to capture
        // the item
        // that was clicked.
     //   btnRemove.setTag(entry);

        // btnRemove.setId(position);


        return convertView;
    }

    @Override
    public void onClick(View v) {
        Phonebook entry = (Phonebook) v.getTag();
        listPhonebook.remove(entry);
        // listPhonebook.remove(view.getId());
        notifyDataSetChanged();
    }

    private void showDialog(Phonebook entry){
        //nothig so far
    }

}

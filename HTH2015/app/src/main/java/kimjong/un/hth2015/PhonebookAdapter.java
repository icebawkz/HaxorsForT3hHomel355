package kimjong.un.hth2015;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Alex on 2/28/2015.
 */
public class PhonebookAdapter extends BaseAdapter implements View.OnClickListener {

    private Context context;

    private List<Phonebook> listPhonebook;

    public PhonebookAdapter(Context context, List<Phonebook>, listPhonebook)


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public void onClick(View v) {

    }
}

package kimjong.un.hth2015;

import android.provider.ContactsContract;

/**
 * Created by Alex on 2/28/2015.
 */
public class Phonebook {
    private String name;
    private String phone;

    public Phonebook(String name, String phone){
        super();
        this.name = name;
        this.phone = phone;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }


}

package com.example.ayesha.contact;

        import android.app.Activity;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TabHost;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;



public class MainActivity extends Activity {

    EditText phoneTxt, nameTxt, addressTxt, emailTxt;
    List<Contact> Contacts= new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTxt = (EditText) findViewById(R.id.txtName);
        phoneTxt = (EditText) findViewById(R.id.txtPhone);
        addressTxt = (EditText) findViewById(R.id.txtAddress);
        emailTxt = (EditText) findViewById(R.id.txtEmail);

        final Button addBtn = (Button) findViewById(R.id.btnAdd);
        addBtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "Your contact has been created!", Toast.LENGTH_SHORT).show();
            addContacts(nameTxt.getText().toString(), phoneTxt.getText().toString(), addressTxt.getText().toString(), emailTxt.getText().toString());
        }} ) ;
        //create first tab
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("creator");
        tabSpec.setContent(R.id.tabCreator);
        tabSpec.setIndicator("Creator");
        tabHost.addTab(tabSpec);
        //create contact list tab
        tabSpec = tabHost.newTabSpec("list");
        tabSpec.setContent(R.id.tabContactList);
        tabSpec.setIndicator("List");
        tabHost.addTab(tabSpec);

        nameTxt.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            addBtn.setEnabled(String.valueOf(nameTxt.getText()).trim().length() > 0);
        }
        @Override
        public void afterTextChanged(Editable editable) {
        }
    }); }

    private void addContacts(String name, String phone, String email, String address) {
        Contacts.add(new Contact(name, phone, email, address));
    }

    private class ContactListAdapter extends ArrayAdapter<Contact> {
        public ContactListAdapter() {
            super (MainActivity.this, R.layout.listview_item, Contacts);
        }
    @Override
        public View getView(int pos, View view, ViewGroup parent){
            if (view == null)
            view = getLayoutInflater().inflate(R.layout.listview_item, parent, false );
        Contact currentContact = Contacts.get(pos);
        TextView name = (TextView) view.findViewById(R.id.contactName);
        name.setText(currentContact.getName());
        TextView phone = (TextView) view.findViewById(R.id.phoneNumber);
        phone.setText(currentContact.getPhone());
        TextView email = (TextView) view.findViewById(R.id.emailAddress);
        email.setText(currentContact.getEmail());
        TextView address = (TextView) view.findViewById(R.id.cAddress);
        return view;  }
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

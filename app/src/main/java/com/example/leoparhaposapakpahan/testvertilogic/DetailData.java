package com.example.leoparhaposapakpahan.testvertilogic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailData extends AppCompatActivity {

    TextView Id, Name, Username, Email, Street, Suite, City, ZipCode, Lat, Lng, Phone, Website, Name_Company, CatchPhrase, BS;
    String txtId, txtName, txtUsername, txtEmail, txtStreet, txtSuite, txtCity, txtZipCode, txtLat, txtLng, txtPhone, txtWebsite, txtName_Company, txtCatchPhrase, txtBS;
    public LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        Id = (TextView) findViewById(R.id.Id);
        Name = findViewById(R.id.Name);
        Username = findViewById(R.id.Username);
        Email = findViewById(R.id.Email);
        Street = findViewById(R.id.Street);
        Suite = findViewById(R.id.Suite);
        City = findViewById(R.id.City);
        ZipCode = findViewById(R.id.Zipcode);
        Lat = findViewById(R.id.Lat);
        Lng = findViewById(R.id.Lng);
        Phone = findViewById(R.id.Phone);
        Website = findViewById(R.id.Website);
        Name_Company = findViewById(R.id.Name_Company);
        CatchPhrase = findViewById(R.id.CatchPhrase);
        BS = findViewById(R.id.BS);

        linearLayout = findViewById(R.id.linearMap);


        txtId = getIntent().getExtras().getString("Id");
        txtName = getIntent().getExtras().getString("Name");
        txtUsername = getIntent().getExtras().getString("Username");
        txtEmail = getIntent().getExtras().getString("Email");
//        txtAddress = getIntent().getExtras().getString("Address");
        txtStreet = getIntent().getExtras().getString("Street");
        txtSuite = getIntent().getExtras().getString("Suite");
        txtCity = getIntent().getExtras().getString("City");
        txtZipCode = getIntent().getExtras().getString("ZipCode");
        txtLat = getIntent().getExtras().getString("Lat");
        txtLng = getIntent().getExtras().getString("Lng");
        txtPhone = getIntent().getExtras().getString("Phone");
        txtWebsite = getIntent().getExtras().getString("Website");
        txtName_Company = getIntent().getExtras().getString("NameC");
        txtCatchPhrase = getIntent().getExtras().getString("CatchP");
        txtBS = getIntent().getExtras().getString("Bs");


        Id.setText(txtId);
        Name.setText(txtName);
        Username.setText(txtUsername);
        Email.setText(txtEmail);
        Street.setText(txtStreet);
        Suite.setText(txtSuite);
        City.setText(txtCity);
        ZipCode.setText(txtZipCode);
        Lat.setText(txtLat);
        Lng.setText(txtLng);
        Phone.setText(txtPhone);
        Website.setText(txtWebsite);
        Name_Company.setText(txtName_Company);
        CatchPhrase.setText(txtCatchPhrase);
        BS.setText(txtBS);



        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailData.this, LocationActivity.class);
                Bundle b = new Bundle();
                String Lat = txtLat;
                String Lng = txtLng;

                intent.putExtra("Lat", Lat);
                intent.putExtra("Lng", Lng);



                intent.putExtras(b);

                //begin activity
                startActivity(intent);
            }
        });



    }
}

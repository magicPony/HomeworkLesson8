package com.example.taras.homeworklesson8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class ShowPersonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_person);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DataModel person;
        person = (DataModel) getIntent().getExtras().getSerializable(Values.PERSON_TO_SHOW_TAG);

        TextView tvFirstName, tvLastName, tvGender, tvAge, tvPhoneNumber;
        tvFirstName = (TextView) findViewById(R.id.tv_first_name_ASP);
        tvLastName = (TextView) findViewById(R.id.tv_last_name_ASP);
        tvGender = (TextView) findViewById(R.id.tv_gender_ASP);
        tvAge = (TextView) findViewById(R.id.tv_age_ASP);
        tvPhoneNumber = (TextView) findViewById(R.id.tv_phone_number_ASP);

        tvFirstName.setText(person.getFirstName());
        tvLastName.setText(person.getLastName());
        tvGender.setText(person.getGender());
        tvAge.setText(person.getAge());
        tvPhoneNumber.setText(person.getPhoneNumber());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}

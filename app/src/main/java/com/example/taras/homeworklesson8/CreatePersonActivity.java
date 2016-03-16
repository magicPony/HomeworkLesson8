package com.example.taras.homeworklesson8;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePersonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_person);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnCreate;
        btnCreate = (Button) findViewById(R.id.btn_create);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText etFirstName, etLastName, etGender, etAge, etPhoneNumber;
                etFirstName = (EditText) findViewById(R.id.et_first_name);
                etLastName = (EditText) findViewById(R.id.et_last_name);
                etGender = (EditText) findViewById(R.id.et_gender);
                etAge = (EditText) findViewById(R.id.et_age);
                etPhoneNumber = (EditText) findViewById(R.id.et_phone_number);

                String firstName, lastName, gender, age, phoneNumber;
                firstName = getString(R.string.NA);
                lastName = getString(R.string.NA);
                gender = getString(R.string.NA);
                age = getString(R.string.NA);
                phoneNumber = getString(R.string.NA);

                if (TextUtils.isEmpty(etFirstName.getText())) {
                    Toast
                            .makeText(CreatePersonActivity.this, R.string.empty_field_message, Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                if (!TextUtils.isEmpty(etLastName.getText())) {
                    lastName = etLastName.getText().toString();
                }

                if (!TextUtils.isEmpty(etGender.getText())) {
                    gender = etGender.getText().toString();
                }

                if (!TextUtils.isEmpty(etAge.getText())) {
                    age = etAge.getText().toString();
                }

                if (!TextUtils.isEmpty(etPhoneNumber.getText())) {
                    phoneNumber = etPhoneNumber.getText().toString();
                }

                Bundle bundle = new Bundle();
                DataModel newPerson = new DataModel(firstName, lastName, gender, age, phoneNumber);
                bundle.putSerializable(Values.NEW_PERSON_TAG, newPerson);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(1, intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setResult(0, new Intent());
        finish();
        return true;
    }
}

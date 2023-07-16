package com.example.sharedprefernce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private UserManager userManager;
    private String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userManager = new UserManager(this);
        TextInputEditText etFullName = findViewById(R.id.textInput_user);
        etFullName.setText(userManager.getFullName());


        TextInputEditText etEmail = findViewById(R.id.textInput_mail);
        etEmail.setText(userManager.getEmail());


        RadioGroup radioGroup = findViewById(R.id.radioGroup_gender);
        gender = userManager.getGender();
        if (gender.equalsIgnoreCase("male")){
            radioGroup.check(R.id.radioBtn_male);
        }else if (gender.equalsIgnoreCase("female")) {
            radioGroup.check(R.id.radioBtn_female);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioBtn_male){
                    gender = "male";
                }else{
                    gender = "female";
                }

            }
        });
        View btnSaveInfo = findViewById(R.id.btn_main_save);
        btnSaveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userManager.saveUserInformation(etFullName.getText().toString(),etEmail.getText().toString(),gender);
            }
        });
    }
}
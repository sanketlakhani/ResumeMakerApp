package com.example.resumemakerapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    AppCompatButton btndone;
    EditText edtfirstname, edtlastname, edtemail, edtaddress, edtnumber, edtself, edtschool, edtcollage;
    RadioGroup radioGroup;
    RadioButton radioButton;
    String gender = "";
    Spinner spin;
    String hobby = "";
    String skill = "";
    CheckBox chkgaming, chkmusic, chkcoding, chklang1, chklang2, chklang3;
    String[] citynames = {"surat", "rajkot", "anand", "bharuch", "amreli", "patan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        display1();

    }

    public void display1() {


        btndone = findViewById(R.id.btndone);
        edtfirstname = findViewById(R.id.edtfirstname);
        edtlastname = findViewById(R.id.edtlastname);
        edtemail = findViewById(R.id.edtemail);
        edtaddress = findViewById(R.id.edtaddress);
        edtnumber = findViewById(R.id.edtnumber);
        edtself = findViewById(R.id.edtself);
        radioGroup = findViewById(R.id.rgroup);
        radioButton = findViewById(R.id.rbmale);
        radioButton = findViewById(R.id.rbfemale);
        radioButton = findViewById(R.id.rbother);
        spin = findViewById(R.id.spin);
        chkgaming = findViewById(R.id.chkgaming);
        chkmusic = findViewById(R.id.chkmusic);
        chkcoding = findViewById(R.id.chkcoding);
        chklang1 = findViewById(R.id.chklang1);
        chklang2 = findViewById(R.id.chklang2);
        chklang3 = findViewById(R.id.chklang3);
        edtschool = findViewById(R.id.edtschool);
        edtcollage = findViewById(R.id.edtcollage);

        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                display2();

                display3();

                String firstname = edtfirstname.getText().toString();
                String lastname = edtlastname.getText().toString();
                String email = edtemail.getText().toString();
                String address = edtaddress.getText().toString();
                String number = edtnumber.getText().toString();
                String self = edtself.getText().toString();
                String school = edtschool.getText().toString();
                String collage = edtcollage.getText().toString();

                if (firstname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter firstname", Toast.LENGTH_SHORT).show();
                } else if (lastname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter lastname", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                } else if (address.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter address", Toast.LENGTH_SHORT).show();
                } else if (number.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter number", Toast.LENGTH_SHORT).show();
                } else if (number.length()<10) {
                    Toast.makeText(MainActivity.this, "Please enter number in minimum 10 digit", Toast.LENGTH_SHORT).show();
                } else if (self.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter about your self", Toast.LENGTH_SHORT).show();
                } else if (gender.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please select your gender", Toast.LENGTH_SHORT).show();
                } else if (hobby.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please select your hobby", Toast.LENGTH_SHORT).show();
                } else if (skill.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please select your skill", Toast.LENGTH_SHORT).show();
                } else {

                    Intent i = new Intent(MainActivity.this, DashBoardActivity.class);
                    i.putExtra("firstname", firstname);
                    i.putExtra("lastname", lastname);
                    i.putExtra("email", email);
                    i.putExtra("address", address);
                    i.putExtra("number", number);
                    i.putExtra("self", self);
                    i.putExtra("school", school);
                    i.putExtra("collage", collage);
                    i.putExtra("gender", gender);
                    i.putExtra("hobby", hobby);
                    i.putExtra("skill", skill);
                    i.putExtra("citynames", citynames);

                    startActivity(i);
                    finish();
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                int id = radioGroup.getCheckedRadioButtonId();

                if (id != -1) {
                    if (id == R.id.rbmale) {

                        gender = "Male";
                    } else if (id == R.id.rbfemale) {

                        gender = "Female";
                    } else {

                        gender = "other";
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Invalid choice", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, citynames);
        spin.setAdapter(adapter);
    }

    public void display2() {
        if (chkgaming.isChecked()) {
            hobby = "Gaming";
        } else if (chkmusic.isChecked()) {
            hobby = "Music";
        } else if (chkcoding.isChecked()) {
            hobby = "Coding";
        }
    }

    public void display3() {
        if (chklang1.isChecked()) {
            skill = "C langauage";
        } else if (chklang2.isChecked()) {
            skill = "C++";
        } else if (chklang3.isChecked()) {
            skill = "Java";
        }
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.ic_baseline_warning_24)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit this app")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        finish();
                    }
                })

                .setNeutralButton("help", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(MainActivity.this, "Press yes for exit the app", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                }).show();
    }
}
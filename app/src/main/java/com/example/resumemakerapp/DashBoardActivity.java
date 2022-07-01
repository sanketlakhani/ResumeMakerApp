package com.example.resumemakerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class DashBoardActivity extends AppCompatActivity {

    RatingBar ratingBar;
    Button ratingbutton;
    String firstname, lastname, email, address, number, self, gender, hobby, skill, school, collage,citynames;
    TextView txtfirstname, txtlastname, txtemail, txtaddress, txtnumber, txtself, txtgender, txthobby, txtskill, txtschool, txtcollage, txtrate,txtcity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        display();
    }
    @SuppressLint("WrongViewCast")
    public void display() {
        txtfirstname = findViewById(R.id.txtfirstname);
        txtlastname = findViewById(R.id.txtlastname);
        txtaddress = findViewById(R.id.txtaddress);
        txtemail = findViewById(R.id.txtemail);
        txtnumber = findViewById(R.id.txtnumber);
        txtself = findViewById(R.id.txtself);
        txtgender = findViewById(R.id.txtgender);
        txthobby = findViewById(R.id.txthobby);
        txtskill = findViewById(R.id.txtskill);
        txtschool = findViewById(R.id.txtschool);
        txtrate = findViewById(R.id.txtrate);
        txtcollage = findViewById(R.id.txtcollage);
        ratingBar = findViewById(R.id.rating);
        ratingbutton = findViewById(R.id.ratingbutton);
        txtcity = findViewById(R.id.txtcity);

        if (getIntent() != null) {
            firstname = getIntent().getStringExtra("firstname");
            lastname = getIntent().getStringExtra("lastname");
            email = getIntent().getStringExtra("email");
            address = getIntent().getStringExtra("address");
            number = getIntent().getStringExtra("number");
            self = getIntent().getStringExtra("self");
            gender = getIntent().getStringExtra("gender");
            hobby = getIntent().getStringExtra("hobby");
            skill = getIntent().getStringExtra("skill");
            school = getIntent().getStringExtra("school");
            collage = getIntent().getStringExtra("collage");
            citynames=getIntent().getStringExtra("citynames");

            Log.e("TAG", "display: " + firstname + " " + lastname + " " + email + " " + address + " " + number);

            txtfirstname.setText("Your Firstname is:  " + firstname);
            txtlastname.setText("Your Lastname is:  " + lastname);
            txtemail.setText("Your Email is:  " + email);
            txtaddress.setText("Your Address is:  " + address);
            txtnumber.setText("Your Number is:  " + number);
            txtself.setText("About your self:  " + self);
            txtgender.setText("Your Gender is:  " + gender);
            txthobby.setText("Your Hobby is:  " + hobby);
            txtskill.setText("your Skill is:  " + skill);
            txtschool.setText("your school name is:  " + school);
            txtcollage.setText("your collage name is:  " + collage);
            txtcity.setText("your city name is:  " + citynames);
            txtrate.setText("Rate us: ");

        }
        ratingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Rating Value:" + ratingBar.getRating(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(DashBoardActivity.this)
                .setCancelable(false)
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

                        Toast.makeText(DashBoardActivity.this, "Press yes for exit the app", Toast.LENGTH_SHORT).show();
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
package com.gyaaanfbtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Random;

public class Navigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);

    }

   public void stu_db(View view)
   {
       Intent i = new Intent();
       i.setClass(getApplicationContext(), StudentDBActivity.class);
       startActivity(i);
   }

    public  void teach_db(View view)
    {
        Intent i = new Intent();
        i.setClass(getApplicationContext(), TeacherDBActivity.class);
        startActivity(i);
    }

    public  void onCourseInsert(View view)
    {
        Intent i = new Intent();
        i.setClass(getApplicationContext(), CourseDBActivity.class);
        startActivity(i);
    }

    public  void onSearch(View view)
    {
        Intent i = new Intent();
        i.setClass(getApplicationContext(), SearchActivity.class);
        startActivity(i);
    }





}
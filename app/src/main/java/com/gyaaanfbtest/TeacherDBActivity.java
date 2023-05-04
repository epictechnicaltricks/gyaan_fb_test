package com.gyaaanfbtest;

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

public class TeacherDBActivity extends AppCompatActivity {
    TextView name, course, clg;
    Button submit;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference teacher_db_path;
    EditText teacher_id_;

    String teacher_id;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_db);

        firebaseDatabase = FirebaseDatabase.getInstance();
        teacher_db_path = firebaseDatabase.getReference("teacher_db");



        submit=findViewById(R.id.submit);
        teacher_id_=findViewById(R.id.teacher_id_);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                teacher_id=teacher_id_.getText().toString().trim();
                insert_teacher_details(teacher_id);

                Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();


            }
        });
    }

    public int getStu_id(int _min, int _max)
    {
        Random random = new Random();

        return random.nextInt(_max- _min +1) +_min;

    }

    private void insert_teacher_details(String _teacher_id)
    {
               HashMap<String,Object> map=new HashMap<>();
                map.put("t_phone","123456789");
                map.put("t_name","Harish");
                map.put("t_email","harish@gmail.com");
                map.put("t_img","https://www.shutterstock.com/shutterstock/photos/327025655/display_1500/stock-vector-cheerful-teacher-on-lesson-teaching-327025655.jpg");
                map.put("t_id",_teacher_id);
                map.put("t_profile_progress","12");
                map.put("t_date_of_join","10/12/2023");
                map.put("t_gender","MALE");
                map.put("t_age","34");
                map.put("t_spaclists","MATH");
                map.put("t_experience","5year");
                teacher_db_path.child(teacher_id).updateChildren(map);
                map.clear();


    }





    private void coments()
    {


        ///   reference.push().updateChildren(map)

        /// Calendar c= Calendar.getInstance();
        /// long time = c.getTimeInMillis();











        //////////////////////////////////////////////////////



        // reference.child("purchesed_course_id").updateChildren(map2);
        //stu_id_1678792658718770




//                String name_s = name1.getText().toString();
//                String course_s = course1.getText().toString();
//                String clg_s =clg1.getText().toString();
//                storing storing = new storing(name,course,clg);
//                reference.setValue(storing);
    }
}
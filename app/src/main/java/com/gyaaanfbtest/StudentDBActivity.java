package com.gyaaanfbtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Random;

public class StudentDBActivity extends AppCompatActivity {
    TextView name, course, clg;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference stu_db_path, stu_course_path;
    EditText stu_id_;

    String stu_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_db);

        firebaseDatabase = FirebaseDatabase.getInstance();
        stu_db_path = firebaseDatabase.getReference("student_db");

        stu_id_ = findViewById(R.id.stu_id_);

    }

    public void onSubmit(View view) {
        stu_id = stu_id_.getText().toString().trim();
        insert_student_details(stu_id);
        Toast.makeText(getApplicationContext(), "Inserted Successfully", Toast.LENGTH_SHORT).show();

    }

    public void onCourseInsert(View view) {
        stu_id = stu_id_.getText().toString().trim();
        insert_student_course_details(stu_id);
        Toast.makeText(getApplicationContext(), "Course Inserted on " + stu_id, Toast.LENGTH_LONG).show();

    }




    public int getStu_id(int _min, int _max) {
        Random random = new Random();
        return random.nextInt(_max - _min + 1) + _min;
    }

    private void insert_student_details(String _stu_id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("s_phone", "course2");
        map.put("s_name", "B.Tech");
        map.put("s_email", "1234567890");
        map.put("s_college", "mhjhhh@huh.com");
        map.put("s_img", "https://thumbs.dreamstime.com/z/elementary-school-students-29286813.jpg");
        map.put("s_id", _stu_id);
        stu_db_path.child(stu_id).updateChildren(map).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                showMessage("FAILED "+e);
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                showMessage("Inserted");

            }
        });
        map.clear();


    }

    private void insert_student_course_details(String _stu_id) {

        stu_course_path = firebaseDatabase.getReference("student_db/" + _stu_id + "/purchesed_course_ids/");

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("c_course_id", _stu_id);
        map2.put("c_isCompleted", "true");
        map2.put("c_progress", "19");
        stu_course_path.push().updateChildren(map2).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                showMessage("Inserted");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showMessage("FAILED "+e);
            }
        });
        map2.clear();

    }




    private void showMessage(String _s)
    {
        Toast.makeText(this, _s, Toast.LENGTH_LONG).show();
    }

}
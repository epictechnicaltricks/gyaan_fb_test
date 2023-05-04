package com.gyaaanfbtest;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Random;

public class CourseDBActivity extends AppCompatActivity {
 

    FirebaseDatabase firebaseDatabase;
    DatabaseReference course_db_path, inside_course_path;
    EditText course_id_;

    String cous_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_db);

        firebaseDatabase = FirebaseDatabase.getInstance();
        course_db_path = firebaseDatabase.getReference("course_db");

        course_id_ = findViewById(R.id.course_id_edit);

    }

    public void course_details_added(View view) {
        cous_id = course_id_.getText().toString().trim();
        insert_course_details(cous_id);
    }

    public void add_video_to_course(View view) {
        cous_id = course_id_.getText().toString().trim();
       insert_video_details(cous_id);
    }

    public void add_exam_to_course(View view) {
        cous_id = course_id_.getText().toString().trim();
        insert_exam_details(cous_id);
    }

    public void enroll_student_to_course(View view) {
        cous_id = course_id_.getText().toString().trim();
         enroll_the_student(cous_id);
    }

    public int getcous_id(int _min, int _max) {
        Random random = new Random();
        return random.nextInt(_max - _min + 1) + _min;
    }

    private void insert_course_details(String _cous_id) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("c_name","Make money online"+_cous_id);
        map.put("c_thumb_link","https://static-cse.canva.com/blob/1024437/1600w-wK95f3XNRaM.jpg");
        map.put("c_author","Soumya Ranjan Bahera"+_cous_id);
        map.put("c_student_doubt_link","https://wa.me/91966551168");
        map.put("c_price","3232");
        map.put("c_created","10th March 2023");
        map.put("c_desc","Take online surveys. Make money while helping companies improve their products and services by sharing your opinions on survey websites. Test games and apps.");
        map.put("c_category","Technology"+_cous_id);
        map.put("c_id",_cous_id);
        map.put("c_teacher_id",_cous_id);


        course_db_path.child(cous_id).updateChildren(map).addOnFailureListener(new OnFailureListener() {
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
    private void insert_video_details(String _video_id) {

        inside_course_path = firebaseDatabase.getReference("course_db/" + _video_id + "/video_list/");

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("c_video_link","http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4");
        map2.put("c_video_title","Make money online");
        map2.put("c_video_desc","This is demo description");
        map2.put("c_duration","7:12 min");
        map2.put("c_video_id",_video_id);

        inside_course_path.push().updateChildren(map2).addOnSuccessListener(new OnSuccessListener<Void>() {
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
    private void insert_exam_details(String _exam_id) {

        inside_course_path = firebaseDatabase.getReference("course_db/" + _exam_id + "/exam_list/");

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("e_title","mcq for earn money");
        map2.put("e_link","http://google.com");
        map2.put("e_desc","Time to limit to finish the exam in 2 days");
        map2.put("e_end_time","14th march 2023 15:12PM");
        map2.put("e_exam_id",_exam_id);

        inside_course_path.push().updateChildren(map2).addOnSuccessListener(new OnSuccessListener<Void>() {
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
    private void enroll_the_student(String student_id_) {

        inside_course_path = firebaseDatabase.getReference("course_db/" + student_id_ + "/student_ids/");

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("s_id",student_id_);

        inside_course_path.push().updateChildren(map2).addOnSuccessListener(new OnSuccessListener<Void>() {
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


    private void showMessage(String _s) {
        Toast.makeText(this, _s, Toast.LENGTH_LONG).show();
    }

}
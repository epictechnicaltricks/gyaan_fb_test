package com.gyaaanfbtest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class SearchActivity extends AppCompatActivity {
    myadapter adapter;



    private final ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();

    private RecyclerView recyclerview1;
    com.google.firebase.database.Query query;

    String str;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference search_path;

    EditText search_edit_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        setTitle("Search here...");

        search_edit_text = findViewById(R.id.search_edit_text_);
        firebaseDatabase = FirebaseDatabase.getInstance();



        search_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }


public void searchQuery(View view)
{
    search(search_edit_text.getText().toString().trim());
}


    ValueEventListener valueEventListener1 = new ValueEventListener() {
        @Override public void onDataChange(DataSnapshot _param1) {
            try {
                str = "";
                listmap.clear();
                GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {
                };

                for (DataSnapshot _data : _param1.getChildren()) {
                    str = (_data.getKey());
                    HashMap<String, Object> _map = _data.getValue(_ind);
                    listmap.add(_map);
                }

                Toast.makeText(SearchActivity.this, listmap.size() +" data ", Toast.LENGTH_SHORT).show();
                Toast.makeText(SearchActivity.this, ""+listmap.get(0).get("c_name").toString(), Toast.LENGTH_SHORT).show();
                if(listmap.size()>0)
                {
                      recyclerview1.setAdapter(new Recyclerview1Adapter(listmap));
                      recyclerview1.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
                      recyclerview1.setLayoutManager(new LinearLayoutManager(SearchActivity.this,LinearLayoutManager.VERTICAL, false));

                }

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e +" 111 error", Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError e) {

            Toast.makeText(getApplicationContext(), e.toString() +" 119 error", Toast.LENGTH_LONG).show();
        }
    };




    private void search(String s) {
        FirebaseRecyclerOptions<model> options = new FirebaseRecyclerOptions.Builder<model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("course_db").orderByChild("c_name").startAt(s).endAt(s + "\ufaff").limitToFirst(5), model.class)
                .build();


        adapter = new myadapter(options);
        adapter.startListening();
        recyclerview1.setAdapter(adapter);

     //query = FirebaseDatabase.getInstance().getReference().child("course_db").orderByChild("c_name").startAt(s).endAt(s + "\ufaff").limitToFirst(10);
     //query.addValueEventListener(valueEventListener1);



       // adapter.startListening();
    }


    public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
        ArrayList<HashMap<String, Object>> _data;
        public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
            _data = _arr;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View _v = _inflater.inflate(R.layout.custom_slide, null);
            RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            _v.setLayoutParams(_lp);
            return new ViewHolder(_v);
        }

        @Override
        public void onBindViewHolder(ViewHolder _holder, final int _position) {
            View _view = _holder.itemView;

            final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
            final LinearLayout linear1 = _view.findViewById(R.id.linear1);
            final ImageView imageview2 = _view.findViewById(R.id.imageview2);
            final TextView textview1 = _view.findViewById(R.id.textview1);
            final TextView textview2 = _view.findViewById(R.id.textview2);


            try{


             //   textview1.setText(Objects.requireNonNull(listmap.get(_position).get("c_name")).toString());
              //  textview2.setText(Objects.requireNonNull(listmap.get(_position).get("c_author")).toString());



/*

                Glide.with(getApplicationContext())
                        .load(Uri.parse(Objects.requireNonNull(listmap.get(_position).get("c_thumb_link")).toString()))
                        .thumbnail(0.01f)
                        .into(imageview2);
*/

/*

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied Text", img_url );
                clipboard.setPrimaryClip(clip);
                Log.d("img_obj", img_url);
*/



            }catch (Exception e)
            {
                //showMessage("887 line "+e.toString());
            }



        }

        @Override
        public int getItemCount() {
            return _data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View v){
                super(v);
            }
        }

    }
}

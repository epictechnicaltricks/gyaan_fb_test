package com.gyaaanfbtest;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.core.Context;

public class myadapter extends FirebaseRecyclerAdapter<model, myadapter.myviewholder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @SuppressLint("RecyclerView")
    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, final int position, @NonNull final model model) {
        holder.textview1.setText(model.getC_name());
        holder.textview2.setText(model.getC_author());

     /*   Glide.with()
                .load(Uri.parse(model.getC_thumb_link()))
                .thumbnail(0.01f)
                .into(holder.imageview2);
        */
        //holder.course.setText(model.getCourse());
        // holder.email.setText(model.getEmail());
        //Glide.with(holder.img.getContext()).load(model.getPurl()).into(holder.img);



    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_slide,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{

        androidx.cardview.widget.CardView cardview1;
        LinearLayout linear1;
        ImageView imageview2;
        TextView textview1 ;
        TextView textview2 ;


        public myviewholder(@NonNull View _view) {
            super(_view);

            final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
            final LinearLayout linear1 = _view.findViewById(R.id.linear1);
            final ImageView imageview2 = _view.findViewById(R.id.imageview2);
            final TextView textview1 = _view.findViewById(R.id.textview1);
            final TextView textview2 = _view.findViewById(R.id.textview2);


        }
    }

}
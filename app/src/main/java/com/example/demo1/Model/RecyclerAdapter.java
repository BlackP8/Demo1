package com.example.demo1.Model;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo1.Model.Data.Data;
import com.example.demo1.Model.Data.DbOperations;
import com.example.demo1.Model.Data.MyConstants;
import com.example.demo1.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

   private List<Data> list;
    private Context context;
    private Cursor cursor;


    public RecyclerAdapter(List<Data> list) {
            this.list = list;
//            this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private CardView income_cv;
        private TextView amount_vh;
        private TextView type_vh;
        private TextView note_vh;
        private TextView date_vh;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            income_cv = (CardView)itemView.findViewById(R.id.dash_income_window);
            amount_vh = (TextView)itemView.findViewById(R.id.amount_income_dash);
            type_vh = (TextView)itemView.findViewById(R.id.type_income_dash);
            note_vh = (TextView)itemView.findViewById(R.id.note_income_dash);
            date_vh = (TextView)itemView.findViewById(R.id.date_income_dash);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dashboard_income_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.amount_vh.setText(list.get(position).getAmount());
        holder.type_vh.setText(list.get(position).getType());
        holder.note_vh.setText(list.get(position).getNote());
        holder.date_vh.setText(list.get(position).getDate());

//        holder.income_cv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String currentValue = list[position];
//                Log.d("CardView", "CardView Clicked: " + currentValue);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

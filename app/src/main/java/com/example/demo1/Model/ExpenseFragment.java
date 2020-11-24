package com.example.demo1.Model;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demo1.R;


public class ExpenseFragment extends Fragment {

    //Recycler view
    private RecyclerView recyclerView;

    //Обновление данных
    private EditText editAmount_exp;
    private EditText editType_exp;
    private EditText editNote_exp;

    private Button btnUpdate_exp;
    private Button btnDelete_exp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myview = inflater.inflate(R.layout.fragment_expense, container, false);

        recyclerView = myview.findViewById(R.id.recycler_expense);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        return myview;
    }

    @Override
    public void onStart() {
        super.onStart();
    }



}
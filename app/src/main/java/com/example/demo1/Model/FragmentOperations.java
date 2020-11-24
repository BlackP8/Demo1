package com.example.demo1.Model;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo1.R;

public class FragmentOperations {

    //Прописываем появление окна обновления
    private void updateData (EditText amount, EditText type, EditText note, Button btnUpdate, Button btnDelete, Activity activity) {

        AlertDialog.Builder mydialog = new AlertDialog.Builder(activity);
        LayoutInflater inflater = LayoutInflater.from(activity);
        View myview = inflater.inflate(R.layout.update_data, null);
        mydialog.setView(myview);

        amount = myview.findViewById(R.id.amount_txt);
        type = myview.findViewById(R.id.type_txt);
        note = myview.findViewById(R.id.note_txt);

        btnUpdate = myview.findViewById(R.id.btn_update);
        btnDelete = myview.findViewById(R.id.btn_delete);

        final AlertDialog dialog = mydialog.create();

        //Задаем обработчик событий для кнопок обновить и удалить
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }



    //Создаем отедльный класс для хранения значений полей окна операции
    public static class IncomeViewHolder extends RecyclerView.ViewHolder {
        View mIncomeView;

        public IncomeViewHolder(@NonNull View itemView) {
            super(itemView);
            mIncomeView = itemView;
        }

        //Устанавливаем тип операции
        private void setType (String type) {
            TextView type_data = mIncomeView.findViewById(R.id.type_income_dash);
            type_data.setText(type);
        }

        //Устанвливаем заметку
        private void setNote (String note) {
            TextView note_data = mIncomeView.findViewById(R.id.note_income_dash);
            note_data.setText(note);
        }

        //Устанавливаем дату
        private void setDate (String date) {
            TextView date_data = mIncomeView.findViewById(R.id.date_income_dash);
            date_data.setText(date);
        }

        private void setAmount (int amount) {
            TextView amount_data = mIncomeView.findViewById(R.id.amount_income_dash);
            String strAmount = String.valueOf(amount);
            amount_data.setText(strAmount);
        }
    }


}

package com.example.demo1.Data;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demo1.CalendarActivity;
import com.example.demo1.HomeActivity;
import com.example.demo1.R;
import com.example.demo1.ui.Login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    DatePickerDialog.OnDateSetListener setListener;

    //Активная кнопка
    private FloatingActionButton float_main_btn;
    private FloatingActionButton float_income_btn;
    private FloatingActionButton float_expense_btn;

    //Текст кнопки
    private TextView float_income_txt;
    private TextView float_expense_txt;

    private boolean isOpen = false;

    //Анимация кнопки
    private Animation fadOpen, fadClose;

//    //Recycler
//    private RecyclerView recyclerIncome;
//    private RecyclerView recyclerExpense;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myview = inflater.inflate(R.layout.fragment_dashboard, container, false);

        //Привязываем активную кнопку к экрану
        float_main_btn = myview.findViewById(R.id.float_main_btn);
        float_income_btn = myview.findViewById(R.id.income_float_btn);
        float_expense_btn = myview.findViewById(R.id.expense_float_btn);

        //Привязываем текст кнопки
        float_income_txt = myview.findViewById(R.id.income_text);
        float_expense_txt = myview.findViewById(R.id.expense_text);

//        //Присоединяем историю операций
//        recyclerIncome = myview.findViewById(R.id.rlr_dash_income);
//        recyclerExpense = myview.findViewById(R.id.rlr_dash_expense);

        //Присоединяем анимацию
        fadOpen = AnimationUtils.loadAnimation(getActivity(), R.anim.float_open);
        fadClose = AnimationUtils.loadAnimation(getActivity(), R.anim.float_close);


        float_main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addOperation();
                floatBtnAnimation ();
            }
        });

        //Прописываем логику отображения истории операций
        LinearLayoutManager layoutManagerIncome = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManagerIncome.setStackFromEnd(true);
        layoutManagerIncome.setReverseLayout(true);
//        recyclerIncome.setHasFixedSize(true);
//        recyclerIncome.setLayoutManager(layoutManagerIncome);

        LinearLayoutManager layoutManagerExpense = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManagerExpense.setStackFromEnd(true);
        layoutManagerExpense.setReverseLayout(true);
//        recyclerExpense.setHasFixedSize(true);
//        recyclerExpense.setLayoutManager(layoutManagerIncome);

        return myview;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    //Анимация исчезновения кнопок доходы и расходы после добавления данных
    private void floatBtnAnimation () {

        if (isOpen) {
            float_income_btn.startAnimation(fadClose);
            float_expense_btn.startAnimation(fadClose);
            float_income_btn.setClickable(false);
            float_expense_btn.setClickable(false);

            float_income_txt.startAnimation(fadClose);
            float_expense_txt.startAnimation(fadClose);
            float_income_txt.setClickable(false);
            float_expense_txt.setClickable(false);
            isOpen = false;
        }
        else {
            float_income_btn.startAnimation(fadOpen);
            float_expense_btn.startAnimation(fadOpen);
            float_income_btn.setClickable(true);
            float_expense_btn.setClickable(true);

            float_income_txt.startAnimation(fadOpen);
            float_expense_txt.startAnimation(fadOpen);
            float_income_txt.setClickable(true);
            float_expense_txt.setClickable(true);
            isOpen = true;
        }
    }

    private void addOperation() {
        //Кнопка доходов
        float_income_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incomeDataInput ();
            }
        });

        //Кнопка расходов
        float_expense_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expenseDataInput();
            }
        });
    }

    private void calendarCall() {
        //Создаем диалоговое окно
        AlertDialog.Builder mydialog = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        //Создаем объект вида нашего окна
        View myview = inflater.inflate(R.layout.activity_calendar, null);

        mydialog.setView(myview);
        final AlertDialog dialog = mydialog.create();

        //Если нажать на пространство вне окна, оно закроется
        dialog.setCancelable(false);

        //Задаем кнопки окна
        Button btnSave_date = myview.findViewById(R.id.btn_save_date);
        Button btnCancel_date = myview.findViewById(R.id.btn_cancel_date);



        btnCancel_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void incomeDataInput () {
        //Создаем диалоговое окно
        AlertDialog.Builder mydialog = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        //Создаем объект вида нашего окна
        View myview = inflater.inflate(R.layout.input_dialog_layout, null);

        mydialog.setView(myview);
        final AlertDialog dialog = mydialog.create();

        //Если нажать на пространство вне окна, оно закроется
        dialog.setCancelable(false);

        //Задаем поля окна
        final EditText amount_ed = myview.findViewById(R.id.amount_txt);
        final EditText type_ed = myview.findViewById(R.id.type_txt);
        final EditText note_ed = myview.findViewById(R.id.note_txt);
        final EditText date_ed = myview.findViewById(R.id.date_txt);

        //Задаем кнопки окна
        Button btnSave = myview.findViewById(R.id.btn_save);
        Button btnCancel = myview.findViewById(R.id.btn_cancel);

        date_ed.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                calendarCall();
            }
        });

        //Создаем обработчик событий для кнопки сохранить
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Записываем значения полей в строки
                String type = type_ed.getText().toString().trim();
                String amount = amount_ed.getText().toString().trim();
                String note = note_ed.getText().toString().trim();
                String date = date_ed.getText().toString().trim();

                //Проверка ввода для полей
                if (TextUtils.isEmpty(date)) {
                    date_ed.setError("Вы ничего не ввели!");
                    return;
                }

                if (TextUtils.isEmpty(type)) {
                    type_ed.setError("Вы ничего не ввели!");
                    return;
                }

                if (TextUtils.isEmpty(amount)) {
                    amount_ed.setError("Вы ничего не ввели!");
                    return;
                }

                int amount_int = Integer.parseInt(amount);

                if (TextUtils.isEmpty(note)) {
                    note_ed.setError("Вы ничего не ввели!");
                    return;
                }

                floatBtnAnimation();
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatBtnAnimation();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void expenseDataInput () {
        //Создаем диалоговое окно
        AlertDialog.Builder mydialog = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        //Создаем объект вида нашего окна
        View myview = inflater.inflate(R.layout.input_dialog_layout, null);

        mydialog.setView(myview);
        final AlertDialog dialog = mydialog.create();

        //Если нажать на пространство вне окна, оно закроется
        dialog.setCancelable(false);

        //Задаем поля окна
        final EditText amount_exp = myview.findViewById(R.id.amount_txt);
        final EditText type_exp = myview.findViewById(R.id.type_txt);
        final EditText note_exp = myview.findViewById(R.id.note_txt);
        final EditText date_ed = myview.findViewById(R.id.date_txt);


        //Задаем кнопки окна
        Button btnSave = myview.findViewById(R.id.btn_save);
        Button btnCancel = myview.findViewById(R.id.btn_cancel);

        date_ed.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                calendarCall();
            }
        });

        //Создаем обработчик событий для кнопки сохранить
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Записываем значения полей в строки
                String expense_type = type_exp.getText().toString().trim();
                String expense_amount = amount_exp.getText().toString().trim();
                String expense_note = note_exp.getText().toString().trim();
                String date = date_ed.getText().toString().trim();

                //Проверка ввода для полей
                if (TextUtils.isEmpty(date)) {
                    date_ed.setError("Вы ничего не ввели!");
                    return;
                }

                if (TextUtils.isEmpty(expense_type)) {
                    type_exp.setError("Вы ничего не ввели!");
                    return;
                }

                if (TextUtils.isEmpty(expense_amount)) {
                    amount_exp.setError("Вы ничего не ввели!");
                    return;
                }

                int amount_int = Integer.parseInt(expense_amount);

                if (TextUtils.isEmpty(expense_note)) {
                    note_exp.setError("Вы ничего не ввели!");
                    return;
                }

                floatBtnAnimation();
            }
        });


        //Обработчик событий для кнопки отмена
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatBtnAnimation();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}
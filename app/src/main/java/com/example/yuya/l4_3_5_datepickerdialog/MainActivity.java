package com.example.yuya.l4_3_5_datepickerdialog;

import android.app.Application;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    EditText mEditText;

    int mYear;
    int mMonth;
    int mDay;
    int mHour;
    int mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);

        mEditText = (EditText) findViewById(R.id.editText);

        //今日の日時を取得
        Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        mHour = calendar.get(Calendar.HOUR);
        mMinute = calendar.get(Calendar.MINUTE);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button1){
            mTextView.setText(mEditText.getText().toString());
        }else if(v.getId() == R.id.button2){
            showAlertDialog();
        }else if(v.getId() == R.id.button3){
            showTimerPickerDialog();
        }else if(v.getId() == R.id.button4){
            showDatePickerDialog();
        }
    }

    private void showAlertDialog(){
        //AlertDialog.Builderクラスを使ってAlertDialogを準備する
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("タイトル");
        alertDialogBuilder.setMessage("メッセージ");

        //肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("肯定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("UI_PARTS", "肯定ボタン");
                Toast.makeText(getApplication(), "肯定ボタンが押されました",Toast.LENGTH_LONG).show();
            }
        });

        //中立ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNeutralButton("中立", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("UI_PARTS","中立ボタン");
                Toast.makeText(getApplication(), "中立ボタンが押されました",Toast.LENGTH_LONG).show();
            }
        });

        //否定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNegativeButton("否定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("UI_PARTS","否定ボタン");
                Toast.makeText(getApplication(),"否定ボタンが押されました",Toast.LENGTH_LONG).show();
            }
        });

        //AlertDialogを作成して、表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void showTimerPickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.d("UI_PARTS", String.valueOf(hourOfDay)+":"+String.valueOf(minute));
                Toast.makeText(getApplication(),String.valueOf(hourOfDay)+":"+String.valueOf(minute)+"に設定しました。",Toast.LENGTH_LONG).show();
            }
        },mHour,mMinute,true);
        timePickerDialog.show();
    }

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d("UI_PARTS", String.valueOf(year)+"年"+String.valueOf(month)+"月"+String.valueOf(dayOfMonth));
                Toast.makeText(getApplication(),String.valueOf(year)+"年"+String.valueOf(month)+"月"+String.valueOf(dayOfMonth)+"に設定しました",Toast.LENGTH_LONG ).show();
            }
        },
        mYear,mMonth,mDay);
        datePickerDialog.show();
    }

}

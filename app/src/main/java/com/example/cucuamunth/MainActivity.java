package com.example.cucuamunth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    CheckBox cb1, cb2, cb3;
    SeekBar see1, see2,see3;
    ImageView img;
    int diem=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ

        txt= (TextView) findViewById(R.id.text);

        cb1=(CheckBox) findViewById(R.id.checkbox_one);
        cb2=(CheckBox) findViewById(R.id.checkbox_two);
        cb3=(CheckBox) findViewById(R.id.checkbox_three);

        see1=(SeekBar) findViewById(R.id.seekBar_one);
        see2=(SeekBar) findViewById(R.id.seekBar_two);
        see3=(SeekBar) findViewById(R.id.seekBar_three);

        img=(ImageView) findViewById(R.id.imageView);

        // Code
        see1.setEnabled(false);
        see2.setEnabled(false);
        see3.setEnabled(false);

        txt.setText(diem +"");
        CountDownTimer cdtime= new CountDownTimer(60000,600) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number=5;
                Random rd= new Random();
                int one = rd.nextInt(number);
                int two =rd.nextInt(number);
                int three =rd.nextInt(number);
                // kiểm tra
                if (see1.getProgress() >= see1.getMax()){
                    // Nút play hiện sau khi cuộc đua kết thúc
                    img.setVisibility(View.VISIBLE);
                    this.cancel();;
                    Toast.makeText(MainActivity.this," see1 win",Toast.LENGTH_LONG).show();
                    // Tạo và hiển thị điểm số cho user
                    if (cb1.isChecked()){
                        diem=diem+10;

                    }
                    else {
                        diem=diem-5;
                    }
                    txt.setText (diem+"");
                    enableCheckbox();

                }
                if (see2.getProgress() >= see2.getMax()){
                      img.setVisibility(View.VISIBLE);
                      this.cancel();
                      Toast.makeText(MainActivity.this,"see2 WIN",Toast.LENGTH_LONG).show();
                      //
                    if (cb2.isChecked()){
                        diem=diem+10;

                    }
                    else {
                        diem=diem-5;

                    }
                    txt.setText (diem+"");
                    enableCheckbox();


                }
                if (see3.getProgress() >= see3.getMax()){
                    img.setVisibility(View.VISIBLE);
                    this.cancel();
                    Toast.makeText(MainActivity.this,"see3 WIN", Toast.LENGTH_LONG).show();
                    //
                    if (cb3.isChecked()){
                        diem=diem+10;

                    }
                    else {
                        diem=diem-5;

                    }
                    txt.setText (diem+"");
                    enableCheckbox();

                }
                // hàm random
                see1.setProgress(see1.getProgress()+one);
                see2.setProgress(see2.getProgress()+two);
                see3.setProgress(see3.getProgress()+three);
            }

            @Override
            public void onFinish() {

            }
        };
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked()){
                    see1.setProgress(0);
                    see2.setProgress(0);
                    see3.setProgress(0);
                    img.setVisibility(View.INVISIBLE);
                    cdtime.start();
                    disseenablCheckbox();

                }
                else {
                    Toast.makeText(MainActivity.this,"Vui lòng đặt cược",Toast.LENGTH_SHORT).show();
                }

            }
        });
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    // bỏ chọn 2 ô kia
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    // bỏ chọn 2 ô kia
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    // bỏ chọn 2 ô kia
                    cb2.setChecked(false);
                    cb1.setChecked(false);
                }
            }
        });
    }
    private void enableCheckbox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);

    }
    private void disseenablCheckbox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);

    }
}
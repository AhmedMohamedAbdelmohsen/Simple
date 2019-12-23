package com.example.mycalculator;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import java.io.IOException;
import org.mozilla.javascript.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mycalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    String Process;
    String finalResault = "";
    boolean checkBrackets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this line for hide statusBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvIsert.setText("");
                binding.tvResult.setText("");
            }
        });
        binding.btBrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkBrackets == true){
                    Process = binding.tvIsert.getText().toString();
                    binding.tvIsert.setText(Process + ")");
                    checkBrackets = false;
                }else {
                    Process = binding.tvIsert.getText().toString();
                    binding.tvIsert.setText(Process + "(");
                    checkBrackets = true;
                }
            }
        });
        binding.btPrecetage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "%");
            }
        });
        binding.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Process.length() > 1) {
                    Process = Process.substring(0,Process.length() - 1);
                    binding.tvIsert.setText(Process);
                } else if (Process.length() <= 1) {
                    binding.tvIsert.setText("");
                }
            }
        });
        binding.btDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "÷");
            }
        });
        binding.btMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "×");
            }
        });
        binding.btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "-");
            }
        });
        binding.btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "+");
                //String plus = Process + "<font color='#F7467C'>+</font>";
                //tvInsert.setText(Html.fromHtml(plus));

            }
        });
        binding.btDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + ".");
            }
        });
        binding.btAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvIsert.setText(finalResault);
                binding.tvResult.setText("");
            }
        });
        binding.btEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                Process = Process.replaceAll("×","*");
                Process = Process.replaceAll("%","/100");
                Process = Process.replaceAll("÷","/");
                Process = Process.replaceAll("\\(" ,"*(");


                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResault = rhino.evaluateString(scriptable,Process,
                            "javascript",1,null).toString();
                }catch (Exception e){
                    finalResault = "0";
                }
                binding.tvResult.setText(finalResault);
            }
        });
        binding.bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "0");
            }
        });
        binding.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "1");
            }
        });
        binding.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "2");
            }
        });
        binding.bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "3");
            }
        });
        binding.bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "4");
            }
        });
        binding.bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "5");
            }
        });
        binding.bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "6");
            }
        });
        binding.bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "7");
            }
        });
        binding.bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "8");
            }
        });
        binding.bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvIsert.getText().toString();
                binding.tvIsert.setText(Process + "9");
            }
        });



    }
}

package com.ahmedabdelmohsen.mycalculator;

import android.databinding.DataBindingUtil;

import org.mozilla.javascript.*;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.ahmedabdelmohsen.mycalculator.databinding.ActivityMainBinding;

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
                binding.tvInsert.setText("");
                binding.tvResult.setText("");
            }
        });
        binding.btBrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkBrackets == true) {
                    Process = binding.tvInsert.getText().toString();
                    binding.tvInsert.setText(Process + ")");
                    checkBrackets = false;
                } else {
                    Process = binding.tvInsert.getText().toString();
                    binding.tvInsert.setText(Process + "(");
                    checkBrackets = true;
                }
            }
        });
        binding.btPrecetage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "%");
            }
        });
        binding.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Process.length() > 1) {
                    Process = Process.substring(0, Process.length() - 1);
                    binding.tvInsert.setText(Process);
                } else if (Process.length() <= 1) {
                    binding.tvInsert.setText("");
                }
            }
        });
        binding.btDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "÷");
            }
        });
        binding.btMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "×");
            }
        });
        binding.btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "-");
            }
        });
        binding.btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "+");
                //String plus = Process + "<font color='#F7467C'>+</font>";
                //tvInsert.setText(Html.fromHtml(plus));

            }
        });
        binding.btDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + ".");
            }
        });
        binding.btAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvInsert.setText(finalResault);
                binding.tvResult.setText("");
            }
        });
        binding.btEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                Process = Process.replaceAll("×", "*");
                Process = Process.replaceAll("%", "/100");
                Process = Process.replaceAll("÷", "/");
                Process = Process.replaceAll("\\(", "*(");


                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResault = rhino.evaluateString(scriptable, Process,
                            "javascript", 1, null).toString();
                } catch (Exception e) {
                    finalResault = "0";
                }
                binding.tvResult.setText(finalResault);
            }
        });
        binding.bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "0");
            }
        });
        binding.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "1");
            }
        });
        binding.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "2");
            }
        });
        binding.bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "3");
            }
        });
        binding.bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "4");
            }
        });
        binding.bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "5");
            }
        });
        binding.bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "6");
            }
        });
        binding.bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "7");
            }
        });
        binding.bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "8");
            }
        });
        binding.bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process = binding.tvInsert.getText().toString();
                binding.tvInsert.setText(Process + "9");
            }
        });


    }
}

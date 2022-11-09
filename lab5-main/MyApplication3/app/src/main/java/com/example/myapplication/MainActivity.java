package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_toast = findViewById(R.id.btn_toast);
        Button btn_custom = findViewById(R.id.btn_custom);
        Button btn_snackbar = findViewById(R.id.btn_snackbar);
        Button btn_dialog1 = findViewById(R.id.btn_dialog1);
        Button btn_dialog2 = findViewById(R.id.btn_dialog2);
        Button btn_dialog3 = findViewById(R.id.btn_dialog3);

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "預設toast", Toast.LENGTH_SHORT).show();
            }
        });

        btn_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast();
            }
        });
        btn_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "I’m Snackbar", Snackbar.LENGTH_LONG).show();

            }
        });
        btn_dialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(false);
                builder.setTitle("按鈕式 AlertDialog");
                builder.setMessage("AlertDialog 內容");
                builder.setNeutralButton("左鍵", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Toast.makeText(MainActivity.this, "左鍵", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("中鍵", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Toast.makeText(MainActivity.this, "中鍵", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("右鍵", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "右鍵", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });

        btn_dialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    showListDialog();
                }

        });

        btn_dialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showsingleListDialog();
            }
        });
    }


    private void showToast() {
        Toast toast = new Toast(MainActivity.this);
        toast.setGravity(Gravity.TOP, 0, 50);
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.cu));
        toast.setView(layout);
        toast.show();
    }

    private void showListDialog() {
        final String[] list = {"message1", "message2", "message3", "message4", "message5"};
        AlertDialog.Builder dialog_list = new AlertDialog.Builder(MainActivity.this);
        dialog_list.setTitle("使用list呈現");
        dialog_list.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this, "你還是得" + list[i], Toast.LENGTH_SHORT).show();
            }
        });
        dialog_list.show();
    }
    private void showsingleListDialog() {
        final String[] list1 = {"選項1", "選項2", "選項3", "選項4", "選項5"};
        AlertDialog.Builder dialog_list = new AlertDialog.Builder(MainActivity.this);
        dialog_list.setSingleChoiceItems(list1,0,new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Toast.makeText(MainActivity.this,  list1[i], Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
        dialog_list.show();
    }
}

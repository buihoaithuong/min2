package com.example.min2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<thoiTiet> thoiTietArrayList;
    thoiTietAdapter adapter;
    EditText edt1, edt2;
    Button btnUpdate, btnView, btnAdd;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        thoiTietArrayList = new ArrayList<>();
        thoiTietArrayList.add(new thoiTiet("Sunday ",R.drawable.ic_baseline_cloud_queue_24,"18"));
        thoiTietArrayList.add(new thoiTiet("Monday ",R.drawable.ic_baseline_cloud_queue_24,"18"));
        thoiTietArrayList.add(new thoiTiet("Tuesday ",R.drawable.ic_baseline_cloud_queue_24,"18"));
        thoiTietArrayList.add(new thoiTiet("Wednesday",R.drawable.ic_baseline_cloud_queue_24,"18"));
        thoiTietArrayList.add(new thoiTiet("Thusday ",R.drawable.ic_baseline_cloud_queue_24,"18"));
        thoiTietArrayList.add(new thoiTiet("Friday",R.drawable.ic_baseline_cloud_queue_24,"18"));
        thoiTietArrayList.add(new thoiTiet("Saturday ",R.drawable.ic_baseline_cloud_queue_24,"18"));

        adapter = new thoiTietAdapter(this, R.layout.dong_thoi_tiet, thoiTietArrayList);
        lv.setAdapter(adapter);
        delete();
        add();
        update();
    }

    private void update() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
                edt1.setText(thoiTietArrayList.get(vitri).getNgay());
                edt2.setText(thoiTietArrayList.get(vitri).getNhiet());
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thoiTietArrayList.set(vitri, new thoiTiet(
                        edt1.getText().toString(),
                        R.drawable.ic_baseline_cloud_queue_24,
                        edt2.getText().toString()
                ));
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void add() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ngay = edt1.getText().toString();
                String nhiet = edt2.getText().toString();
                thoiTietArrayList.add(new thoiTiet(ngay, R.drawable.ic_baseline_cloud_queue_24,nhiet));
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void delete() {
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                thoiTietArrayList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void AnhXa() {
        lv = (ListView)findViewById(R.id.Listview);
        edt1 = (EditText)findViewById(R.id.edt1);
        edt2 = (EditText)findViewById(R.id.edt2);
        btnUpdate = (Button)findViewById(R.id.button1);
        btnView = (Button)findViewById(R.id.button2);
        btnAdd = (Button)findViewById(R.id.button3);
    }
}
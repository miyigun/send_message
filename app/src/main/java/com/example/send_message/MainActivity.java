package com.example.send_message;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        define();
        createList();
    }

    private void createList() {
        list=new ArrayList<>();
        Model model1=new Model("Aleksandr","00000000000");
        Model model2=new Model("Mikhail","11111111111");
        Model model3=new Model("Siegbert","22222222222");
        Model model4=new Model("Robert","33333333333");
        Model model5=new Model("Tigran","44444444444");
        Model model6=new Model("Magnus","55555555555");

        list.add(model1);
        list.add(model2);
        list.add(model3);
        list.add(model4);
        list.add(model5);
        list.add(model6);

    }

    public void define(){
        ListView listView=(ListView) findViewById(R.id.messageList);
        adapter adp=new adapter(list,this,this);
        listView.setAdapter(adp);
    }
}
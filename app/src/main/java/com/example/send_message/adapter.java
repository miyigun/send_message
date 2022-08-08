package com.example.send_message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class adapter extends BaseAdapter {
    List<Model> list;
    Context context;
    Activity activity;

    public adapter(List<Model> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.layout,viewGroup,false);
        final EditText editText=(EditText) view.findViewById(R.id.messageContent);
        Button button=(Button) view.findViewById(R.id.buton);
        TextView tel=(TextView) view.findViewById(R.id.tel);
        TextView name=(TextView) view.findViewById(R.id.name);

        tel.setText(list.get(i).getTel());
        name.setText(list.get(i).getName());
        final String telNo=list.get(i).getTel();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageContent=editText.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("SMS: "+telNo));
                intent.putExtra("sms_body",messageContent);
                activity.startActivity(intent);

            }
        });

        return view;
    }
}

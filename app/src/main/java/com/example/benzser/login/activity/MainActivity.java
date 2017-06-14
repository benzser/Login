package com.example.benzser.login.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.benzser.login.R;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();
    }

    private void initInstances() {
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(new MainAdapter(getApplicationContext()));
    }

    public class MainAdapter extends BaseAdapter {

        public Context mContext;
        public LayoutInflater mInflater;

        public MainAdapter(Context context) {
            mContext = context;
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Viewholder holder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.report_adapter, null);

                holder = new Viewholder();
                holder.category = (TextView) convertView.findViewById(R.id.report_catetv);
                holder.description = (TextView) convertView.findViewById(R.id.report_destv);
                holder.amount = (TextView) convertView.findViewById(R.id.report_amounttv);
                convertView.setTag(holder);
            } else {
                holder = (Viewholder) convertView.getTag();
            }

            holder.category.setText("Category " + position);
            holder.description.setText("Hello " + position);
            holder.amount.setText(""+position);

            return convertView;
        }
    }

    public class Viewholder {
        TextView category, description, amount;
    }
}

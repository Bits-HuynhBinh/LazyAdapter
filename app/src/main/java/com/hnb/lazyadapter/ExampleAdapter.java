package com.hnb.lazyadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by USER on 9/25/2015.
 */
public class ExampleAdapter extends BaseAdapter
{
    List<ExampleObject> listData;
    Activity activity;
    private LayoutInflater layoutInflater;
    ViewHolder holder;
    Executor executor;

    public ExampleAdapter(Activity activity, List<ExampleObject> list)
    {
        this.listData = list;
        this.layoutInflater = LayoutInflater.from(activity);
        this.activity = activity;
        executor = new Executor();
    }

    public void setListData(List<ExampleObject> data)
    {
        this.listData = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        int count = (listData == null) ? 0 : listData.size();

        return count;
    }

    @Override
    public Object getItem(int position)
    {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = this.layoutInflater.inflate(R.layout.row, null);
            holder = new ViewHolder();

            holder.rowRoot = (LinearLayout) convertView.findViewById(R.id.rowRoot);
            holder.txt1 = (TextView) convertView.findViewById(R.id.item1);
            holder.txt2 = (TextView) convertView.findViewById(R.id.item2);
            holder.txt3 = (TextView) convertView.findViewById(R.id.item3);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        final ExampleObject exampleObject = listData.get(position);


        //Integer a = 0;
        holder.txt1.setText("...");

        executor.run(position, holder.txt1);




        /*if (exampleObject != null)
        {

            holder.txt1.setText(a.toString());
            holder.txt2.setText(exampleObject.item2);
            holder.txt3.setText(exampleObject.item3);
        }
        else
        {
            holder.txt1.setText("-");
            holder.txt2.setText("-");
            holder.txt3.setText("-");
        }*/

        return convertView;
    }

    public class ViewHolder
    {
        LinearLayout rowRoot;
        TextView txt1;
        TextView txt2;
        TextView txt3;
    }


}

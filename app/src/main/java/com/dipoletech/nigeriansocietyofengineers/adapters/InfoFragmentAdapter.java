package com.dipoletech.nigeriansocietyofengineers.adapters;/**
 * Created by DABBY(3pleMinds) on 22-Nov-15.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dipoletech.nigeriansocietyofengineers.R;

/**
 * DABBY(3pleMinds) 22-Nov-15 4:07 PM 2015 11
 * 22 16 07 NigerianSocietyOfEngineers
 **/
public class InfoFragmentAdapter extends RecyclerView.Adapter<InfoItem> {
    private final Context context;

    public InfoFragmentAdapter(Context context) {
        this.context  = context;
    }

    @Override
    public InfoItem onCreateViewHolder(ViewGroup parent, int viewType) {
        //get the instance of the layoutInflater
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //inflate the view
        View view  = inflater.inflate(R.layout.info_item,parent,false);

        InfoItem item = new InfoItem(view);
        return item;
    }

    @Override
    public void onBindViewHolder(InfoItem holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}

class InfoItem extends RecyclerView.ViewHolder
{

    public InfoItem(View itemView) {
        super(itemView);
    }
}
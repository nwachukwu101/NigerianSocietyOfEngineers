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
 * DABBY(3pleMinds) 22-Nov-15 3:39 PM 2015 11
 * 22 15 39 NigerianSocietyOfEngineers
 **/
public class PaymentFragmentAdapter extends RecyclerView.Adapter<PaymentItem> {

    private final Context context;

    //this implementation needs a context
    public PaymentFragmentAdapter(Context context)
    {
        this.context = context;
    }
    @Override
    public PaymentItem onCreateViewHolder(ViewGroup parent, int viewType) {
        //this will return a view holder of the type Payment Item
        //get the inflater first
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        //inflate the view
        View  view = inflater.inflate(R.layout.payment_item,parent,false);

        return new PaymentItem(view);
    }

    @Override
    public void onBindViewHolder(PaymentItem holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }
}

class PaymentItem extends RecyclerView.ViewHolder{

    public PaymentItem(View itemView) {
        super(itemView);
    }
}
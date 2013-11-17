package com.madan.fakecake;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import com.madan.model.Cupcake;

import java.util.List;

/**
 * Created by Madan on 11/17/13.
 */
public class CupcakeAdapter extends ArrayAdapter<Cupcake> {

    private List<Cupcake> cupcakes;
    private Context context;
    int layoutResourceId;

    public CupcakeAdapter(Context context, int textViewResourceId, List<Cupcake> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.cupcakes = objects;
        layoutResourceId = textViewResourceId;
    }


    public List<Cupcake> getCupcakes() {
        return cupcakes;
    }

    public void setCupcakes(List<Cupcake> cupcakes) {
        this.cupcakes = cupcakes;
    }

    public static class CellViewHolder{
        public TextView name;
        public TextView shortDescription;
    }

    public View getView(int position, View converterView, ViewGroup parent){
        View cellView = converterView;
        CellViewHolder holder = null;
        if(cellView==null){
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            cellView = layoutInflater.inflate(layoutResourceId, parent, false);
            holder = new CellViewHolder();
            holder.name = (TextView) cellView.findViewById(R.id.name);
            holder.shortDescription = (TextView) cellView.findViewById(R.id.short_description);
            cellView.setTag(holder);
        }
        else {
            holder = (CellViewHolder)cellView.getTag();
        }
        Cupcake cupcake = cupcakes.get(position);
        holder.name.setText(cupcake.getName());
        holder.shortDescription.setText(cupcake.getShortDescription());
        return cellView;
    }

    @Override
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}

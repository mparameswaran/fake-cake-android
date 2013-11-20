package com.madan.fakecake;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.madan.model.Cupcake;

import java.util.List;

/**
 * Created by Madan on 11/17/13.
 */
public class CupcakeAdapter extends ArrayAdapter<Cupcake> {

    private List<Cupcake> cupcakes;
    private Context context;
    int layoutResourceId;
    String baseURL = null;

    public CupcakeAdapter(Context context, int textViewResourceId, List<Cupcake> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.cupcakes = objects;
        layoutResourceId = textViewResourceId;
        baseURL = context.getString(R.string.base_url);
    }


    public List<Cupcake> getCupcakes() {
        return cupcakes;
    }

    public void setCupcakes(List<Cupcake> cupcakes) {
        this.cupcakes = cupcakes;
    }

    public static class CellViewHolder{
        public TextView name;
        public ImageView imageView;
        public  TextView description;
    }

    public View getView(int position, View converterView, ViewGroup parent){
        View cellView = converterView;
        CellViewHolder holder = null;
        if(cellView==null){
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            cellView = layoutInflater.inflate(layoutResourceId, parent, false);
            holder = new CellViewHolder();
            holder.name = (TextView) cellView.findViewById(R.id.cupcake_name);
            Typeface typewriter = Typeface.createFromAsset(context.getAssets(), "fonts/moms_typewriter.ttf");
            holder.name.setTypeface(typewriter);
            holder.description = (TextView) cellView.findViewById(R.id.description);
            holder.imageView = (ImageView) cellView.findViewById(R.id.cupcake_list_image);
            cellView.setTag(holder);
        }
        else {
            holder = (CellViewHolder)cellView.getTag();
        }
        Cupcake cupcake = cupcakes.get(position);
        holder.name.setText(cupcake.getName());
        holder.description.setText(cupcake.getDescription());

        UrlImageViewHelper.setUrlDrawable(holder.imageView, baseURL+cupcake.getThumbnailURL());
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

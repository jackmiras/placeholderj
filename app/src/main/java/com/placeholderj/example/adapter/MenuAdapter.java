package com.placeholderj.example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.placeholderj.example.R;
import com.placeholderj.example.models.Coupon;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jackson on 14/12/15.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private final Context context;
    private final List<Coupon> cupons;

    public MenuAdapter(Context context, List<Coupon> cupons) {
        this.context = context;
        this.cupons = cupons;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String unavailable = context.getResources().getString(R.string.activity_coupons_unavaliable);
        final Coupon cupon = cupons.get(position);
        if (cupon.imgUrl != null) {
            Picasso.with(context).load(cupon.imgUrl).into(holder.imageViewCoupon);
        }
        holder.textViewCode.setText(cupon.code != null ? cupon.code : unavailable);
    }

    @Override
    public int getItemCount() {
        return cupons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageview_cupon)
        ImageView imageViewCoupon;
        @BindView(R.id.textview_code)
        TextView textViewCode;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

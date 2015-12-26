package com.example.jackmiras.placeholderj.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jackmiras.placeholderj.R;
import com.example.jackmiras.placeholderj.models.Coupon;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jackson on 14/12/15.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private final Context context;
    private final List<Coupon> cupons;

    public MainAdapter(Context context, List<Coupon> cupons) {
        this.context = context;
        this.cupons = cupons;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String unavailable = context.getResources().getString(R.string.activity_coupons_unavaliable);
        Resources res = context.getResources();
        final Coupon cupon = cupons.get(position);
        if (cupon.imgUrl != null) {
            Picasso.with(context).load(cupon.imgUrl).into(holder.imageViewCoupon);
        }
        holder.textViewCode.setText(cupon.code != null ? cupon.code : unavailable);
//        holder.textViewExpirationDate.setText(cupon.exprirationDate != null ? res.getString(R.string.activity_redeem_expiration_date, getDateFormated(cupon.exprirationDate)) : unavailable);
    }

    @Override
    public int getItemCount() {
        return cupons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.card_view)
        CardView cardView;
        @Bind(R.id.imageview_cupon)
        ImageView imageViewCoupon;
        @Bind(R.id.textview_code)
        TextView textViewCode;
        @Bind(R.id.textView_expiration_date)
        TextView textViewExpirationDate;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public String getDateFormated(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(dt);
    }
}

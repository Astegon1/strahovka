package com.example.betaforall.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.betaforall.R;
import com.example.betaforall.insurance.AccidentInsuranceActivity;
import com.example.betaforall.insurance.HomeInsuranceActivity;
import com.example.betaforall.insurance.KaskoActivity;
import com.example.betaforall.insurance.MortgageInsuranceActivity;
import com.example.betaforall.insurance.OsagoActivity;
import com.example.betaforall.insurance.TravelInsuranceActivity;
import com.example.betaforall.model.ItemModel;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private final Context context;
    private final List<ItemModel> items;

    public ItemAdapter(Context context, List<ItemModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel item = items.get(position);
        holder.text1.setText(item.getText1());
        holder.text2.setText(item.getText2());
        holder.text3.setText(item.getText3());
        holder.imageView.setImageResource(item.getImageResId());
        holder.button.setOnClickListener(v -> {
            Intent intent;
            CharSequence text = holder.text2.getText();
            if (text.equals("Электронное ОСАГО")) {
                intent = new Intent(context, OsagoActivity.class);
            } else if (text.equals("Автострахование Каско")) {
                intent = new Intent(context, KaskoActivity.class);
            } else if (text.equals("Страхование для туристов")) {
                intent = new Intent(context, TravelInsuranceActivity.class);
            } else if (text.equals("Страхование ипотеки")) {
                intent = new Intent(context, MortgageInsuranceActivity.class);
            } else if (text.equals("Страхование квартиры")) {
                intent = new Intent(context, HomeInsuranceActivity.class);
            } else if (text.equals("Страхование от несчастных случаев")) {
                intent = new Intent(context, AccidentInsuranceActivity.class);
            } else {
                return;
            }
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2, text3;
        ImageView imageView;
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.category_title);
            text2 = itemView.findViewById(R.id.item_title);
            text3 = itemView.findViewById(R.id.item_description);
            imageView = itemView.findViewById(R.id.item_image);
            button = itemView.findViewById(R.id.calculate_button);
        }
    }
}

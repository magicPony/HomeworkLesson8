package com.example.taras.homeworklesson8;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by taras on 15.03.16.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private static ShowPersonActivityStarter starter = null;

    public CustomAdapter(ShowPersonActivityStarter starter) {
        this.starter = starter;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int listPosition) {
        TextView tvNameField;
        CardView cardView;
        tvNameField = holder.tvNameField;
        cardView = holder.cardView;
        tvNameField.setText(Data.getFirstName(listPosition));
        cardView.setCardBackgroundColor(Data.get(listPosition).isFilled() ? Color.YELLOW : Color.RED);
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvNameField;
        CardView cardView;
        ImageButton btnDelete;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvNameField = (TextView) itemView.findViewById(R.id.tv_name_field);
            this.cardView = (CardView) itemView.findViewById(R.id.card_view);
            this.btnDelete = (ImageButton) itemView.findViewById(R.id.btn_delete);

            tvNameField.setOnClickListener(this);
            btnDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int listPosition = this.getLayoutPosition();

            switch (v.getId()) {
                case R.id.tv_name_field : {
                    starter.startShowPersonActivity(listPosition);
                    break;
                }

                case R.id.btn_delete : {
                    MainActivity.removePerson(listPosition);
                    break;
                }
            }
        }
    }
}

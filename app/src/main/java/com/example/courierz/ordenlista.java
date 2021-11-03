package com.example.courierz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ordenlista extends RecyclerView.Adapter<ordenlista.OrderViewHolder> {
    private List<ordedetalle> order;

    public ordenlista(List<ordedetalle> order) {
        this.order = order;
    }

    @NonNull
    @Override
    public ordenlista.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orden, parent,false);

        OrderViewHolder OrderViewHolder = new ordenlista.OrderViewHolder(vista);
        return OrderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ordenlista.OrderViewHolder holder, int position) {
        holder.myText1.setText(order.get(position).getLugarEntrega());
        holder.myText2.setText(order.get(position).getID_Order());
        holder.setOnClickListener();
    }

    @Override
    public int getItemCount() {
        return order.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView myText1, myText2;
        public ImageButton Ver;
        public Context context;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            myText1 = itemView.findViewById(R.id.destinatario_tv);
            myText2 = itemView.findViewById(R.id.destino_tv);
            Ver = itemView.findViewById(R.id.btn_register);
        }
        void setOnClickListener(){
            Ver.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, Detalles.class);
            intent.putExtra("id",myText2.getText());
            context.startActivity(intent);
        }
    }
}

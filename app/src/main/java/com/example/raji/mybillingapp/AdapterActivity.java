package com.example.raji.mybillingapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.viewHolder>{


    Context context;
    List<Items> itemsList;

    public AdapterActivity(Context context, List<Items> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_listview,null);

        viewHolder holder = new viewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {


        final Items items = itemsList.get(i);

        viewHolder.orderTimeText.setText(items.getOrderedTime());
        viewHolder.orderNoText.setText(items.getOrderRef());
        viewHolder.professionText.setText(items.getOrderProf());
        viewHolder.statusText.setText(items.getOrderStatus());


        viewHolder.clickedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(context,OrderInfo.class);
                intent.putExtra("orderTime",items.getOrderedTime());
                intent.putExtra("orderRef",items.getOrderRef());
                intent.putExtra("orderProf",items.getOrderProf());
                intent.putExtra("orderStatus",items.getOrderStatus());
                intent.putExtra("orderAddress",items.getOrderAddress());
                intent.putExtra("orderRate",items.getOrderRate());
                intent.putExtra("orderTax",items.getOrderTax());
                intent.putExtra("orderDiscount",items.getOrderDiscount());
                intent.putExtra("orderGrandTotal",items.getOrderGrandTotal());
                intent.putExtra("orderServices",items.getOrderServices());
                intent.putExtra("orderPaymentStatus",items.getOrderPaymentStatus());
                intent.putExtra("orderPlace",items.getOrderPlace());
                intent.putExtra("orderStartTime",items.getOrderStartTime());
                intent.putExtra("orderEndTime",items.getOrderEndTime());
                intent.putExtra("orderTotalTime",items.getOrderTotalTime());
                intent.putExtra("jobAssignment",items.getJobAssignment());
                intent.putExtra("changeBooking",items.getChangeBooking());

                context.startActivity(intent);

            }
        });
        //image variable should also be declared

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {


        TextView orderTimeText,orderNoText,professionText,statusText;
        ImageView personImage;
        LinearLayout clickedLayout;

        public viewHolder(@NonNull View itemView) {

            super(itemView);

            orderTimeText = itemView.findViewById(R.id.orderTimeTextView);
            orderNoText = itemView.findViewById(R.id.orderNoTextView);
            professionText = itemView.findViewById(R.id.professionTextView);
            statusText = itemView.findViewById(R.id.statusTextView);
            personImage = itemView.findViewById(R.id.personView);
            clickedLayout = itemView.findViewById(R.id.itemLayout);

        }

    }




}

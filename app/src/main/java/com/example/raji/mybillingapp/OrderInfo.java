package com.example.raji.mybillingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class OrderInfo extends AppCompatActivity {


    TextView oProfTextView,oTimeTextView,oAddressTextView,oStatusTextView,oJobTextView;
    TextView rateTextView,taxTextView,discountTextView,grandTotalTextView,startTimeTextView,endTimeTextView,totalTimeTextView,paymentStatusTextView;
    TextView oServiceAnsTextView,oWorkAnsTextView,oChangeBookingTextView;
    DatabaseReference updateFirstDataBase,updateSecondDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);

        Intent intent = getIntent();


        setTitle(intent.getStringExtra("orderRef"));

        oProfTextView = (TextView)findViewById(R.id.oProfTextView) ;
        oAddressTextView = (TextView)findViewById(R.id.oAddressTextView);
        oStatusTextView = (TextView)findViewById(R.id.oStatusTextView);
        oJobTextView = (TextView)findViewById(R.id.oJobTextView);
        rateTextView = (TextView)findViewById(R.id.rateTextView);
        taxTextView = (TextView)findViewById(R.id.taxTextView);
        discountTextView = (TextView)findViewById(R.id.discountTextView);
        grandTotalTextView = (TextView)findViewById(R.id.grandTotalTextView);
        startTimeTextView = (TextView)findViewById(R.id.startTimeTextView);
        endTimeTextView = (TextView)findViewById(R.id.endTimeTextView);
        totalTimeTextView = (TextView)findViewById(R.id.totalTimeTextView);
        paymentStatusTextView = (TextView)findViewById(R.id.paymentStatusTextView);
        oTimeTextView = (TextView)findViewById(R.id.oTimeTextView);
        oServiceAnsTextView = (TextView)findViewById(R.id.oServiceAnsTextView);
        oWorkAnsTextView = (TextView)findViewById(R.id.oWorkAnsTextView);
        oChangeBookingTextView = (TextView)findViewById(R.id.oChangeBookingTextView);

        updateFirstDataBase = FirebaseDatabase.getInstance().getReference("orders").child("order1");
        updateSecondDataBase = FirebaseDatabase.getInstance().getReference("orders").child("order2");


        oProfTextView.setText(intent.getStringExtra("orderProf"));
        oTimeTextView.setText(intent.getStringExtra("orderTime"));
        oAddressTextView.setText(intent.getStringExtra("orderAddress"));
        oStatusTextView.setText(intent.getStringExtra("orderStatus"));
        rateTextView.setText(intent.getStringExtra("orderRate"));
        taxTextView.setText(intent.getStringExtra("orderTax"));
        discountTextView.setText(intent.getStringExtra("orderDiscount"));
        grandTotalTextView.setText(intent.getStringExtra("orderGrandTotal"));
        startTimeTextView.setText(intent.getStringExtra("orderStartTime"));
        endTimeTextView.setText(intent.getStringExtra("orderEndTime"));
        totalTimeTextView.setText(intent.getStringExtra("orderTotalTime"));
        paymentStatusTextView.setText(intent.getStringExtra("orderPaymentStatus"));
        oServiceAnsTextView.setText(intent.getStringExtra("orderServices"));
        oWorkAnsTextView.setText(intent.getStringExtra("orderPlace"));
        oJobTextView.setText(intent.getStringExtra("jobAssignment"));
        oChangeBookingTextView.setText(intent.getStringExtra("changeBooking"));

        oChangeBookingTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (oChangeBookingTextView.getText().equals("Cancel Booking")){

                    oChangeBookingTextView.setText("Booking Cancelled!");
                    oStatusTextView.setText("Cancelled");
                    paymentStatusTextView.setText("Booking cancelled");


                    Map<String, Object> updates = new HashMap<>();
                    updates.put("ChangeBooking", oChangeBookingTextView.getText());
                    updates.put("OrderStatus", oStatusTextView.getText());
                    updates.put("OrderPaymentStatus", paymentStatusTextView.getText());
                    updateFirstDataBase.updateChildren(updates);
                    updateSecondDataBase.updateChildren(updates);

                }



            }
        });




    }
}

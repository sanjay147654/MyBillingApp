package com.example.raji.mybillingapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterActivity adapter;

    List<Items> itemsList;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("My Orders");

        itemsList = new ArrayList<Items>();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("orders");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                itemsList.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                    String orderTime = snapshot.child("OrderTime").getValue(String.class);
                    String orderRef = snapshot.child("OrderNo").getValue(String.class);
                    String orderProf = snapshot.child("OrderProfession").getValue(String.class);
                    String orderStatus = snapshot.child("OrderStatus").getValue(String.class);
                    String orderRate = snapshot.child("OrderRate").getValue(String.class);
                    String orderAddress = snapshot.child("OrderAddress").getValue(String.class);
                    String jobAssignment = snapshot.child("JobAssignment").getValue(String.class);
                    String orderTax = snapshot.child("OrderTax").getValue(String.class);
                    String orderDiscount = snapshot.child("OrderDiscount").getValue(String.class);
                    String orderGrandTotal = snapshot.child("OrderGrandTotal").getValue(String.class);
                    String orderServices = snapshot.child("OrderServices").getValue(String.class);
                    String orderPaymentStatus = snapshot.child("OrderPaymentStatus").getValue(String.class);
                    String orderPlace = snapshot.child("OrderPlace").getValue(String.class);
                    String orderStartTime = snapshot.child("OrderStartTime").getValue(String.class);
                    String orderEndTime = snapshot.child("OrderEndTime").getValue(String.class);
                    String orderTotalTime = snapshot.child("OrderTotalTime").getValue(String.class);
                    String changeBooking = snapshot.child("ChangeBooking").getValue(String.class);


                    Items newItem = new Items(orderTime, orderRef, orderProf, orderStatus, orderRate, orderAddress,jobAssignment, orderTax, orderDiscount, orderGrandTotal, orderServices, orderPaymentStatus, orderPlace, orderStartTime, orderEndTime, orderTotalTime,changeBooking );

                    itemsList.add(newItem);
                    adapter.notifyDataSetChanged();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(MainActivity.this, "Could not load data from firebase", Toast.LENGTH_SHORT).show();


            }
        });



        adapter = new AdapterActivity(MainActivity.this,itemsList);
        recyclerView.setAdapter(adapter);


    }


}

package com.example.user.laundress2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;

public class ClientMyLaundry extends Fragment {
    String clientName;
    int clientId;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    Button laundrydetails, findlsp;
    @Nullable
    @Override

    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.client_mylaundry, container, false);
        laundrydetails = rootView.findViewById(R.id.laundrydetails);
        laundrydetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ClientLaundryDetails.class);
                intent.putExtra("client_name", getClientName());
                intent.putExtra("client_id", getClientId());
                startActivity(intent);
            }
        });
        findlsp = rootView.findViewById(R.id.findlsp);
        findlsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FindLaundryServiceProv.class);
                intent.putExtra("client_name", getClientName());
                intent.putExtra("client_id", getClientId());
                startActivity(intent);
            }
        });
        return rootView;
    }

}

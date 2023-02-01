package com.example.midtermexam_danialsasanpour;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import Model.User;
public class TransportActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewUsername;
    Button btnReturn, btnShow;
    RadioGroup rgCommonTransport, rgPrivateTransport;
    String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        Initialize();
    }

    private void Initialize() {
        Username = getIntent().getStringExtra("username");

        textViewUsername = findViewById(R.id.textViewLoggedUsername);
        textViewUsername.setText(Username);

        btnReturn = findViewById(R.id.buttonReturn);
        btnReturn.setOnClickListener(this);

        btnShow = findViewById(R.id.buttonShow);
        btnShow.setOnClickListener(this);

        rgCommonTransport = findViewById(R.id.radioGroupCommonTransport);
        rgPrivateTransport = findViewById(R.id.radioGroupPrivateTransport);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.buttonShow: {
                Show();
                break;
            }
            case R.id.buttonReturn: {
                ReturnToMainPage();
                break;
            }
        }
    }

    private void Show() {
        int idCommonTransport = rgCommonTransport.getCheckedRadioButtonId();
        int idPrivateTransport = rgPrivateTransport.getCheckedRadioButtonId();

        if (idCommonTransport == -1) {
            Toast.makeText(this, "You need to select 1 common transport!", Toast.LENGTH_LONG).show();
        } else if (idPrivateTransport == -1) {
            Toast.makeText(this, "You need to select 1 private transport!", Toast.LENGTH_LONG).show();
        } else {
            String Bus = null;
            String Metro = null;
            String Car = null;
            String Bike = null;

            switch (idCommonTransport) {
                case R.id.radioButtonBus: {
                    Bus = "Yes";
                    Metro = "No";
                    break;
                }
                case R.id.radioButtonMetro: {
                    Bus = "No";
                    Metro = "Yes";
                    break;
                }
            }

            switch (idPrivateTransport) {
                case R.id.radioButtonCar: {
                    Car = "Yes";
                    Bike = "No";
                    break;
                }
                case R.id.radioButtonBike: {
                    Car = "No";
                    Bike = "Yes";
                    break;
                }
            }
            User user = new User(Username, Bus, Metro, Car, Bike);
            Toast.makeText(this, user.toString(), Toast.LENGTH_LONG).show();
        }

    }

    private void ReturnToMainPage() {
        finish();
    }
}

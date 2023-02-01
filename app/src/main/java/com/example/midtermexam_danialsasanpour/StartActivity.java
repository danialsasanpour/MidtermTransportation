package com.example.midtermexam_danialsasanpour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edUsername, edPassword;
    Button btnValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Initialize();
    }

    private void Initialize() {
        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPass);
        btnValidate = findViewById(R.id.tvValidate);
        btnValidate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();
        switch (id){
            case R.id.tvValidate: {
                if (checkLogin(username, password)) {
                    Intent intent = new Intent(this, TransportActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Incorrect username/password", Toast.LENGTH_LONG).show();
                    edUsername.setText("");
                    edPassword.setText("");
                    edUsername.findFocus();
                }
                break;
            }
        }
    }

    public Boolean checkLogin(String username, String password){
        if(username.equals("Admin") && password.equals("padmin")){
            return true;
        }
        return false;
    }
}
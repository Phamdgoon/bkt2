package dgoon.mobile.thuocmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private EditText name, email, pass;
    Button btnSignup;
    User newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        btnSignup = (Button) findViewById(R.id.SignUpButton);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().equals("") || email.getText().toString().equals("") || pass.getText().toString().equals("")) {
                    Toast.makeText(SignUpActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    newUser =new User(name.getText().toString(), email.getText().toString(), pass.getText().toString());
                    Intent intent = new Intent(SignUpActivity.this, loginActivity.class);
                    intent.putExtra("email", newUser.getEmail());
                    intent.putExtra("password", newUser.getPass());
                    startActivity(intent);
                }
            }
        });
    }
}
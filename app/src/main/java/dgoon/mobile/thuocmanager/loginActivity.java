package dgoon.mobile.thuocmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    private EditText email, pass;
    Button btnLogin;
    TextView txtSignUp;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.loginButton);
        cbRemember = (CheckBox) findViewById(R.id.cbRemember);
        txtSignUp = (TextView) findViewById(R.id.signupText);

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        email.setText(sharedPreferences.getString("taikhoan", ""));
        pass.setText(sharedPreferences.getString("matkhau", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));

        String passemail = getIntent().getStringExtra("email");
        String passPword = getIntent().getStringExtra("password");


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernames = email.getText().toString().trim();
                String password = pass.getText().toString().trim();

                if(email.getText().toString().equals("") || pass.getText().toString().equals("")) {
                    Toast.makeText(loginActivity.this, "Vui lòng nhập thông tin!", Toast.LENGTH_SHORT).show();
                } else if((email.getText().toString().equals("admin") && pass.getText().toString().equals("admin"))
                        || (email.getText().toString().equals(passemail) && pass.getText().toString().equals(passPword)))         {
                    Intent intent = new Intent(loginActivity.this, MainActivity.class);
                    Toast.makeText(loginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    if(cbRemember.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan", usernames);
                        editor.putString("matkhau", password);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                } else {
                    Toast.makeText(loginActivity.this, "Tài khoản hoặc mật khẩu chưa chính xác!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
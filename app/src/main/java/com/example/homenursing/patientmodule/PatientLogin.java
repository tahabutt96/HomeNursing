package com.example.homenursing.patientmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.homenursing.dashboardmodule.nurse_dashboard;
import com.example.homenursing.dashboardmodule.patient_dashboard;
import com.example.homenursing.R;
import com.example.homenursing.nursemodule.NurseLogin;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PatientLogin extends AppCompatActivity {

    Button forgotpasspatient, callsignup, login;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout username, password;

    String GEtname,GEtpasword;
    ProgressDialog progress;
    Integer id=0;
    private static String URL_LOGIN = "https://192.168.0.151/home-nursnig-mobileapp/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_patient_login);

        callsignup = findViewById(R.id.Signup_screen_nurse);
        image = findViewById(R.id.Logo_image);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = (Button)findViewById(R.id.loginpatient);

        forgotpasspatient =(Button)findViewById(R.id.forgotpasswordpatient);
        forgotpasspatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientLogin.this, Forgotpasswordpatient.class);
                startActivity(intent);
                finish();
            }
        });

        callsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientLogin.this, PatientSignUp.class);
                startActivity(intent);
                finish();
            }

        });

        progress = new ProgressDialog(PatientLogin.this);
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateUsername();
                validatePassword();
                GEtname = username.getEditText().toString().trim();
                GEtpasword = password.getEditText().toString().trim();
                if(!validateUsername()||!validatePassword())
                {
                    return;
                }
                else {
                    progress.show();
                    UserLogin();
                }

            }
        });
    }
    private boolean validateUsername() {
        String usernameInput = username.getEditText().toString().trim();

        if (usernameInput.isEmpty()) {
            username.setError("Field can't be empty");
            return false;

        } else {
            username.setError(null);
            return true;
        }
    }
    private boolean validatePassword() {
        String passwordInput = password.getEditText().toString().trim();

        if (passwordInput.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }

    public void UserLogin()
    {

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        try {
                            JSONObject obj = new JSONObject(ServerResponse);
                            JSONObject user = obj.getJSONObject("user");
                            Integer ids = user.getInt("id");
                            //getting user id
                            SharedPreferences sharedPreferences=getSharedPreferences("userId",MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            //Toast.makeText(login.this,id,Toast.LENGTH_SHORT);

                            editor.putInt("id",ids);
                            editor.putString("logged","yes");
                            editor.apply();
                            editor.commit();

                            Toast.makeText(PatientLogin.this, ids.toString(), Toast.LENGTH_LONG).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        // Matching server responce message to our text.
                        if(ServerResponse.toString().contains("Login successfull")) {

                            // If response matched then show the toast.
                            Toast.makeText(PatientLogin.this, "Logged In Successfully", Toast.LENGTH_LONG).show();
                            // Finish the current Login activity.
//
                            Intent intent = new Intent(PatientLogin.this, patient_dashboard.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            // Showing Echo Response Message Coming From Server.
                            //Toast.makeText(Login.this, ServerResponse, Toast.LENGTH_LONG).show();
                            progress.dismiss();
                            Toast.makeText(PatientLogin.this, "Invalid username or password", Toast.LENGTH_LONG).show();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {


                        // Showing error message if something goes wrong.
                        Toast.makeText(PatientLogin.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();


                params.put("username", GEtname);
                params.put("password", GEtpasword);

                return params;
            }

        };
        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(PatientLogin.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);
    }
}

package com.example.homenursing.nursemodule;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.homenursing.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Forgetpasswordnurse extends AppCompatActivity {

    Button Suuuubmit;
    EditText uuuemail;
    String Getemail;
    ProgressDialog progress;


    private static String URL = "https://29e15b602a41.ngrok.io/home-nursing-mobileapp/forgetpassnurse.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpasswordnurse);

//        fp = findViewById(R.id.recoverpassnurse);
//        fp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Forgetpasswordnurse.this, NurseLogin.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//    }
//}

        Suuuubmit = (Button) findViewById(R.id.recoverpassnurse);
        uuuemail = (EditText) findViewById(R.id.forgetpasswordnurse);
        progress = new ProgressDialog(Forgetpasswordnurse.this);
        progress.setMessage("Wait while processing...");
        progress.setCancelable(false);

        Suuuubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailInput = uuuemail.getText().toString().trim();
                if (emailInput.isEmpty()) {
                    uuuemail.setError("Field can't be empty");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                    uuuemail.setError("Please enter a valid email address");
                } else {
                    Getemail=uuuemail.getText().toString();
                    progress.show();
                    Forgot_Password();
                    new Timer().schedule(
                            new TimerTask() {

                                @Override
                                public void run() {
                                    //if you need some code to run when the delay expires
                                    Intent intent = new Intent(Forgetpasswordnurse.this, NurseLogin.class);
                                    startActivity(intent);
                                }

                            }, 2000);
                }
            }
        });
    }
    //    }
//    private boolean validateEmail()
//    {
//        String emailInput = uuuemail.getText().toString().trim();
//        if(emailInput.isEmpty())
//        {
//            uuuemail.setError("Field can't be empty");
//            return false;
//        }
//        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
//        {
//            uuuemail.setError("Please enter a valid email address");
//            return false;
//        } else
//        {
//            uuuemail.setError(null);
//            return true;
//        }
//    }
    public void Forgot_Password() {

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {
                        Getemail=uuuemail.getText().toString();
                        // id = user.getInt("id");
                        //getting user id
                        SharedPreferences sharedPreferences=getSharedPreferences("useremail",MODE_PRIVATE);
                        SharedPreferences.Editor preferenceEditor=sharedPreferences.edit();
                        preferenceEditor.putString("email",Getemail);
                        preferenceEditor.apply();

                        // Matching server responce message to our text.
                        if (ServerResponse.toString().contains("Password containing mail sent.")) {
                            // If response matched then show the toast.
                            Toast.makeText(Forgetpasswordnurse.this, "Mail Sent", Toast.LENGTH_LONG).show();
                        } else {
                            // Showing Echo Response Message Coming From Server.
                            Toast.makeText(Forgetpasswordnurse.this, ServerResponse, Toast.LENGTH_LONG).show();

                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {


                        // Showing error message if something goes wrong.
                        Toast.makeText(Forgetpasswordnurse.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The firs argument should be same sa your MySQL database table columns.
                params.put("email", Getemail);
                //params.put("", "jaani");

                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(Forgetpasswordnurse.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);
    }
}
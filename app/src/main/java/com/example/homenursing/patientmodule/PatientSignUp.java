package com.example.homenursing.patientmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.homenursing.R;
import com.example.homenursing.nursemodule.NurseLogin;
import com.example.homenursing.nursemodule.NurseSignUp;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class PatientSignUp extends AppCompatActivity {
    String gender;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile( "^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    // "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 8 characters
                    "$");
    private RadioGroup genderRadioGroup;
    EditText username,email,password,confirmpassword;
    RadioButton male,female,other;
    ProgressDialog progress;
    private static String URL = "https://99584dc7032a.ngrok.io/home-nursing-mobileapp/patientregister.php";
    Button loginpatient, signuppatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_patient_sign_up);

        username=(EditText)findViewById(R.id.patient_name);
        email=(EditText)findViewById(R.id.patient_email);
        password=(EditText)findViewById(R.id.patient_password);
        confirmpassword=(EditText)findViewById(R.id.patient_cpassword);
        male=(RadioButton)findViewById(R.id.patient_rmale);
        female=(RadioButton)findViewById(R.id.patient_rfemale);
        other=(RadioButton)findViewById(R.id.patient_rother);
        genderRadioGroup=findViewById(R.id.patient_gender_radiogroup);

        loginpatient = findViewById(R.id.patient_login_again);
        loginpatient.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientSignUp.this, PatientLogin.class);
                startActivity(intent);
                finish();
            }
        });

        progress = new ProgressDialog(PatientSignUp.this);
        progress.setMessage("Wait while processing...");
        progress.setCancelable(false);


        signuppatient = findViewById(R.id.signuppatient);
        signuppatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateEmail();
                validateUsername();
                validatePassword();
                if (!validateEmail() | !validateUsername() | !validatePassword()) {
                    return;
                }
                if(genderRadioGroup.getCheckedRadioButtonId()==-1){//No Radio Button Is Checked
                    Toast.makeText(getApplicationContext(), "Please Select Gender", Toast.LENGTH_LONG).show();
                }else{//Radio Button Is Checked
                    RadioButton selectedRadioButton = findViewById(genderRadioGroup.getCheckedRadioButtonId());
                    gender = selectedRadioButton == null ? "" : selectedRadioButton.getText().toString().trim();
                }
                //Validate
                if (validateInputs()) {
//                    Toast.makeText(Signup.this,"Register Successfull",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(Signup.this, Login.class);
//                    startActivity(intent);//Signup.setVisibility(View.VISIBLE);
//                    progressBar.setVisibility(View.VISIBLE);
//                    finish();
                    progress.show();
                    Regist();//code to proceed when Radio button is checked
                }

            }
        });
    }
    private boolean validateEmail()
    {
        String emailInput = email.getText().toString().trim();
        if(emailInput.isEmpty())
        {
            email.setError("Field can't be empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {
            email.setError("Please enter a valid email address");
            return false;
        } else
        {
            email.setError(null);
            return true;
        }
    }
    private boolean validateUsername() {
        String usernameInput = username.getText().toString().trim();

        if (usernameInput.isEmpty()) {
            username.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            username.setError("Username too long");
            return false;
        } else {
            username.setError(null);
            return true;
        }
    }
    private boolean validateInputs() {
        if (genderRadioGroup.getCheckedRadioButtonId()==-1) {
            return false;
        }
        return true;
    }
    private boolean validatePassword() {
        String passwordInput = password.getText().toString().trim();
        String getcp = confirmpassword.getText().toString();
        if (passwordInput.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if (getcp.isEmpty()){
            confirmpassword.setError("Field can't be empty");
            return false;
        }else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            password.setError("Password must have 8 characters(letters and numbers)");
            return false;
        }else if (!passwordInput.equals(getcp))
        {
            confirmpassword.setError("Password doesn't match");
            return false;
        }
        else {
            password.setError(null);
            return true;
        }
    }
    private void Regist()
    {  //getting user inputs
        final String name = this.username.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String password = this.password.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject  = new JSONObject(response);
                            //String success=jsonObject.getString("success");
                            if( response.toString().contains("Information Added.")){
                                Toast.makeText(PatientSignUp.this,"Register Successfull",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(PatientSignUp.this, PatientLogin.class);
                                startActivity(intent);//Signup.setVisibility(View.VISIBLE);
                                finish();
                            }


                        }
                        catch  (JSONException e)
                        {
                            e.printStackTrace();
                            progress.dismiss();
                            Toast.makeText(PatientSignUp.this,"Register UnSuccessfull",Toast.LENGTH_SHORT).show();
                            //here is a bhnd application bagair signup kare bhi khul rahi hai jabky aisa nahi hona chahaie

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(PatientSignUp.this,"Volley Error"+ error.toString(),Toast.LENGTH_SHORT).show();
                //btnsignup.setVisibility(View.VISIBLE);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                //post paramters
                params.put("username",name);
                params.put("email",email);
                params.put("password",password);
                params.put("gender",gender);

                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this  );
        requestQueue.add(stringRequest);
    }
}

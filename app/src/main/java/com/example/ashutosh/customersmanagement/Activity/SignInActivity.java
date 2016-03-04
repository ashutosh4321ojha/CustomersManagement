package com.example.ashutosh.customersmanagement.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ashutosh.customersmanagement.R;
import com.example.ashutosh.customersmanagement.model.model.shopkeeper.ObjectOfShopkeeperDetails;
import com.example.ashutosh.customersmanagement.retrofit.RestClient;
import com.example.ashutosh.customersmanagement.utils.CommonAlert;
import com.example.ashutosh.customersmanagement.utils.CommonAlertDialog;
import com.example.ashutosh.customersmanagement.utils.CommonData;
import com.example.ashutosh.customersmanagement.utils.CommonProgressDialog;
import com.example.ashutosh.customersmanagement.utils.ErrorHandlerClass;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ashutosh on 2/11/2016.
 * ta@GMAIL.COM  === EMAIL
 8989===PASSWORD
 */
public class SignInActivity extends AppCompatActivity {
    EditText etShopkeeperEmail,etShopkeeperPassword;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        etShopkeeperEmail=(EditText)findViewById(R.id.email_edit_text);
        etShopkeeperPassword=(EditText)findViewById(R.id.password_edit_text);
        btnSignIn=(Button)findViewById(R.id.btn_sign_in);

    }

    public void onClickSignIn(View view){

//check the validation of the email here
        if(isValid())
            getDataFromServer();//if vali fetch data from the server


}

    private boolean isValid() {

        if(TextUtils.isEmpty(etShopkeeperEmail.getText().toString()) &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(etShopkeeperEmail.getText().toString()).matches()){

            CommonAlert.showAlert(SignInActivity.this, "enter correct eamil");
            return false;
        }

        if ((etShopkeeperPassword.getText().toString().length() >5&&etShopkeeperPassword.getText().toString().equals("")))
        {
            CommonAlert.showAlert(SignInActivity.this, "enter correct password");
            return false;
        }
        return true;

    }

    private void getDataFromServer() {
        CommonProgressDialog.showProgressDialog(SignInActivity.this,"you are about to signed in...");

        RestClient.getApiService().signIn(etShopkeeperEmail.getText().toString(), etShopkeeperPassword.getText().toString(),
                new Callback<ObjectOfShopkeeperDetails>() {

                    @Override
                    public void success(ObjectOfShopkeeperDetails objectOfShopkeeperDetails, Response response) {
                        CommonData.saveAppUser(getApplicationContext(), objectOfShopkeeperDetails);
                        CommonProgressDialog.dismissProgressDialog();


                        CommonAlert.showAlert(SignInActivity.this, "Click Ok To See List Of Customer",
                                new CommonAlert.OnAlertOkClickListener() {
                            @Override
                            public void onOkButtonClicked() {
                                Intent intent = new Intent(getApplicationContext(), CustomerListActivity.class);
                                startActivity(intent);
                            }
                        });

                       // Intent intent = new Intent(SignInActivity.this, CustomerListActivity.class);
                       // startActivity(intent);
                        //finish();

                    }




                    @Override
                    public void failure(RetrofitError error) {

                        CommonProgressDialog.dismissProgressDialog();
                        ErrorHandlerClass.checkCode(SignInActivity.this,error,true);

                        //CommonAlertDialog.setDialog(SignInActivity.this, "Failed");



                    }
                });
    }


    public void onClickNoAccount(View view) {
        Intent intent=new Intent(SignInActivity.this,SignUpActivity.class);
        startActivity(intent);
    }
}

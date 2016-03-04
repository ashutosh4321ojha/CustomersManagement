package com.example.ashutosh.customersmanagement.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.ashutosh.customersmanagement.Activity.SignInActivity;
import com.example.ashutosh.customersmanagement.model.model.shopkeeper.ObjectOfShopkeeperDetails;

/**
 * Created by ashutosh on 2/16/2016.
 */
public  class CommonAlertDialog {
   private static AlertDialog.Builder myAlertDialog=null;


    public static void setDialog(Context context,String message){
        if(myAlertDialog==null)
         myAlertDialog=new AlertDialog.Builder(context);

        myAlertDialog.setTitle("--- Title ---");
        myAlertDialog.setMessage(message);
        myAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {

            }
        });

        myAlertDialog.show();

    }


}

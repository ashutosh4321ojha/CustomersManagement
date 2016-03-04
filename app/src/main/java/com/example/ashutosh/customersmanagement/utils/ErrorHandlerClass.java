package com.example.ashutosh.customersmanagement.utils;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.example.ashutosh.customersmanagement.R;

import org.json.JSONObject;

import retrofit.RetrofitError;
import retrofit.mime.TypedByteArray;

/**
 * Created by ashutosh on 2/17/2016.
 */
public class ErrorHandlerClass {

    private static String errorMessage = "";

    /**
     * @param context
     * @param error
     */
    public static void checkCode(final Activity context, RetrofitError error, Boolean doCheckSession) {
        try {
            errorMessage = "";
            Log.v("error bundle", error.toString() + "");

            if (doCheckSession) {
                try {
                    if (error.getResponse().getStatus() == 401) {
                        CommonAlertDialog.setDialog(context, "Session Expired");


                        return;
                    }
                } catch (Exception e) {
                    Log.v("error Exception", e.toString() + "");
                }
            }


            switch (error.getKind()) {
                case NETWORK:
                    errorMessage = "Failed to connect. Please check your internet connection.";

                    break;
                case CONVERSION:
                    errorMessage = "An error was procured while parsing.";
                    break;
                case HTTP: {
                    errorMessage = "Application server could not respond. Please try later.";

                    try {
                        String str = new String(((TypedByteArray) error.getResponse().getBody()).getBytes());
                        JSONObject json = new JSONObject(str);
                        errorMessage = json.getString("message");

                    } catch (Exception e) {
                        errorMessage = "Something went wrong. Please try later.";
                    }
                }
                break;

                case UNEXPECTED:
                    errorMessage = "An unexpected error occurred. Please try later.";
                    break;
            }

            if (!errorMessage.isEmpty())
                CommonAlertDialog.setDialog(context, errorMessage);


        } catch (Exception e) {
            CommonAlertDialog.setDialog(context,"Something went wrong. Please try later");

        }
    }
/*
    private static void AppExit(Activity context) {
        CommonData.ClearData(context);
        Intent i = new Intent(context, LoginSignupActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
        context.finish();
        context.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }
    */
}

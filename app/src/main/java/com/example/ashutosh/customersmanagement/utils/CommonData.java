package com.example.ashutosh.customersmanagement.utils;

import android.content.Context;

import com.example.ashutosh.customersmanagement.model.model.Customer.ObjectCustomerDetails;
import com.example.ashutosh.customersmanagement.model.model.shopkeeper.ObjectOfShopkeeperDetails;
import com.example.ashutosh.customersmanagement.sharedpreferences.Prefs;
import com.example.ashutosh.customersmanagement.sharedpreferences.SharedPreferencesName;


public class CommonData {

    private static ObjectOfShopkeeperDetails AppUser = null;
    private static ObjectCustomerDetails Customer = null;


    public static ObjectOfShopkeeperDetails getAppUser(Context context) {
        if (AppUser == null) {
            AppUser = Prefs.with(context).getObject(SharedPreferencesName.APP_USER, ObjectOfShopkeeperDetails.class);
        }


        return AppUser;

    }

    public static ObjectCustomerDetails getCustomer(Context context) {
        if (Customer == null) {
            Customer = Prefs.with(context).getObject(SharedPreferencesName.APP_USER, ObjectCustomerDetails.class);
        }

        return Customer;

    }



    public static void saveAppUser(Context context, ObjectOfShopkeeperDetails appUser) {
        AppUser = appUser;
        Prefs.with(context).save(SharedPreferencesName.APP_USER, appUser);

    }
    public static void saveCustomer(Context context,ObjectCustomerDetails customer) {
       Customer=customer;
         Prefs.with(context).save(SharedPreferencesName.USERS_CUSTOMER, customer);

    }



}

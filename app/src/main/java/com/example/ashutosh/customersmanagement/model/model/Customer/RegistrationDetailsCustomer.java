package com.example.ashutosh.customersmanagement.model.model.Customer;

import com.example.ashutosh.customersmanagement.model.model.shopkeeper.ProfilePicURL;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ashutosh on 2/12/2016.
 */
public class RegistrationDetailsCustomer implements Serializable{

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phoneNo")
    @Expose
    private String phoneNo;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("profilePicURL")
    @Expose
    private ProfilePicURL profilePicURL;
    @SerializedName("IsDeleted")
    @Expose
    private Boolean IsDeleted;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("__v")
    @Expose
    private Integer V;

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     *
     * @param phoneNo
     * The phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The profilePicURL
     */
    public ProfilePicURL getProfilePicURL() {
        return profilePicURL;
    }

    /**
     *
     * @param profilePicURL
     * The profilePicURL
     */
    public void setProfilePicURL(ProfilePicURL profilePicURL) {
        this.profilePicURL = profilePicURL;
    }

    /**
     *
     * @return
     * The IsDeleted
     */
    public Boolean getIsDeleted() {
        return IsDeleted;
    }

    /**
     *
     * @param IsDeleted
     * The IsDeleted
     */
    public void setIsDeleted(Boolean IsDeleted) {
        this.IsDeleted = IsDeleted;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The V
     */
    public Integer getV() {
        return V;
    }

    /**
     *
     * @param V
     * The __v
     */
    public void setV(Integer V) {
        this.V = V;
    }
}

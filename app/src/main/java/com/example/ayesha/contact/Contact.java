package com.example.ayesha.contact;

/**
 * Created by Ayesha on 2014-11-15.
 */
public class Contact {

    private String _name, _phone, _email, _address;

    public Contact (String name, String phone, String email, String address) {
        _name = name;
        _phone = phone;
        _email = email;
        _address = address;
    }

    public String getName() {
        return _name;
    }
    public void setName(String _name) {
        this._name = _name;
    }
    public String getAddress() {
        return _address;
    }
    public void setAddress(String _address) {
        this._address = _address;
    }
    public String getEmail() {
        return _email;
    }
    public void setEmail(String _email) {
        this._email = _email;
    }
    public String getPhone() {
        return _phone;
    }
    public void setPhone(String _phone) {
        this._phone = _phone;
    }
}


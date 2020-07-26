package vn.edu.ntu.vancuong.ontap_bai2.controller;

import java.util.List;

import vn.edu.ntu.vancuong.ontap_bai2.model.Contact;

public interface IContactController {
    public List<Contact> getAllContact();
    public void addContact(Contact contact);
    public int layid();
}

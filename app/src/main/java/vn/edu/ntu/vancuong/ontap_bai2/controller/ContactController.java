package vn.edu.ntu.vancuong.ontap_bai2.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.vancuong.ontap_bai2.model.Contact;

public class ContactController extends Application implements IContactController {
    List<Contact> list = new ArrayList<>();

    public ContactController(){
        list.add(new Contact(1,"phạm văn cường","10/05/1999","0898391944","ninh hòa"));
        list.add(new Contact(2,"phạm văn cường","10/05/1999","0898391944","ninh hòa"));
        list.add(new Contact(3,"phạm văn cường","10/05/1999","0898391944","ninh hòa"));
    }

    @Override
    public List<Contact> getAllContact() {
        return list;
    }

    @Override
    public void addContact(Contact contact) {
        list.add(contact);
    }

    @Override
    public int layid() {
        return list.get(list.size()-1).getId() + 1;
    }


}

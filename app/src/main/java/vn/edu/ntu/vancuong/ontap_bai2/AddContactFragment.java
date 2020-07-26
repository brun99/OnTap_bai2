package vn.edu.ntu.vancuong.ontap_bai2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.edu.ntu.vancuong.ontap_bai2.controller.IContactController;
import vn.edu.ntu.vancuong.ontap_bai2.model.Contact;


public class AddContactFragment extends Fragment {
    EditText edtID, edtName, edtBrith, edtPhoneNumber, edtAddress;
    Button btnAdd;

    IContactController controller;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_contact, container, false);
        addView(view);
        addEvent();
        return view;
    }

    private void addEvent() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact contact = new Contact();
                contact.setId(controller.layid());
                contact.setName(edtName.getText().toString());
                contact.setBrith(edtBrith.getText().toString());
                contact.setPhoneNumber(edtPhoneNumber.getText().toString());
                contact.setAddress(edtAddress.getText().toString());
                controller.addContact(contact);
                Toast.makeText(getActivity(),"đã thêm",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void addView(View view) {
        edtID = view.findViewById(R.id.edtID);
        edtName = view.findViewById(R.id.editName);
        edtBrith = view.findViewById(R.id.edtBrith);
        edtPhoneNumber = view.findViewById(R.id.edtPhone);
        edtAddress = view.findViewById(R.id.edtAddress);
        btnAdd = view.findViewById(R.id.btnAdd);

        controller = (IContactController) ((MainActivity)getActivity()).getApplication();
        navController = NavHostFragment.findNavController(AddContactFragment.this);

//        ((MainActivity)getActivity()).navController = navController;
//        ((MainActivity)getActivity()).toolbar.setSubtitle("Detail of friend");
//        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtID.setText(Integer.toString(controller.layid()));

    }
}
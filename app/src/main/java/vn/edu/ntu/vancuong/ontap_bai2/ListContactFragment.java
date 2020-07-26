package vn.edu.ntu.vancuong.ontap_bai2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.vancuong.ontap_bai2.controller.IContactController;
import vn.edu.ntu.vancuong.ontap_bai2.model.Contact;


public class ListContactFragment extends Fragment {
    List<Contact> listContact = new ArrayList<>();
    IContactController controller;
    ContactAdapter adapter;
    RecyclerView rvListContact;
    NavController navController;


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.my_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_list_contact, container, false);
        addView(view);
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.ItemAdd){
            navController.navigate(R.id.action_listContactFragment2_to_addContactFragment2);
        }
        return super.onOptionsItemSelected(item);
    }

    private void addView(View view) {
        rvListContact =view.findViewById(R.id.rvListContact);
        controller = (IContactController) ((MainActivity)getActivity()).getApplication();
        listContact = controller.getAllContact();
        adapter = new ContactAdapter(listContact);
        rvListContact.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvListContact.setAdapter(adapter);

        navController = NavHostFragment.findNavController(ListContactFragment.this);
//        ((MainActivity)getActivity()).navController = navController;
//        ((MainActivity)getActivity()).toolbar.setSubtitle("list of all friend");


    }

    public  class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtBrith, txtPhoneNumber;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtBrith = itemView.findViewById(R.id.txtBrith);
            txtPhoneNumber = itemView.findViewById(R.id.txtPhone);
        }

        public void bind(Contact contact){
            txtName.setText(contact.getName());
            txtBrith.setText(contact.getBrith());
            txtPhoneNumber.setText(contact.getPhoneNumber());
        }
    }

    public  class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder>{
        List<Contact> list = new ArrayList<>();

        public ContactAdapter(List<Contact> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater =getLayoutInflater();
            View view = inflater.inflate(R.layout.contact,parent,false);
            return new ContactViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
            holder.bind(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}
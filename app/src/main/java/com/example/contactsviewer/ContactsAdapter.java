package com.example.contactsviewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    private List<Contact> contactsList;

    public ContactsAdapter(List<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact currentContact = contactsList.get(position);
        holder.nameTextView.setText(currentContact.name);
        holder.numberTextView.setText(currentContact.phoneNumber);
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView numberTextView;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.contactName);
            numberTextView = itemView.findViewById(R.id.contactNumber);
        }
    }
}
package com.example.leoparhaposapakpahan.testvertilogic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by leoparhaposapakpahan on 06/09/2018.
 */

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {

    private Context context;
    private List<Data> list;

    public ShowAdapter(Context context, List<Data> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.data_item, parent, false);
//        return new ViewHolder(v);

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_item, parent, false);

        return new ViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Data movie = list.get(position);

        holder.textTitle.setText(movie.getId());
        holder.textRating.setText(String.valueOf(movie.getName()));
        holder.textYear.setText(String.valueOf(movie.getUsername()));
        holder.textEmail.setText(movie.getEmail());
        //nodeAddress
//        holder.textAddress.setText(String.valueOf(movie.getAddress()));
        holder.textStreet.setText(String.valueOf(movie.getStreet()));
        holder.textSuite.setText(String.valueOf(movie.getSuite()));
        holder.textCity.setText(String.valueOf(movie.getCity()));
        holder.textZipCode.setText(String.valueOf(movie.getZipcode()));
//        holder.textGeo.setText(String.valueOf(movie.getGeo()));
        holder.textLat.setText(String.valueOf(movie.getLat()));
        holder.textLng.setText(String.valueOf(movie.getLng()));
        holder.textPhone.setText(String.valueOf(movie.getPhone()));
        holder.textWebsite.setText(movie.getWebsite());
//        holder.textCompany.setText(String.valueOf(movie.getCompany()));

        holder.textCompany_name.setText(String.valueOf(movie.getCompany_name()));
        holder.textcatchPhrase.setText(String.valueOf(movie.getCatchPhrase()));
        holder.textBs.setText(movie.getBs());


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked data " + movie.getId(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(holder.itemView.getContext(), DetailData.class);
                Bundle b = new Bundle();

                //get text for current item
                String Id = movie.getId();
                String Name = movie.getName();
                String Username = movie.getUsername();
                String Email = movie.getEmail();
                String Street = movie.getStreet();
                String Suite = movie.getSuite();
                String City = movie.getCity();
                String ZipCode = movie.getZipcode();
                String Lat = movie.getLat();
                String Lng = movie.getLng();
                String Phone = movie.getPhone();
                String Website = movie.getWebsite();
                String Name_Company = movie.getCompany_name();
                String CatchPhrase = movie.getCatchPhrase();
                String BS = movie.getBs();



                //put text into a bundle and add to intent
                intent.putExtra("Id", Id);
                intent.putExtra("Name", Name);
                intent.putExtra("Username", Username);
                intent.putExtra("Email", Email);
                intent.putExtra("Street", Street);
                intent.putExtra("Suite", Suite);
                intent.putExtra("City", City);
                intent.putExtra("ZipCode", ZipCode);
                intent.putExtra("Lat", Lat);
                intent.putExtra("Lng", Lng);
                intent.putExtra("Phone", Phone);
                intent.putExtra("Website", Website);
                intent.putExtra("NameC", Name_Company);
                intent.putExtra("CatchP", CatchPhrase);
                intent.putExtra("Bs", BS);


                //get position to carry integer
                intent.putExtra("position", position);

                intent.putExtras(b);

                //begin activity
                holder.itemView.getContext().startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle, textRating, textYear, textEmail, textAddress, textPhone, textWebsite, textCompany, textStreet, textSuite, textCity, textZipCode, textGeo, textLat, textLng, textCompany_name, textcatchPhrase, textBs;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.main_title);
            textRating = itemView.findViewById(R.id.main_rating);
            textYear = itemView.findViewById(R.id.main_year);
            textEmail = itemView.findViewById(R.id.main_email);
            textPhone = itemView.findViewById(R.id.main_phone);
            textWebsite = itemView.findViewById(R.id.main_website);


            //nodeAddress
            textAddress = itemView.findViewById(R.id.main_address);
            textStreet = itemView.findViewById(R.id.main_street);
            textSuite = itemView.findViewById(R.id.main_suite);
            textCity = itemView.findViewById(R.id.main_city);
            textZipCode = itemView.findViewById(R.id.main_zipcode);
            textGeo = itemView.findViewById(R.id.main_geo);
            textLat = itemView.findViewById(R.id.main_lat);
            textLng = itemView.findViewById(R.id.main_lng);

            //nodeCompany
            textCompany = itemView.findViewById(R.id.main_company);
            textCompany_name = itemView.findViewById(R.id.main_company_name);
            textcatchPhrase = itemView.findViewById(R.id.main_catchPhrase);
            textBs = itemView.findViewById(R.id.main_bs);


            linearLayout = itemView.findViewById(R.id.linearData);

        }
    }
}

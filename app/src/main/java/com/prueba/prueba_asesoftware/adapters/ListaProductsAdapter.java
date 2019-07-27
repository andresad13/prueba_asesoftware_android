package com.prueba.prueba_asesoftware.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.prueba.prueba_asesoftware.DetailProduct;
import com.prueba.prueba_asesoftware.R;
import com.prueba.prueba_asesoftware.entities.Products;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListaProductsAdapter extends RecyclerView.Adapter<ListaProductsAdapter.ProductsViewHolder> {

   private  ArrayList<Products> listaProducto;
    public ListaProductsAdapter(ArrayList<Products> listaProducto) {
        this.listaProducto = listaProducto;
    }
    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_products,null,false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductsViewHolder holder, final int position) {
        holder.producto.setText(listaProducto.get(position).getProducto().toString());
        holder.descripcion.setText(listaProducto.get(position).getDescripcion());
        holder.precio.setText(listaProducto.get(position).getPrecio());
        Picasso.get().load(listaProducto.get(position).getImg()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(holder.itemView.getContext(), DetailProduct.class);
                i.putExtra("productImg", listaProducto.get(position).getImg().toString());
                i.putExtra("productName", listaProducto.get(position).getProducto().toString());
                i.putExtra("productDesc", listaProducto.get(position).getDescripcion().toString());
                i.putExtra("productPrice", listaProducto.get(position).getPrecio().toString());
                holder.itemView.getContext().startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return listaProducto.size();
    }
    public class ProductsViewHolder extends RecyclerView.ViewHolder {
        TextView producto,descripcion,precio;
        ImageView img;

        public ProductsViewHolder(View itemView) {
            super(itemView);
            producto = (TextView) itemView.findViewById(R.id.textProduct);
            descripcion = (TextView) itemView.findViewById(R.id.textDesc);
            precio = (TextView) itemView.findViewById(R.id.textPrice);
            img = (ImageView) itemView.findViewById(R.id.id_img);
        }
    }
}
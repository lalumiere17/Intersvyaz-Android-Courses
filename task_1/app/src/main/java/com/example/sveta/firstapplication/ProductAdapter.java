package com.example.sveta.firstapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>
{
    private LayoutInflater inflater;
    private List<Product> products;

    ProductAdapter(Context context, List<Product> products)
    {
        this.products = products;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_products, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.nameView.setText(product.getName());
        holder.priceView.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, priceView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView) itemView.findViewById(R.id.productName);
            priceView = (TextView) itemView.findViewById(R.id.productPrice);
        }
    }
}
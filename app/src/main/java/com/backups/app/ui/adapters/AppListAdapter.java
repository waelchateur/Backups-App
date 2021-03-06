package com.backups.app.ui.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.backups.app.R;
import com.backups.app.data.APKFile;

import java.util.List;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {

    private final List<APKFile> mDataSet;

    public AppListAdapter(List<APKFile> dataSet) {
        mDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String appName = mDataSet.get(position).getName();
        String packageName = mDataSet.get(position).getPackageName();
        Drawable appIcon = mDataSet.get(position).getIcon();

        holder.setAppName(appName);
        holder.setPackageName(packageName);
        holder.setAppIcon(appIcon);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mAppName;
        private final TextView mPackageName;
        private final ImageView mAppIcon;

        public ViewHolder(View view) {
            super(view);
            mAppName = view.findViewById(R.id.app_name);
            mPackageName = view.findViewById(R.id.package_name);
            mAppIcon = view.findViewById(R.id.app_icon);
        }

        public void setAppName(String appName) {
            mAppName.setText(appName);
        }

        public void setPackageName(String packageName) {
            mPackageName.setText(packageName);
        }

        public void setAppIcon(Drawable icon) {
            mAppIcon.setImageDrawable(icon);
        }
    }

}

package com.example.techexactlyassingments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.techexactlyassingments.R
import com.example.techexactlyassingments.model.ApplicationsModel

class ApplicationsFragAdapter(
    private var appList: List<ApplicationsModel> = emptyList(),
    private var filteredList: List<ApplicationsModel> = emptyList()
) : RecyclerView.Adapter<ApplicationsFragAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val appName: TextView = itemView.findViewById(R.id.app_name)
        val appStatus: TextView = itemView.findViewById(R.id.app_status)
        val appIcon: ImageView = itemView.findViewById(R.id.app_icon)
        val switchButton: SwitchCompat = itemView.findViewById(R.id.app_status_switch)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_application, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int = filteredList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val application = filteredList[position]
        with(holder) {
            appName.text = application.app_name
            appStatus.text = application.status
            Glide.with(appIcon.context)
                .load(application.app_icon)
                .placeholder(R.drawable.man)
                .into(appIcon)
            switchButton.setOnCheckedChangeListener(null)
            switchButton.isChecked = application.status.equals("Active", ignoreCase = true)


            switchButton.setOnCheckedChangeListener { _, isChecked ->
                application.isSwitchOn = isChecked
                application.status = if (isChecked) "Active" else "Inactive"
                appStatus.text = application.status

            }
        }
    }
                fun updateList(newList: List<ApplicationsModel>) {
        appList = newList
        filteredList = newList
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            appList
        } else {
            appList.filter {
                it.app_name.contains(query, ignoreCase = true) ||
                        it.status.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }
}



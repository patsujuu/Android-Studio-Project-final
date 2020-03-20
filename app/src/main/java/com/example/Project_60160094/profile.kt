package com.example.Project_60160094

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.facebook.login.LoginManager

/**
 * A simple [Fragment] subclass.
 */
class profile : Fragment() {

    var PhotoURL : String = ""
    var Name : String = ""

    fun newInstance(url: String,name : String): profile {

        val profile = profile()
        val bundle = Bundle()
        bundle.putString("PhotoURL", url)
        bundle.putString("Name", name)
        profile.setArguments(bundle)

        return profile
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val ivProfilePicture = view.findViewById(R.id.iv_profile) as ImageView
        val tvName = view.findViewById(R.id.tv_name) as TextView
        val login_button2 = view.findViewById(R.id.login_button2) as Button
        val list_button = view.findViewById(R.id.btn_list) as Button
        val chart_button = view.findViewById(R.id.btn_chart) as Button
        val data_button = view.findViewById(R.id.btn_data) as Button




        Glide.with(activity!!.baseContext)
            .load(PhotoURL)
            .into(ivProfilePicture)

        tvName.setText(Name)

        login_button2.setOnClickListener{

            LoginManager.getInstance().logOut()
            activity!!.supportFragmentManager.popBackStack()
        }

        list_button.setOnClickListener {
            val fragment_RecyclerView = Recycler_view()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout, fragment_RecyclerView,"fragment_RecyclerView ")
            transaction.addToBackStack("fragment_RecyclerView ")
            transaction.commit()
        }

        chart_button.setOnClickListener {
            val MainChart = MainChart()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.contentContainer, MainChart,"fragment_MainChart")
            transaction.addToBackStack("fragment_MainChart")
            transaction.commit()

        }

        data_button.setOnClickListener {
            val DataRealtime = DataRealtime()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()

            transaction.replace(R.id.layout, DataRealtime,"fragment_DataRealtime")
            transaction.addToBackStack("fragment_DataRealtime")
            transaction.commit()
        }

        return view

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            PhotoURL = bundle.getString("PhotoURL").toString()
            Name = bundle.getString("Name").toString()

        }

    }

}


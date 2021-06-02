package com.example.lab6

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.lab6.data.IDataSource
import com.example.lab6.data.di.DiHelper
import com.example.lab6.data.model.JsonData

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    val service: IDataSource = DiHelper.getService()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<Button>(R.id.button_second).setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
        service.getData(object : IDataSource.DataCallback {
            override fun onSuccess(data: JsonData) {
                displayData(data,view)
            }
            override fun onFailure() {
                displayError()
            }
        },"60b7715392af611956fa97d3")
    }

    fun displayData(data: JsonData,view: View) {
        Log.d("API", "${data.getName()}")
        Log.d("API", "${data.getLoad()}")
        Log.d("API", "${data.getSpace()}")
        Log.d("API", "${data.getNetwork()}")
        Log.d("API", "${data.getErrors()}")
        view.findViewById<TextView>(R.id.textViewName).setText("${data.getName()}")
        view.findViewById<TextView>(R.id.textViewLoad).setText("${data.getLoad()}")
        view.findViewById<TextView>(R.id.textViewSpace).setText("${data.getSpace()}")
        view.findViewById<TextView>(R.id.textViewNetwork).setText("${data.getNetwork()}")
        view.findViewById<TextView>(R.id.textViewErrors).setText("${data.getErrors()}")
    }
    fun displayError() {
        Log.d("API", "error loading data")
    }

}
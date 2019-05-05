package com.example.eventbussample.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.eventbussample.Model.SendItemModel
import com.example.eventbussample.R
import org.greenrobot.eventbus.EventBus

class FragmentA : Fragment() {

    lateinit var textField : EditText
    lateinit var button : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_frag_a, container, false)
        initView(view)
        return view
    }

    fun initView(view : View){
        textField = view.findViewById(R.id.editText)
        button = view.findViewById(R.id.button)

        button.setOnClickListener{

            textField?.let {
                if(!textField.text.isNullOrEmpty()){
                    EventBus.getDefault().post(SendItemModel(textField.text.toString()))
                }
            }
        }
    }
}
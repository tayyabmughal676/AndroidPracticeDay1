package com.example.androidpracticeday1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.androidpracticeday1.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var mToggleButton: ToggleButton
    private lateinit var mSwitch: Switch
    private lateinit var mRadioGroup: RadioGroup
    private lateinit var mSelectBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel::class.java)
            ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        mToggleButton = root.findViewById(R.id.toggleButton)
        mSwitch = root.findViewById(R.id.switch1)
        mRadioGroup = root.findViewById(R.id.myRadioGroup)
        mSelectBtn = root.findViewById(R.id.selectRadio)

        mToggleButton.setOnCheckedChangeListener { _: CompoundButton, b: Boolean ->
            if (b) {
                Toast.makeText(root.context, "ON: ${b.toString()}", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(root.context, "OFF: ${b.toString()}", Toast.LENGTH_SHORT).show()
            }
        }

        mSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(root.context, "On", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(root.context, "Off", Toast.LENGTH_SHORT).show()
            }
        }

//        mRadioButtonMale.setOnCheckedChangeListener { buttonView, isChecked ->
//            val n = buttonView.text.toString()
//            if (isChecked) {
//                Toast.makeText(root.context, "Off: ${n}", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(root.context, "On ${n}", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        mRadioButtonFemale.setOnCheckedChangeListener { buttonView, isChecked ->
//            val f = buttonView.text.toString()
//            if (isChecked) {
//                Toast.makeText(root.context, "Off: ${f}", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(root.context, "On ${f}", Toast.LENGTH_SHORT).show()
//            }
//        }

        mRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = root.findViewById(checkedId)
            Toast.makeText(root.context, "Checked: ${radio.text.toString()}", Toast.LENGTH_SHORT)
                .show()
        }
        mSelectBtn.setOnClickListener {
            val id: Int = mRadioGroup.checkedRadioButtonId
            if (id != -1) {
                val radio: RadioButton = root.findViewById(id)
                Toast.makeText(root.context, "Checked Value: ${radio.text}", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(root.context, "Value isn't select...", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }
}
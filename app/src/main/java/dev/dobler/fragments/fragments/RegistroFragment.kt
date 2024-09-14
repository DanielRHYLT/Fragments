package dev.dobler.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import dev.dobler.fragments.R
import java.util.Objects

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_registro, container, false)

        val btnSave: Button = view.findViewById(R.id.btnSave)
        val etFullName: EditText = view.findViewById(R.id.etFullName)
        val etEmail: EditText = view.findViewById(R.id.etEmail)
        val spCountry: Spinner = view.findViewById(R.id.spCountry)
        val rgGender: RadioGroup = view.findViewById(R.id.rgGender)
        val ckLicense: CheckBox = view.findViewById(R.id.ckLicense)
        val ckCar: CheckBox = view.findViewById(R.id.ckCar)

        //Loading Spinner
        ArrayAdapter.createFromResource(requireContext(),
            R.array.country_array,
            android.R.layout.simple_spinner_item).also {
                adapter -> adapter
                    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spCountry.adapter = adapter
        }
        var spCountryValue = ""
        spCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                spCountryValue = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        btnSave.setOnClickListener {
            val fullNameValue = etFullName.text.toString()
            val emailValue = etEmail.text.toString()
            var intSelectedButton = rgGender!!.checkedRadioButtonId
            var rbSelected: RadioButton = view.findViewById(intSelectedButton)
            val genderValue = rbSelected.text

            val allValues = "Full name: $fullNameValue \nEmail: $emailValue \nGender: $genderValue" +
                            "\nCountry: $spCountryValue \nLicense: ${ckLicense.isChecked}" +
                            "\nCar: ${ckCar.isChecked}"
            Toast.makeText(requireContext(), allValues, Toast.LENGTH_LONG).show()
        }


        return view
    }

}
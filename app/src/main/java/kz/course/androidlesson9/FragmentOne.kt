package kz.course.androidlesson9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentOne : Fragment() {
    private lateinit var fragmentOneButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initListeners()
    }

    private fun initViews(view: View) {
        fragmentOneButton = view.findViewById(R.id.fragmentOneButton)
    }

    private fun initListeners() {
        fragmentOneButton.setOnClickListener {
            makeToast()
        }
    }

    private fun makeToast() {
        (activity as OnButtonClick).onFragmentClick("Hello Nurasyl")
    }

    interface OnButtonClick {
        fun onFragmentClick(text: String)
    }
}
package kz.course.androidlesson9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), FragmentOne.OnButtonClick {
    private lateinit var showFragmentButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initListener()
    }

    private fun initViews() {
        showFragmentButton = findViewById(R.id.showFragmentButton)
    }

    private fun initListener() {
        showFragmentButton.setOnClickListener {
            changeFragment(FragmentThree())
        }
    }

    private fun changeFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.contentFragment, fragment)
        transaction.commit()
    }

    override fun onFragmentClick(text: String) {
        //Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

        val fragmentTwo = supportFragmentManager.findFragmentById(R.id.fragmentTwo) as FragmentTwo
        fragmentTwo.setFragmentText(text)
    }


}
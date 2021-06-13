package edu.utxaustin.motivateme

import android.content.Context
import android.graphics.Color.*
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var userName: EditText
    private lateinit var  msg: TextView
    private lateinit var  mainView: View
    private val motivationalMsgsList = listOf("Believe you can and you’re halfway there.",
        "Nothing ever gets easier. You just get stronger.",
        "You will allow life’s changes to make you better, not bitter.",
        "If you work on something a little bit every day, you end up with something that is massive.",
        "If you cannot do great things, do small things in a great way.",
        "Nothing will work unless you do.",
        "Dreams don’t work unless you do.",
        "Go the extra mile. It’s never crowded there.")

    private val txtColorList = listOf(R.color.black,
        R.color.darkgreen,
        R.color.darkorange,
        R.color.darkpurple,
        R.color.navy_blue,
        R.color.purple_200,
        R.color.purple_700,
        R.color.sky_blue,
        R.color.teal_200,
        R.color.teal_700,
        R.color.green,
        R.color.blue,
        R.color.dark_sea_green,
        R.color.darkred,
        R.color.orange)

    private val viewColorList = listOf(   R.color.champagner_pink,
    R.color.background_olivine,
    R.color.background_white,
    R.color.background_blue,
    R.color.background_pink,
    R.color.background_lavender,
    R.color.background_brown,
    R.color.background_gray,
    R.color.background_camBlue,
    R.color.background_oPar,
    R.color.background_silvar,
    R.color.background_french)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val updateButton: Button = findViewById(R.id.main_activity_button_update)
        //updateButton.setOnClickListener { Log.i("test", "btn pushed") }
        userName = findViewById(R.id.activity_main_edited_text_name)
        //val msg: TextView = findViewById(R.id.main_activity_text_view_motive_msg)
        msg=findViewById<TextView>(R.id.main_activity_text_view_motive_msg)
        mainView=findViewById<View>(R.id.main_view)

        updateButton.setOnClickListener { updateMessage() }
    }
    // get a name from the editText
    private fun updateMessage(){


        val userNameText = userName.text


        val msgIndex = (0..motivationalMsgsList.size-1).random()
        val currentMsg = motivationalMsgsList[msgIndex]

        val txtColorIndex = (0..txtColorList.size-1).random()
        val currentTxtColor = txtColorList[txtColorIndex]

        val viewColorIndex = (0..viewColorList.size-1).random()
        val currentviewColor = viewColorList[viewColorIndex]

        if (userNameText.toString()=="") {
            msg.text = "Make sure to enter your name!"
            msg.setTextColor(getResources().getColor(R.color.red))

        } else{
            msg.text = "Hey ${userNameText}! ${currentMsg}"
            msg.run {
                setTextColor(getResources().getColor(currentTxtColor))
                setTextSize(TypedValue.COMPLEX_UNIT_SP,30F)
            };
            mainView.setBackgroundColor(getResources().getColor(currentviewColor))
        }
        //set the userName empty
        userName.setText("")
        hideKeyBoard()
        }

    //Hide Keyboard using an InputMethodManager
    private fun hideKeyBoard(){
        val myInputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        myInputMethodManager.hideSoftInputFromWindow(userName.windowToken,0)
    }

    }



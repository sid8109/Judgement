package com.example.judgement

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.CursorAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.judgement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var n = 0
    private var CURRENT_PLAYER = -1
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.plus10.setOnClickListener { updatepoints(10) }
        binding.plus1.setOnClickListener { updatepoints(1) }
        binding.minus1.setOnClickListener { updatepoints(-1) }
    }

    private fun updatepoints(point: Int) {
        if (CURRENT_PLAYER == -1) {
            Toast.makeText(this, "No Players Added", Toast.LENGTH_SHORT).show()
            return
        }
        val player = when (CURRENT_PLAYER) {
            1 -> binding.playerPoint1
            2 -> binding.playerPoint2
            3 -> binding.playerPoint3
            4 -> binding.playerPoint4
            5 -> binding.playerPoint5
            else -> binding.playerPoint6
        }

        player.text = (player.text.toString().toInt() + point).toString()
    }

    fun addPlayerName(view: View) {

        val name = binding.nameInputEditText.text.toString()
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        binding.nameInputEditText.setText("")

        if (n == 6) {
            Toast.makeText(this, "Player limit exceeded", Toast.LENGTH_SHORT).show()
            return
        } else if (name == "") {
            Toast.makeText(this, "Name field cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }
        n += 1

        val textview = when (n) {
            1 -> binding.playerName1
            2 -> binding.playerName2
            3 -> binding.playerName3
            4 -> binding.playerName4
            5 -> binding.playerName5
            else -> binding.playerName6
        }
        val textviewpoints = when (n) {
            1 -> binding.playerPoint1
            2 -> binding.playerPoint2
            3 -> binding.playerPoint3
            4 -> binding.playerPoint4
            5 -> binding.playerPoint5
            else -> binding.playerPoint6
        }
        textview.text = name
        textviewpoints.text = "0"
        val temp = n
        textview.setOnClickListener {
            setplayer(temp);
        }
        textviewpoints.setOnClickListener {
            setplayer(temp)
        }

        if (n == 1) {
            CURRENT_PLAYER = 1
            setplayer(1)
        }
    }

    private fun setplayer(num: Int) {
        val players_textView = arrayOf(
            Pair(binding.playerName1, binding.playerPoint1),
            Pair(binding.playerName2, binding.playerPoint2),
            Pair(binding.playerName3, binding.playerPoint3),
            Pair(binding.playerName4, binding.playerPoint4),
            Pair(binding.playerName5, binding.playerPoint5),
            Pair(binding.playerName6, binding.playerPoint6)
        )

        players_textView[CURRENT_PLAYER - 1].first.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.white
//                R.color.primary
            )
        )
        players_textView[CURRENT_PLAYER - 1].second.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.white
//                R.color.primary
            )
        )

        CURRENT_PLAYER = num

        players_textView[CURRENT_PLAYER - 1].second.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.heading
            )
        )
        players_textView[CURRENT_PLAYER - 1].first.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.heading
            )
        )
    }

//    private fun changeselectedplayer(direction: Int) {
//        val players_textView = arrayOf(
//            Pair(binding.playerName1, binding.playerPoint1),
//            Pair(binding.playerName2, binding.playerPoint2),
//            Pair(binding.playerName3, binding.playerPoint3),
//            Pair(binding.playerName4, binding.playerPoint4),
//            Pair(binding.playerName5, binding.playerPoint5),
//            Pair(binding.playerName6, binding.playerPoint6)
//        )
//
//        if (CURRENT_PLAYER == -1) {
//            Toast.makeText(this, "No Players Added", Toast.LENGTH_SHORT).show()
//            return
//        }
//
//        players_textView[CURRENT_PLAYER - 1].first.setTextColor(
//            ContextCompat.getColor(
//                this,
//                R.color.white
//            )
//        )
//        players_textView[CURRENT_PLAYER - 1].second.setTextColor(
//            ContextCompat.getColor(
//                this,
//                R.color.white
//            )
//        )
//
//        CURRENT_PLAYER = (CURRENT_PLAYER + n + direction - 1) % n + 1
//
//        players_textView[CURRENT_PLAYER - 1].second.setTextColor(
//            ContextCompat.getColor(
//                this,
//                R.color.heading
//            )
//        )
//        players_textView[CURRENT_PLAYER - 1].first.setTextColor(
//            ContextCompat.getColor(
//                this,
//                R.color.heading
//            )
//        )
//    }
}

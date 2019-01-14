package com.renji.tetris

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.renji.tetris.storage.AppPreferences

class MainActivity : AppCompatActivity() {
    private var tvHighScore: TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val btnNewGame = findViewById<Button>(R.id.btn_new_game)
        val btnResetScore = findViewById<Button>(R.id.btn_reset_score)
        val btnExit : Button = findViewById<Button>(R.id.btn_exit)
        tvHighScore = findViewById<TextView>(R.id.tv_high_score)

        btnNewGame.setOnClickListener(this::onBtnNewGameClick)
        btnResetScore.setOnClickListener(this::onBtnResetScoreClick)
        btnExit.setOnClickListener(this::handleExitClick)

    }
    private fun onBtnNewGameClick(view: View){
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
    private fun onBtnResetScoreClick(view: View){
        val preferences = AppPreferences(this)
        preferences.clearHighScore()
        Snackbar.make(view, "Score successfully reset",
            Snackbar.LENGTH_SHORT).show()
        tvHighScore?.text ="High score: ${preferences.getHighScore()}"
    }

    private fun handleExitClick(view: View){
        finish()
    }
}
package com.vanlang.kiemtra_laptrinhungdungdidong_2374802010037

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Lấy Email được truyền từ màn hình đăng nhập
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        val email = intent.getStringExtra("EMAIL")
        tvEmail.text = "Email: ${email ?: ""}"

        // Đăng xuất và quay lại màn hình trước
        btnLogout.setOnClickListener {
            finish()
        }
    }
}

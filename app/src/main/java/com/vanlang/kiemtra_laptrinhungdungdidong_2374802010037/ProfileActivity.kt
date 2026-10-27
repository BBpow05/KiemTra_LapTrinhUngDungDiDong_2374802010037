package com.vanlang.kiemtra_laptrinhungdungdidong_2374802010037

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Hiển thị Email được truyền từ màn hình đăng nhập
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        val email = intent.getStringExtra("EMAIL")
        tvEmail.text = "Email: ${email ?: ""}"

        // Đăng xuất và quay lại màn hình đăng nhập
        btnLogout.setOnClickListener {
            finish()
        }

        // Lấy ListView từ giao diện
        val lvSkills = findViewById<ListView>(R.id.lvSkills)

        // Danh sách ít nhất 5 kỹ năng
        val skills = arrayOf(
            "Lập trình Android",
            "Lập trình Java",
            "Lập trình Kotlin",
            "Cơ sở dữ liệu",
            "Lập trình mạng",
            "Thiết kế giao diện"
        )

        // Tạo Adapter để hiển thị danh sách
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            skills
        )
        lvSkills.adapter = adapter

        // Hiển thị Toast khi chọn một mục
        lvSkills.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this,
                skills[position],
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

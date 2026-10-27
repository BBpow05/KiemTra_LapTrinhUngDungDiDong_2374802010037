package com.vanlang.kiemtra_laptrinhungdungdidong_2374802010037

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Giữ phần xử lý khoảng đệm từ code mẫu của thầy
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        // Ánh xạ các thành phần giao diện bằng findViewById
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        // Xử lý khi nhấn nút Đăng nhập
        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            when {
                email.isEmpty() -> {
                    tvStatus.text = "Vui lòng nhập Email!"
                }

                password.isEmpty() -> {
                    tvStatus.text = "Vui lòng nhập mật khẩu!"
                }

                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvStatus.text = "Email không đúng định dạng!"
                }

                password.length < 6 -> {
                    tvStatus.text = "Mật khẩu phải có ít nhất 6 ký tự!"
                }

                else -> {
                    tvStatus.text = "Xác thực thành công!"

                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("EMAIL", email)
                    startActivity(intent)
                }
            }
        }
    }
}

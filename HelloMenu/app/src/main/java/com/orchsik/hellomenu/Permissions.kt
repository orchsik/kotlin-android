package com.orchsik.hellomenu

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orchsik.hellomenu.databinding.PermissionsBinding

class Permissions : AppCompatActivity() {

  private val permissions = arrayOf(
    Manifest.permission.INTERNET,
    Manifest.permission.ACCESS_FINE_LOCATION,
    Manifest.permission.ACCESS_COARSE_LOCATION,
    Manifest.permission.READ_CONTACTS,
    Manifest.permission.WRITE_CONTACTS,
    Manifest.permission.READ_EXTERNAL_STORAGE,
    Manifest.permission.WRITE_EXTERNAL_STORAGE,
  )

  private lateinit var binding : PermissionsBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = PermissionsBinding.inflate(layoutInflater)
    setContentView(binding.root)

    /**
     * 권한여부 확인
     */
    binding.textView.text = ""
    for(P in permissions) {
      val chk = checkCallingOrSelfPermission(P)
      if(chk == PackageManager.PERMISSION_GRANTED) {
        binding.textView.append("$P: GRANTED\n")
      } else {
        binding.textView.append("$P: DENIED\n")
      }
    }

    /**
     * 권한 요청
     */
    binding.button.setOnClickListener{
      requestPermissions(permissions, 0)
    }
  }

  /**
   * 권한요청 후 이벤트
   */
  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    binding.textView.text = ""
    for(idx in grantResults.indices) {
      if(grantResults[idx] == PackageManager.PERMISSION_GRANTED) {
        binding.textView.append("${permissions[idx]}: GRANTED.\n")
      } else {
        binding.textView.append("${permissions[idx]}: DENIED.\n")
      }
    }
  }
}
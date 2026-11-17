package org.stratoemu.strato

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Caminho direto para a ROM do Zelda no armazenamento interno do Android
        val romFile = File("/storage/emulated/0/Zelda/LinkAwakening.nsp")
        
        if (romFile.exists()) {
            val intent = Intent(this, EmulationActivity::class.java).apply {
                data = Uri.fromFile(romFile)
            }
            startActivity(intent)
            finish()
            return
        }
        
        // Se o arquivo não for encontrado, abre a interface normal de segurança
        setContentView(R.layout.activity_main)
    }
}

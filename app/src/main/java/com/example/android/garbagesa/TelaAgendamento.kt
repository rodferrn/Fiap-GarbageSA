package com.example.android.garbagesa

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.core.app.NotificationCompat
import java.lang.Exception

const val CHANNEL_ID = "Notificacao"

class TelaAgendamento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_agendamento)
    }

    fun createNotificationChannel() {
        // Cria um notification channel apenas disponivel em versoes 26+

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            // Registra o canal com o sistema
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }
    }

    fun acessarAgendamentoConfirmadoActivity(view: View) {

        createNotificationChannel()

        var cb_count: Int = 0

        val cb_agendamento1: CheckBox = findViewById(R.id.agendamento1)
        val cb_agendamento2: CheckBox = findViewById(R.id.agendamento2)
        val cb_agendamento3: CheckBox = findViewById(R.id.agendamento3)
        val cb_agendamento4: CheckBox = findViewById(R.id.agendamento4)
        val cb_agendamento5: CheckBox = findViewById(R.id.agendamento5)

        if (cb_agendamento1.isChecked) {
            cb_count = cb_count + 1
        }
        if (cb_agendamento2.isChecked) {
            cb_count = cb_count + 1
        }
        if (cb_agendamento3.isChecked) {
            cb_count = cb_count +1
        }
        if (cb_agendamento4.isChecked) {
            cb_count = cb_count + 1
        }
        if (cb_agendamento5.isChecked) {
            cb_count = cb_count +1
        }

        if (cb_count == 1) {

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val p = PendingIntent.getActivity(this, 0,
                Intent(this, AgendamentoConfirmadoActivity::class.java), 0)
//            startActivity(intent)

            var mensagem = ("Obrigado por escolher a Garbage SA.")

            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            builder.setContentTitle(mensagem)
            builder.setSmallIcon(R.drawable.ponteiro)
            builder.setLargeIcon(GarbageLargeIcon.decoder())
            builder.priority = NotificationCompat.PRIORITY_DEFAULT
            builder.setContentIntent(p)

            val style = NotificationCompat.InboxStyle()

            val aprovacao = arrayOf("Clique para confirmar o agendamento.")

            for (detalhe in aprovacao) {
                style.addLine(detalhe)
            }

            builder.setStyle(style)

            val notificacao = builder.build()

            notificacao.flags = Notification.FLAG_AUTO_CANCEL

            notificationManager.notify(R.drawable.ic_launcher_background,notificacao)

            // Emite um som para chamar a atenção do usuário

            try {
                val som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val toque = RingtoneManager.getRingtone(this, som)
                toque.play()

            } catch(e: Exception) {
                Log.e("ErroSom", e.message.toString())
            }

        } else {
            Toast.makeText(this, "Selecionar apenas um dia para a coleta.", Toast.LENGTH_SHORT).show()
        }
    }
}
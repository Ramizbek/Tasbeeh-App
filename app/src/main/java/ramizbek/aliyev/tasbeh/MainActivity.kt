package ramizbek.aliyev.tasbeh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import ramizbek.aliyev.tasbeh.utils.MySharedPreferences

class MainActivity : AppCompatActivity() {
    var current = -1
    var overall = -1
    var lap = 0
    var type = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(tv_duolar)
        tv_progress.text = tv_progress.hint
        number()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        MySharedPreferences.init(this)

        tv_33.setText(MySharedPreferences.name)
        tv_33.addTextChangedListener{
            MySharedPreferences.name = it.toString()
        }

        tv_jami.setText(MySharedPreferences.name)
        tv_jami.addTextChangedListener{
            MySharedPreferences.name = it.toString()
        }

        tv_progress.setText(MySharedPreferences.name)

        tv_progress.addTextChangedListener{
            MySharedPreferences.name = it.toString()
        }

    }

    fun number(view: View? = null) {

        if (!type) {
            current += 1
            overall += 1

            tv_progress.text = current.toString()
            tv_jami.text = overall.toString()
            tv_33.text = lap.toString()

            if (current == 32) {
                current = 0
                lap += 1
            }
        } else {
            current += 1
            overall += 1

            tv_progress.text = current.toString()
            tv_jami.text = overall.toString()
            tv_33.text = lap.toString()

            if (current == 98) {
                current = 0
                lap += 1
            }
        }
        tv_clear.setOnClickListener {
            current = -1
            overall = -1
            lap = 0
            number()
        }
        textView3.setOnClickListener {

            type = !type
            setLap()
//            MySharedPreferences.name = it.toString()
        }
        setLap()
    }

    private fun setLap() {
        if (!type) {
            textView3.text = " /33"
            lap = overall / 33
        } else {

            textView3.text = " /99"
            lap = overall / 99
        }
        tv_33.text = lap.toString()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.nom, menu)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> {
                tv_duolar.text = "SubhanAllah wa biHamdihi"
            }
            R.id.menu2 -> {
                tv_duolar.text = "SubhanAllah"
            }
            R.id.menu3 -> {
                tv_duolar.text = "Subhaan-Allahi wa bihamdihi"
            }
            R.id.menu4 -> {
                tv_duolar.text = "Hasbunallahu Wa Ni'mal Wakeel"
            }
            R.id.menu5 -> {
                tv_duolar.text = "la ilaha illa'llah"
            }
            R.id.menu6 -> {
                tv_duolar.text = "Astaghfirullah"
            }
            R.id.menu7 -> {
                tv_duolar.text = "Allah-o-Akbar"
            }
            R.id.menu8 -> {
                tv_duolar.text = "Alhamdulillah"
            }
            R.id.menu9 -> {
                tv_duolar.text = "Ya-Fattahu"
            }
            R.id.menu10 -> {
                tv_duolar.text = "Al-Basit"
            }
            R.id.menu11 -> {
                tv_duolar.text = "Al-Wahhab"
            }
            R.id.menu12 -> {
                tv_duolar.text = "Ya-Latifu"
            }
        }
        return super.onContextItemSelected(item)
    }

    private fun clear() {

    }
}

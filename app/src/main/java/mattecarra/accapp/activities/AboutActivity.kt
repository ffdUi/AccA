package mattecarra.accapp.activities

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import kotlinx.android.synthetic.main.activity_about.*
import mattecarra.accapp.R
import mattecarra.accapp.acc.Acc

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        setSupportActionBar(about_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set appropriate version numbers
        val app = applicationContext.packageManager.getPackageInfo(packageName, 0)
        acca_version_tv.text = String.format("%s (%s)", app.versionName, app.versionCode.toString())
        acc_version_tv.text = Acc.getAccVersion().toString()
    }

    companion object {
        fun launch(context: Context) {
            context.startActivity(Intent(context, AboutActivity::class.java))
        }
    }

    private fun openUrl(url: String) {
        try {
            val tabsBuilder = CustomTabsIntent.Builder()
            val tabs: CustomTabsIntent = tabsBuilder.build()
            tabs.launchUrl(this, Uri.parse(url))
        } catch (anfEx: ActivityNotFoundException) {
            Toast.makeText(this, R.string.toast_no_browser_installed, Toast.LENGTH_LONG).show()
        }
    }

    fun accaGitHubOnClick(view: View) {
        openUrl("https://github.com/MatteCarra/AccA")
    }

    fun vr25GitHubOnClick(view: View) {
        openUrl("https://github.com/VR-25")
    }
    fun vr25WebsiteOnClick(view: View) {
        openUrl("https://forum.xda-developers.com/member.php?u=5228676")
    }

    fun matteGitHubOnClick(view: View) {
        openUrl("https://github.com/MatteCarra")
    }
    fun matteWebsiteOnClick(view: View) {
        openUrl("https://forum.xda-developers.com/member.php?u=9731715")
    }

    fun squabbiGitHubOnClick(view: View) {
        openUrl("https://github.com/squabbi")
    }
    fun squabbiWebsiteOnClick(view: View) {
        openUrl("https://squabbi.com/")
    }


}

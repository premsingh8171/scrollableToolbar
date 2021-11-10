package com.example.scrollactivityexample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.scrollactivityexample.databinding.ActivityScrollingBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.snackbar.Snackbar

class ScrollingActivity : AppCompatActivity() {

	private lateinit var binding: ActivityScrollingBinding
	private var barOffset = 0
	private var fabVisible = true

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityScrollingBinding.inflate(layoutInflater)
		setContentView(binding.root)

//		setSupportActionBar(findViewById(R.id.toolbar))
//		binding.toolbarLayout.title = "prem"


		binding.appBar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
			override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
				val dy: Int = barOffset - verticalOffset
				barOffset = verticalOffset
				if (dy > 0 && fabVisible) {
					// scrolling up
					fabVisible = false
					Log.e("fabVisible", "up")
					binding.resHeaderConstL.visibility=View.VISIBLE
					binding.tvStoreNameTxt.visibility=View.GONE
					binding.storeDetailsLay.visibility=View.GONE
					binding.tvStoreName.text="prem"
				} else if (dy < 0 && !fabVisible) {
					// scrolling down
					fabVisible = true
					Log.e("fabVisible", "down")
					binding.resHeaderConstL.visibility=View.VISIBLE
					binding.tvStoreName.text=""
					binding.tvStoreNameTxt.visibility=View.VISIBLE
					binding.storeDetailsLay.visibility=View.VISIBLE

				}
			}
		})

	}


//	override fun onCreateOptionsMenu(menu: Menu): Boolean {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		menuInflater.inflate(R.menu.menu_scrolling, menu)
//		return true
//	}

//	override fun onOptionsItemSelected(item: MenuItem): Boolean {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//
//		return when (item.itemId) {
//			R.id.action_settings -> true
//			else -> super.onOptionsItemSelected(item)
//		}
//	}
}
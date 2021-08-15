package manabboro.roomdatabase.daggertest

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {


    lateinit var mImageView: ImageView
    lateinit var mViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mImageView = findViewById(R.id.image_view)
        mViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mViewModel.getDogImageObserver().observe(this) {
            Glide.with(this).load(it.dogImage).into(mImageView)
        }

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            mViewModel.getDogImageFromApi()
        }
    }
}
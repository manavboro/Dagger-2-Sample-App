package manabboro.roomdatabase.daggertest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import manabboro.roomdatabase.daggertest.di.RetroServiceInterface
import manabboro.roomdatabase.daggertest.model.DataOutput
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel(
    application: Application
) : AndroidViewModel(application) {

    init {
        val app = application as MyApplication
        app.getRetroCompo().inject(this)
    }

    @Inject
    lateinit var mService: RetroServiceInterface

    var dogImage: MutableLiveData<DataOutput> = MutableLiveData()


    fun getDogImageObserver(): MutableLiveData<DataOutput> {
        return dogImage
    }

    fun getDogImageFromApi() {
        val call = mService.getDogImage()
        call.enqueue(object : Callback<DataOutput> {
            override fun onResponse(call: Call<DataOutput>, response: Response<DataOutput>) {
                if (response.isSuccessful) {
                    dogImage.postValue(response.body())
                } else dogImage.postValue(null)
            }

            override fun onFailure(call: Call<DataOutput>, t: Throwable) {
                dogImage.postValue(null)
            }

        })
    }

}
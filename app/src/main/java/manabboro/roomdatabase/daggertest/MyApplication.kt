package manabboro.roomdatabase.daggertest

import android.app.Application
import manabboro.roomdatabase.daggertest.di.DaggerRetroComponent
import manabboro.roomdatabase.daggertest.di.RetroComponent
import manabboro.roomdatabase.daggertest.di.RetroModule


class MyApplication : Application() {

    private lateinit var retroComponent: RetroComponent
    override fun onCreate() {
        super.onCreate()

        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }

    fun getRetroCompo():RetroComponent{
        return  retroComponent
    }
}
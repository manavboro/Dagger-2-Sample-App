package manabboro.roomdatabase.daggertest.di

import dagger.Component
import manabboro.roomdatabase.daggertest.MainActivityViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)
}
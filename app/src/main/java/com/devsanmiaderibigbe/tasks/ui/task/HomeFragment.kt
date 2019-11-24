package com.devsanmiaderibigbe.tasks.ui.task


import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.devsanmiaderibigbe.tasks.MyApplicatoin
import com.devsanmiaderibigbe.tasks.R
import com.devsanmiaderibigbe.tasks.ui.MainActivity
import com.devsanmiaderibigbe.tasks.ui.common.Authentication
import com.devsanmiaderibigbe.tasks.ui.login.LoginViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    @Inject lateinit var loginViewModel: LoginViewModel

    lateinit var viewController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (context.applicationContext as MyApplicatoin).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewController = findNavController()
        observeLoginState()

    }

    private fun observeLoginState(){
        loginViewModel.loginStatusLiveData.observe(viewLifecycleOwner, Observer { authState ->
            when(authState.data){
                Authentication.AUTHENTICATED -> {

                }
                Authentication.UNAUTHENTICATED -> {
                    viewController.navigate(HomeFragmentDirections.action_homeFragment_to_loginFragment())
                }

            }
        })
    }
}

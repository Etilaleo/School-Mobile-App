package com.example.esmmobile.guestScreen

import android.os.Bundle
import android.view.*
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.esmmobile.R
import com.example.esmmobile.databinding.FragmentGuestHomeBinding

class GuestHomeFragment : Fragment() {

    private lateinit var binding : FragmentGuestHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGuestHomeBinding.inflate(layoutInflater)

        val actionBarTitle = getString(R.string.app_name)
        val actionBar  = (activity as AppCompatActivity).supportActionBar!!
        actionBar.title = actionBarTitle.uppercase()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Creating a loginMenu
        val menu : MenuHost = requireActivity()
        menu.addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.guest_login_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.loginMenu -> {
                        findNavController().navigate(R.id.action_guestHomeFragment_to_login2)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)


        val animation  = AnimationUtils.loadAnimation(requireContext(), R.anim.guest_home_animation)
        animation.duration = 1500
        binding.admissionOpenLayout.startAnimation(animation)

        binding.applyNowButton.setOnClickListener {
            findNavController().navigate(R.id.action_guestHomeFragment_to_applyNowFragment)
        }
    }
}
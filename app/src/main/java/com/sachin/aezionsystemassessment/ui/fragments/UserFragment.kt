package com.sachin.aezionsystemassessment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.sachin.aezionsystemassessment.R
import com.sachin.aezionsystemassessment.databinding.FragmentUserBinding
import com.sachin.aezionsystemassessment.ui.UserAdapter
import com.sachin.aezionsystemassessment.ui.UserViewModel
import com.sachin.aezionsystemassessment.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : Fragment(R.layout.fragment_user) {

    lateinit var fragmentUserBinding: FragmentUserBinding
    val userViewMode: UserViewModel by viewModels()
    lateinit var adapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentUserBinding = FragmentUserBinding.inflate(inflater, container, false)



        userViewMode.getUsersFromRepo()

        observeData()

        return fragmentUserBinding.root
    }

    private fun observeData() {
        userViewMode.getUsers().observe(viewLifecycleOwner, Observer {

//            when(response) {
//                is Resource.Success -> {
//                    response.data?.let {
//                        adapter = UserAdapter(it)
//                    }
//                }
//
//            }



//                





        })
    }

    private fun showProgressBar() {
//        fragmentUserBinding.paginationProgressBar.visibility = VISIBLE
    }

    private fun hideProgressbar() {
//        fragmentUserBinding.apply {
//            paginationProgressBar.visibility = INVISIBLE
//        }
    }



}
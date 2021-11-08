package com.sigma.internship.cleanacrhitecture.ui.screens.main

import android.os.Bundle
import com.sigma.internship.cleanacrhitecture.databinding.ActivityMainBinding
import com.sigma.internship.cleanacrhitecture.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initClicks()
    }

    override fun liveDataObserver() {
        viewModel.getUserResponse.observe(this, {
            binding.tvUsers.text = it.joinToString(separator = "\n")
        })
    }

    private fun initClicks(){
        with(binding){
            btnAddUser.setOnClickListener { onAddUser() }
            btnShowUser.setOnClickListener { viewModel.getUsers() }
        }
    }

    private fun onAddUser(){
        with(binding){
            viewModel.adduser(edtUserName.text.toString(), edtUserSurname.text.toString())
            edtUserName.text.clear()
            edtUserSurname.text.clear()
        }
    }
}
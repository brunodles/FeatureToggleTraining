package com.brunodles.workshop.featuretoggle

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view?.let { setupRecyclerView(it.findViewById(R.id.recyclerView)) }
    }

    private fun setupRecyclerView(recycler: RecyclerView) {
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = ContentAdapter(onClickListener = { position -> // named parameter
            startActivity(DetailActivity.newIntent(context, position))

        })
    }
}
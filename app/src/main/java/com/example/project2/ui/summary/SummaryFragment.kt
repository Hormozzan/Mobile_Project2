package com.example.project2.ui.summary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.project2.R


class SummaryFragment : Fragment() {

    private lateinit var summaryViewModel: SummaryViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        summaryViewModel =
                ViewModelProvider(this).get(SummaryViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_summary, container, false)
        val textView: TextView = root.findViewById(R.id.text_summary)
        val recyclerViewAnimal: RecyclerView = root.findViewById(R.id.recycler_view_animal)
        textView.text = "Animals"

        summaryViewModel.animals.observe(viewLifecycleOwner) { animals ->
            recyclerViewAnimal.adapter = AnimalAdapter(animals)
        }
        recyclerViewAnimal.addItemDecoration(
            DividerItemDecoration(
                recyclerViewAnimal.getContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        return root
    }
}
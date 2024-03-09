package org.gold.mvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import org.gold.mvvm.databinding.FragmentMainBinding
import org.gold.mvvm.viewmodel.MainViewModel


class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    private val viewMode: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.updateText.setOnClickListener {
            viewMode.getUpDatedText()
        }
        textUpdateObserver()

    }
    private fun textUpdateObserver(){
        viewMode.uiTextLiveData.observe(viewLifecycleOwner, Observer {updateText ->
            binding.textView.text=updateText
        })
    }
}
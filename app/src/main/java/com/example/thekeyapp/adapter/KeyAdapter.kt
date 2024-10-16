package com.example.thekeyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.thekeyapp.databinding.KeyLayoutBinding
import com.example.thekeyapp.fragments.ActiveKeyDetailsFragmentDirections
import com.example.thekeyapp.fragments.ActiveKeyFragmentDirections
import com.example.thekeyapp.fragments.HomeFragmentDirections
import com.example.thekeyapp.model.Key

class KeyAdapter : RecyclerView.Adapter<KeyAdapter.KeyViewHolder>(){

    class KeyViewHolder(val itemBinding: KeyLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Key>(){
        override fun areItemsTheSame(oldItem: Key, newItem: Key): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.keyDesc == newItem.keyDesc &&
                    oldItem.keyName == newItem.keyName
        }

        override fun areContentsTheSame(oldItem: Key, newItem: Key): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyViewHolder {
        return KeyViewHolder(
            KeyLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: KeyViewHolder, position: Int) {
        val currentKey = differ.currentList[position]

        holder.itemBinding.keyName.text = currentKey.keyName
        holder.itemBinding.keyDesc.text = currentKey.keyDesc

        holder.itemView.setOnClickListener{
            val direction = ActiveKeyDetailsFragmentDirections.actionActiveKeyDetailsFragment2ToEditActiveKeysFragment(currentKey)
            it.findNavController().navigate(direction)

            val direction2 = ActiveKeyFragmentDirections.actionActiveKeyFragmentToActiveKeyDetailsFragment2()
            it.findNavController().navigate(direction2)

            val direction3 = HomeFragmentDirections.actionHomeFragmentToActiveKeyFragment()
            it.findNavController().navigate(direction3)


        }
    }
}
package com.example.testandroid.presentation

import android.app.Activity
import android.content.Intent
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.ListAdapter
import com.example.testandroid.R

import com.example.testandroid.domain.image.ImageItem
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropSquareTransformation
import kotlinx.coroutines.withContext
import java.util.ArrayList


class RecyclerViewAdapter (var activity: Activity) :
ListAdapter<ImageItem, ImageItemViewHolder>(ImageItemDiffCallback()){

    var viewModel: MainViewModel? = null
    var isEnable = false
    var isSelectAll = false
    var selectList = ArrayList<ImageItem>()
    var listForSelection = ArrayList<ImageItem>()
    var onClickListener: ((ImageItem) -> Unit)? = null


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.images_item,
            parent,
            false
        )
        viewModel = ViewModelProvider(activity as MainActivity)[MainViewModel::class.java]
        return ImageItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ImageItemViewHolder, position: Int) {
        val imageItem = getItem(position)
        Picasso.get().apply { isLoggingEnabled = true }
            .load(imageItem.photo)
            .transform(CropSquareTransformation())
            .into(viewHolder.photo)


        viewHolder.view.setOnLongClickListener{ v ->
            if (!isEnable){
                val callback: ActionMode.Callback =
                object : ActionMode.Callback {
                    override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                        val menuInflater = mode.menuInflater
                        menuInflater.inflate(R.menu.menu, menu)

                        return true
                    }

                    override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                        isEnable = true
                        clickItem(viewHolder)
                        viewModel?.getText()?.observe(
                            activity as LifecycleOwner,
                            Observer { s ->
                                mode.title = String.format("$s Selected", s)
                            })
                        return true
                    }

                    override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
                        when(item.itemId){
                            R.id.menu_delete -> {
                                for (s in selectList){
                                    viewModel?.deleteSelected(s)
                                }
                                mode.finish()
                            }
                            R.id.menu_select_all -> {
                                if (selectList.size == currentList.size){
                                    isSelectAll = false
                                    selectList.clear()
                                }else{
                                    isSelectAll = true
                                    selectList.clear()
                                    selectList.addAll(currentList)

                                }
                                viewModel?.setText(selectList.size.toString())
                                submitList(currentList)
                            }
                        }
                        return true
                    }

                    override fun onDestroyActionMode(p0: ActionMode?) {
                        viewHolder.checkbox.visibility = View.GONE
                        viewHolder.pickCheckbox.visibility = View.GONE
                        isEnable = false
                        isSelectAll = false
                        selectList.clear()
                        submitList(currentList)
                    }
                }
                (v.context as AppCompatActivity).startActionMode(callback)
            } else {
                clickItem(viewHolder)
            }
            true
        }
        viewHolder.view.setOnClickListener {
            if (isEnable){
                clickItem(viewHolder)
            }else{
               onClickListener?.invoke(getItem(position))
            }
        }
        if (isSelectAll){
            viewHolder.pickCheckbox.visibility = View.VISIBLE
        } else {
            viewHolder.pickCheckbox.visibility = View.GONE
        }
    }

    private fun clickItem(viewHolder: ImageItemViewHolder){
        val s = getItem(viewHolder.adapterPosition)
        if (viewHolder.pickCheckbox.visibility == View.GONE){
            viewHolder.pickCheckbox.visibility = View.VISIBLE
            selectList.add(s)
        }else{
            viewHolder.pickCheckbox.visibility = View.GONE
            selectList.remove(s)
        }
    }


}
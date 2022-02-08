//package com.example.testandroid.presentation
//import android.R
//import android.app.Activity
//import android.graphics.Color
//import android.view.*
//import android.view.View.OnLongClickListener
//import android.widget.ImageView
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.FragmentActivity
//import androidx.lifecycle.LifecycleOwner
//import androidx.lifecycle.ViewModelProviders
//import androidx.recyclerview.widget.RecyclerView
//import java.util.ArrayList
//
//
//class MainAdapter     // create constructor
//    (// initialize variables
//    var activity: Activity, var arrayList: ArrayList<String>, var tvEmpty: TextView
//) :
//    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
//    var mainViewModel: MainViewModel? = null
//    var isEnable = false
//    var isSelectAll = false
//    var selectList = ArrayList<String>()
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        // initialize variables
//        val view: View =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
//
//        // initialize view Model
//        mainViewModel = ViewModelProviders.of((activity as FragmentActivity))
//            .get(MainViewModel::class.java)
//
//        // return view
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//        // set text on text view
//        holder.textView.text = arrayList[position]
//        holder.itemView.setOnLongClickListener { v -> // check condition
//            if (!isEnable) {
//                // when action mode is not enable
//                // initialize action mode
//                val callback: ActionMode.Callback =
//                    object : ActionMode.Callback {
//                        override fun onCreateActionMode(
//                            mode: ActionMode,
//                            menu: Menu
//                        ): Boolean {
//                            // initialize menu inflater
//                            val menuInflater = mode.menuInflater
//                            // inflate menu
//                            menuInflater.inflate(R.menu.menu, menu)
//                            // return true
//                            return true
//                        }
//
//                        override fun onPrepareActionMode(
//                            mode: ActionMode,
//                            menu: Menu
//                        ): Boolean {
//                            // when action mode is prepare
//                            // set isEnable true
//                            isEnable = true
//                            // create method
//                            ClickItem(holder)
//                            // set observer on getText method
//                            mainViewModel!!.getText()!!.observe(
//                                (activity as LifecycleOwner), { s -> // when text change
//                                    // set text on action mode title
//                                    mode.title = String.format("%s Selected", s)
//                                })
//                            // return true
//                            return true
//                        }
//
//                        override fun onActionItemClicked(
//                            mode: ActionMode,
//                            item: MenuItem
//                        ): Boolean {
//                            // when click on action mode item
//                            // get item id
//                            val id = item.itemId
//                            when (id) {
//                                R.id.menu_delete -> {
//                                    // when click on delete
//                                    // use for loop
//                                    for (s in selectList) {
//                                        // remove selected item list
//                                        arrayList.remove(s)
//                                    }
//                                    // check condition
//                                    if (arrayList.size == 0) {
//                                        // when array list is empty
//                                        // visible text view
//                                        tvEmpty.visibility = View.VISIBLE
//                                    }
//                                    // finish action mode
//                                    mode.finish()
//                                }
//                                R.id.menu_select_all -> {
//                                    // when click on select all
//                                    // check condition
//                                    if (selectList.size == arrayList.size) {
//                                        // when all item selected
//                                        // set isselectall false
//                                        isSelectAll = false
//                                        // create select array list
//                                        selectList.clear()
//                                    } else {
//                                        // when all item unselected
//                                        // set isSelectALL true
//                                        isSelectAll = true
//                                        // clear select array list
//                                        selectList.clear()
//                                        // add value in select array list
//                                        selectList.addAll(arrayList)
//                                    }
//                                    // set text on view model
//                                    mainViewModel!!.setText(selectList.size.toString())
//                                    // notify adapter
//                                    notifyDataSetChanged()
//                                }
//                            }
//                            // return true
//                            return true
//                        }
//
//                        override fun onDestroyActionMode(mode: ActionMode) {
//                            // when action mode is destroy
//                            // set isEnable false
//                            isEnable = false
//                            // set isSelectAll false
//                            isSelectAll = false
//                            // clear select array list
//                            selectList.clear()
//                            // notify adapter
//                            notifyDataSetChanged()
//                        }
//                    }
//                // start action mode
//                (v.context as AppCompatActivity).startActionMode(callback)
//            } else {
//                // when action mode is already enable
//                // call method
//                ClickItem(holder)
//            }
//            // return true
//            true
//        }
//        holder.itemView.setOnClickListener {
//            // check condition
//            if (isEnable) {
//                // when action mode is enable
//                // call method
//                ClickItem(holder)
//            } else {
//                // when action mode is not enable
//                // display toast
//                Toast.makeText(
//                    activity, "You Clicked" + arrayList[holder.adapterPosition],
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//        // check condition
//        if (isSelectAll) {
//            // when value selected
//            // visible all check boc image
//            holder.checkbox.visibility = View.VISIBLE
//            //set background color
//            holder.itemView.setBackgroundColor(Color.LTGRAY)
//        } else {
//            // when all value unselected
//            // hide all check box image
//            holder.checkbox.visibility = View.GONE
//            // set background color
//            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
//        }
//    }
//
//    private fun ClickItem(holder: ViewHolder) {
//
//        // get selected item value
//        val s = arrayList[holder.adapterPosition]
//        // check condition
//        if (holder.checkbox.visibility == View.GONE) {
//            // when item not selected
//            // visible check box image
//            holder.checkbox.visibility = View.VISIBLE
//            // set background color
//            holder.itemView.setBackgroundColor(Color.LTGRAY)
//            // add value in select array list
//            selectList.add(s)
//        } else {
//            // when item selected
//            // hide check box image
//            holder.checkbox.visibility = View.GONE
//            // set background color
//            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
//            // remove value from select arrayList
//            selectList.remove(s)
//        }
//        // set text on view model
//        mainViewModel!!.setText(selectList.size.toString())
//    }
//
//    override fun getItemCount(): Int {
//        return arrayList.size
//    }
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        // initialize variables
//        var imageView: ImageView
//        var checkbox: ImageView
//
//        init {
//            // assign variables
//            imageView = itemView.findViewById(R.id.image_item)
//            checkbox = itemView.findViewById(R.id.checkbox)
//        }
//    }
//}

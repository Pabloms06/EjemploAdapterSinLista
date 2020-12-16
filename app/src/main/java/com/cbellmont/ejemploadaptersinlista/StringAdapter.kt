package com.cbellmont.ejemploadaptersinlista

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class StringAdapter() : RecyclerView.Adapter<StringAdapter.StringViewHolder>()  {

    class StringViewHolder(var root: View, var textView: TextView) : RecyclerView.ViewHolder(root)

    var numeroElementos=100

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val twTextView = view.findViewById<TextView>(R.id.textView)
        return StringViewHolder(view, twTextView)
    }

    override fun getItemCount(): Int {
        return numeroElementos
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {

        if (position%2==1){
        holder.textView.text = "Soy impar"
            holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.colorAccent))
            //Para que siempre tenga colores diferentes y no funcione por las VISTAS

        }else{
            holder.textView.text = "Position = $position"
            holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.colorPrimary))
        }
       // if (position == itemCount -1){
         //   holder.textView.text = "Soy el último"
       // }

        if (position == itemCount -1){
            holder.textView.text = "Añadir"
            holder.root.setOnClickListener{
                var toast =  Toast.makeText(it.context, "Añadiendo...",Toast.LENGTH_LONG)
                //Modificaciones del TOAST
                toast.setGravity(Gravity.CENTER,0,0)
                toast.setMargin(0F,2F)
                toast.show()
                numeroElementos++
                notifyDataSetChanged()   //notifica de que cambia el numero de elementos para que actualice
                // lo que se ve por pantalla
            }
        }
    }

}


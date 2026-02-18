package mx.itson.edu.practica3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ProductosActivity : AppCompatActivity() {
    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductos(menuOption)

        var listView: ListView = findViewById<ListView>(R.id.litview) as ListView

        var adaptador: AdaptardorProductos = AdaptardorProductos(this,menu)
        listView.adapter = adaptador
    }

    fun agregarProductos(option:String?){
        when(option){
           "Antojitos"->{
               menu.add( Product( "Quesadillas", R.drawable.quesadillas,"Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.", 5.69 ) )
               menu.add(Product("Huaraches",R.drawable.huaraches,"Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema. Big thick tortilla with beans, your choice of meat, lettuce, fresh cheese and cream.", 7.99 ))
               menu.add(Product("Gringas", R.drawable.gringas,"Tortilla de harina con queso, carne al pastor y piña. Flour tortilla with cheese, marinated pork and pineapple.", 7.99))
               menu.add(Product("Sincronizadas",R.drawable.sincronizadas,"Tortilla de harina rellena con queso y jamon. Se sirve con lechuga, crema y guacamole. Sandwich of two flour tortillas.",7.99))
               menu.add(Product("Sopes",R.drawable.sopes,"Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema. Fried thick tortilla with beans, your choice of meat.",6.99))
               menu.add(Product("Tostadas", R.drawable.tostadas,"Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate. Fried tortilla with beans, your choice of meat.",6.99))
           }
            "Especialidades"->{
                menu.add(Product("Mojarra Frita", R.drawable.mojarra, "Tilipa frita servida con lechiga, jitomate, aguacate y tortillas.", 8.3))
            }
            "Combination"->{
                menu.add(Product("Traditional Taco Combo",R.drawable.combinationtaco,"Tortilla de maíz y tu carne favorita. Servido con arroz y frijoles. Corn taco, your choice of meat, served with rice and beans.", 6.99))
            }
            "Tortas"->{
                menu.add(Product("Torta Regular",R.drawable.torta,"All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeno pepper and your choice of meat.",13.39))
            }
            "Sopas"->{
                menu.add(Product("Caldo De Res",R.drawable.caldores,"Beef ribs and chuck stew with corn, potato, chayote (squash family), cabage, cilantro, onion, zuccini, carrots, lime, and tortillas. DO NOT FORGET OUR SALSA BAR TO MAKE IT MORE FLAVORFULL",8.39))
            }
            "Drinks"->{
                menu.add(Product("Jarritos",R.drawable.jarritos,"We’ll try our best to accommodate requests, but can’t make changes that affect pricing.",2.75))
            }
        }

    }

    private class AdaptardorProductos: BaseAdapter{
        var producto= ArrayList<Product>()
        var contexto: Context?=null

        constructor(contexto: Context,producto: ArrayList<Product>){
            this.producto=producto
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return producto.size
        }

        override fun getItem(position: Int): Any? {
            return producto[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?
        ): View? {
            var prod=producto[position]
            var inflador= LayoutInflater.from(contexto)
            var vista=inflador.inflate(R.layout.product_view,null)

            var imagen=vista.findViewById<ImageView>(R.id.producto_img) as ImageView
            var nombre=vista.findViewById<TextView>(R.id.producto_nombre) as TextView
            var desc=vista.findViewById<TextView>(R.id.producto_desc) as TextView
            var precio=vista.findViewById<TextView>(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista
        }
    }
}
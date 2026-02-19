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

        var imagen : ImageView = findViewById(R.id.imagenView) as ImageView
        when(option){
            "Antojitos"->{
                imagen.setImageResource(R.drawable.antojitos)
                menu.add( Product( "Quesadillas", R.drawable.quesadillas,"Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.", 5.69 ) )
                menu.add(Product("Huaraches",R.drawable.huaraches,"Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema. Big thick tortilla with beans, your choice of meat, lettuce, fresh cheese and cream.", 7.99 ))
                menu.add(Product("Gringas", R.drawable.gringas,"Tortilla de harina con queso, carne al pastor y piña. Flour tortilla with cheese, marinated pork and pineapple.", 7.99))
                menu.add(Product("Sincronizadas",R.drawable.sincronizadas,"Tortilla de harina rellena con queso y jamon. Se sirve con lechuga, crema y guacamole. Sandwich of two flour tortillas.",7.99))
                menu.add(Product("Sopes",R.drawable.sopes,"Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema. Fried thick tortilla with beans, your choice of meat.",6.99))
                menu.add(Product("Tostadas", R.drawable.tostadas,"Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate. Fried tortilla with beans, your choice of meat.",6.99))
            }
            "Especialidades"->{
                imagen.setImageResource(R.drawable.especialidades)
                menu.add(Product("Mojarra Frita", R.drawable.mojarra, "Tilipa frita servida con lechiga, jitomate, aguacate y tortillas.", 8.3))
                menu.add(Product("Ceviche",R.drawable.ceviche,"Tilapia, camarones, aguacate y pico de gallo servido con chips. Tilapia, shrimp, avocado and pico de gallo, served with chips.", 6.99))
                menu.add(Product("Botana De Camarones Al Mojo De Ajo",R.drawable.botanacamarones,"Haremos todo lo posible para satisfacer las solicitudes, pero no podemos realizar cambios que afecten los precios.",19.99))
            }
            "Combination"->{
                imagen.setImageResource(R.drawable.combinations)
                menu.add(Product("Traditional Taco Combo",R.drawable.combinationtaco,"Tortilla de maíz y tu carne favorita. Servido con arroz y frijoles. Corn taco, your choice of meat, served with rice and beans.", 6.99))
                menu.add(Product("Mexican Burritos",R.drawable.cominationburros,"Tu carne favorita en una tortilla grande de harina rellena con cebolla frita, pico de gallo, sour cream, frijoles y acompañado de arroz. Your choice of meat on a big burrito made of flour tortilla with rice, beans, lettuce, grilled onions, pico de gallo, and sour cream.",13.69))
                menu.add(Product("Cinco",R.drawable.cinco,"Un taco de venta fuerte con su elección de carne, lechuga y queso. Un burrito con su elección de carne, pico de gallo, crema agria y frijoles. Servido con arroz y frijoles.",10.99))
            }
            "Tortas"->{
                imagen.setImageResource(R.drawable.tortas)
                menu.add(Product("Torta Regular",R.drawable.torta,"All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeno pepper and your choice of meat.",13.39))
                menu.add(Product("Torta Mixta",R.drawable.tortamixta,"Chorizo, asada y pastor. Mexican sausage, steak and marinated por.",13.99))
                menu.add(Product("Torta Cubana",R.drawable.tortacubana,"Chorizo, asada, jamon, pastor y queso. Mexican sausage, steak, marinated pork, ham, and cheese.",14.49))
                menu.add(Product("Milanesa De Pollo Torta",R.drawable.tortamilanesa,"Pollo.",13.99))
            }
            "Sopas"->{
                imagen.setImageResource(R.drawable.sopas)
                menu.add(Product("Caldo De Res",R.drawable.caldores,"Beef ribs and chuck stew with corn, potato, chayote (squash family), cabage, cilantro, onion, zuccini, carrots, lime, and tortillas. DO NOT FORGET OUR SALSA BAR TO MAKE IT MORE FLAVORFULL",8.39))
                menu.add(Product("Sopa De Mariscos",R.drawable.sopamariscos,"sopa de mariscos",21.99))
                menu.add(Product("Caldo De Camarón", R.drawable.caldocamaron,"Sopa de camarones.",13.99))
                menu.add(Product("Menudo",R.drawable.menudo,"",7.99))

            }
            "Drinks"->{
                imagen.setImageResource(R.drawable.drinks)
                menu.add(Product("Jarritos",R.drawable.jarritos,"We’ll try our best to accommodate requests, but can’t make changes that affect pricing.",2.75))
                menu.add(Product("MODELO ESPECIAL",R.drawable.mexicanbeer,"",5.49))
                menu.add(Product("Caguama",R.drawable.caguama,"",9.99))
                menu.add(Product("Caguama Michelada",R.drawable.caguamamichelada,"",9.99))
                menu.add(Product("Michelada",R.drawable.michelada,"",9.99))
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
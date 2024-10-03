import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejercicio05_ontouchlistener.R

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var spinner: Spinner
    private val users = mutableListOf<User>()
    private var lastMotionEventProcessed = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializamos los componentes
        val blueBox: View = findViewById(R.id.blue_box)
        nameEditText = findViewById(R.id.editTextName)
        passwordEditText = findViewById(R.id.editTextPassword)
        spinner = findViewById(R.id.spinner)

        // Creamos un adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mutableListOf<String>())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Añadir algunos elementos por defecto al Spinner
        users.add(User("Usuario1", "password1"))
        users.add(User("Usuario2", "password2"))
        users.add(User("Usuario3", "password3"))
        updateSpinner()

        // Evento de movimiento sobre el recuadro azul
        blueBox.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_MOVE && !lastMotionEventProcessed) {
                // Añadir un nuevo usuario usando el texto de los EditText
                val name = nameEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (name.isNotEmpty() && password.isNotEmpty()) {
                    users.add(User(name, password))
                    updateSpinner() // Actualizar el Spinner con el nuevo usuario
                }

                lastMotionEventProcessed = true
            }

            if (event.action == MotionEvent.ACTION_UP) {
                lastMotionEventProcessed = false
            }

            true
        }

        // Evento de selección en el Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Obtener el usuario seleccionado y rellenar los EditTexts
                val selectedUser = users[position]
                nameEditText.setText(selectedUser.name)
                passwordEditText.setText(selectedUser.password)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No hacer nada si no se selecciona nada
            }
        }
    }

    // Clase para manejar los datos de los usuarios
    data class User(val name: String, val password: String)

    // Actualizar el Spinner
    private fun updateSpinner() {
        val adapter = spinner.adapter as ArrayAdapter<String>
        adapter.clear()
        adapter.addAll(users.map { it.name })
        adapter.notifyDataSetChanged()
    }
}

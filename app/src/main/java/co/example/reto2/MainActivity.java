package co.example.reto2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.example.reto2.adapters.AnimalAdapter;
import co.example.reto2.entity.Animal;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listViewAnimales)
    public ListView listViewAnimales;
    @BindView(R.id.txtBuscar)
    public EditText txtBuscar;
    private AnimalAdapter AnimalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); //Mapeo
        loadInfo();
        buscarOnTextListener();

        listViewAnimales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animal animal = AnimalAdapter.getItem(i);
                if (animal.getNombre().equals("Elefante")){
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.elefante);
                    mediaPlayer.start();
                }
                if (animal.getNombre().equals("Mono")){
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.mono);
                    mediaPlayer.start();
                }
                if (animal.getNombre().equals("Jaguar")){
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.jaguar);
                    mediaPlayer.start();
                }
                if (animal.getNombre().equals("Gorila")){
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.gorila);
                    mediaPlayer.start();
                }
                if (animal.getNombre().equals("León")){
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.leon);
                    mediaPlayer.start();
                }
            }
        });

        this.setTitle(R.string.mi_titulo);

    }

    private void buscarOnTextListener() {
        txtBuscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                AnimalAdapter.getFilter().filter(charSequence);
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });
    }

    private void loadInfo() {
        List<Animal> listaAnimales = new ArrayList<>();
        listaAnimales.add(new Animal(R.drawable.elefante, "Elefante", "Son los animales terrestres más grandes del mundo, siendo el elefante africano el de mayor tamaño ya que puede llegar a pesar hasta 7,000-7.500 kg."));
        listaAnimales.add(new Animal(R.drawable.gorila, "Gorila", "El gorila es el más grande de todos los primates. Éstos se desplazan en cuatro patas. Sus extremidades superiores son similares a los brazos humanos que también utilizan para apoyarse al andar."));
        listaAnimales.add(new Animal(R.drawable.leon, "León", "Es el segundo felino de mayor tamaño después del trigre, llega a pesar hasta 200 kilos. Existe una marcada diferencia entre el macho y la hembra, ya que el primero posee una llamativa y frondosa melena. La longitud y el color de esta depende de la edad, del desgaste físico, de la genética y de las hormonas del animal."));
        listaAnimales.add(new Animal(R.drawable.mono, "Mono","Son animales muy sociales que emplean vocalizaciones, movimientos corporales y expresiones faciales para comunicarse. A un grupo de monos se le conoce como tropa y el número de integrantes varía con el tipo de especie. Los miembros de una tropa viajan juntos para encontrar comida y protegerse del peligro"));
        listaAnimales.add(new Animal(R.drawable.jaguar,"Jaguar","Esta especie habitaba desde Estados Unidos hasta el norte de Argentina, pero con su exterminio generado por el hombre, hoy en día sólo forma parte de las selvas tropicales de América Central y del Sur. La distribución más grande de este felino se encuentra en la cuenca del Amazonas y en el norte y este de las costas caribeñas de Venezuela y Guayana."));
        AnimalAdapter = new AnimalAdapter(this, listaAnimales);
        listViewAnimales.setAdapter(AnimalAdapter);
    }
}
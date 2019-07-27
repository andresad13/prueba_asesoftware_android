package com.prueba.prueba_asesoftware;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prueba.prueba_asesoftware.adapters.ListaProductsAdapter;
import com.prueba.prueba_asesoftware.entities.Products;
import com.prueba.prueba_asesoftware.helpers.ConexionSQLiteHelper;
import com.prueba.prueba_asesoftware.helpers.Utilidades;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


   private ArrayList<Products> listaProducto;
    private RecyclerView recyclerViewProducto;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_productos",null,1);
        listaProducto=new ArrayList<>();
        recyclerViewProducto= (RecyclerView) findViewById(R.id.recyclerProductos);
        recyclerViewProducto.setLayoutManager(new LinearLayoutManager(this));
        consultarListaProductos();
        ListaProductsAdapter adapter=new ListaProductsAdapter(listaProducto);
        recyclerViewProducto.setAdapter(adapter);
        llenarListaProductos();
    }

    private void consultarListaProductos() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Products producto=null;

        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_PRODUCTO ,null);

        while (cursor.moveToNext()){
            producto=new Products();
            producto.setProducto(cursor.getString(0));
            producto.setDescripcion(cursor.getString(1));
            producto.setPrecio(cursor.getString(2));
            producto.setImg(cursor.getString(3));

            listaProducto.add(producto);
        }
    }

    private void llenarListaProductos() {
        listaProducto.add(new Products("lavadora"," Indicador de carga ubicado dentro de la canasta. Mide el tamaño de la carga seca al lavar y la selecciona de acuerdo a la marca más aproximada; de este modo, la lavadora utilizará solo el agua necesaria.","450.000", "https://5af2ab3cc7e0a3391218-bb2ad470ea539c5163aaf64511d96f64.ssl.cf1.rackcdn.com/productos/122199/122199-d.jpg"));
        listaProducto.add(new Products("tv","Disfruta de la TV HD en la era digital. Cuando veas este televisor con imagen de alta calidad con nítidos y vivos detalles, no querrás volver a ver los televisores tradicionales.","1.950.000", "https://i5.walmartimages.ca/images/Large/010/121/6000199010121.jpg"));
        listaProducto.add(new Products("equipo de sonido","Siente el ritmo de tus temas favoritos incluso desde largas distancias con este potente sistema de sonido todo en uno. Disfruta de las luces de altavoz que cambian al ritmo de la música y controla la reproducción desde tu smartphone.","950.000", "https://http2.mlstatic.com/panasonic-equipo-de-sonido-6000wats-scakx38-D_NQ_NP_891282-MLV28750129197_112018-Q.jpg"));
        listaProducto.add(new Products("nevera","Tecnología Home Energy Saver. Control efectivo de la temperatura dentro de la nevera conservando mejor los alimentos. Gran capacidad para mejor distribución de los alimentos","1.710.000","https://www.francobordo.com/images/productos/thumbnails/neveranfijandenabsorcionncombicoolnrfn60ndometic-1-4859_thumb_432x345.png"));
        listaProducto.add(new Products("lavadora"," Indicador de carga ubicado dentro de la canasta. Mide el tamaño de la carga seca al lavar y la selecciona de acuerdo a la marca más aproximada; de este modo, la lavadora utilizará solo el agua necesaria.","450.000", "https://5af2ab3cc7e0a3391218-bb2ad470ea539c5163aaf64511d96f64.ssl.cf1.rackcdn.com/productos/122199/122199-d.jpg"));
        listaProducto.add(new Products("equipo de sonido","Siente el ritmo de tus temas favoritos incluso desde largas distancias con este potente sistema de sonido todo en uno. Disfruta de las luces de altavoz que cambian al ritmo de la música y controla la reproducción desde tu smartphone.","950.000", "https://http2.mlstatic.com/panasonic-equipo-de-sonido-6000wats-scakx38-D_NQ_NP_891282-MLV28750129197_112018-Q.jpg"));
        listaProducto.add(new Products("tv","Disfruta de la TV HD en la era digital. Cuando veas este televisor con imagen de alta calidad con nítidos y vivos detalles, no querrás volver a ver los televisores tradicionales.","1.960.000", "https://i5.walmartimages.ca/images/Large/010/121/6000199010121.jpg"));
        listaProducto.add(new Products("equipo de sonido","Siente el ritmo de tus temas favoritos incluso desde largas distancias con este potente sistema de sonido todo en uno. Disfruta de las luces de altavoz que cambian al ritmo de la música y controla la reproducción desde tu smartphone.","950.000", "https://http2.mlstatic.com/panasonic-equipo-de-sonido-6000wats-scakx38-D_NQ_NP_891282-MLV28750129197_112018-Q.jpg"));
        listaProducto.add(new Products("nevera","Tecnología Home Energy Saver. Control efectivo de la temperatura dentro de la nevera conservando mejor los alimentos. Gran capacidad para mejor distribución de los alimentos","1.000.000","https://www.francobordo.com/images/productos/thumbnails/neveranfijandenabsorcionncombicoolnrfn60ndometic-1-4859_thumb_432x345.png"));
        listaProducto.add(new Products("lavadora"," Indicador de carga ubicado dentro de la canasta. Mide el tamaño de la carga seca al lavar y la selecciona de acuerdo a la marca más aproximada; de este modo, la lavadora utilizará solo el agua necesaria.","450.000", "https://5af2ab3cc7e0a3391218-bb2ad470ea539c5163aaf64511d96f64.ssl.cf1.rackcdn.com/productos/122199/122199-d.jpg"));
        listaProducto.add(new Products("tv","Disfruta de la TV HD en la era digital. Cuando veas este televisor con imagen de alta calidad con nítidos y vivos detalles, no querrás volver a ver los televisores tradicionales.","2.350.000", "https://i5.walmartimages.ca/images/Large/010/121/6000199010121.jpg"));
        listaProducto.add(new Products("equipo de sonido","Siente el ritmo de tus temas favoritos incluso desde largas distancias con este potente sistema de sonido todo en uno. Disfruta de las luces de altavoz que cambian al ritmo de la música y controla la reproducción desde tu smartphone.","950.000", "https://http2.mlstatic.com/panasonic-equipo-de-sonido-6000wats-scakx38-D_NQ_NP_891282-MLV28750129197_112018-Q.jpg"));
        listaProducto.add(new Products("nevera","Tecnología Home Energy Saver. Control efectivo de la temperatura dentro de la nevera conservando mejor los alimentos. Gran capacidad para mejor distribución de los alimentos","1.050.000","https://www.francobordo.com/images/productos/thumbnails/neveranfijandenabsorcionncombicoolnrfn60ndometic-1-4859_thumb_432x345.png"));
        listaProducto.add(new Products("lavadora"," Indicador de carga ubicado dentro de la canasta. Mide el tamaño de la carga seca al lavar y la selecciona de acuerdo a la marca más aproximada; de este modo, la lavadora utilizará solo el agua necesaria.","450.000", "https://5af2ab3cc7e0a3391218-bb2ad470ea539c5163aaf64511d96f64.ssl.cf1.rackcdn.com/productos/122199/122199-d.jpg"));
        listaProducto.add(new Products("tv","Disfruta de la TV HD en la era digital. Cuando veas este televisor con imagen de alta calidad con nítidos y vivos detalles, no querrás volver a ver los televisores tradicionales.","1.950.000", "https://i5.walmartimages.ca/images/Large/010/121/6000199010121.jpg"));
        listaProducto.add(new Products("equipo de sonido","Siente el ritmo de tus temas favoritos incluso desde largas distancias con este potente sistema de sonido todo en uno. Disfruta de las luces de altavoz que cambian al ritmo de la música y controla la reproducción desde tu smartphone.","950.000", "https://http2.mlstatic.com/panasonic-equipo-de-sonido-6000wats-scakx38-D_NQ_NP_891282-MLV28750129197_112018-Q.jpg"));
        listaProducto.add(new Products("nevera","Tecnología Home Energy Saver. Control efectivo de la temperatura dentro de la nevera conservando mejor los alimentos. Gran capacidad para mejor distribución de los alimentos","4.200.000","https://www.francobordo.com/images/productos/thumbnails/neveranfijandenabsorcionncombicoolnrfn60ndometic-1-4859_thumb_432x345.png"));
        listaProducto.add(new Products("tv","Disfruta de la TV HD en la era digital. Cuando veas este televisor con imagen de alta calidad con nítidos y vivos detalles, no querrás volver a ver los televisores tradicionales.","1.950.000", "https://i5.walmartimages.ca/images/Large/010/121/6000199010121.jpg"));
        listaProducto.add(new Products("equipo de sonido","Siente el ritmo de tus temas favoritos incluso desde largas distancias con este potente sistema de sonido todo en uno. Disfruta de las luces de altavoz que cambian al ritmo de la música y controla la reproducción desde tu smartphone.","950.000", "https://http2.mlstatic.com/panasonic-equipo-de-sonido-6000wats-scakx38-D_NQ_NP_891282-MLV28750129197_112018-Q.jpg"));
        listaProducto.add(new Products("nevera","Tecnología Home Energy Saver. Control efectivo de la temperatura dentro de la nevera conservando mejor los alimentos. Gran capacidad para mejor distribución de los alimentos","6.400.000","https://www.francobordo.com/images/productos/thumbnails/neveranfijandenabsorcionncombicoolnrfn60ndometic-1-4859_thumb_432x345.png"));
        listaProducto.add(new Products("lavadora"," Indicador de carga ubicado dentro de la canasta. Mide el tamaño de la carga seca al lavar y la selecciona de acuerdo a la marca más aproximada; de este modo, la lavadora utilizará solo el agua necesaria.","450.000", "https://5af2ab3cc7e0a3391218-bb2ad470ea539c5163aaf64511d96f64.ssl.cf1.rackcdn.com/productos/122199/122199-d.jpg"));
        listaProducto.add(new Products("tv","Disfruta de la TV HD en la era digital. Cuando veas este televisor con imagen de alta calidad con nítidos y vivos detalles, no querrás volver a ver los televisores tradicionales.","1.950.000", "https://i5.walmartimages.ca/images/Large/010/121/6000199010121.jpg"));
        listaProducto.add(new Products("equipo de sonido","Siente el ritmo de tus temas favoritos incluso desde largas distancias con este potente sistema de sonido todo en uno. Disfruta de las luces de altavoz que cambian al ritmo de la música y controla la reproducción desde tu smartphone.","950.000", "https://http2.mlstatic.com/panasonic-equipo-de-sonido-6000wats-scakx38-D_NQ_NP_891282-MLV28750129197_112018-Q.jpg"));
        listaProducto.add(new Products("nevera","Tecnología Home Energy Saver. Control efectivo de la temperatura dentro de la nevera conservando mejor los alimentos. Gran capacidad para mejor distribución de los alimentos","3.000.000","https://www.francobordo.com/images/productos/thumbnails/neveranfijandenabsorcionncombicoolnrfn60ndometic-1-4859_thumb_432x345.png"));
        listaProducto.add(new Products("lavadora"," Indicador de carga ubicado dentro de la canasta. Mide el tamaño de la carga seca al lavar y la selecciona de acuerdo a la marca más aproximada; de este modo, la lavadora utilizará solo el agua necesaria.","450.000", "https://5af2ab3cc7e0a3391218-bb2ad470ea539c5163aaf64511d96f64.ssl.cf1.rackcdn.com/productos/122199/122199-d.jpg"));
        listaProducto.add(new Products("tv","Disfruta de la TV HD en la era digital. Cuando veas este televisor con imagen de alta calidad con nítidos y vivos detalles, no querrás volver a ver los televisores tradicionales.","1.950.000", "https://i5.walmartimages.ca/images/Large/010/121/6000199010121.jpg"));
        listaProducto.add(new Products("nevera","Tecnología Home Energy Saver. Control efectivo de la temperatura dentro de la nevera conservando mejor los alimentos. Gran capacidad para mejor distribución de los alimentos","2.500.000","https://www.francobordo.com/images/productos/thumbnails/neveranfijandenabsorcionncombicoolnrfn60ndometic-1-4859_thumb_432x345.png"));
        listaProducto.add(new Products("lavadora"," Indicador de carga ubicado dentro de la canasta. Mide el tamaño de la carga seca al lavar y la selecciona de acuerdo a la marca más aproximada; de este modo, la lavadora utilizará solo el agua necesaria.","450.000", "https://5af2ab3cc7e0a3391218-bb2ad470ea539c5163aaf64511d96f64.ssl.cf1.rackcdn.com/productos/122199/122199-d.jpg"));
        listaProducto.add(new Products("lavadora"," Indicador de carga ubicado dentro de la canasta. Mide el tamaño de la carga seca al lavar y la selecciona de acuerdo a la marca más aproximada; de este modo, la lavadora utilizará solo el agua necesaria.","450.000", "https://5af2ab3cc7e0a3391218-bb2ad470ea539c5163aaf64511d96f64.ssl.cf1.rackcdn.com/productos/122199/122199-d.jpg"));
        listaProducto.add(new Products("tv","Disfruta de la TV HD en la era digital. Cuando veas este televisor con imagen de alta calidad con nítidos y vivos detalles, no querrás volver a ver los televisores tradicionales.","1.950.000", "https://i5.walmartimages.ca/images/Large/010/121/6000199010121.jpg"));
        listaProducto.add(new Products("equipo de sonido","Siente el ritmo de tus temas favoritos incluso desde largas distancias con este potente sistema de sonido todo en uno. Disfruta de las luces de altavoz que cambian al ritmo de la música y controla la reproducción desde tu smartphone.","950.000", "https://http2.mlstatic.com/panasonic-equipo-de-sonido-6000wats-scakx38-D_NQ_NP_891282-MLV28750129197_112018-Q.jpg"));
        listaProducto.add(new Products("nevera","Tecnología Home Energy Saver. Control efectivo de la temperatura dentro de la nevera conservando mejor los alimentos. Gran capacidad para mejor distribución de los alimentos","1.100.000","https://www.francobordo.com/images/productos/thumbnails/neveranfijandenabsorcionncombicoolnrfn60ndometic-1-4859_thumb_432x345.png"));
        listaProducto.add(new Products("lavadora"," Indicador de carga ubicado dentro de la canasta. Mide el tamaño de la carga seca al lavar y la selecciona de acuerdo a la marca más aproximada; de este modo, la lavadora utilizará solo el agua necesaria.","450.000", "https://5af2ab3cc7e0a3391218-bb2ad470ea539c5163aaf64511d96f64.ssl.cf1.rackcdn.com/productos/122199/122199-d.jpg"));
        listaProducto.add(new Products("equipo de sonido","Siente el ritmo de tus temas favoritos incluso desde largas distancias con este potente sistema de sonido todo en uno. Disfruta de las luces de altavoz que cambian al ritmo de la música y controla la reproducción desde tu smartphone.","950.000", "https://http2.mlstatic.com/panasonic-equipo-de-sonido-6000wats-scakx38-D_NQ_NP_891282-MLV28750129197_112018-Q.jpg"));
        listaProducto.add(new Products("tv","Disfruta de la TV HD en la era digital. Cuando veas este televisor con imagen de alta calidad con nítidos y vivos detalles, no querrás volver a ver los televisores tradicionales.","1.650.000", "https://i5.walmartimages.ca/images/Large/010/121/6000199010121.jpg"));
        listaProducto.add(new Products("nevera","Tecnología Home Energy Saver. Control efectivo de la temperatura dentro de la nevera conservando mejor los alimentos. Gran capacidad para mejor distribución de los alimentos","1.600.000","https://www.francobordo.com/images/productos/thumbnails/neveranfijandenabsorcionncombicoolnrfn60ndometic-1-4859_thumb_432x345.png"));
        listaProducto.add(new Products("lavadora"," Indicador de carga ubicado dentro de la canasta. Mide el tamaño de la carga seca al lavar y la selecciona de acuerdo a la marca más aproximada; de este modo, la lavadora utilizará solo el agua necesaria.","450.000", "https://5af2ab3cc7e0a3391218-bb2ad470ea539c5163aaf64511d96f64.ssl.cf1.rackcdn.com/productos/122199/122199-d.jpg"));
        listaProducto.add(new Products("tv","Disfruta de la TV HD en la era digital. Cuando veas este televisor con imagen de alta calidad con nítidos y vivos detalles, no querrás volver a ver los televisores tradicionales.","1.050.200", "https://i5.walmartimages.ca/images/Large/010/121/6000199010121.jpg"));
        listaProducto.add(new Products("equipo de sonido","Siente el ritmo de tus temas favoritos incluso desde largas distancias con este potente sistema de sonido todo en uno. Disfruta de las luces de altavoz que cambian al ritmo de la música y controla la reproducción desde tu smartphone.","950.000", "https://http2.mlstatic.com/panasonic-equipo-de-sonido-6000wats-scakx38-D_NQ_NP_891282-MLV28750129197_112018-Q.jpg"));
        listaProducto.add(new Products("nevera","Tecnología Home Energy Saver. Control efectivo de la temperatura dentro de la nevera conservando mejor los alimentos. Gran capacidad para mejor distribución de los alimentos","1.000.000","https://www.francobordo.com/images/productos/thumbnails/neveranfijandenabsorcionncombicoolnrfn60ndometic-1-4859_thumb_432x345.png"));
        listaProducto.add(new Products("lavadora"," Indicador de carga ubicado dentro de la canasta. Mide el tamaño de la carga seca al lavar y la selecciona de acuerdo a la marca más aproximada; de este modo, la lavadora utilizará solo el agua necesaria.","450.000", "https://5af2ab3cc7e0a3391218-bb2ad470ea539c5163aaf64511d96f64.ssl.cf1.rackcdn.com/productos/122199/122199-d.jpg"));
        listaProducto.add(new Products("tv","Disfruta de la TV HD en la era digital. Cuando veas este televisor con imagen de alta calidad con nítidos y vivos detalles, no querrás volver a ver los televisores tradicionales.","1.700.000", "https://i5.walmartimages.ca/images/Large/010/121/6000199010121.jpg"));
        listaProducto.add(new Products("equipo de sonido","Siente el ritmo de tus temas favoritos incluso desde largas distancias con este potente sistema de sonido todo en uno. Disfruta de las luces de altavoz que cambian al ritmo de la música y controla la reproducción desde tu smartphone.","950.000", "https://http2.mlstatic.com/panasonic-equipo-de-sonido-6000wats-scakx38-D_NQ_NP_891282-MLV28750129197_112018-Q.jpg"));
        listaProducto.add(new Products("nevera","Tecnología Home Energy Saver. Control efectivo de la temperatura dentro de la nevera conservando mejor los alimentos. Gran capacidad para mejor distribución de los alimentos","1.570.000","https://www.francobordo.com/images/productos/thumbnails/neveranfijandenabsorcionncombicoolnrfn60ndometic-1-4859_thumb_432x345.png"));



    }
}

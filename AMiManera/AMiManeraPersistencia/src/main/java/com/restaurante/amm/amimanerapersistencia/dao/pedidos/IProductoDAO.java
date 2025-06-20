<<<<<<< HEAD
package com.restaurante.amm.amimanerapersistencia.dao.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimanerapersistencia.dao.ICrud;

public interface IProductoDAO extends ICrud<Producto>{
    
}
=======
package com.restaurante.amm.amimanerapersistencia.dao.pedidos;

import com.restaurante.amm.amimaneramodel.pedidos.Producto;
import com.restaurante.amm.amimanerapersistencia.dao.ICrud;
import java.util.List;

public interface IProductoDAO extends ICrud<Producto>{
    List<Producto> buscarPorNombre(String nombre);
}
>>>>>>> main

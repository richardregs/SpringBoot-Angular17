package pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.service;

import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.entity.ProductoEntity;

public interface ProductoService extends GenericService<ProductoEntity>{
	
	Boolean updateStock(Long id, Integer stock) throws ServiceException;
	
}

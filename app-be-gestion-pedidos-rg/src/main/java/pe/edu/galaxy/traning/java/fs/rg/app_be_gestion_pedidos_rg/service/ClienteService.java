package pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.service;

import java.util.List;
import java.util.Optional;
import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.entity.ClienteEntity;

public interface ClienteService extends GenericService<ClienteEntity>{
	
	Optional<ClienteEntity> findByRuc(String ruc) throws ServiceException;
	List<ClienteEntity> findByLikeRazonSocial(String razonSocial) throws ServiceException;
	
}

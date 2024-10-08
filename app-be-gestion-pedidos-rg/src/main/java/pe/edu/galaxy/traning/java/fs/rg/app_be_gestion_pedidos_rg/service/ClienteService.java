package pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.service;

import java.util.List;
import java.util.Optional;
import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.entity.ClienteEntity;

public interface ClienteService {
	
	List<ClienteEntity> findAll();
	
	Optional<ClienteEntity> findById(Long id);
	
	List<ClienteEntity> findByLikeRazonSocial(String razonSocial);
	
	ClienteEntity save(ClienteEntity clienteEntity);
	
	ClienteEntity update(ClienteEntity clienteEntity);
	
	void delete(Long id);
}

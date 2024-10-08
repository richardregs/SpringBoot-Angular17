package pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.entity.ClienteEntity;
import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private ClienteRepository clienteRepository;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository){
		this.clienteRepository = clienteRepository;
	}

	@Override
	public List<ClienteEntity> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public ClienteEntity save(ClienteEntity clienteEntity) {
		return clienteRepository.save(clienteEntity);
	}

	@Override
	public Optional<ClienteEntity> findById(Long id) {
		return clienteRepository.findById(id);
	}

	@Override
	public List<ClienteEntity> findByLikeRazonSocial(String razonSocial) {
		return clienteRepository.findByLikeRazonSocial("%"+razonSocial+"%");
	}

	@Override
	public ClienteEntity update(ClienteEntity clienteEntity) { //Idempotente
		Optional<ClienteEntity> rClienteEntity = clienteRepository.findById(clienteEntity.getId());
		if (rClienteEntity.isPresent()) {
			ClienteEntity prmClienteEntity = rClienteEntity.get();
			BeanUtils.copyProperties(clienteEntity, prmClienteEntity);
			return clienteRepository.save(prmClienteEntity);
		}
		return clienteRepository.save(clienteEntity);
	}

	@Override
	public void delete(Long id) {
		//clienteRepository.deleteById(id);//fisico
		Optional<ClienteEntity> rClienteEntity = clienteRepository.findById(id);
		if (rClienteEntity.isPresent()) {
			ClienteEntity prmClienteEntity = rClienteEntity.get();
			prmClienteEntity.setEstado("0"); //lógico
			clienteRepository.save(prmClienteEntity);
		}
	}

}

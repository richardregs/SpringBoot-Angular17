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
	public Optional<ClienteEntity> findById(ClienteEntity clienteEntity) throws ServiceException {
		return clienteRepository.findById(clienteEntity.getId());
	}

	@Override
	public List<ClienteEntity> findLikeObject(ClienteEntity t) throws ServiceException {
		return clienteRepository.findAll();
	}

	@Override
	public ClienteEntity save(ClienteEntity clienteEntity) throws ServiceException {
		
		try {
			return clienteRepository.save(clienteEntity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public ClienteEntity update(ClienteEntity clienteEntity) throws ServiceException {
		Optional<ClienteEntity> rClienteEntity = clienteRepository.findById(clienteEntity.getId());
		if (rClienteEntity.isPresent()) {
			ClienteEntity prmClienteEntity = rClienteEntity.get();
			BeanUtils.copyProperties(clienteEntity, prmClienteEntity);
			return clienteRepository.save(prmClienteEntity);
		}
		return clienteRepository.save(clienteEntity);
	}

	@Override
	public Boolean delete(ClienteEntity clienteEntity) throws ServiceException {
		Optional<ClienteEntity> rClienteEntity = clienteRepository.findById(clienteEntity.getId());
		if (rClienteEntity.isPresent()) {
			ClienteEntity prmClienteEntity = rClienteEntity.get();
			prmClienteEntity.setEstado("0"); //lógico
			clienteRepository.save(prmClienteEntity);
			return true;
		}
		return false;
	}

	@Override
	public Optional<ClienteEntity> findByRuc(String ruc) throws ServiceException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<ClienteEntity> findByLikeRazonSocial(String razonSocial) throws ServiceException {
		try {
			return clienteRepository.findByLikeRazonSocial("%"+razonSocial+"%");
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}	
	
}




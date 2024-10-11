package pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.entity.ProductoEntity;
import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	private final ProductoRepository productoRepository;
	
	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	public Optional<ProductoEntity> findById(ProductoEntity productoEntity) throws ServiceException {
		try {
			return productoRepository.findById(productoEntity.getId());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<ProductoEntity> findLikeObject(ProductoEntity productoEntity) throws ServiceException {
		try {
			return productoRepository.findByLikeNombre("%" +productoEntity.getNombre()+"%");
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public ProductoEntity save(ProductoEntity productoEntity) throws ServiceException {
		try {
			return productoRepository.save(productoEntity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public ProductoEntity update(ProductoEntity productoEntity) throws ServiceException {
		try {
			Optional<ProductoEntity> rProductoEntity = productoRepository.findById(productoEntity.getId());
			if (rProductoEntity.isPresent()) {
				ProductoEntity prmProductoEntity = rProductoEntity.get();
				BeanUtils.copyProperties(productoEntity, prmProductoEntity);
				return productoRepository.save(prmProductoEntity);
			}
			return productoRepository.save(productoEntity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Boolean delete(ProductoEntity productoEntity) throws ServiceException {
		try {
			productoRepository.delete(productoEntity.getId());
			return true;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Boolean updateStock(Long id, Integer stock) throws ServiceException {
		try {
			productoRepository.updateStock(stock, id);
			return true;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}

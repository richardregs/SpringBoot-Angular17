package pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
	
	@Query("select p from ProductoEntity p where upper(p.nombre) like upper(:nombre) and p.estado='1'")
	List<ProductoEntity> findByLikeNombre(@Param("nombre") String nombre);
	
	// SQL
	@Transactional
	@Modifying
	@Query(value="UPDATE tbl_producto SET estado='0' WHERE producto_id=:id", nativeQuery = true)
	void delete (@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE tbl_producto SET stock=(stock+:stock) WHERE producto_id=:id", nativeQuery = true)
	void updateStock (@Param("stock") Integer stock, @Param("id") Long id);

}

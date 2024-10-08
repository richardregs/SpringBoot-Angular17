package pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
	
	//JPQL
	@Query("select p from ClienteEntity p where upper(p.razonSocial) like upper(:razonSocial) and p.estado='1'")
	List<ClienteEntity> findByLikeRazonSocial(@Param("razonSocial") String razonSocial);

}

package pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.entity.ClienteEntity;
import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.service.ClienteService;

import static java.util.Objects.isNull;

 @RestController
 @RequestMapping("/v1/clientes")
public class ClienteRestContreller {
	
	private ClienteService clienteService;
	
	public ClienteRestContreller(ClienteService clienteService){
		this.clienteService = clienteService;
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteEntity>> findAll(){
		try {
			ClienteEntity prmClienteEntity = new ClienteEntity();
			List<ClienteEntity> lstClienteEntity = clienteService.findLikeObject(prmClienteEntity);
			if (lstClienteEntity.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstClienteEntity);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteEntity> findById(@PathVariable("id") Long id){
		try {
			ClienteEntity prmClienteEntity = new ClienteEntity();
			prmClienteEntity.setId(id);
			Optional<ClienteEntity> optClienteEntity = clienteService.findById(prmClienteEntity);
			if (optClienteEntity.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(optClienteEntity.get());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@GetMapping("/by-razonSocial")
	public ResponseEntity<List<ClienteEntity>> findByLikeRazonSocial(
			@RequestParam(value="razonSocial", defaultValue="") String razonSocial){
		try {
			List<ClienteEntity> ListClienteEntity = clienteService.findByLikeRazonSocial(razonSocial);
			if (ListClienteEntity.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(ListClienteEntity);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<ClienteEntity> save(@RequestBody ClienteEntity clienteEntity){
		try {
			ClienteEntity rClienteEntity = clienteService.save(clienteEntity);
			if (isNull(rClienteEntity)) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(rClienteEntity);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteEntity> update(@PathVariable("id") Long id, @RequestBody ClienteEntity clienteEntity){
		try {
			clienteEntity.setId(id);
			ClienteEntity rClienteEntity = clienteService.update(clienteEntity);
			if (isNull(rClienteEntity)) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok(rClienteEntity);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		try {
			ClienteEntity prmClienteEntity = new ClienteEntity();
			prmClienteEntity.setId(id);
			clienteService.delete(prmClienteEntity); 
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}

}

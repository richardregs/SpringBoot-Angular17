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
		List<ClienteEntity> lstClienteEntity = clienteService.findAll();
		if (lstClienteEntity.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(lstClienteEntity);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteEntity> findById(@PathVariable("id") Long id){
		Optional<ClienteEntity> optClienteEntity = clienteService.findById(id);
		if (optClienteEntity.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(optClienteEntity.get());
	}
	
	@GetMapping("/by-razonSocial")
	public ResponseEntity<List<ClienteEntity>> findByLikeRazonSocial(@RequestParam(value="razonSocial", defaultValue="") String razonSocial){
		List<ClienteEntity> ListClienteEntity = clienteService.findByLikeRazonSocial(razonSocial);
		if (ListClienteEntity.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(ListClienteEntity);
	}
	
	@PostMapping
	public ResponseEntity<ClienteEntity> save(@RequestBody ClienteEntity clienteEntity){
		ClienteEntity rClienteEntity = clienteService.save(clienteEntity);
		if (isNull(rClienteEntity)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(rClienteEntity);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteEntity> update(@PathVariable("id") Long id, @RequestBody ClienteEntity clienteEntity){
		clienteEntity.setId(id);
		ClienteEntity rClienteEntity = clienteService.update(clienteEntity);
		if (isNull(rClienteEntity)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(rClienteEntity);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		clienteService.delete(id); 
		return ResponseEntity.ok().build();
	}

}

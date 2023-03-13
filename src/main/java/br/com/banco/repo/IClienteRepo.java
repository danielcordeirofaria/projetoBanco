package br.com.banco.repo;

<<<<<<< HEAD
public interface IClienteRepo {
=======
import org.springframework.data.repository.CrudRepository;

import br.com.banco.model.Cliente;

public interface IClienteRepo extends CrudRepository<Cliente, Integer> {
>>>>>>> 1add1bc0351e36e77bf264fb8b4c7dfe76ced138

}

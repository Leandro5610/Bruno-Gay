package senai.sp.cotia.wms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import senai.sp.cotia.wms.model.Fornecedor;

public interface FornecedorRepository extends PagingAndSortingRepository<Fornecedor, Long> {
	@Query("SELECT forn FROM Fornecedor forn WHERE forn.nome LIKE %:p% OR forn.cnpj LIKE %:p% "
			+ " OR forn.cep LIKE %:p% OR forn.logradouro LIKE %:p% OR forn.localidade LIKE %:p%" 
			+" OR forn.uf LIKE %:p% OR forn.homologado LIKE %:p%" )
    public List<Fornecedor> procurarTudo(@Param("p") String param);
}

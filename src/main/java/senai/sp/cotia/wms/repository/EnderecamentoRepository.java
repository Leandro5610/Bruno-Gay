package senai.sp.cotia.wms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import senai.sp.cotia.wms.model.Aluno;
import senai.sp.cotia.wms.model.Enderecamento;

public interface EnderecamentoRepository extends PagingAndSortingRepository<Enderecamento, Long>{
	
	@Query("SELECT enderecamento FROM Enderecamento enderecamento WHERE enderecamento.corredor LIKE %:p% "
	+" OR enderecamento.edificio LIKE %:p% OR enderecamento.andar LIKE %:p% OR enderecamento.modulo LIKE %:p%"
+" OR enderecamento.demanda LIKE %:p%")
    public List<Enderecamento> procurarTudo(@Param("p") String param);
}

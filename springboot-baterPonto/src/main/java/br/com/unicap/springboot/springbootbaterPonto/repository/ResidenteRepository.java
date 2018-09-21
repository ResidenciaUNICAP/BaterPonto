package br.com.unicap.springboot.springbootbaterPonto.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.unicap.springboot.springbootbaterPonto.model.Residente;;

public interface ResidenteRepository extends JpaRepository<Residente, String>{
	
	@Query(value = "SELECT * from tbl_residente where token like :token",nativeQuery = true)
	public Residente getResidenteByToken(@Param("token") String token);

	@Query(value = "SELECT * from tbl_residente where matricula like :matricula",nativeQuery = true)
	public Residente getResidenteByMatricula(@Param("matricula") String matricula);
	
	@Query(value = "SELECT * from tbl_residente where tipo=0",nativeQuery = true)
	public List<Residente> getResidentes();
	
	@Modifying
	@Query(value = "UPDATE tbl_residente SET token like :token WHERE matricula like :matricula",nativeQuery = true)
	@Transactional
	public void atualizarToken(@Param("token")String token, @Param("matricula")String matricula);
	
}
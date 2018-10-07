package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.FormaDePago;

@Repository
public interface FormaDePagoRepository extends JpaRepository<FormaDePago, Long>{

}

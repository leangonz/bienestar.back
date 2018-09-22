package ungs.bienestar.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ungs.bienestar.back.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

}

package tn.esprit.rh.achat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rh.achat.entities.DetailFacture;

@Repository
public interface DetailFactureRepository extends JpaRepository<DetailFacture, Long> {
  @Query("SELECT f FROM Facture f where f.fournisseur=:fournisseur and f.archivee=false")
	public List<Facture> getFactureByFournisseur(@Param("fournisseur") Fournisseur fournisseur);

	
	@Query("SELECT sum(f.montantFacture) FROM Facture f where  f.dateCreationFacture between :startDate"
			+ " and :endDate and f.archivee=false")
	float getTotalFacturesEntreDeuxDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Modifying
	@Query("update Facture f set f.archivee=true where f.idFacture=?1")
	void updateFacture(Long id);

}

package ui.UI.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ui.UI.model.Client;

@Repository
@Qualifier("clientRepo")
public interface ClientRepo extends JpaRepository<Client, Integer> {


}

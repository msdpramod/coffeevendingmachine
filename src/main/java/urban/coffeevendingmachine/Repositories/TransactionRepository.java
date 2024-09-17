package urban.coffeevendingmachine.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import urban.coffeevendingmachine.Models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}


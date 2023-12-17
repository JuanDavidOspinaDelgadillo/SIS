package SIS.example.Simple.Inventory.System.repositories;

import SIS.example.Simple.Inventory.System.commons.domains.entities.Product;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO worker (name, age, email, password) VALUES (:#{#worker.name}, :#{#worker.age}, :#{#worker.email}, :#{#worker.password})", nativeQuery = true)
    void registerWorker(@Param("worker") Worker worker);

    @Query(value = "SELECT * FROM worker w WHERE w.worker_id = :workerId", nativeQuery = true)
    Optional<Worker> getWorkerById(@Param("workerId") Long workerId);

    @Query(value = "SELECT * FROM worker", nativeQuery = true)
    List<Worker> getAll();

    @Query(value = "SELECT * FROM product p WHERE p.worker_id = :workerId", nativeQuery = true)
    List<Product> getAllProductsRegisteredByWorkerId(@Param("workerId") Long workerId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE worker SET name = :#{#worker.name}, age = :#{#worker.age}, email = :#{#worker.email}, password = :#{#worker.password} ", nativeQuery = true)
    void updateWorker(@Param("worker") Worker worker);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM worker WHERE worker_id = :workerId", nativeQuery = true)
    void deleteWorkerById(@Param("workerId") Long workerId);
}

package SIS.example.Simple.Inventory.System.repositories;

import SIS.example.Simple.Inventory.System.commons.domains.entities.Role;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO role (name, wage) VALUES :#{#role.name}, :#{#role.wage}", nativeQuery = true)
    void createRole(@Param("role") Role role);

    @Query(value = "SELECT * FROM role r WHERE r.role_id = :roleId ", nativeQuery = true)
    Role getRoleByRoleId(@Param("roleId") Long roleId);

    @Query(value = "SELECT * FROM role", nativeQuery = true)
    List<Role> getAll();

    @Query(value = "SELECT * FROM worker w WHERE w.role_id = :roleId", nativeQuery = true)
    List<Worker> getAllByRoleId(@Param("roleId") Long roleId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE role SET name = :#{#role.name}, wage = :#{#role.wage}", nativeQuery = true)
    void updateRole(@Param("role") Role role);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM role r WHERE role_id = :roleId", nativeQuery = true)
    void deleteByRoleId(@Param("roleId") Long roleId);
}